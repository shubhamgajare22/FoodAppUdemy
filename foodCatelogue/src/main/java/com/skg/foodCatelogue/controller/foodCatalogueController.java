package com.skg.foodCatelogue.controller;

import com.skg.foodCatelogue.dtos.FoodCataloguePage;
import com.skg.foodCatelogue.dtos.FoodItemDto;
import com.skg.foodCatelogue.entities.FoodItem;
import com.skg.foodCatelogue.service.foodCatalogueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/foodcatalogue")
public class foodCatalogueController {

    private final foodCatalogueService foodCatalogueService;

    //@Autowired annotation is optional
    public foodCatalogueController(foodCatalogueService catalogueService) {
        this.foodCatalogueService = catalogueService;
    }

    @PostMapping("/addFoodItem")
    public ResponseEntity<FoodItemDto> createFoodItem(@RequestBody FoodItemDto foodItemDto) {
        FoodItemDto foodItemDto1 = foodCatalogueService.addFoodItem(foodItemDto);
        return ResponseEntity.ok(foodItemDto1);
    }

    @GetMapping("/fetchRestaurantAndFoodItemsById/{restaurantId}")
    public ResponseEntity<FoodCataloguePage> fetchRestauDetailsWithFoodMenu(@PathVariable Integer restaurantId) {

        FoodCataloguePage foodCataloguePage = this.foodCatalogueService.fetchFoodCateloguePageDetails(restaurantId);

        return ResponseEntity.ok(foodCataloguePage);
    }


}


