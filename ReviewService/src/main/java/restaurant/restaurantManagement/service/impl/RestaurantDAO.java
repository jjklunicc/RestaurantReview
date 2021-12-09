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

import restaurant.restaurantManagement.service.RestaurantVO;
import egovframework.rte.psl.dataaccess.EgovAbstractDAO;
import org.springframework.stereotype.Repository;

/**
 * @Class Name : SampleDAO.java
 * @Description : Sample DAO Class
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

@Repository("restaurantDAO")
public class RestaurantDAO extends EgovAbstractDAO {


	public String insertReataurant(RestaurantVO vo) throws Exception 
	{
		return (String) insert("restaurantDAO.insertreataurant", vo);
	}


	public void UpdateRestaurant(RestaurantVO vo) throws Exception
	{
		update("restaurantDAO.updatereataurant", vo);
	}
	public void UpdateRestaurantImage(RestaurantVO vo) throws Exception
	{
		update("restaurantDAO.updateimage", vo);
	}

	
	public void DeleteRestaurant(RestaurantVO vo) throws Exception 
	{
		delete("restaurantDAO.deletereataurant", vo);
	}


	public RestaurantVO SelectRestaurant(RestaurantVO vo) throws Exception 
	{
		Object sql= select("restaurantDAO.selectreataurant", vo);
		if(sql != null)
			return (RestaurantVO) sql;
		else return null;
	}


	public List<?> SelectAllRestaurant() throws Exception 
	{
		return list("restaurantDAO.selectallreataurant");
	}
	public List<?> SelectCategoryRestaurant(RestaurantVO vo) throws Exception 
	{
		return list("restaurantDAO.selectcategory",vo);
	}
}
