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
public class EgovReviewCommentController {

	/** EgovReviewCommentService */
	@Resource(name = "reviewCommentService")
	private EgovReviewCommentService reviewCommentService;

	/** Validator */
	@Resource(name = "beanValidator")
	protected DefaultBeanValidator beanValidator;

	@RequestMapping(value = "/addReviewComment.do", method = RequestMethod.POST)
	public String addReviewComment(@ModelAttribute("searchVO") ReviewCommentDefaultVO searchVO, ReviewCommentVO reviewCommentVO, BindingResult bindingResult, Model model, SessionStatus status, RedirectAttributes redirectAttributes)
			throws Exception {

		beanValidator.validate(reviewCommentVO, bindingResult);

		if (bindingResult.hasErrors()) {
			model.addAttribute("reviewCommentVO", reviewCommentVO);
			return "review/detail";
		}

		reviewCommentService.insertReviewComment(reviewCommentVO);
		status.setComplete();

		ReviewVO redirectReviewVO = new ReviewVO();
		redirectReviewVO.setId(reviewCommentVO.getReviewId());
		redirectAttributes.addAttribute("reviewVO", redirectReviewVO);
		return "redirect:/detailReview.do";
	}
}
