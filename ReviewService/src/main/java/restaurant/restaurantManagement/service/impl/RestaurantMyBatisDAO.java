package restaurant.restaurantManagement.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractMapper;
import restaurant.restaurantManagement.service.RestaurantManagementService;
import restaurant.restaurantManagement.service.RestaurantVO;


@Repository("restaurantMyBatisDAO")
public class RestaurantMyBatisDAO extends EgovAbstractMapper implements RestaurantManagementService {

	@Override
	public String insertRestaurant(RestaurantVO vo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void UpdateRestaurant(RestaurantVO vo) throws Exception {
		// TODO Auto-generated method stub
		update("", vo);
	}

	@Override
	public void UpdateRestaurantImage(RestaurantVO vo) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void DeleteRestaurant(RestaurantVO vo) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public RestaurantVO SelectRestaurant(RestaurantVO vo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<?> SelectAllRestaurant() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<?> SelectCategoryRestaurant(RestaurantVO vo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
