package restaurant.reviewManagement.service.impl;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import restaurant.reviewManagement.service.ReviewUserRecoDefaultVO;
import restaurant.reviewManagement.service.ReviewCommentVO;

import java.util.List;

@Mapper("reviewCommentMapper")
public interface ReviewCommentMapper {

	void insertReviewMenu(ReviewCommentVO vo) throws Exception;

	void updateReviewMenu(ReviewCommentVO vo) throws Exception;

	void deleteReviewMenu(ReviewCommentVO vo) throws Exception;

	ReviewCommentVO selectReviewMenu(ReviewCommentVO vo) throws Exception;

	List<?> selectReviewMenuList(ReviewUserRecoDefaultVO searchVO) throws Exception;

}
