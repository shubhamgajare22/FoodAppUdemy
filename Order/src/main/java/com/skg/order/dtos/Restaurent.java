package com.skg.order.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Restaurent {

    private int id;
    private String name;
    private String address;
    private String city;
    private String restaurantDescription;
}
