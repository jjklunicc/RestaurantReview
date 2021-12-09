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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springmodules.validation.commons.DefaultBeanValidator;

import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class RestaurantManagementController {

	private String TestJspStr = "restaurant/restaurantmanagementtest";
	private String imgtest = "restaurant/ImgUploadTest";

	/** EgovSampleService */
	@Resource(name = "restaurantManagementService")
	private RestaurantManagementService restaurantService;

	//@RequestMapping(value = "/imgtest.do")
	public String GoImgTest(ModelMap model) throws Exception {

		return imgtest;
	}
	// 카테고리별 식당을 반환한다.
	// request 
	// category - 검색하려는 카테고리
	@RequestMapping(value = "/lstRestaurant.do", method = RequestMethod.GET)
	public ResponseEntity<String> lstRestaurant(@RequestParam("category") String category) throws Exception {

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
	// RestaurantVO - 업데이트하려는 식당의 정보 (member_index를 제외하고 모두 업데이트)
	@RequestMapping(value = "/updateRestaurantInfo.do", method = RequestMethod.POST)
	public ResponseEntity<String> updateRestaurantInfo(@ModelAttribute("RestaurantVO") RestaurantVO vo)
			throws Exception {


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
	//@RequestMapping(value = "/restaurantInformationtest.do", method = RequestMethod.GET)
	public String restaurantInformationtest(@RequestParam("restaurantID") String restaurantID, Model model)
			throws Exception {

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
	
		//해당 Mapping을 사용하는 jsp페이지는 아직없음.
		//이미지업데이트용, 이미지를 서버에 저장, 디비에 경로를 입력한다
		//request 
		//req - 파일
		//restaurantID 업데이트할 식당 아이디
		@RequestMapping(value="/updateRestaurantImage.do") 
		public ResponseEntity<String> updateRestaurantImage(MultipartHttpServletRequest req,@RequestParam("restaurantID") String restaurantID) throws Exception {
			
			Iterator<String> itr = req.getFileNames();
			
			RestaurantVO vo = new RestaurantVO();
			vo.setIndex(Integer.parseInt(restaurantID));
			String requestUrl = new String(req.getRequestURL());
			System.out.println(requestUrl);		
			String fullpath;
			while(itr.hasNext()) {
				MultipartFile mpf = req.getFile(itr.next());
				fullpath=Util_bin.fileUpload(mpf);
				
				vo.setImg_path_str(fullpath);
				restaurantService.UpdateRestaurantImage(vo);
			}
			
			Map<String, Object> responseMap = new HashMap<>();
			String json;
			HttpStatus resultstate = HttpStatus.OK;
			json = Util_bin.AddHttpStateAndJson(responseMap, resultstate, true);
			
			return new ResponseEntity<String>(json, resultstate);
		}
		//이미지 업로드 테스트용 , 파일 선택 및 식당아이디를 입력하여 업로드한다.
		/*@RequestMapping(value="/test_fileUpload.do") 
		public String fileUploadTest(MultipartHttpServletRequest req) throws Exception {
			
			Iterator<String> itr = req.getFileNames();
			
			
			RestaurantVO vo = new RestaurantVO();
			vo.setIndex(Integer.parseInt(req.getParameter("id")));
			String requestUrl = new String(req.getRequestURL());
			System.out.println(requestUrl);		
			String fullpath;
			while(itr.hasNext()) {
				MultipartFile mpf = req.getFile(itr.next());
				fullpath=Util_bin.fileUpload(mpf);
				
				vo.setImg_path_str(fullpath);
				restaurantService.UpdateRestaurantImage(vo);
			}
			
			return "업로드 완료";
		}*/
}
