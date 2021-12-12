package restaurant.restaurantManagement.service.impl;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import restaurant.restaurantManagement.domain.CountryOfOrginInformation;
import restaurant.restaurantManagement.service.CountryOfOrginInformationService;


@Service("countryOfOrginInformationService")
public class CountryOfOrginInformationServiceImpl extends EgovAbstractServiceImpl
		implements CountryOfOrginInformationService {
	
	
		@Resource(name="countryOfOrginInformationDAO")
		private CountryOfOrginInformationDAO countryOfOrginInformationDAO;

	@Override
	public void InsertCountryOfOrginInformation(CountryOfOrginInformation vo) throws Exception {
		// TODO Auto-generated method stub
		countryOfOrginInformationDAO.InsertCountryOfOrginInformation(vo);
	}

	@Override
	public void UpdateCountryOfOrginInformation(CountryOfOrginInformation vo) throws Exception {
		// TODO Auto-generated method stub
		countryOfOrginInformationDAO.UpdateCountryOfOrginInformation(vo);
	}

	@Override
	public void DeletCountryOfOrginInformation(CountryOfOrginInformation vo) throws Exception {
		// TODO Auto-generated method stub
		countryOfOrginInformationDAO.DeletCountryOfOrginInformation(vo);
	}

	@Override
	public List<CountryOfOrginInformation> FindMenuCountryOfOrginInformation(CountryOfOrginInformation vo)
			throws Exception {
		// TODO Auto-generated method stub
		return countryOfOrginInformationDAO.FindMenuCountryOfOrginInformation(vo);
	}

	@Override
	public List<Object> FindMenuCountryOfOrginInformation(HashMap<String, Object> vo) throws Exception {
		// TODO Auto-generated method stub
		return countryOfOrginInformationDAO.FindMenuCountryOfOrginInformation(vo);
	}

}
