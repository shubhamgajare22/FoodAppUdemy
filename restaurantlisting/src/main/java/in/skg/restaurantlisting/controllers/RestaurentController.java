package in.skg.restaurantlisting.controllers;

import in.skg.restaurantlisting.dtos.RestaurantDto;
import in.skg.restaurantlisting.service.RestaurentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController //@controller + @responsebody
// it is responsible for map response always in JSON format not in JSP or any other Response model
@RequestMapping("/restaurent")
//this annotation maps the web request to this class if we annotated with the class viceversa method
public class RestaurentController {

    @Autowired
    private RestaurentService restaurentService;

    @GetMapping("/fetchAllRestaurants")
    public ResponseEntity<List<RestaurantDto>> fetListResponseEntity() {
        return ResponseEntity.ok(this.restaurentService.fetchAllRestaurents());
    }

    @PostMapping("/addRestaurant")
    public ResponseEntity<RestaurantDto> createRestaurant(@RequestBody RestaurantDto restaurantDto) {
        return ResponseEntity.ok(this.restaurentService.saveRestaurant(restaurantDto));
    }

    @GetMapping("/getById/{restaurantId}")
    public ResponseEntity<RestaurantDto> getRestaurantById( @PathVariable int restaurantId) {
        Optional<RestaurantDto> restaurantDto = this.restaurentService.findByIdRestaurant(restaurantId);
        if (restaurantDto.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(restaurantDto.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }


}
