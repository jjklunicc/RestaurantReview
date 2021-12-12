package restaurant.restaurantManagement.service;

import java.util.List;

import org.springframework.stereotype.Repository;


import egovframework.rte.psl.dataaccess.EgovAbstractDAO;
import restaurant.restaurantManagement.domain.Menu;

@Repository("menuDao")
public class MenuDao extends EgovAbstractDAO implements IMenuService {
	
 public String insertMenu(Menu vo) throws Exception{
	 System.out.println("menuDao insertMenu입니다.");
	 return (String) insert("menuDAO.insertMenu",vo);
 }
 public List<Menu> selectMenuList(Menu vo) throws Exception{
	 return  (List<Menu>) list("menuDAO.selectMenuList");
 }
@Override
public void updateMenu(Menu vo) throws Exception {
	// TODO Auto-generated method stub
		update("updateMenu", vo);
}
@Override
public void deleteMenu(Menu vo) throws Exception {
	// TODO Auto-generated method stub
	delete("deleteMenu", vo);
}
@Override
public Menu selectMenu(Menu vo) throws Exception {
	// TODO Auto-generated method stub
	return null;
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
