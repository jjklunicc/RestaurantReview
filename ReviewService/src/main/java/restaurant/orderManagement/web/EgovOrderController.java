/*
 * Copyright 2008-2009 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package restaurant.orderManagement.web;

import java.util.Date;
import java.util.List;

import restaurant.orderManagement.service.OrderManagementService;
import restaurant.orderManagement.service.OrderRequestVO;
import restaurant.orderManagement.service.OrderResponseVO;


import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @Class Name : EgovSampleController.java
 * @Description : EgovSample Controller Class
 * @Modification Information
 * @
 * @  수정일      수정자              수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2009.03.16           최초생성
 *
 * @author 개발프레임웍크 실행환경 개발팀
 * @since 2009. 03.16
 * @version 1.0
 * @see
 *
 *  Copyright (C) by MOPAS All right reserved.
 */

@Controller
public class EgovOrderController {	
	
	@Resource(name = "orderServic")
	private OrderManagementService orderSevice;
	
	@PostMapping(value = "/orderComplete.do")
	public String selectSampleList(@ModelAttribute OrderRequestVO orderRequestVO) throws Exception {	
		orderSevice.insertOrder(orderRequestVO);
		return "order/orderComplete";		
	}
	
	@ResponseBody
	@RequestMapping(value = "/orderList.do")
	public String selectOrderList() throws Exception {	
		System.out.println(">>>>>>>>>>>>>>>>>>>>> orderList 실행됨!");
		return "order/orderList";
	}
	
	@RequestMapping(value = "/orderList.do", method = RequestMethod.POST)
	public String selectOrder(@RequestParam("userCd") String userCd, Model model) throws Exception {	
		System.out.println(">>>>>>>>>>>>>>>>>>>>> orderList >>>> ");
		List<OrderResponseVO> orderVO =  orderSevice.selectOrder(userCd);
		model.addAttribute("data", orderVO);
		System.out.println(">>>>>>>>>>>>>>>>>>>>> orderList 실행됨 >>> ");
		return "order/orderComplete";
		
	}

}
