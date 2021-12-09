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
package restaurant.userManagement.service.impl;

import java.util.List;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;
import restaurant.restaurantManagement.service.RestaurantVO;
import restaurant.userManagement.service.UserVO;
import restaurant.userManagement.service.loginVO;

import org.springframework.stereotype.Repository;

@Repository("UserDAO")
public class UserDAO extends EgovAbstractDAO {

	public String insertUser(UserVO vo) throws Exception {
		return (String) insert("UserDAO.insertUser", vo);
	}

	public UserVO selectUser(loginVO vo) throws Exception 
	{
		Object sql= select("UserDAO.selectUser", vo);
		System.out.println(sql);
		if(sql != null)
			return (UserVO) select("UserDAO.selectUser", vo);
		else return null;
	}

}
