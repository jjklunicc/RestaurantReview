package restaurant.restaurantManagement.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import restaurant.restaurantManagement.domain.Shoppingbasket;
import restaurant.restaurantManagement.service.ShoppingbasketService;


@Service("shoppingbasketService")
public class ShoppingbasketServiceImpl extends EgovAbstractServiceImpl implements ShoppingbasketService {

	private static final Logger LOGGER= LoggerFactory.getLogger(RestaurantCategoryServiceImpl.class); 
	
	@Resource(name= "shoppingbasketDAO")
	private ShoppingbasketDAO shoppingbasketDAO;
	@Override
	public void InsertForwardingMenu(Shoppingbasket vo) throws Exception {
		// TODO Auto-generated method stub
		shoppingbasketDAO.InsertForwardingMenu(vo);
	}
	@Override
	public void UpdateCountryOfOrginInformation(Shoppingbasket vo) throws Exception {
		// TODO Auto-generated method stub
		shoppingbasketDAO.UpdateCountryOfOrginInformation(vo);
	}
	@Override
	public void DeleteCountryOfOrginInformation(Shoppingbasket vo) throws Exception {
		// TODO Auto-generated method stub
		shoppingbasketDAO.DeleteCountryOfOrginInformation(vo);
	}
	@Override
	public List<Shoppingbasket> SelectShoppingbasketList(Shoppingbasket vo) throws Exception {
		// TODO Auto-generated method stub
		return shoppingbasketDAO.SelectShoppingbasketList(vo);
	}

}
