package restaurant.orderManagement.service.impl;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import restaurant.orderManagement.service.ShoppingBagService;
import restaurant.orderManagement.service.ShoppingBagVO;

@Service("ShoppingBackService")
public class ShoppingBagServiceImpl extends EgovAbstractServiceImpl implements ShoppingBagService{
	@Resource(name="ShoppingBagDAO")
	private ShoppingBagDAO shoppingBagDAO;
	
	@Override
	public void deleteShoppingBag(ShoppingBagVO vo) throws Exception
	{
		shoppingBagDAO.deleteShoppingBag(vo);
	}
}
