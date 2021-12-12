package restaurant.orderManagement.service.impl;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;
import restaurant.orderManagement.service.OrderRequestVO;


import java.util.List;


@Repository("orderDAO")
public class OrderDAO extends EgovAbstractDAO{
	
	public String insertOrder(OrderRequestVO vo) throws Exception 
	{
		return (String) insert("orderDAO.insertOrder", vo);
	}
	
	public List<?> selectOrder(String user_id) throws Exception 
	{
		return list("orderDAO.selectOrder",user_id);
	}
}
