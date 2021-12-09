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

import restaurant.restaurantManagement.service.MenuVO;
import egovframework.rte.psl.dataaccess.EgovAbstractDAO;
import org.springframework.stereotype.Repository;

/**
 * @Class Name : SampleDAO.java
 * @Description : Sample DAO Class
 * @Modification Information
 * @ @ 수정일 수정자 수정내용 @ --------- --------- ------------------------------- @
 *   2009.03.16 최초생성
 *
 * @author 개발프레임웍크 실행환경 개발팀
 * @since 2009. 03.16
 * @version 1.0
 * @see
 *
 * 		Copyright (C) by MOPAS All right reserved.
 */

@Repository("menuDAO")
public class MenuDAO extends EgovAbstractDAO {

	public String insertMenu(MenuVO vo) throws Exception {
		return (String) insert("menuDAO.insertmenu", vo);
	}

	public void UpdateMenu(MenuVO vo) throws Exception {
		update("menuDAO.updatemenu", vo);
	}

	public void UpdateMenuImage(MenuVO vo) throws Exception {
		update("menuDAO.updatemenuimage", vo);
	}

	public void DeleteMenu(MenuVO vo) throws Exception {
		delete("menuDAO.deletemenu", vo);
	}

	public List<MenuVO>  SelectRestaurantMenu(MenuVO vo) throws Exception {
		List<?> list = list("menuDAO.selectreataurantmenu", vo);
		if (list != null)
			return (List<MenuVO>) list;
		else
			return null;
	}


}
