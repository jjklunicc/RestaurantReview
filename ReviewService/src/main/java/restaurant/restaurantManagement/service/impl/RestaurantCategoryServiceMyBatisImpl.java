package restaurant.restaurantManagement.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import restaurant.restaurantManagement.service.RestaurantManagementService;
import restaurant.restaurantManagement.service.RestaurantVO;


@Service("restaurantCategoryServiceMyBatisImpl")
public class RestaurantCategoryServiceMyBatisImpl extends EgovAbstractServiceImpl
		implements RestaurantManagementService {
	private static final Logger LOGGER= LoggerFactory.getLogger(RestaurantCategoryServiceMyBatisImpl.class); 
	
	@Resource(name="restaurantMyBatisDAO")
	private  RestaurantMyBatisDAO restaurantMyBatisDAO; 
	@Override
	public String insertRestaurant(RestaurantVO vo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void UpdateRestaurant(RestaurantVO vo) throws Exception {
		// TODO Auto-generated method stub
		restaurantMyBatisDAO.UpdateRestaurant(vo);
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
