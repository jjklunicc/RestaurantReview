package restaurant.reviewManagement.service;

import java.util.List;

public interface EgovReviewUserRecoService {

    // 등록
	void insertReviewUserReco(ReviewUserRecoVO vo) throws Exception;

    // 삭제
	void deleteReviewUserReco(ReviewUserRecoVO vo) throws Exception;

    // 조회
    ReviewUserRecoVO selectReviewUserReco(ReviewUserRecoVO vo) throws Exception;

    // 목록 조회
    List<?> selectReviewUserRecoList(ReviewUserRecoVO vo) throws Exception;

    // 수 조회
    int selectReviewUserRecoListTotCnt(ReviewUserRecoVO vo);
}
