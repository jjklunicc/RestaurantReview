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
package restaurant.userManagement.web;

import java.util.List;

import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import restaurant.userManagement.service.EgovUserService;
import restaurant.userManagement.service.UserVO;
import restaurant.userManagement.service.loginVO;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springmodules.validation.commons.DefaultBeanValidator;

@Controller
public class EgovUserController {

	/** EgovSampleService */
	@Resource(name = "userService")
	private EgovUserService userService;

	/** EgovPropertyService */
	@Resource(name = "propertiesService")
	protected EgovPropertyService propertiesService;

	/** Validator */
	@Resource(name = "beanValidator")
	protected DefaultBeanValidator beanValidator;

	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public String selectUser(@ModelAttribute("loginVO") loginVO loginVO, ModelMap model) throws Exception {		
		UserVO userVO = userService.selectUser(loginVO); 
		
		System.out.println(userVO.getId());
		
		return "forward:/restaurantList.do";
	}
	

	@RequestMapping(value = "/login.do", method = RequestMethod.GET)
	public String loginPage() throws Exception {		
		return "user/login";
	}
	
	@RequestMapping(value = "/signUp.do", method = RequestMethod.GET)
	public String signUpPage() throws Exception {		
		return "user/signUp";
	}
	

	@RequestMapping(value = "/signUp.do", method = RequestMethod.POST) 
	public String signUp(UserVO UserVO, Model model, SessionStatus status) throws Exception {
		userService.insertUser(UserVO);
		status.setComplete();
		
		return "forward:/login.do";
	}
}
