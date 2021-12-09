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
package restaurant.restaurantManagement.web;

import java.util.Base64;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import restaurant.restaurantManagement.cmmn.Util_bin;
import restaurant.restaurantManagement.domain.Menu;
import restaurant.restaurantManagement.service.RestaurantManagementService;
import restaurant.restaurantManagement.service.RestaurantMenuService;
import restaurant.restaurantManagement.service.RestaurantVO;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springmodules.validation.commons.DefaultBeanValidator;

import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class RestaurantMenuController {

	private String imgtest = "restaurant/ImgUploadTest2";

	/** EgovSampleService */

	@Resource(name = "restaurantMenuService")
	private RestaurantMenuService restaurantMenuService;

	// 해당 Mapping을 사용하는 jsp페이지는 아직없음.
	// 이미지업데이트용, 이미지를 서버에 저장, 디비에 경로를 입력한다
	// request
	// req - 파일
	// restaurantID 업데이트할 식당 아이디
	@RequestMapping(value = "/updateMenuImage.do")
	public ResponseEntity<String> updateMenuImage(
			MultipartHttpServletRequest req,
			@RequestParam("menuID") String menuID,
			@RequestParam("restaurantID") String restaurantID) throws Exception {

		Iterator<String> itr = req.getFileNames();

		Menu vo = new Menu();
		vo.setIndex(Integer.parseInt(menuID));
		vo.setRestaurant_index(Integer.parseInt(restaurantID));
		String requestUrl = new String(req.getRequestURL());
		System.out.println(requestUrl);
		String fullpath;
		while (itr.hasNext()) {
			MultipartFile mpf = req.getFile(itr.next());
			fullpath = Util_bin.fileUpload(mpf);

			vo.setImg_path_str(fullpath);
			restaurantMenuService.UpdateMenuImage(vo);
		}

		Map<String, Object> responseMap = new HashMap<>();
		String json;
		HttpStatus resultstate = HttpStatus.OK;
		json = Util_bin.AddHttpStateAndJson(responseMap, resultstate, true);
		
		return new ResponseEntity<String>(json, resultstate);
	}
}
