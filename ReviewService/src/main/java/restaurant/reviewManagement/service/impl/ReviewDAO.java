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
        insert("reviewDAO.insertReview", vo);
    }

    // 수정
    public void updateReview(ReviewVO vo) throws Exception {
        update("reviewDAO.updateReview", vo);
    }

    // 삭제
    public void deleteReview(ReviewVO vo) throws Exception {
        delete("reviewDAO.deleteReview", vo);
    }

    // 조회
    public ReviewVO selectReview(ReviewVO vo) throws Exception {
        return (ReviewVO) select("reviewDAO.selectReview", vo);
    }

    // 목록 조회
    public List<?> selectReviewList(ReviewDefaultVO searchVO) throws Exception {
        return list("reviewDAO.selectReviewList", searchVO);
    }

    // 리뷰 수 조회
    public int selectReviewListTotCnt(ReviewDefaultVO searchVO) {
        return (Integer) select("reviewDAO.selectReviewListTotCnt", searchVO);
    }

}