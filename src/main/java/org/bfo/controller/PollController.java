package org.bfo.controller;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.bfo.domain.Criteria;
import org.bfo.domain.FileVO;
import org.bfo.domain.ItemVO;
import org.bfo.domain.MemberVO;
import org.bfo.domain.MyPollArray;
import org.bfo.domain.PageMaker;
import org.bfo.domain.PollVO;
import org.bfo.domain.TextVO;
import org.bfo.service.PollService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value = "/poll/*")
public class PollController {

	private static final Logger logger = LoggerFactory.getLogger(PollController.class);

	@Inject
	private PollService service;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(HttpServletRequest request, @ModelAttribute("cri") Criteria cri, Model model)  throws Exception {
		
		HttpSession session = request.getSession();
		Object obj = new Object();
		MemberVO vo = new MemberVO();
		
		logger.info("---------------mypage 갈라고 잘 들어왔다. ");
		obj = session.getAttribute("login");
		vo = (MemberVO)obj;
		logger.info(vo.toString());
		logger.info("디스타임");
		//logger.info(vo.toString());
		logger.info("-=-=-=---------------------------");

		cri.setMno(vo.getMno());
	
		model.addAttribute("mno", vo.getMno());
		model.addAttribute("list", service.list(cri));

		PageMaker pageMaker = new PageMaker();

		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.listCount(cri));

		logger.info("------------------------------");
		logger.info(pageMaker.toString());
		model.addAttribute("pageMaker", pageMaker);

