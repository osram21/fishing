package kr.or.dgit.fishing;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.dgit.service.MemberService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private MemberService service;
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
}
