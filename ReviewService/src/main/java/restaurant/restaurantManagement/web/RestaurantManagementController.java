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
import java.util.List;
import java.util.Map;

import restaurant.restaurantManagement.cmmn.Util_bin;
import restaurant.restaurantManagement.service.RestaurantManagementService;
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
import org.springmodules.validation.commons.DefaultBeanValidator;

import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class RestaurantManagementController {

	private String TestJspStr = "restaurant/restaurantmanagementtest";
	private String imgtest = "restaurant/ImgUploadTest";

	/** EgovSampleService */
	@Resource(name = "restaurantManagementService")
	private RestaurantManagementService restaurantService;

	@RequestMapping(value = "/imgtest.do")
	public String GoImgTest(ModelMap model) throws Exception {

		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!GoImgTest!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		return imgtest;
	}
	// 카테고리별 식당을 반환한다.
	// request 
	// category - 검색하려는 카테고리
	@RequestMapping(value = "/lstRestaurant.do", method = RequestMethod.GET)
	public ResponseEntity<String> lstRestaurant(@RequestParam("category") String category) throws Exception {
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!lstRestaurant!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");

		int requestcategory = Integer.parseInt(category.toString());
		RestaurantVO newvo = new RestaurantVO();
		newvo.setCategory(requestcategory);
		List<?> sqlresult = restaurantService.SelectCategoryRestaurant(newvo);
		Map<String, Object> responseMap = new HashMap<>();

		HttpStatus resultstate = HttpStatus.OK;
		if (sqlresult != null) {
			for (Object vo : sqlresult) {

				RestaurantVO resultvo = (RestaurantVO) vo;
				if (resultvo.getImg_path_str() != null || resultvo.getImg_path_str().trim() != "") {
					resultvo.setImg_src(Util_bin.ImgTobyte(resultvo.getImg_path_str()));

				}
			}
			responseMap.put("lstRestaurant", sqlresult);
		}
		String json = Util_bin.AddHttpStateAndJson(responseMap, resultstate);
		return new ResponseEntity<String>(json, resultstate);

	}
	// 한 식당의 상세정보 표시 (식당테이블의 모든 컬럼 반환)
	// request 
	// restaurantID - 검색하려는 식당 id
	@RequestMapping(value = "/restaurantInformation.do", method = RequestMethod.GET)
	public ResponseEntity<String> restaurantInformation(@RequestParam("restaurantID") String restaurantID)
			throws Exception {
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!restaurantInformation!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		System.out.println(restaurantID);

		int requestrestaurantID = Integer.parseInt(restaurantID.toString());

		RestaurantVO newvo = new RestaurantVO();
		newvo.setIndex(requestrestaurantID);

		RestaurantVO resultnewvo = restaurantService.SelectRestaurant(newvo);
		Map<String, Object> responseMap = new HashMap<>();

		String json;
		HttpStatus resultstate = HttpStatus.OK;
		if (resultnewvo != null) {

			if (resultnewvo.getImg_path_str() != null || resultnewvo.getImg_path_str().trim() != "") {
				resultnewvo.setImg_src(Util_bin.ImgTobyte(resultnewvo.getImg_path_str()));

			}

			responseMap.put("data", resultnewvo);
		}

		json = Util_bin.AddHttpStateAndJson(responseMap, resultstate, resultnewvo != null);
		return new ResponseEntity<String>(json, resultstate);

	}
	// 한 식당의  정보업데이트
	// request 
	// RestaurantVO - 업데이트하려는 식당의 정보 (member_index를 제외하고 모드 업데이트)
	@RequestMapping(value = "/updateRestaurantInfo.do", method = RequestMethod.POST)
	public ResponseEntity<String> updateRestaurantInfo(@ModelAttribute("RestaurantVO") RestaurantVO vo)
			throws Exception {
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!updateRestaurantInfo!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");

		// category컬럼이 1~11 사이값이 아닌경우 쿼리가 실패함. 0도 마찬가지. (제약조건)
		// member_index 컬럼은 백엔드에서도 변경은 안함.(첫 insert시 고정되는 값이라고 생각함)
		restaurantService.UpdateRestaurant(vo);

		Map<String, Object> responseMap = new HashMap<>();
		String json;
		HttpStatus resultstate = HttpStatus.OK;
		json = Util_bin.AddHttpStateAndJson(responseMap, resultstate, true);
		System.out.println(json);
		return new ResponseEntity<String>(json, resultstate);
	}
	//이미지 테스트용 
	//request
	//restaurantID 이미지를 얻어올 식당 아이디(인덱스)
	//디비에 저장된 이미지 경로에 이미지가 있는경우 해당 이미지 파일을 바이너리로 변환 후 전송 
	@RequestMapping(value = "/restaurantInformationtest.do", method = RequestMethod.GET)
	public String restaurantInformationtest(@RequestParam("restaurantID") String restaurantID, Model model)
			throws Exception {
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!restaurantInformation!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");

		int requestrestaurantID = Integer.parseInt(restaurantID.toString());

		RestaurantVO newvo = new RestaurantVO();
		newvo.setIndex(requestrestaurantID);

		RestaurantVO resultnewvo = restaurantService.SelectRestaurant(newvo);

		if (resultnewvo != null) {

			if (resultnewvo.getImg_path_str() != null || resultnewvo.getImg_path_str().trim() != "") {
				resultnewvo.setImg_src(Util_bin.ImgTobyte(resultnewvo.getImg_path_str()));
				// System.out.println(new
				// String(Base64.getEncoder().encode(resultnewvo.getImg_src())));

			}
		}
		model.addAttribute("data", resultnewvo);
		return "restaurant/ImgTest";
	}

//	
//	@RequestMapping(value = "/GoRestaurantManagementTestPage.do")
//	public String GoRestaurantManagementTestPage(ModelMap model) throws Exception {
//
//		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!GoRestaurantManagementTestPage!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
//		return TestJspStr;
//	}
//
//	@RequestMapping(value = "/addrestaurantManagement.do")
//	public String addRestaurant(@ModelAttribute("RestaurantVO") RestaurantVO vo, ModelMap model) throws Exception {
//
//		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!addRestaurant!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
//		RestaurantVO newvo = new RestaurantVO();
//
//		newvo.setMember_index(20);
//		newvo.setAddress("주소");
//		newvo.setBusiness_hours("영업시간");
//		newvo.setBusiness_name("가게이름");
//		newvo.setBusiness_number("사업자번호");
//		newvo.setDescription("");
//		newvo.setImg_path_str("C://2sadsad/sada");
//		newvo.setName("");
//		newvo.setPhone_number("");
//		restaurantService.insertRestaurant(newvo);
//
//		return TestJspStr;
//	}
//
//	@RequestMapping("/updaterestaurantManagement.do")
//	public String updateRestaurant(@RequestParam("updateid") int id, Model model) throws Exception {
//		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!updatereataurant!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
//		RestaurantVO newvo = new RestaurantVO();
//		newvo.setIndex(id);
//		newvo.setMember_index(99999);
//		newvo.setAddress("변경됨");
//		newvo.setBusiness_hours("변경됨");
//		newvo.setBusiness_name("변경됨");
//		newvo.setBusiness_number("변경됨");
//		newvo.setDescription("변경됨");
//		newvo.setImg_path_str("변경됨");
//		newvo.setName("변경됨");
//		newvo.setPhone_number("변경됨");
//		restaurantService.UpdateRestaurant(newvo);
//
//		return TestJspStr;
//	}
//
//	@RequestMapping("/deleterestaurantManagement.do")
//	public String deleteRestaurant(@RequestParam("updateid") int id, Model model) throws Exception {
//		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!deleteRestaurant!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
//		RestaurantVO newvo = new RestaurantVO();
//		newvo.setIndex(id);
//		restaurantService.DeleteRestaurant(newvo);
//		return TestJspStr;
//	}
//
//	@RequestMapping("/selectrestaurantManagement.do")
//	public String selectRestaurant(@RequestParam("updateid") int id, Model model) throws Exception {
//		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!selectRestaurant!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
//		RestaurantVO newvo = new RestaurantVO();
//		newvo.setIndex(id);
//		RestaurantVO selectvo = restaurantService.SelectRestaurant(newvo);
//		String json = new ObjectMapper().writeValueAsString(selectvo);
//		model.addAttribute("value1", selectvo.getIndex());
//		model.addAttribute("value2", selectvo.getAddress());
//		model.addAttribute("value3", selectvo.getBusiness_hours());
//		model.addAttribute("value4", selectvo.getBusiness_name());
//		model.addAttribute("value5", selectvo.getBusiness_number());
//		model.addAttribute("value6", selectvo.getDescription());
//		model.addAttribute("value7", selectvo.getImg_path_str());
//		model.addAttribute("value8", selectvo.getMember_index());
//		model.addAttribute("value9", selectvo.getName());
//		model.addAttribute("value10", selectvo.getPhone_number());
//
//		model.addAttribute("valueobj", selectvo);
//		System.out.println(json);
//		return "restaurantManagement/ShowRestaurantSelsect";
//	}
//
//	@RequestMapping("/selectallrestaurantManagement.do")
//	public String selectallRestaurant(Model model) throws Exception {
//		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!selectRestaurant!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
//
//		List<?> selectvo = restaurantService.SelectAllRestaurant();
//		String json = new ObjectMapper().writeValueAsString(selectvo);
//
//		System.out.println(json);
//		return TestJspStr;
//	}
}
