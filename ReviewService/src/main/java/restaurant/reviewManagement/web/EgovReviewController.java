package restaurant.reviewManagement.web;

import egovframework.rte.fdl.property.EgovPropertyService;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import restaurant.reviewManagement.service.*;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springmodules.validation.commons.DefaultBeanValidator;

@Controller
public class EgovReviewController {

	/** EgovReviewService */
	@Resource(name = "reviewService")
	private EgovReviewService reviewService;

	@Resource(name = "reviewCommentService")
	private EgovReviewCommentService reviewCommentService;

	@Resource(name = "reviewUserRecoService")
	private EgovReviewUserRecoService reviewUserRecoService;

	/** Validator */
	@Resource(name = "beanValidator")
	protected DefaultBeanValidator beanValidator;

	@RequestMapping(value = "/reviewMain.do", method = RequestMethod.GET)
	public String selectReviewMainView(@ModelAttribute("searchVO") ReviewDefaultVO searchVO, Model model) throws Exception {
		model.addAttribute("resultList", reviewService.selectReviewList(searchVO));
		for (Model m : model.getAttribute("resultList")) {
			ReviewUserRecoVO reviewUserRecoVO = new reviewUserRecoVO();
			reviewUserRecoVO.setReviewId((Integer) m.getAttribute("id"));
			m.addAttribute("likeCnt", reviewUserRecoService.selectReviewUserRecoListTotCnt(reviewUserRecoVO));
		}
		model.addAttribute("total", reviewService.selectReviewListTotCnt(searchVO));
		return "review/main";
	}

	@RequestMapping(value = "/reviewMain_orderStar.do", method = RequestMethod.GET)
	public String selectReviewMainView(@ModelAttribute("searchVO") ReviewDefaultVO searchVO, Model model) throws Exception {
		model.addAttribute("resultList", reviewService.selectReviewOrderStarList(searchVO));
		model.addAttribute("total", reviewService.selectReviewListTotCnt(searchVO));
		return "review/main";
	}

	@RequestMapping(value = "/detailReview.do", method = RequestMethod.GET)
	public String detailReviewView(@ModelAttribute("searchVO") ReviewDefaultVO searchVO, ReviewVO reviewVO, Model model) throws Exception {
		model.addAttribute("reviewVO", reviewService.selectReview(reviewVO));
		ReviewCommentVO reviewCommentVO = new ReviewCommentVO();
		reviewCommentVO.setReviewId(reviewVO.getId());
		model.addAttribute("reviewCommentVO", reviewCommentService.selectReviewComment(reviewCommentVO));
		ReviewUserRecoVO reviewUserRecoVO = new reviewUserRecoVO();
		reviewUserRecoVO.setReviewId(reviewVO.getId());
		model.addAttribute("likeCnt", reviewUserRecoService.selectReviewUserRecoListTotCnt(reviewUserRecoVO));
		return "review/detail";
	}

	@RequestMapping(value = "/addReview.do", method = RequestMethod.GET)
	public String addReviewView(@ModelAttribute("searchVO") ReviewDefaultVO searchVO, Model model) throws Exception {
		model.addAttribute("reviewVO", new ReviewVO());
		return "review/form";
	}

	@RequestMapping(value = "/addReview.do", method = RequestMethod.POST)
	public String addReview(@ModelAttribute("searchVO") ReviewDefaultVO searchVO, ReviewVO reviewVO, BindingResult bindingResult, Model model, SessionStatus status)
			throws Exception {

		beanValidator.validate(reviewVO, bindingResult);

		if (bindingResult.hasErrors()) {
			model.addAttribute("reviewVO", reviewVO);
			return "review/form";
		}

		reviewService.insertReview(reviewVO);
		status.setComplete();
		return "redirect:/reviewMain.do";
	}

	@RequestMapping(value = "/updateReview.do", method = RequestMethod.GET)
	public String updateReviewView(@ModelAttribute("searchVO") ReviewDefaultVO searchVO, Model model) throws Exception {
		model.addAttribute("reviewVO", new ReviewVO());
		return "review/form";
	}

	@RequestMapping(value = "/updateReview.do", method = RequestMethod.POST)
	public String updateReview(@ModelAttribute("searchVO") ReviewDefaultVO searchVO, ReviewVO reviewVO, BindingResult bindingResult, Model model, SessionStatus status)
			throws Exception {

		beanValidator.validate(reviewVO, bindingResult);

		if (bindingResult.hasErrors()) {
			model.addAttribute("reviewVO", reviewVO);
			return "review/form";
		}

		reviewService.updateReview(reviewVO);
		status.setComplete();
		return "redirect:/reviewMain.do";
	}

	@RequestMapping(value = "/deleteReview.do", method = RequestMethod.POST)
	public String deleteReviewView(ReviewVO reviewVO, Model model) throws Exception {
		reviewService.deleteReview(reviewVO);
		return "redirect:/reviewMain.do";
	}
}
