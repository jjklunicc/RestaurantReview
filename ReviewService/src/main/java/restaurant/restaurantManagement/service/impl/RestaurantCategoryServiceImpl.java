package restaurant.restaurantManagement.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import restaurant.restaurantManagement.domain.RestaurantCategory;
import restaurant.restaurantManagement.service.RestaurantCategoryService;

@Service("restaurantCategoryService")
public class RestaurantCategoryServiceImpl extends EgovAbstractServiceImpl implements RestaurantCategoryService {

	private static final Logger LOGGER= LoggerFactory.getLogger(RestaurantCategoryServiceImpl.class); 
	
	@Resource(name="restaurantCategoryDao")
	private RestaurantCategoryDAO restaurantCategoryDao;
	
	@Override
	public RestaurantCategory SelectRestaurantCategory(RestaurantCategory vo) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("restaurantCategoryDao의 SelectRestaurantCategory 입니다.");
		
	
		return restaurantCategoryDao.SelectRestaurantCategory(vo);
	}

	@Override
	public List<RestaurantCategory> SelectRestaurantCategoryList(RestaurantCategory vo) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("restaurantCategoryDao의 SelectRestaurantCategoryList 입니다.");
		//restaurantCategoryDao.SelectRestaurantCategoryList(vo);
		return restaurantCategoryDao.SelectRestaurantCategoryList(vo);
	}

}
