package restaurant.restaurantManagement.domain;

import java.time.LocalDateTime;
import java.util.Date;

public class Shoppingbasket {
	Integer index;
	int user_index;
	int restaurant_index;
	int menu_index;
	int count;
	String date;

	public Shoppingbasket() {

	}

	public Shoppingbasket(int user_index, int restaurant_index, int menu_index, int count, String date) {
		super();
		this.user_index = user_index;
		this.restaurant_index = restaurant_index;
		this.menu_index = menu_index;
		this.count = count;
		this.date = date;
	}

	public Integer getIndex() {
		return index;
	}

	public int getUser_index() {
		return user_index;
	}

	public int getRestaurant_index() {
		return restaurant_index;
	}

	public int getMenu_index() {
		return menu_index;
	}

	public int getCount() {
		return count;
	}

	public String getDate() {
		return date;
	}

}
