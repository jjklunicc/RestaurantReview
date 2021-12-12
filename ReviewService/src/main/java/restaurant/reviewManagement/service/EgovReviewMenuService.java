package restaurant.reviewManagement.service;

import java.util.List;

public interface EgovReviewMenuService {

    // 등록
	int insertReviewMenu(ReviewMenuVO vo) throws Exception;

    // 수정
	void updateReviewMenu(ReviewMenuVO vo) throws Exception;

    // 삭제
	void deleteReviewMenu(ReviewMenuVO vo) throws Exception;

    // 조회
	ReviewMenuVO selectReviewMenu(ReviewMenuVO vo) throws Exception;

    // 목록 조회
	List<?> selectReviewMenuList(ReviewMenuDefaultVO searchVO) throws Exception;
}
