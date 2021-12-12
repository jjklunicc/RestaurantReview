package restaurant.orderManagement.service;

import java.util.List;

public interface OrderManagementService {
	
	 String insertOrder(OrderRequestVO vo) throws Exception;
	 List<OrderResponseVO> selectOrder(String user_index) throws Exception;

}
