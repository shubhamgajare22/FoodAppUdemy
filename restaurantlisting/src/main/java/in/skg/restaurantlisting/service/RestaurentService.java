package in.skg.restaurantlisting.service;

import in.skg.restaurantlisting.dtos.RestaurantDto;

import java.util.List;
import java.util.Optional;

public interface RestaurentService {

    List<RestaurantDto> fetchAllRestaurents();

    RestaurantDto saveRestaurant(RestaurantDto restaurantDto);

    Optional<RestaurantDto> findByIdRestaurant(int restaurantId);
}
