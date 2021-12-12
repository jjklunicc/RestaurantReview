package restaurant.restaurantManagement.web;



import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import restaurant.restaurantManagement.cmmn.Util_bin;
import restaurant.restaurantManagement.domain.CountryOfOrginInformation;
import restaurant.restaurantManagement.domain.Menu;
import restaurant.restaurantManagement.domain.RestaurantCategory;
import restaurant.restaurantManagement.domain.Shoppingbasket;

import restaurant.restaurantManagement.service.CountryOfOrginInformationService;
import restaurant.restaurantManagement.service.IMenuService;
import restaurant.restaurantManagement.service.RestaurantCategoryService;
import restaurant.restaurantManagement.service.RestaurantVO;
import restaurant.restaurantManagement.service.ShoppingbasketService;

@Controller
public class RestaurantController {

	@Resource(name="daoMyBatis")
	private IMenuService menuservice;
	
	@Resource(name="countryOfOrginInformationService")
	private CountryOfOrginInformationService countryOfOrginInformationService;
	
	@Resource(name="restaurantCategoryService")
	private RestaurantCategoryService restaurantCategoryService;
	
	@Resource(name="shoppingbasketService")
	private ShoppingbasketService shoppingbasketService;
	
	
	@RequestMapping(value="/lstRestaurantCategory.do", method=RequestMethod.GET, produces = "application/json; charset=utf8")
	public String lstRestaurantCategory(ModelMap model)throws Exception{
	
		RestaurantCategory restaurantCategory= new RestaurantCategory();
		List<RestaurantCategory> sqlResult= restaurantCategoryService.SelectRestaurantCategoryList(restaurantCategory);
			System.out.println("sqlResult"+sqlResult);
		Map<String, Object> responseMap = new HashMap<>();
		HttpStatus state = HttpStatus.OK;
		responseMap.put("listRestaurant",  sqlResult);
		String json =Util_bin.AddHttpStateAndJson(responseMap, state);
		model.addAttribute("responseEntity",new ResponseEntity<String>(json, state));
		return "redirect:/";
	}
	

	@RequestMapping(value="/lstRestaurantMenu.do", method=RequestMethod.GET, produces = "application/json; charset=utf8")
	public String lstRestaurantMenu(@RequestParam("category")int restaurant_index, ModelMap model)throws Exception{
		
		Menu menu= new Menu();
		menu.setRestaurant_index(restaurant_index);
		List<Menu> sqlResult;
		Map<String, Object> responseMap = new HashMap<>();
		HttpStatus 	state;
		 
		/**
		 *  0일때 식당 카테고리 전체 보여주기 1 이상일때는 선택된 식당 카테고리보여주기 
		 */
		if(restaurant_index!=0) {		
			sqlResult=  menuservice.lstRestaurantSelect(menu);

		}else {
			
			sqlResult=  menuservice.selectMenuList(menu);
		}		
		state = HttpStatus.OK;		
		System.out.println("sqlResult"+sqlResult);	
		if(sqlResult != null) {	
			//이미지 바이너리 주입
			for (Object vo : sqlResult) {

				Menu resultvo = (Menu) vo;
				if (resultvo.getImg_path_str() != null || resultvo.getImg_path_str().trim() != "") {
					resultvo.setImg_src(Util_bin.ImgTobyte(resultvo.getImg_path_str()));

				}
			}
			
			
			responseMap.put("listRestaurant",  sqlResult);		
		}		
		String json =Util_bin.AddHttpStateAndJson(responseMap, state);
		model.addAttribute("responseEntity",new ResponseEntity<String>(json, state));
		return "redirect:/";
	}
	


	
	@RequestMapping(value="/updateMenuInfo.do", method=RequestMethod.POST, produces = "application/json; charset=utf8")
	public String updateMenuInfo(@ModelAttribute("menuVo") Menu menu, ModelMap model)throws Exception{
		
		menuservice.updateMenu(menu);	
		Map<String, Object> responseMap = new HashMap<>();
		HttpStatus 	state = HttpStatus.OK;	

			
		String json =Util_bin.AddHttpStateAndJson(responseMap, state, true);
		model.addAttribute("responseEntity",new ResponseEntity<String>(json, state));
		return "redirect:/";
		
	}
	
	
	
