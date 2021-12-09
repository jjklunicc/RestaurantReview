package restaurant.restaurantManagement.service;

import java.util.HashMap;
import java.util.List;

import restaurant.restaurantManagement.domain.CountryOfOrginInformation;


public interface CountryOfOrginInformationService {

		public void InsertCountryOfOrginInformation(CountryOfOrginInformation vo) throws Exception;
		
		public void UpdateCountryOfOrginInformation(CountryOfOrginInformation vo) throws Exception;
		public void DeletCountryOfOrginInformation(CountryOfOrginInformation vo) throws Exception;
		public List<CountryOfOrginInformation> FindMenuCountryOfOrginInformation(CountryOfOrginInformation vo) throws Exception;

		List<Object> FindMenuCountryOfOrginInformation(HashMap<String, Object> vo) throws Exception;
}
