package kr.or.dgit.fishing;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.dgit.domain.Member;
import kr.or.dgit.service.MemberService;

@Controller
@RequestMapping("/join")
public class MemberController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	private MemberService service;
	
	
	//아직 이건 모르겟음
	@RequestMapping(value="/joinForm",method=RequestMethod.GET)
	public String joinGet()throws Exception{
		return "join/joinForm";
	}
	
	@RequestMapping(value="/joinForm",method=RequestMethod.POST)
	public String joinPost(Member m)throws Exception{
		service.memberInsert(m);
		return "redirect:/point/listPage";
	}
}
