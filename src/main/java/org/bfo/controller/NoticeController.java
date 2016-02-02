package org.bfo.controller;

import javax.inject.Inject;
import org.bfo.domain.Criteria;
import org.bfo.domain.NoticeVO;
import org.bfo.domain.PageMaker;
import org.bfo.service.NoticeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value = "/notice/*")
public class NoticeController {

	private static final Logger logger = LoggerFactory.getLogger(PollController.class);

	@Inject
	private NoticeService service;
	
	@RequestMapping(value = "/nlist", method = RequestMethod.GET)
	public String list(@ModelAttribute("cri") Criteria cri, Model model) throws Exception {
		logger.info("============ nlist ============");
		model.addAttribute("list", service.list(cri));
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.listCount(cri));
		model.addAttribute("pageMaker", pageMaker);
		return "/notice/nlist";
	}
	
	@RequestMapping(value = "/nregist", method = RequestMethod.GET)
	public void registGET(NoticeVO vo, Model model) throws Exception {
		logger.info("============ nregist get ============");
	}
	
	@RequestMapping(value = "/nregist", method = RequestMethod.POST)
	public String registPOST(NoticeVO vo, RedirectAttributes rttr) throws Exception {
		logger.info("============ nregist post ============");
		service.regist(vo);		
		rttr.addFlashAttribute("msg", "success");
		return "redirect:/notice/nlist";
	}
	
	@RequestMapping(value = "/nview", method = RequestMethod.GET)
	public void view(@RequestParam("nno") int nno, @ModelAttribute("cri") Criteria cri,
					Model model) throws Exception {
		logger.info("============ view get ============");
		model.addAttribute(service.view(nno));
	}
	
	@RequestMapping(value = "/nmodify", method = RequestMethod.GET)
	public void modifyGET(@ModelAttribute("noticeVO") NoticeVO vo, @ModelAttribute("cri") Criteria cri, Model model) throws Exception {
		logger.info("============ modify get ============");
//		model.addAttribute(service.view(nno));
	}
	
	@RequestMapping(value = "/nmodify", method = RequestMethod.POST)
	public String modifyPOST(NoticeVO vo, Criteria cri, RedirectAttributes rttr) throws Exception {
		logger.info("============ modify post ============");
		service.modify(vo);
		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		rttr.addFlashAttribute("msg", "SUCCESS");
		return "redirect:/notice/nlist";
	}
	
	@RequestMapping(value = "/nremove", method = RequestMethod.POST)
	public String remove(@RequestParam("nno") int nno, Criteria cri, RedirectAttributes rttr) throws Exception {
		logger.info("============ remove post ============");
		service.remove(nno);
		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		rttr.addFlashAttribute("msg", "SUCCESS");
		return "redirect:/notice/nlist";
	}
}
