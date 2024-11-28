package com.skg.foodCatelogue.service.impl;

import com.skg.foodCatelogue.dtos.FoodCataloguePage;
import com.skg.foodCatelogue.dtos.FoodItemDto;
import com.skg.foodCatelogue.dtos.RestaurantDto;
import com.skg.foodCatelogue.entities.FoodItem;
import com.skg.foodCatelogue.mapper.FoodItemMapper;
import com.skg.foodCatelogue.repo.FoodItemRepo;
import com.skg.foodCatelogue.service.foodCatalogueService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
@Slf4j
public class foodCatalogueServiceImpl implements foodCatalogueService {

    @Autowired
    private FoodItemRepo foodItemRepo;

    @Autowired
    private WebClient webClient;

    @Override
    public FoodItemDto addFoodItem(FoodItemDto foodItemDto) {
        FoodItem foodItem = null;
        if (foodItemDto != null) {
            foodItem = this.foodItemRepo.save(FoodItemMapper.INSTANCE.foodItemDtoToFoodItem(foodItemDto));
        }
        return FoodItemMapper.INSTANCE.foodItemToFoodItemDto(foodItem);
    }

    @Override
    public FoodCataloguePage fetchFoodCateloguePageDetails(Integer restaurant_Id) {

        List<FoodItem> foodItemList = fetchFoodItemList(restaurant_Id);

        RestaurantDto restaurantDto = fetchRestaurantDetailsFromRestaurantMS(restaurant_Id);

        return createFoodCateloguePage(foodItemList, restaurantDto);
    }

    private List<FoodItem> fetchFoodItemList(int restaurantId) {

        return this.foodItemRepo.findByRestaurantId(restaurantId);
    }

    private RestaurantDto fetchRestaurantDetailsFromRestaurantMS(Integer restaurantId) {
        return webClient
                .get()// Typo fixed in URI
                .uri("http://localhost:5001/restaurent/getById/{restaurantId}", restaurantId)
                .retrieve()// Retrieves the response
                .onStatus(status -> status.is2xxSuccessful(), clientResponse -> Mono.empty())// Handle success status
                .bodyToMono(RestaurantDto.class)// Map the response body to RestaurantDto
                .doOnError(error -> System.out.println("Error Fetching Restaurant Details !! " + error.getMessage()))// Logging errors
                .switchIfEmpty(Mono.error(new RuntimeException("Restuarant not found !! ")))// Handle empty response
                .block();
    }

    private FoodCataloguePage createFoodCateloguePage(List<FoodItem> foodItemList, RestaurantDto restaurantDto) {

        FoodCataloguePage foodCataloguePage = new FoodCataloguePage();

        foodCataloguePage.setFoodItemList(foodItemList);
        foodCataloguePage.setRestaurantDto(restaurantDto);

        return foodCataloguePage;
    }


}

