package restaurant.restaurantManagement.service;

import java.util.List;

import restaurant.restaurantManagement.domain.Menu;




public interface IMenuService {

	/**
	 * 글을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Menu
	 * @return 등록 결과
	 * @exception Exception
	 */
	String insertMenu(Menu vo) throws Exception;

	/**
	 * 글을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Menu
	 * @return void형
	 * @exception Exception
	 */
	void updateMenu(Menu vo) throws Exception;

	/**
	 * 글을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Menu
	 * @return void형
	 * @exception Exception
	 */
	void deleteMenu(Menu vo) throws Exception;

	/**
	 * 글을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Menu
	 * @return 조회한 글
	 * @exception Exception
	 */
	Menu selectMenu(Menu vo) throws Exception;

	/**
	 * 글 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return 글 목록
	 * @exception Exception
	 */
	List<Menu> selectMenuList(Menu vo) throws Exception;

	/**
	 * 글 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return 글 총 갯수
	 * @exception
	 */
	int selectMenuListTotCnt(Menu vo) throws Exception;
	
	
	public List<Menu> selectRestaurantIndex(Menu vo) throws Exception;
	public List<Menu> lstRestaurantSelect(Menu vo) throws Exception;
}
