package com.skg.order.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {

    private Integer orderId;

    private List<FoodItems> foodItemsList;

    private Restaurent restaurent;

    private User user;
}
