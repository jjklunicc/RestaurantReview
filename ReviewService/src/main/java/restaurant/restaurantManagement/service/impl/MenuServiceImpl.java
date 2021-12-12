package restaurant.restaurantManagement.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;



import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import restaurant.restaurantManagement.domain.Menu;
import restaurant.restaurantManagement.service.IMenuService;

@Service("menuService")
public class MenuServiceImpl  extends EgovAbstractServiceImpl implements IMenuService{
//
	@Resource(name="menuDao")
	private IMenuService menuDao;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MenuServiceImpl.class);
	
	@Override
	public String insertMenu(Menu vo) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("menuService insertMenu입니다.");
		menuDao.insertMenu(vo);
		return null;
	}

	@Override
	public void updateMenu(Menu vo) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("menuService insertMenu입니다.");
		menuDao.updateMenu(vo);
	}

	@Override
	public void deleteMenu(Menu vo) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("menuService insertMenu입니다.");
		menuDao.deleteMenu(vo);
	}

	@Override
	public Menu selectMenu(Menu vo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Menu> selectMenuList(Menu vo) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("menuService selectMenuList입니다.");
		
		return menuDao.selectMenuList(vo);
	}

	@Override
	public int selectMenuListTotCnt(Menu vo) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Menu> lstRestaurantSelect(Menu vo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Menu> selectRestaurantIndex(Menu vo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
