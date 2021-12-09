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

@Repository("menuDAO_dabin")
public class MenuDAO_dabin extends EgovAbstractDAO {

	public String insertMenu(Menu vo) throws Exception {
		return (String) insert("menuDAO_dabin.insertmenu", vo);
	}

	public void UpdateMenu(Menu vo) throws Exception {
		update("menuDAO_dabin.updatemenu", vo);
	}

	public void UpdateMenuImage(Menu vo) throws Exception {
		update("menuDAO_dabin.updatemenuimage", vo);
	}

	public void DeleteMenu(Menu vo) throws Exception {
		delete("menuDAO_dabin.deletemenu", vo);
	}

	public List<Menu>  SelectRestaurantMenu(Menu vo) throws Exception {
		List<?> list = list("menuDAO_dabin.selectreataurantmenu", vo);
		if (list != null)
			return (List<Menu>) list;
		else
			return null;
	}


}
