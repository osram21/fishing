package kr.or.dgit.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.or.dgit.domain.Member;

public class LoginInterceptor extends HandlerInterceptorAdapter{
	private static final String LOGIN = "login";
	
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)throws Exception{
		return true;
	}
	
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)throws Exception{
		Member m = (Member)modelAndView.getModel().get("loginGo");
		System.out.println("옴?"+m);
		//회원가입처리
		if(m == null){
			//로그인 가게 처리
			response.sendRedirect("login");
		}else{
			HttpSession session = request.getSession();
			session.setAttribute(LOGIN,m.getMemberId());
			
			String path = (String)session.getAttribute("dest");
			if(path !=null){
				response.sendRedirect(path);
			}
		}
	}
}
