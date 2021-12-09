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

import restaurant.restaurantManagement.service.RestaurantManagementService;
import restaurant.restaurantManagement.service.RestaurantVO;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;

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

@Service("restaurantManagementService")
public class RestaurantManagementServiceImpl extends EgovAbstractServiceImpl implements RestaurantManagementService {

	private static final Logger LOGGER = LoggerFactory.getLogger(RestaurantManagementServiceImpl.class);

	@Resource(name = "restaurantDAO")
	private RestaurantDAO restaurantDAO;


	@Override
	public String insertRestaurant(RestaurantVO vo) throws Exception {
		// TODO Auto-generated method stub
		restaurantDAO.insertReataurant(vo);
		return null;
	}


	@Override
	public void UpdateRestaurant(RestaurantVO vo) throws Exception {
		restaurantDAO.UpdateRestaurant(vo);
		
	}

	@Override
	public void UpdateRestaurantImage(RestaurantVO vo) throws Exception {
		restaurantDAO.UpdateRestaurantImage(vo);
		
	}


	@Override
	public void DeleteRestaurant(RestaurantVO vo) throws Exception {
		restaurantDAO.DeleteRestaurant(vo);
	}


	@Override
	public RestaurantVO SelectRestaurant(RestaurantVO vo) throws Exception {
		RestaurantVO resultVO = restaurantDAO.SelectRestaurant(vo);
		return resultVO;
	}


	@Override
	public List<?> SelectAllRestaurant() throws Exception {
		
		List<?> listresultVO = restaurantDAO.SelectAllRestaurant();
		return listresultVO;
	}
	@Override
	public List<?> SelectCategoryRestaurant(RestaurantVO vo) throws Exception {
		List<?> listresultVO = restaurantDAO.SelectCategoryRestaurant(vo);
		return listresultVO;
	}


}
