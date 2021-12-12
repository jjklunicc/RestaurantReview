package restaurant.restaurantManagement.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractMapper;
import restaurant.restaurantManagement.domain.RestaurantCategory;
import restaurant.restaurantManagement.service.RestaurantCategoryService;

@Repository("restaurantCategoryDao")
public class RestaurantCategoryDAO extends EgovAbstractMapper implements RestaurantCategoryService {

	@Override
	public RestaurantCategory SelectRestaurantCategory(RestaurantCategory vo) throws Exception {
		// TODO Auto-generated method stub
		
		return (RestaurantCategory) selectList("SelectRestaurantCategory",vo);
	}

	@Override
	public List<RestaurantCategory> SelectRestaurantCategoryList(RestaurantCategory vo) throws Exception {
		// TODO Auto-generated method stub
		return selectList("selectRestaurantCategoryList",vo);
	}

}
