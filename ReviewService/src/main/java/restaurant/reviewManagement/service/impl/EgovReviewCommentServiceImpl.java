package restaurant.reviewManagement.service.impl;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;
import org.springframework.stereotype.Service;
import restaurant.reviewManagement.service.EgovReviewCommentService;
import restaurant.reviewManagement.service.ReviewCommentVO;

import javax.annotation.Resource;

@Service("reviewCommentService")
public class EgovReviewCommentServiceImpl extends EgovAbstractServiceImpl implements EgovReviewCommentService {

//	private static final Logger LOGGER = LoggerFactory.getLogger(EgovReviewCommentServiceImpl.class);

	@Resource(name = "reviewCommentDAO")
	private ReviewCommentDAO reviewCommentDAO;

//	// TODO mybatis 사용
//	//  @Resource(name="reviewMapper")
//	//	private ReviewCommentMapper reviewDAO;

	/** ID Generation */
	@Resource(name = "egovIdGnrService")
	private EgovIdGnrService egovIdGnrService;

    // 등록
	@Override
	public int insertReviewComment(ReviewCommentVO vo) throws Exception {
		// LOGGER.debug(vo.toString());

		/** ID Generation Service */
		int id = egovIdGnrService.getNextIntegerId();
		vo.setId(id);
		// LOGGER.debug(vo.toString());

		reviewCommentDAO.insertReviewComment(vo);
		return id;
	}

    // 수정
	@Override
	public void updateReviewComment(ReviewCommentVO vo) throws Exception {
		reviewCommentDAO.updateReviewComment(vo);
	}

    // 삭제
    @Override
	public void deleteReviewComment(ReviewCommentVO vo) throws Exception {
		reviewCommentDAO.deleteReviewComment(vo);
	}

    // 조회
	@Override
	public ReviewCommentVO selectReviewComment(ReviewCommentVO vo) throws Exception {
		ReviewCommentVO resultVO = reviewCommentDAO.selectReviewComment(vo);
		if (resultVO == null)
			throw processException("info.nodata.msg");
		return resultVO;
	}
}
