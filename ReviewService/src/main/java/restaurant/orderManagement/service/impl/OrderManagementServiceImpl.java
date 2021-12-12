package restaurant.orderManagement.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import restaurant.orderManagement.service.OrderManagementService;
import restaurant.orderManagement.service.OrderRequestVO;
import restaurant.orderManagement.service.OrderResponseVO;

@Service("orderServic")
public class OrderManagementServiceImpl extends EgovAbstractServiceImpl implements OrderManagementService {

	@Resource(name = "orderDAO")
	private OrderDAO orderDAO;

	private static final Logger LOGGER = LoggerFactory.getLogger(OrderManagementServiceImpl.class);
	
	public String insertOrder(OrderRequestVO vo) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("insertOrder");
		orderDAO.insertOrder(vo);
		return null;
	}

	@Override
	public List<OrderResponseVO> selectOrder(String user_id) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("selectOrder");
		orderDAO.selectOrder(user_id);
		return null;
	}
	
}
