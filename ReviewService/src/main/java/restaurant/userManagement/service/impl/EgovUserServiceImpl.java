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

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;
import restaurant.restaurantManagement.service.RestaurantVO;
import restaurant.userManagement.service.EgovUserService;
import restaurant.userManagement.service.UserVO;
import restaurant.userManagement.service.loginVO;
import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


@Service("userService")
public class EgovUserServiceImpl extends EgovAbstractServiceImpl implements EgovUserService {

	private static final Logger LOGGER = LoggerFactory.getLogger(EgovUserServiceImpl.class);
	@Resource(name = "UserDAO")
	private UserDAO UserDAO;

	
	@Override
	public String insertUser(UserVO vo) throws Exception {

		UserDAO.insertUser(vo);	
		return vo.getId();
	}
	
	@Override
	public UserVO selectUser(loginVO vo) throws Exception {
		UserVO userVO = UserDAO.selectUser(vo);
		
		return userVO;
	}
}
