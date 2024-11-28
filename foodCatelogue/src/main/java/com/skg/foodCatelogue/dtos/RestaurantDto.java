package com.skg.foodCatelogue.dtos;

import lombok.*;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantDto {
    private int id;
    private String name;
    private String address;
    private String city;
    private String restaurantDescription;
}
