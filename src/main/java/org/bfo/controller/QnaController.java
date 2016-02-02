package org.bfo.controller;

import java.util.List;

import javax.inject.Inject;

import org.bfo.domain.Criteria;
import org.bfo.domain.PageMaker;
import org.bfo.domain.QnaVO;
import org.bfo.service.QnaService;
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
@RequestMapping(value="/qna/*")
public class QnaController {

	@Inject
	private QnaService service;
	
	private static final Logger logger = LoggerFactory.getLogger(QnaController.class);
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public void list(@ModelAttribute("cri")Criteria cri,Model model) throws Exception {
		
		logger.info("============qna 잘 들어왔당");
		
		List<QnaVO> list = service.getQnaList(cri);
		
		model.addAttribute("list", list);
		for (int i = 0; i < 10; i++) {
			
			logger.info("====================pw"+i+" : "+list.get(0).getPw());

		}
		
		logger.info("====================페이지메이커만들거다 ");
		PageMaker pageMaker = new PageMaker();
		
		pageMaker.setCri(cri);
		
		logger.info("====================페이지메이커 카운트 크리는 넣어줌 ");
		
		pageMaker.setTotalCount(service.qnaCount(cri));
		
		logger.info("====================페이지메이커 카운트 셋팅 마침 ");
		
		model.addAttribute("pageMaker", pageMaker);
		
		logger.info("====================페이지메이커도 보낸다. ");
	}

	
	
	
	@RequestMapping(value="/regist",method=RequestMethod.GET)
	public void create() throws Exception{
	
		logger.info("============================등록화면으로 갈것.");
	
	}
	
	
	@RequestMapping(value="/regist",method=RequestMethod.POST)
	public String createPost(QnaVO vo,RedirectAttributes rttr) throws Exception{
		
		logger.info("=====================등록작업 할거다");
		
		logger.info("vo: "+vo.toString());
		
		service.qnaReigster(vo);
		
		logger.info("====================등록했다.");
		
		rttr.addFlashAttribute("msg", "REGIST");
		
		return "redirect:/qna/list";
		
	}
	
	@RequestMapping(value="/view",method=RequestMethod.GET)
	public void read(@RequestParam("qnano")int qnano,@ModelAttribute("cri")Criteria cri,Model model) throws Exception{
		
		logger.info("=====================뷰화면");
		
		QnaVO vo =service.QnaView(qnano);
		
		model.addAttribute("VO", vo);
		
		logger.info("==================vo: "+vo.toString());
		
	}
	
	
	@RequestMapping(value="/remove",method=RequestMethod.POST)
	public String remove(@RequestParam("qnano")int qnano,RedirectAttributes rttr,Criteria cri) throws Exception{
		
		logger.info("=======================삭제 할건데");
		
		service.qnaRemove(qnano);
		
		logger.info("=====================삭제함");
		
		rttr.addFlashAttribute("msg", "DELETE");
		
		PageMaker pageMaker = new PageMaker();
		
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.qnaCount(cri));
		
		logger.info("======================삭제할때 cri: "+cri);
		
		return "redirect:/qna/list"+pageMaker.makeSearch(cri.getPage());
	}
	
	
	@RequestMapping(value="/modify",method=RequestMethod.GET)
	public void modify(@RequestParam("qnano")int qnano,Model model,@ModelAttribute("cri")Criteria cri) throws Exception{
		
		logger.info("======================수정하는 페이지");
		
		QnaVO vo = service.QnaView(qnano);
		
		model.addAttribute("VO", vo);
		
		logger.info("--------------------------cri:"+cri.toString());
		
		logger.info("===================vo: "+vo.toString());
		
		
	}
	
	
	@RequestMapping(value="/modify",method=RequestMethod.POST)
	public String modifyPost(QnaVO vo, RedirectAttributes rttr, Criteria cri) throws Exception{
		
		logger.info("=======================이제 수정 처리 할라고");
		logger.info("----------------------받아온 vo:"+vo.toString());
		logger.info("--------------------문제인건가cri:"+cri.toString());
		service.qnaModify(vo);
		
		logger.info("=======================수정되었다");
		
		rttr.addFlashAttribute("msg", "MODIFY");
		
		
		
		PageMaker pageMaker = new PageMaker();
		
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.qnaCount(cri));
		
		return "redirect:/qna/view"+pageMaker.makeSearch(cri.getPage())+"&qnano="+vo.getQnano();
		
	}
	
}
