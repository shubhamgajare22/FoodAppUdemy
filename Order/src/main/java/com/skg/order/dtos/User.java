package com.skg.order.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private int userId;

    private String userName;

    private String userPassword;

    private String address;

    private String city;
}
