package restaurant.restaurantManagement.domain.dto;

public class MenuCountryOfOrginInformationDTO {

	int countryOfOrginInformation_index;
	int menu_index;
	int menu_restaurant_index;
	String countryOfOrgin_country_name;
	String menu_img_path_str;
	int menu_price;
	String menu_name;
	String menu_info;
	
	
	
	public int getCountryOfOrginInformation_index() {
		return countryOfOrginInformation_index;
	}
	public void setCountryOfOrginInformation_index(int countryOfOrginInformation_index) {
		this.countryOfOrginInformation_index = countryOfOrginInformation_index;
	}
	public int getMenu_index() {
		return menu_index;
	}
	public void setMenu_index(int menu_index) {
		this.menu_index = menu_index;
	}
	public int getMenu_restaurant_index() {
		return menu_restaurant_index;
	}
	public void setMenu_restaurant_index(int menu_restaurant_index) {
		this.menu_restaurant_index = menu_restaurant_index;
	}
	public String getCountryOfOrgin_country_name() {
		return countryOfOrgin_country_name;
	}
	public void setCountryOfOrgin_country_name(String countryOfOrgin_country_name) {
		this.countryOfOrgin_country_name = countryOfOrgin_country_name;
	}
	public String getMenu_img_path_str() {
		return menu_img_path_str;
	}
	public void setMenu_img_path_str(String menu_img_path_str) {
		this.menu_img_path_str = menu_img_path_str;
	}
	public int getMenu_price() {
		return menu_price;
	}
	public void setMenu_price(int menu_price) {
		this.menu_price = menu_price;
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
	
	@Override
	public String toString() {
		return "MenuCountryOfOrginInformationDTO [countryOfOrginInformation_index=" + countryOfOrginInformation_index
				+ ", menu_index=" + menu_index + ", menu_restaurant_index=" + menu_restaurant_index
				+ ", countryOfOrgin_country_name=" + countryOfOrgin_country_name + ", menu_img_path_str="
				+ menu_img_path_str + ", menu_price=" + menu_price + ", menu_name=" + menu_name + ", menu_info="
				+ menu_info + "]";
	}
	
	
	
	
	
}
