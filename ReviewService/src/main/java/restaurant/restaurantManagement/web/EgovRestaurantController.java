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

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 개발프레임웍크 실행환경 개발팀
 * @version 1.0
 * @Class Name : EgovSampleController.java
 * @Description : EgovSample Controller Class
 * @Modification Information
 * @
 * @ 수정일      수정자              수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2009.03.16           최초생성
 * @see Copyright (C) by MOPAS All right reserved.
 * @since 2009. 03.16
 */

@Controller
public class EgovRestaurantController {

    @RequestMapping(value = "/restaurantList.do")
    public String selectRestaurantCategory() throws Exception {
        return "restaurant/restaurantCategory";
    }

    @RequestMapping(value = "/restaurant.do")
    public String selectRestaurantList(@Param("category") String category, Model model) throws Exception {
    	model.addAttribute("category", category);
        return "restaurant/restaurantList";
    }

    @RequestMapping(value = "/restaurantDetail.do")
    public String selectRestaurantDetail() throws Exception {
        return "restaurant/restaurant";
    }

    @RequestMapping(value = "/mypage.do")
    public String selectmypage() throws Exception {
        return "user/mypage";
    }

}
