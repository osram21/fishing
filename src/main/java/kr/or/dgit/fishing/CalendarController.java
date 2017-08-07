package kr.or.dgit.fishing;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/calendar")
public class CalendarController {
	private static final Logger logger = LoggerFactory.getLogger(CalendarController.class);
	
	@RequestMapping(value="/calListPage",method=RequestMethod.GET)
	public String listAll(Model model)throws Exception{
		model.addAttribute("s","성환이바보");
		
		return "calendar/calListPage";
	}
}
