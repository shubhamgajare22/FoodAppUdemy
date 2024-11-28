package com.skg.order.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDtoFromFrontEnd {

    private List<FoodItems> foodItemsList;

    private Integer userId;

    private Restaurent restaurent;

}
