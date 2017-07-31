package kr.or.dgit.fishing;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.dgit.domain.Member;
import kr.or.dgit.service.MemberService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private MemberService service;
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public void getLogin(){
		
	}
	
	@RequestMapping(value="/loginPost",method=RequestMethod.POST)
	public void postLogin(Member member,Model model)throws Exception{
		logger.info("==========================로그인===============================");
		logger.info("오네"+member.toString());
		Member b = service.Login(member.getMemberId(),member.getMemberPass());
		if(b == null){
			return; 
		}
		model.addAttribute("loginGo",b);
	}
	
	@RequestMapping(value="/logout",method=RequestMethod.GET)
	public String logOut(HttpSession session,HttpServletRequest request){
		session.removeAttribute("login");
		session.invalidate();
		//여기부분 메인부분 만들면 고쳐야 될듯?
		String url = "/point/listPage";
		return "redirect:"+url;
	}
}
