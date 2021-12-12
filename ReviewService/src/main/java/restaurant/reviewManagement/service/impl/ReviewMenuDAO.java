package restaurant.reviewManagement.service.impl;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;
import org.springframework.stereotype.Repository;
import restaurant.reviewManagement.service.ReviewMenuDefaultVO;
import restaurant.reviewManagement.service.ReviewMenuVO;

import java.util.List;

@Repository("reviewMenuDAO")
public class ReviewMenuDAO extends EgovAbstractDAO {

    // 등록
    public String insertReviewMenu(ReviewMenuVO vo) throws Exception {
        return (String) insert("ReviewMenuDAO.insertReviewMenu", vo);
    }

    // 수정
    public void updateReviewMenu(ReviewMenuVO vo) throws Exception {
        update("ReviewMenuDAO.updateReviewMenu", vo);
    }

    // 삭제
    public void deleteReviewMenu(ReviewMenuVO vo) throws Exception {
        delete("ReviewMenuDAO.deleteReviewMenu", vo);
    }

    // 조회
    public ReviewMenuVO selectReviewMenu(ReviewMenuVO vo) throws Exception {
        return (ReviewMenuVO) select("ReviewMenuDAO.selectReviewMenu", vo);
    }

    // 목록 조회
    public List<?> selectReviewMenuList(ReviewMenuDefaultVO searchVO) throws Exception {
        return list("ReviewMenuDAO.selectReviewMenuList", searchVO);
    }

}