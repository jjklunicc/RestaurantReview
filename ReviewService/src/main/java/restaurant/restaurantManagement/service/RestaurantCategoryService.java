package restaurant.restaurantManagement.service;

import java.util.List;

import restaurant.restaurantManagement.domain.RestaurantCategory;

public interface RestaurantCategoryService {

	RestaurantCategory SelectRestaurantCategory(RestaurantCategory vo) throws Exception;
	List<RestaurantCategory> SelectRestaurantCategoryList(RestaurantCategory vo) throws Exception; 
	
}
