package restaurant.reviewManagement.service.impl;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import restaurant.reviewManagement.service.ReviewMenuDefaultVO;
import restaurant.reviewManagement.service.ReviewMenuVO;

import java.util.List;

@Mapper("reviewMenuMapper")
public interface ReviewMenuMapper {

	void insertReviewMenu(ReviewMenuVO vo) throws Exception;

	void updateReviewMenu(ReviewMenuVO vo) throws Exception;

	void deleteReviewMenu(ReviewMenuVO vo) throws Exception;

	ReviewMenuVO selectReviewMenu(ReviewMenuVO vo) throws Exception;

	List<?> selectReviewMenuList(ReviewMenuDefaultVO searchVO) throws Exception;

}
