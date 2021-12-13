package restaurant.orderManagement.service.impl;

import org.springframework.stereotype.Repository;

import restaurant.orderManagement.service.OrderListVO;
import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

@Repository("OrderListDAO")
public class OrderListDAO extends EgovAbstractDAO{
	public String insertOrderList(OrderListVO vo) throws Exception
	{
		return (String)insert("orderListDAO.insertOrderList", vo);		
	}
}
