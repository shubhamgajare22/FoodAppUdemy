package com.skg.foodCatelogue.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String itemName;

    private String itemDescription;

    private boolean isVeg;

    private Number price;

    private Integer restaurantId; //with the help of this we can show restaurents which has different different food items

    @Column(nullable = false,columnDefinition = "INT DEFAULT 0")
    private Integer quantity;

}
