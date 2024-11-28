package com.skg.foodCatelogue.service;

import com.skg.foodCatelogue.dtos.FoodCataloguePage;
import com.skg.foodCatelogue.dtos.FoodItemDto;

public interface foodCatalogueService {

    FoodItemDto addFoodItem(FoodItemDto foodItemDto);

    FoodCataloguePage fetchFoodCateloguePageDetails(Integer restaurant_Id);
}
