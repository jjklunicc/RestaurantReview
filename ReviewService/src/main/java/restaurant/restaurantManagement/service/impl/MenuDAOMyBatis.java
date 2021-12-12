package restaurant.restaurantManagement.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;


import egovframework.rte.psl.dataaccess.EgovAbstractMapper;
import restaurant.restaurantManagement.domain.Menu;
import restaurant.restaurantManagement.service.IMenuService;

@Repository("daoMyBatis")
public class MenuDAOMyBatis extends EgovAbstractMapper implements IMenuService {
	private static final Logger LOGGER = LoggerFactory.getLogger(MenuServiceImpl.class);

	@Override
	public String insertMenu(Menu vo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateMenu(Menu vo) throws Exception {
		// TODO Auto-generated method stub
		update("updateMenu",vo);
	}

	@Override
	public void deleteMenu(Menu vo) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Menu selectMenu(Menu vo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Menu> selectMenuList(Menu vo) throws Exception {
		// TODO Auto-generated method stub
		return selectList("selectMenuListAll", vo);
	}

	@Override
	public int selectMenuListTotCnt(Menu vo) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Menu> selectRestaurantIndex(Menu vo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Menu> lstRestaurantSelect(Menu vo) throws Exception {
		// TODO Auto-generated method stub
		return selectList("selectRestaurantIndex", vo);
	}
	
	
	

}
