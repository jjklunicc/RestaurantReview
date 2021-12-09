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
package restaurant.restaurantManagement.service.impl;

import java.util.List;

import restaurant.restaurantManagement.domain.Menu;
import restaurant.restaurantManagement.service.RestaurantMenuService;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @Class Name : EgovSampleServiceImpl.java
 * @Description : Sample Business Implement Class
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

@Service("restaurantMenuService")
public class RestaurantMenuServiceImpl extends EgovAbstractServiceImpl implements RestaurantMenuService {

	private static final Logger LOGGER = LoggerFactory.getLogger(RestaurantMenuServiceImpl.class);

	@Resource(name = "menuDAO_dabin")
	private MenuDAO_dabin menuDAO;

	@Override
	public String insertMenu(Menu vo) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("insertMenu");
		menuDAO.insertMenu(vo);
		return null;
	}

	@Override
	public void UpdateMenu(Menu vo) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("UpdateMenu");
		menuDAO.UpdateMenu(vo);
		
	}

	@Override
	public void UpdateMenuImage(Menu vo) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("UpdateMenuImage");
		menuDAO.UpdateMenuImage(vo);
	}

	@Override
	public void DeleteMenu(Menu vo) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("DeleteMenu");
		menuDAO.DeleteMenu(vo);
		
	}

	@Override
	public List<Menu> SelectRestaurantMenu(Menu vo) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("SelectRestaurantMenu");
		return menuDAO.SelectRestaurantMenu(vo);
	}


	

}
