package restaurant.restaurantManagement.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractMapper;
import restaurant.restaurantManagement.domain.Shoppingbasket;
import restaurant.restaurantManagement.service.ShoppingbasketService;


@Repository("shoppingbasketDAO")
public class ShoppingbasketDAO extends EgovAbstractMapper implements ShoppingbasketService {

	@Override
	public void InsertForwardingMenu(Shoppingbasket vo) throws Exception {
		// TODO Auto-generated method stub
			insert("insertForwardingMenu", vo);
	}

	@Override
	public void UpdateCountryOfOrginInformation(Shoppingbasket vo) throws Exception {
		// TODO Auto-generated method stub
		update("updateCountryOfOrginInformation",vo);
	}

	@Override
	public void DeleteCountryOfOrginInformation(Shoppingbasket vo) throws Exception {
		// TODO Auto-generated method stub
		delete("deleteCountryOfOrginInformation", vo);
	}

	@Override
	public List<Shoppingbasket> SelectShoppingbasketList(Shoppingbasket vo) throws Exception {
		// TODO Auto-generated method stub
		return selectList("SelectShoppingbasketList", vo);
	}

}
