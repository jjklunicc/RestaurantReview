package restaurant.reviewManagement.service.impl;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import restaurant.reviewManagement.service.ReviewDefaultVO;
import restaurant.reviewManagement.service.ReviewVO;

import java.util.List;

@Mapper("reviewMapper")
public interface ReviewMapper {

	void insertReview(ReviewVO vo) throws Exception;

	void updateReview(ReviewVO vo) throws Exception;

	void deleteReview(ReviewVO vo) throws Exception;

	ReviewVO selectReview(ReviewVO vo) throws Exception;

	List<?> selectReviewList(ReviewDefaultVO searchVO) throws Exception;

	int selectReviewListTotCnt(ReviewDefaultVO searchVO);

}
