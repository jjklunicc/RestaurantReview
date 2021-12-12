package restaurant.restaurantManagement.domain;

import java.util.List;

public class CountryOfOrginInformation {

		private Integer index;
		private int menu_index;
		private String country_name;
	

		public CountryOfOrginInformation(Integer index, int menu_index, String country_name) {
			super();
			this.index = index;
			this.menu_index = menu_index;
			this.country_name = country_name;
		}

		public Integer getIndex() {
			return index;
		}
		public int getMenu_index() {
			return menu_index;
		}
		public String getCountry_name() {
			return country_name;
		}

		@Override
		public String toString() {
			return "CountryOfOrginInformation [index=" + index + ", menu_index=" + menu_index + ", country_name="
					+ country_name  + "]";
		}
		
}
