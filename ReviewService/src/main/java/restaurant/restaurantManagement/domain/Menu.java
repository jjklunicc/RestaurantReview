package restaurant.restaurantManagement.domain;

import javax.validation.constraints.NotNull;

/**
 * 
 * @author EaBEll
 * @param index set은 키를 bind할 용도로만 쓰시오.
 * 
 */
public class Menu {

	private Integer	index;
	private int restaurant_index;
	private String img_path_str;
	private int price;
	private String menu_name;
	private String menu_info;
	
	public Menu() {}

	public Integer getIndex() {
		return index;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}

	public int getRestaurant_index() {
		return restaurant_index;
	}

	public void setRestaurant_index(int restaurant_index) {
		this.restaurant_index = restaurant_index;
	}

	public String getImg_path_str() {
		return img_path_str;
	}

	public void setImg_path_str(String img_path_str) {
		this.img_path_str = img_path_str;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getMenu_name() {
		return menu_name;
	}

	public void setMenu_name(String menu_name) {
		this.menu_name = menu_name;
	}

	public String getMenu_info() {
		return menu_info;
	}

	public void setMenu_info(String menu_info) {
		this.menu_info = menu_info;
	}

	







	
}
