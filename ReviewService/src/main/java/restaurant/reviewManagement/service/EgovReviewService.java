package restaurant.reviewManagement.service;

import java.util.List;

public interface EgovReviewService {

    // 등록
	void insertReview(ReviewVO vo) throws Exception;

    // 수정
	void updateReview(ReviewVO vo) throws Exception;

    // 삭제
	void deleteReview(ReviewVO vo) throws Exception;

    // 조회
	ReviewVO selectReview(ReviewVO vo) throws Exception;

    // 목록 조회
	List<?> selectReviewList(ReviewDefaultVO searchVO) throws Exception;

    // 리뷰 수 조회
	int selectReviewListTotCnt(ReviewDefaultVO searchVO);

}
