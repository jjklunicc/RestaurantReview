package restaurant.orderManagement.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import restaurant.orderManagement.service.OrderListService;
import restaurant.orderManagement.service.OrderListVO;

@Service("OrderListService")
public class OrderListServiceImpl extends EgovAbstractServiceImpl implements OrderListService{
	@Resource(name="OrderListDAO")
	private OrderListDAO orderListDAO;

	@Override
	public String insertOrderList(OrderListVO vo) throws Exception {
		// TODO Auto-generated method stub
		orderListDAO.insertOrderList(vo);
		return null;
	}
}
