package restaurant.reviewManagement.service.impl;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;
import org.springframework.stereotype.Service;
import restaurant.reviewManagement.service.EgovReviewMenuService;
import restaurant.reviewManagement.service.ReviewMenuDefaultVO;
import restaurant.reviewManagement.service.ReviewMenuVO;

import javax.annotation.Resource;
import java.util.List;

@Service("reviewMenuService")
public class EgovReviewMenuServiceImpl extends EgovAbstractServiceImpl implements EgovReviewMenuService {

//	private static final Logger LOGGER = LoggerFactory.getLogger(EgovReviewMenuServiceImpl.class);

	@Resource(name = "reviewMenuDAO")
	private ReviewMenuDAO reviewMenuDAO;

//	// TODO mybatis 사용
//	//  @Resource(name="reviewMapper")
//	//	private ReviewMenuMapper reviewDAO;

	/** ID Generation */
	@Resource(name = "egovIdGnrService")
	private EgovIdGnrService egovIdGnrService;

    // 등록
	@Override
	public int insertReviewMenu(ReviewMenuVO vo) throws Exception {
		// LOGGER.debug(vo.toString());

		/** ID Generation Service */
		int id = egovIdGnrService.getNextIntegerId();
		vo.setId(id);
		// LOGGER.debug(vo.toString());

		reviewMenuDAO.insertReviewMenu(vo);
		return id;
	}

    // 수정
	@Override
	public void updateReviewMenu(ReviewMenuVO vo) throws Exception {
		reviewMenuDAO.updateReviewMenu(vo);
	}

    // 삭제
    @Override
	public void deleteReviewMenu(ReviewMenuVO vo) throws Exception {
		reviewMenuDAO.deleteReviewMenu(vo);
	}

    // 조회
	@Override
	public ReviewMenuVO selectReviewMenu(ReviewMenuVO vo) throws Exception {
		ReviewMenuVO resultVO = reviewMenuDAO.selectReviewMenu(vo);
		if (resultVO == null)
			throw processException("info.nodata.msg");
		return resultVO;
	}

    // 목록 조회
	@Override
	public List<?> selectReviewMenuList(ReviewMenuDefaultVO searchVO) throws Exception {
		return reviewMenuDAO.selectReviewMenuList(searchVO);
	}
}
