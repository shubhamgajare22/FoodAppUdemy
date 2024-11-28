package com.skg.foodCatelogue.mapper;

import com.skg.foodCatelogue.dtos.FoodItemDto;
import com.skg.foodCatelogue.entities.FoodItem;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FoodItemMapper {

    FoodItemMapper INSTANCE= Mappers.getMapper(FoodItemMapper.class);

    FoodItemDto foodItemToFoodItemDto(FoodItem foodItem);

    FoodItem foodItemDtoToFoodItem(FoodItemDto foodItemDto);
}
