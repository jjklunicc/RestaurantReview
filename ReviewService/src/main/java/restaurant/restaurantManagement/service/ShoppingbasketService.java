package restaurant.restaurantManagement.service;


import java.util.List;

import restaurant.restaurantManagement.domain.Shoppingbasket;

public interface ShoppingbasketService {

	
	 void InsertForwardingMenu(Shoppingbasket vo) throws Exception;
	 
	 void UpdateCountryOfOrginInformation(Shoppingbasket vo) throws Exception;
	 
	 void DeleteCountryOfOrginInformation(Shoppingbasket vo) throws Exception;
	 
	 List<Shoppingbasket> SelectShoppingbasketList(Shoppingbasket vo) throws Exception;
}
