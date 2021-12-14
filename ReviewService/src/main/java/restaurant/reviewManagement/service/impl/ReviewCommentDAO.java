package restaurant.reviewManagement.service.impl;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;
import org.springframework.stereotype.Repository;
import restaurant.reviewManagement.service.ReviewCommentVO;

@Repository("reviewCommentDAO")
public class ReviewCommentDAO extends EgovAbstractDAO {

    // 등록
    public String insertReviewComment(ReviewCommentVO vo) throws Exception {
        return (String) insert("reviewCommentDAO.insertReviewComment", vo);
    }

    // 수정
    public void updateReviewComment(ReviewCommentVO vo) throws Exception {
        update("reviewCommentDAO.updateReviewComment", vo);
    }

    // 삭제
    public void deleteReviewComment(ReviewCommentVO vo) throws Exception {
        delete("reviewCommentDAO.deleteReviewComment", vo);
    }

    // 조회
    public ReviewCommentVO selectReviewComment(ReviewCommentVO vo) throws Exception {
        return (ReviewCommentVO) select("reviewCommentDAO.selectReviewComment", vo);
    }

}