package restaurant.reviewManagement.service;

public interface EgovReviewCommentService {

    // 등록
	void insertReviewComment(ReviewCommentVO vo) throws Exception;

    // 수정
	void updateReviewComment(ReviewCommentVO vo) throws Exception;

    // 삭제
	void deleteReviewComment(ReviewCommentVO vo) throws Exception;

    // 조회
	ReviewCommentVO selectReviewComment(ReviewCommentVO vo) throws Exception;
}
