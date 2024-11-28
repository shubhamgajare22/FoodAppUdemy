package com.skg.order.entities;

import com.skg.order.dtos.FoodItems;
import com.skg.order.dtos.Restaurent;
import com.skg.order.dtos.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("order")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {


    private Integer orderId;

    private List<FoodItems> foodItemsList;


    private Restaurent restaurent;

    private User user;


}
