package restaurant.reviewManagement.web;

import egovframework.rte.fdl.property.EgovPropertyService;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import restaurant.reviewManagement.service.EgovReviewService;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springmodules.validation.commons.DefaultBeanValidator;
import restaurant.reviewManagement.service.ReviewDefaultVO;
import restaurant.reviewManagement.service.ReviewVO;

@Controller
public class EgovReviewController {

	/** EgovReviewService */
	@Resource(name = "reviewService")
	private EgovReviewService reviewService;

	/** EgovPropertyService */
	@Resource(name = "propertiesService")
	protected EgovPropertyService propertiesService;

	/** Validator */
	@Resource(name = "beanValidator")
	protected DefaultBeanValidator beanValidator;

	@RequestMapping(value = "/reviewMain.do", method = RequestMethod.GET)
	public String selectReviewMainView(@ModelAttribute("searchVO") ReviewDefaultVO searchVO, Model model) throws Exception {
		model.addAttribute("resultList", reviewService.selectReviewList(searchVO));
		model.addAttribute("total", reviewService.selectReviewListTotCnt(searchVO));
		return "review/main";
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
		return "review/main";
	}

	@RequestMapping(value = "/updateReview.do", method = RequestMethod.GET)
	public String updateReviewView(@ModelAttribute("searchVO") ReviewDefaultVO searchVO, Model model) throws Exception {
		model.addAttribute("reviewVO", new ReviewVO());
		return "review/form";
	}

	@RequestMapping(value = "/updateReview.do", method = RequestMethod.PUT)
	public String updateReview(@ModelAttribute("searchVO") ReviewDefaultVO searchVO, ReviewVO reviewVO, BindingResult bindingResult, Model model, SessionStatus status)
			throws Exception {

		beanValidator.validate(reviewVO, bindingResult);

		if (bindingResult.hasErrors()) {
			model.addAttribute("reviewVO", reviewVO);
			return "review/form";
		}

		reviewService.updateReview(reviewVO);
		status.setComplete();
		return "review/main";
	}
}
