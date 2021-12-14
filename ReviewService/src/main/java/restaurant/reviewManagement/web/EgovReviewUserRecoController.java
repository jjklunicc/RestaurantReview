package restaurant.reviewManagement.web;

import egovframework.rte.fdl.property.EgovPropertyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springmodules.validation.commons.DefaultBeanValidator;
import restaurant.reviewManagement.service.*;

import javax.annotation.Resource;

@Controller
public class EgovReviewUserRecoController {

	/** EgovReviewUserRecoService */
	@Resource(name = "reviewUserRecoService")
	private EgovReviewUserRecoService reviewUserRecoService;

	/** Validator */
	@Resource(name = "beanValidator")
	protected DefaultBeanValidator beanValidator;

	@RequestMapping(value = "/addReviewUserReco.do", method = RequestMethod.POST)
	public String addReviewUserReco(@ModelAttribute("searchVO") ReviewUserRecoDefaultVO searchVO, ReviewUserRecoVO reviewUserRecoVO, BindingResult bindingResult, Model model, SessionStatus status, RedirectAttributes redirectAttributes)
			throws Exception {

		beanValidator.validate(reviewUserRecoVO, bindingResult);

		if (bindingResult.hasErrors()) {
			model.addAttribute("reviewUserRecoVO", reviewUserRecoVO);
			return "redirect:/reviewMain.do";
		}

		reviewUserRecoService.insertReviewUserReco(reviewUserRecoVO);
		status.setComplete();

		ReviewVO redirectReviewVO = new ReviewVO();
		redirectReviewVO.setId(reviewUserRecoVO.getReviewId());
		redirectAttributes.addAttribute("reviewVO", redirectReviewVO);
		return "redirect:/detailReview.do";
	}

	@RequestMapping(value = "/deleteReviewUserReco.do", method = RequestMethod.POST)
	public String deleteReviewViewUserReco(ReviewUserRecoVO reviewUserRecoVO, Model model, RedirectAttributes redirectAttributes) throws Exception {
		reviewUserRecoService.deleteReviewUserReco(reviewUserRecoVO);

		ReviewVO redirectReviewVO = new ReviewVO();
		redirectReviewVO.setId(reviewUserRecoVO.getReviewId());
		redirectAttributes.addAttribute("reviewVO", redirectReviewVO);
		return "redirect:/detailReview.do";
	}
}
