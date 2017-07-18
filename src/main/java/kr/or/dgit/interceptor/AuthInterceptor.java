package kr.or.dgit.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthInterceptor extends HandlerInterceptorAdapter{
	
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("AUTH INTERCEPTOR PRE HANDLER==============");
		HttpSession session = request.getSession();
		String userid = (String)session.getAttribute("login");
		System.out.println("userid :"+userid);
		if(userid == null){
			saveDest(request);
			String url = request.getContextPath()+"/user/login";
			response.sendRedirect(url);
			return false;
		}
		return true;
	}
	
	private void saveDest(HttpServletRequest request){
		String uri = request.getRequestURI();
		String query = request.getQueryString();
		
		if(query == null || query.equals("null")){
			query ="";
		}else{
			query="?"+query;
		}
		
		if(request.getMethod().equals("GET")){
			System.out.println(uri+query);
			request.getSession().setAttribute("dest", uri+query);
		}
	}
	
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("AUTH INTERCEPTOR POST HANDLER==============");
	}
}