	//?
	@RequestMapping(value="/insertForwardingMenu.do", method=RequestMethod.POST, produces = "application/json; charset=utf8")
	public String insertForwardingMenu(				ModelMap model,
													@RequestParam("user_index")int user_index,
													@RequestParam("restaurantID")int restaurantID,
													@RequestParam("menu_index")int munu_index,
													@RequestParam("count")int count													
		)throws Exception{
		String date=LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyy-MM-dd HH:MM:SS "));
		Shoppingbasket shoppingbasket = new Shoppingbasket( user_index, restaurantID, munu_index,count, date);
		
		shoppingbasketService.InsertForwardingMenu(shoppingbasket);
		List<Shoppingbasket> list=shoppingbasketService.SelectShoppingbasketList(shoppingbasket);
		
		Map<String, Object> responseMap = new HashMap<>();
		responseMap.put("SelectShoppingbasketList", list);
		HttpStatus 	state = HttpStatus.OK;	
		String json =Util_bin.AddHttpStateAndJson(responseMap, state);
		
		model.addAttribute("responseEntity", new ResponseEntity<String>( json ,state));
		return "redirect:/";
	}

	
	
	

	
	//api에 없어서 냅뒀음.
	@RequestMapping(value="/FindMenuCountryOfOrginInformation.do", method=RequestMethod.GET, produces = "application/json; charset=utf8")
	public String findMenuCountryOfOrginInformation(
												    @ModelAttribute("menuVo") Menu menu,
													@ModelAttribute("countryOfOrginInformationVo") CountryOfOrginInformation countryOfOrginInformation,
													ModelMap model
			)throws Exception{
		
		HashMap<String, Object> inputMap= new HashMap<String, Object>();
		inputMap.put("countryOfOrginInformationVo", countryOfOrginInformation);	
		inputMap.put("menuVo", menu);
		
		List<Object> sqlResult=countryOfOrginInformationService.FindMenuCountryOfOrginInformation(inputMap);
		
		Map<String, Object> responseMap = new HashMap<>();
		responseMap.put("listRestaurant",  sqlResult);	
		
		HttpStatus 	state = HttpStatus.OK;	
		String json =Util_bin.AddHttpStateAndJson(responseMap, state);
		
		model.addAttribute("responseEntity",new ResponseEntity<String>(json, state));
		return "redirect:/";
	}

	
	
	
	
	
	
//	@GetMapping("/lstRestaurantCategory2.do")
//	public String testURL(Model model) throws Exception{
//		return "redirect:lstRestaurantCategory2.jsp";
//	}
//	@RequestMapping(value="/lstRestaurantCategory.do", method=RequestMethod.POST)
//	public String lstRestaurantTest2(@RequestParam("id") int id , Model model) throws Exception{
//		System.out.println("lstRestaurantCategory.do");
//		
//		Menu menu=new Menu(null, id, "", 0, "", "");
//		List<Menu>list=	menuservice.lstRestaurantSelect(menu);
//		//json형으로 넘기는법.	
//		String lstRestaurant = new ObjectMapper().writeValueAsString(list);
//		System.out.println("lstRestaurant" );
//		
//		model.addAttribute("lstRestaurant", lstRestaurant);
//		model.addAttribute("a", "test");
//		return"redirect:/lstRestaurantCategory2.jsp";	
//	}
	
//	@RequestMapping(value="/lstRestaurantCategory.do", method=RequestMethod.GET)
//	public String lstRestaurantTest(@RequestParam("id") int id,ModelMap model) throws Exception{
//		System.out.println("lstRestaurantCategory2.do");
//		Menu menu=new Menu(null, id, "", 0, "", "");
//		List<Menu>list=	menuservice.lstRestaurantSelect(menu);
//		//json형으로 넘기는법.	
//		String lstRestaurant = new ObjectMapper().writeValueAsString(list);
//		
//		
//		model.addAttribute("lstRestaurant", lstRestaurant);
//		return"redirect:/lstRestaurantCategory2.jsp";	
//	}	
	
	
	
	
//	
//	@RequestMapping(value="/insertForwardingMenuTest.do", method=RequestMethod.POST, produces = "application/json; charset=utf8")
//	public String insertForwardingMenu(		ModelMap model													
//		)throws Exception{
//		String date=LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyy-MM-dd HH:MM:SS "));
//		Shoppingbasket shoppingbasket = new Shoppingbasket( 1, 1, 4,1, date);
//		
//		shoppingbasketService.InsertForwardingMenu(shoppingbasket);
//		List<Shoppingbasket> list=shoppingbasketService.SelectShoppingbasketList(shoppingbasket);
//		
//		Map<String, Object> responseMap = new HashMap<>();
//		responseMap.put("SelectShoppingbasketList", list);
//		HttpStatus 	state = HttpStatus.OK;	
//		HttpHeaders httpHeaders = new HttpHeaders();
//		URI location = new URI("/testaurant/RestaurantCategory");
//		httpHeaders.setLocation(location);
//		String json =Util_bin.AddHttpStateAndJson(responseMap, state);
//		
//		model.addAttribute("responseEntity", new ResponseEntity<String>( json ,state));
//		return "redirect:/";	
//	}
	
}	