		return "/poll/mypoll";

	}
 
	
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public String listDelete(String[] pnos,@ModelAttribute("cri") Criteria cri, Model model)  throws Exception {

		for (String pno : pnos) {
			
			service.remove(Integer.parseInt(pno));
		}
		return "redirect:/poll/list";
	}

	@ResponseBody
	@RequestMapping(value = "/removes", method = RequestMethod.POST)
	public String removeMany(RedirectAttributes rttr, @RequestBody MyPollArray arr) throws Exception {

		logger.info("---------------removes로 들어왔다....");

		logger.info(arr.toString());

		logger.info(arr.getArr().toString());

		String[] arr2 = arr.getArr();

		logger.info(Arrays.toString(arr2));

		System.out.println(arr2.length);

		return "/poll/mypoll";

	}

	@RequestMapping(value = "/category", method = RequestMethod.GET)
	public void cotegory(Model model, MemberVO vo) throws Exception {
		
		logger.info("this is category");
		logger.info(vo.toString());
		
		model.addAttribute("categoryList", service.categoryList());		

	}

	@RequestMapping(value = "/pollsetting", method = RequestMethod.GET)
	   public void settingGET(Model model, @RequestParam("pno") int pno) throws Exception {
	      logger.info("regist get.........");
	      //System.out.println(service.categoryList());
	      logger.info("yyyyyyyyyyyyyyyyyyyyyyy");

	      int newPno = service.newPno();
	      
	      model.addAttribute("categoryList", service.categoryList());
	      
	      logger.info("******************"+service.categoryList().toString());
	      
	      model.addAttribute("newPno", newPno);
	      model.addAttribute("settings",service.setting(pno));
	   }// 수정함

	@ResponseBody
	@RequestMapping(value = "/getsetting/{pno}", method = RequestMethod.GET)
	public ResponseEntity<PollVO> jsonGET(@PathVariable("pno") int pno) {
		ResponseEntity<PollVO> entity = null;
		try {
			entity = new ResponseEntity<>(service.setting(pno), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}

	@RequestMapping(value = "/pollsetting", method = RequestMethod.POST)
	public String settingPOST(PollVO vo,Model model, RedirectAttributes rttr) throws Exception {
		
		logger.info("find");
		logger.info(vo.toString()+"================1");
		
		if(vo.getMultiOpt() == null){
	         vo.setMultiOpt("f");
	    }
		
		service.regist(vo);
		logger.info("★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★");
		logger.info(vo.getPno().toString());
		
		
		model.addAttribute("pno", vo.getPno());

		//rttr.addFlashAttribute("pno", vo.getPno());
		
		
		return "redirect:/poll/pollmaking?pno="+vo.getPno();
	}
	
	@RequestMapping(value="/pollmaking", method=RequestMethod.GET)
    public void registGET(Model model, Integer pno)throws Exception{
      logger.info("regist get...........");

      model.addAttribute(service.view(pno));
    }
 
   @RequestMapping(value = "/pollmaking", method=RequestMethod.POST)
    public String registPOST(ItemVO itemVO, PollVO vo, RedirectAttributes rttr) throws Exception {
      logger.info("===========pollmaking post........");
      logger.info(vo.toString());
      
       service.registUpt(vo, itemVO);
       rttr.addFlashAttribute("msg", "SUCCESS");
       
		String path ="http://localhost:3000/connect/call/"+vo.getPno();
		URL url = new URL(path);		
		InputStream in = url.openStream();
		
		logger.info(in.toString());
		in.close();
		
       return "redirect:/poll/list";
    }

	@RequestMapping(value = "/mypollview", method = RequestMethod.GET)
	public void view(@RequestParam("pno") int pno, @ModelAttribute("cri") Criteria cri, Model model) throws Exception {
		logger.info("===========mypollview get........");
		List<FileVO> filesVO = service.readAttach(pno);
		List<TextVO> textsVO = service.readItem(pno);
		List<String> files = new ArrayList<>();
		List<String> texts = new ArrayList<>();
		ItemVO list = new ItemVO();
		int maxIndex = 0;
			
		for (FileVO fileVO : filesVO) {
			if(fileVO.getPnoFileNo() > maxIndex){
				maxIndex = fileVO.getPnoFileNo();
			}
		}
		for (TextVO textVO : textsVO) {
			if(textVO.getPnoItemNo() > maxIndex){
				maxIndex = textVO.getPnoItemNo();
			}
		}
		
		for(int i=0; i<maxIndex+1; i++){
			
			files.add(i, "");
			texts.add(i, "");
			
			for (FileVO fileVO : filesVO) {
				if(fileVO.getPnoFileNo() == i){
					files.set(i, fileVO.getFullName());
				}
			}
			for(TextVO textVO : textsVO) {
				if(textVO.getPnoItemNo() == i){
					texts.set(i, textVO.getSelectItem());
				}
			}
		}
		list.setFiles(files);
		list.setTexts(texts);
		
		model.addAttribute(list);
		model.addAttribute(service.view(pno));
	}

	
	@RequestMapping(value = "/pollmodify", method = RequestMethod.GET)
	public void modifyGET(int pno, Model model)throws Exception{
		logger.info("===========modify get........");
		List<FileVO> filesVO = service.readAttach(pno);
		List<TextVO> textsVO = service.readItem(pno);
		List<String> files = new ArrayList<>();
		List<String> texts = new ArrayList<>();
		ItemVO list = new ItemVO();
		int maxIndex = 0;
			
		for (FileVO fileVO : filesVO) {
			if(fileVO.getPnoFileNo() > maxIndex){
				maxIndex = fileVO.getPnoFileNo();
			}
		}
		for (TextVO textVO : textsVO) {
			if(textVO.getPnoItemNo() > maxIndex){
				maxIndex = textVO.getPnoItemNo();
			}
		}
		
		for(int i=0; i<maxIndex+1; i++){
			
			files.add(i, "");
			texts.add(i, "");
			
			for (FileVO fileVO : filesVO) {
				if(fileVO.getPnoFileNo() == i){
					files.set(i, fileVO.getFullName());
				}
			}
			for(TextVO textVO : textsVO) {
				if(textVO.getPnoItemNo() == i){
					texts.set(i, textVO.getSelectItem());
				}
			}
		}
		list.setFiles(files);
		list.setTexts(texts);
		
		model.addAttribute(list);
		model.addAttribute(service.view(pno));
	}
	
	@RequestMapping(value = "/pollmodify", method = RequestMethod.POST)
	public String modifyPOST(PollVO vo, ItemVO itemVO, RedirectAttributes rttr) throws Exception {
		logger.info("===========modify post........");
		logger.info(vo.toString());
		
		
		
		service.modify(vo, itemVO);
		rttr.addFlashAttribute("msg", "SUCCESS");
		
		
		String path ="http://localhost:3000/connect/update/"+vo.getPno();
		URL url = new URL(path);		
		InputStream in = url.openStream();
		
		logger.info(in.toString());
		in.close();
		return "redirect:/poll/list";
	}
	
	//수정할 때 노드가 호출하는 부분
	@ResponseBody
    @RequestMapping(value="/modify/{pno}")
    public ResponseEntity<PollVO> modifypno(@PathVariable("pno")int pno){

       ResponseEntity<PollVO> entity = null;
       try {
          entity = new ResponseEntity<>(service.viewAll(pno),HttpStatus.OK);
          logger.info(pno+"");
          System.out.println("--------------------------------가져와짐");
       } catch (Exception e) {
         
          e.printStackTrace();
          entity = new ResponseEntity<>(HttpStatus.OK);
          System.out.println("--------------------------------에러남");
       }
      
       System.out.println("--------------------------------처리됨");
       logger.info(entity.toString());
       return entity;
      
    }
	

	@Transactional
	@RequestMapping(value="/remove", method=RequestMethod.POST)
	public String remove(int pno, Criteria cri, RedirectAttributes rttr) throws Exception {
		logger.info("드루와");
		
		if(service.checkFile(pno) != 0 ){
			service.removeFile(pno);
		}
		
		if(service.checkItem(pno) != 0){
			service.removeItem(pno);
		}
		
		String path ="http://localhost:3000/connect/remove/"+pno;
		URL url = new URL(path);		
		InputStream in = url.openStream();
		
		logger.info(in.toString());
		in.close();
		
		service.remove(pno);
		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		rttr.addFlashAttribute("msg", "success");
		return "redirect:/poll/list";
	}
	
	//node.js에서 호출해서 객체를 가져간다
    @ResponseBody
    @RequestMapping(value="/create/{pno}")
    public ResponseEntity<PollVO> getpno(@PathVariable("pno")int pno){

       ResponseEntity<PollVO> entity = null;
       try {
          entity = new ResponseEntity<>(service.viewAll(pno),HttpStatus.OK);
          logger.info(pno+"");
          System.out.println("--------------------------------가져와짐");
       } catch (Exception e) {
         
          e.printStackTrace();
          entity = new ResponseEntity<>(HttpStatus.OK);
          System.out.println("--------------------------------에러남");
       }
      
       System.out.println("--------------------------------처리됨");
       logger.info(entity.toString());
       return entity;
      
    }
	
	
}