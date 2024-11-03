package in.skg.restaurantlisting.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantDto {

    private int id;
    private String name;
    private String address;
    private String city;
    private String restaurantDescription;




}
