package restaurant.restaurantManagement.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractMapper;
import restaurant.restaurantManagement.domain.CountryOfOrginInformation;
import restaurant.restaurantManagement.service.CountryOfOrginInformationService;


@Repository("countryOfOrginInformationDAO")
public class CountryOfOrginInformationDAO extends EgovAbstractMapper implements CountryOfOrginInformationService {

	@Override
	public void InsertCountryOfOrginInformation(CountryOfOrginInformation vo) throws Exception {
		insert("insertCountryOfOrginInformation", vo);
		
	}

	@Override
	public void UpdateCountryOfOrginInformation(CountryOfOrginInformation vo) throws Exception {
		// TODO Auto-generated method stub
		update("updateCountryOfOrginInformation", vo);
		
	}

	@Override
	public void DeletCountryOfOrginInformation(CountryOfOrginInformation vo) throws Exception {
		// TODO Auto-generated method stub
		delete("deletCountryOfOrginInformation", vo);		
	}

	@Override
	public List<CountryOfOrginInformation> FindMenuCountryOfOrginInformation(CountryOfOrginInformation vo)
			throws Exception {
		// TODO Auto-generated method stub
		
		return selectList("findMenuCountryOfOrginInformation", vo);
	}

	@Override
	public  List<Object> FindMenuCountryOfOrginInformation(HashMap<String, Object> vo)
			throws Exception {
		// TODO Auto-generated method stub
		
		return selectList("findMenuCountryOfOrginInformation", vo);
	}
}
