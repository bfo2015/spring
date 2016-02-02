package org.bfo.controller;

import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.bfo.domain.MemberDTO;
import org.bfo.domain.MemberVO;
import org.bfo.service.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.WebUtils;

@Controller
@RequestMapping(value = "/account/*")
public class AccountController {
	
	private static final Logger logger = LoggerFactory.getLogger(PollController.class);

	@Inject
	private MemberService service;
	
	@RequestMapping(value = "/login", method=RequestMethod.GET)
	public void loginGet(@ModelAttribute("dto")MemberDTO dto)throws Exception{
		logger.info("로그인겟 들어왔다..");
	}
	
	@RequestMapping(value = "/loginPost", method=RequestMethod.POST)
	public void loginPost(MemberDTO dto, HttpSession session, Model model)throws Exception{
		logger.info("로그인포스트 들어왔다..");
		logger.info("dto : " + dto.toString());
		MemberVO vo = service.login(dto);
		logger.info("vo : " + vo);
		if(vo==null){
			return;
		}
		
		
		model.addAttribute("memberVO", vo);
		
	}
	
	@RequestMapping(value = "/createAccount" ,method=RequestMethod.GET)
	public void registAccountGet()throws Exception{
		logger.info("회원가입 들어왔다..");
	}
	
	@RequestMapping(value = "/createAccount" ,method=RequestMethod.POST)
	public String registAccountPost(MemberVO vo, Model model)throws Exception{
		logger.info("가입버튼 눌렀다..");
		
		logger.info(vo.toString());
		
		service.createAccount(vo);
		
		logger.info("성공적으로 회원 만들었다..");
		model.addAttribute("mem", vo);
		
		return "redirect:/poll/list";
	}
	
	@RequestMapping(value="logout", method=RequestMethod.POST)
	public void logout(HttpServletRequest request, HttpServletResponse response,
			HttpSession session)throws Exception{
		
		Object obj = session.getAttribute("login");
		
		if(obj != null){
			MemberVO vo = (MemberVO) obj;
			
			session.removeAttribute("login");
			session.invalidate();
			
			Cookie loginCookie = WebUtils.getCookie(request, "loginCookie");
			
			if(loginCookie != null){
				
				loginCookie.setPath("/account/login");
				loginCookie.setMaxAge(0);
				response.addCookie(loginCookie);
				
			}
			
		}

	}
	
	
}
