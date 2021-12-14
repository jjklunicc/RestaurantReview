package restaurant.reviewManagement.service.impl;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;
import org.springframework.stereotype.Repository;
import restaurant.reviewManagement.service.ReviewDefaultVO;
import restaurant.reviewManagement.service.ReviewUserRecoVO;
import restaurant.reviewManagement.service.ReviewVO;

import java.util.List;

@Repository("reviewUserRecoDAO")
public class ReviewUserRecoDAO extends EgovAbstractDAO {

    // 등록
    public void insertReviewUserReco(ReviewUserRecoVO vo) throws Exception {
        insert("reviewUserRecoDAO.insertReviewUserReco", vo);
    }
    // 삭제
    public void deleteReviewUserReco(ReviewUserRecoVO vo) throws Exception {
        delete("reviewUserRecoDAO.deleteReviewUserReco", vo);
    }

    // 조회
    public ReviewUserRecoVO selectReviewUserReco(ReviewUserRecoVO vo) throws Exception {
        return (ReviewUserRecoVO) select("reviewUserRecoDAO.selectReviewUserReco", vo);
    }

    // 목록 조회
    public List<?> selectReviewUserRecoList(ReviewUserRecoVO vo) throws Exception {
        return list("reviewUserRecoDAO.selectReviewUserRecoList", vo);
    }

    // 수 조회
    public int selectReviewUserRecoListTotCnt(ReviewUserRecoVO vo) {
        return (Integer) select("reviewUserRecoDAO.selectReviewUserRecoListTotCnt", vo);
    }

}