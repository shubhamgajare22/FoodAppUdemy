package in.skg.restaurantlisting.service.impl;

import in.skg.restaurantlisting.dtos.RestaurantDto;
import in.skg.restaurantlisting.entities.Restaurant;
import in.skg.restaurantlisting.mapper.RestaurentMapper;
import in.skg.restaurantlisting.repo.RestaurentRepo;
import in.skg.restaurantlisting.service.RestaurentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RestaurantServiceImpl implements RestaurentService {


    @Autowired
    private RestaurentRepo restaurentRepo;


    @Override
    public List<RestaurantDto> fetchAllRestaurents() {
        List<Restaurant> restaurantList = restaurentRepo.findAll();

        List<RestaurantDto> restaurantDtosList = restaurantList.stream()
                .map(restaurant -> RestaurentMapper.INSTANCE.mapRestaurantToRestaurantDto(restaurant))
                .collect(Collectors.toList());

        return restaurantDtosList;
    }

    @Override
    public RestaurantDto saveRestaurant(RestaurantDto restaurantDto) {
        Restaurant restaurant = null;
        if (restaurantDto != null) {
            restaurant = this.restaurentRepo.save(RestaurentMapper.INSTANCE.mapRestaurantDtoToRestaurant(restaurantDto));
        }
        return RestaurentMapper.INSTANCE.mapRestaurantToRestaurantDto(restaurant);
    }

    @Override
    public Optional<RestaurantDto> findByIdRestaurant(int restaurantId) {

        Optional<Restaurant> restById = this.restaurentRepo.findById(restaurantId);
        if (restById.isPresent()) {
            return Optional.of(RestaurentMapper.INSTANCE.mapRestaurantToRestaurantDto(restById.get()));
        }
        return Optional.empty();
    }

}
