package restaurant.reviewManagement.service.impl;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;
import org.springframework.stereotype.Service;
import restaurant.reviewManagement.service.EgovReviewService;
import restaurant.reviewManagement.service.ReviewDefaultVO;
import restaurant.reviewManagement.service.ReviewVO;

import javax.annotation.Resource;
import java.util.List;

@Service("reviewService")
public class EgovReviewServiceImpl extends EgovAbstractServiceImpl implements EgovReviewService {

	@Resource(name = "reviewDAO")
	private ReviewDAO reviewDAO;

	// 등록
	@Override
	public void insertReview(ReviewVO vo) throws Exception {
		reviewDAO.insertReview(vo);
	}

    // 수정
	@Override
	public void updateReview(ReviewVO vo) throws Exception {
		reviewDAO.updateReview(vo);
	}

    // 삭제
    @Override
	public void deleteReview(ReviewVO vo) throws Exception {
		reviewDAO.deleteReview(vo);
	}

    // 조회
	@Override
	public ReviewVO selectReview(ReviewVO vo) throws Exception {
		ReviewVO resultVO = reviewDAO.selectReview(vo);
		if (resultVO == null)
			throw processException("info.nodata.msg");
		return resultVO;
	}

    // 목록 조회
	@Override
	public List<?> selectReviewList(ReviewDefaultVO searchVO) throws Exception {
		return reviewDAO.selectReviewList(searchVO);
	}

	@Override
	public List<?> selectReviewOrderStarList(ReviewDefaultVO searchVO) throws Exception {
		return reviewDAO.selectReviewOrderStarList(searchVO);
	}

    // 리뷰 수 조회
	@Override
	public int selectReviewListTotCnt(ReviewDefaultVO searchVO) {
		return reviewDAO.selectReviewListTotCnt(searchVO);
	}
}
