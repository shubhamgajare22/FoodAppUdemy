package in.skg.restaurantlisting.mapper;

import in.skg.restaurantlisting.dtos.RestaurantDto;
import in.skg.restaurantlisting.entities.Restaurant;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RestaurentMapper {

    RestaurentMapper INSTANCE = Mappers.getMapper(RestaurentMapper.class);

    Restaurant mapRestaurantDtoToRestaurant(RestaurantDto restaurantDto);
    RestaurantDto mapRestaurantToRestaurantDto(Restaurant restaurant);

}
