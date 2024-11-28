package in.skg.restaurantlisting.repo;

import in.skg.restaurantlisting.entities.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
//if we havent provide this annotation then spring data jpa respository will create
//automatically by extending jpaRepository
//
//but specific significance of this annotation is it will translated database related exception
//into Spring's DataAccessException heirarchy.

//this annotation is speciallization of @Component annotation
public interface RestaurentRepo extends JpaRepository<Restaurant, Integer> {



}
