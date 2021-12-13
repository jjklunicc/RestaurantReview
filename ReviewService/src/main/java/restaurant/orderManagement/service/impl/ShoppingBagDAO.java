package restaurant.orderManagement.service.impl;
import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;
import restaurant.orderManagement.service.ShoppingBagVO;

@Repository("ShoppingBagDAO")
public class ShoppingBagDAO extends EgovAbstractDAO{

	public void deleteShoppingBag(ShoppingBagVO vo) throws Exception
	{
		delete("ShoppingBagDAO.deleteShoppingBag", vo);
	}
}
