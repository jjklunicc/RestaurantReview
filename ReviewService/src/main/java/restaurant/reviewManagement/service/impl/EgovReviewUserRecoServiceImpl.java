package restaurant.reviewManagement.service.impl;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;
import org.springframework.stereotype.Service;
import restaurant.reviewManagement.service.EgovReviewCommentService;
import restaurant.reviewManagement.service.ReviewCommentVO;

import javax.annotation.Resource;

@Service("reviewCommentService")
public class EgovReviewCommentServiceImpl extends EgovAbstractServiceImpl implements EgovReviewUserRecoService {

	@Resource(name = "reviewCommentDAO")
	private ReviewUserRecoDAO reviewUserRecoDAO;

    // 등록
	@Override
	public void insertReviewUserReco(ReviewUserRecoVO vo) throws Exception {
		reviewUserRecoDAO.insertReviewUserReco(vo);
	}

    // 삭제
    @Override
	public void deleteReviewUserReco(ReviewUserRecoVO vo) throws Exception {
		reviewUserRecoDAO.deleteReviewUserReco(vo);
	}

    // 조회
	@Override
	public ReviewCommentVO selectReviewUserReco(ReviewUserRecoVO vo) throws Exception {
		ReviewUserRecoVO resultVO = reviewUserRecoDAO.selectReviewUserReco(vo);
		if (resultVO == null)
			throw processException("info.nodata.msg");
		return resultVO;
	}

	// 목록 조회
	@Override
	public List<?> selectReviewUserRecoList(ReviewUserRecoVO searchVO) throws Exception {
		return reviewUserRecoDAO.selectReviewUserRecoList(searchVO);
	}

	// 리뷰 수 조회
	@Override
	public int selectReviewUserRecoListTotCnt(ReviewUserRecoVO searchVO) {
		return reviewUserRecoDAO.selectReviewUserRecoListTotCnt(searchVO);
	}

}
