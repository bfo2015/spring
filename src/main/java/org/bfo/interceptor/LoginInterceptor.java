package org.bfo.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter {

	private static final String LOGIN = "login";
	private static final Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		// super.postHandle(request, response, handler, modelAndView);

		HttpSession session = request.getSession();

		ModelMap modelMap = modelAndView.getModelMap();
		Object memberVO = modelMap.get("memberVO");

		if (memberVO != null) {
			logger.info("new login success");
			session.setAttribute(LOGIN, memberVO);
			//response.sendRedirect("/");
			Object dest = session.getAttribute("dest");

			//보내주는곳
			response.sendRedirect(dest != null ? (String)dest:"/");
		}
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub

		HttpSession session = request.getSession();

		if (session.getAttribute(LOGIN) != null) {
			logger.info("clear login data before");
			session.removeAttribute(LOGIN);
		}

		return true;
	}

}
