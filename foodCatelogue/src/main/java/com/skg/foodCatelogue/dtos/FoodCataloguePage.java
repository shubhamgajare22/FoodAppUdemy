package com.skg.foodCatelogue.dtos;

import com.skg.foodCatelogue.entities.FoodItem;
import jakarta.persistence.Column;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodCataloguePage {

    // this page provides only foodItemList and Restaurants
    //actually we are not going to save restaurant
    private List<FoodItem> foodItemList;

    private RestaurantDto restaurantDto;


}


































