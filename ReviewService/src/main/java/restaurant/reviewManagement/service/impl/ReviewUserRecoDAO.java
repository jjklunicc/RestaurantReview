package restaurant.reviewManagement.service.impl;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;
import org.springframework.stereotype.Repository;
import restaurant.reviewManagement.service.ReviewDefaultVO;
import restaurant.reviewManagement.service.ReviewVO;

import java.util.List;

@Repository("reviewDAO")
public class ReviewDAO extends EgovAbstractDAO {

    // 등록
    public void insertReview(ReviewVO vo) throws Exception {
        insert("reviewUserRecoDAO.insertReviewUserReco", vo);
    }
    // 삭제
    public void deleteReview(ReviewVO vo) throws Exception {
        delete("reviewUserRecoDAO.deleteReviewUserReco", vo);
    }

    // 조회
    public ReviewVO selectReview(ReviewVO vo) throws Exception {
        return (ReviewVO) select("reviewUserRecoDAO.selectReviewUserReco", vo);
    }

    // 목록 조회
    public List<?> selectReviewList(ReviewDefaultVO searchVO) throws Exception {
        return list("reviewUserRecoDAO.selectReviewUserRecoList", searchVO);
    }

    // 수 조회
    public int selectReviewListTotCnt(ReviewDefaultVO searchVO) {
        return (Integer) select("reviewUserRecoDAO.selectReviewUserRecoListTotCnt", searchVO);
    }

}