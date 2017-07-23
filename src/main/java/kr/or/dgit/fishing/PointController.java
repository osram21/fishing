package kr.or.dgit.fishing;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.dgit.domain.Board;
import kr.or.dgit.domain.PageMaker;
import kr.or.dgit.domain.Point;
import kr.or.dgit.domain.SerchCriteria;
import kr.or.dgit.service.PointService;

@Controller
@RequestMapping("/point")
public class PointController {
	private static final Logger logger = LoggerFactory.getLogger(PointController.class);
	
	@Autowired
	private PointService service;
	
	@RequestMapping(value="/insert",method=RequestMethod.GET)
	public String insertGet()throws Exception{
		logger.info("왓냐=========================");
		return "point/insert";
	}
	
	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public String insertPost(Point p)throws Exception{
		logger.info("post옴??=========================");
		service.pointInsert(p);
		logger.info("들어갓냐======================="+p);
		return"redirect:listPage";
	}
	@RequestMapping(value="/listPage",method=RequestMethod.GET)
	public String listAll(Model model,@ModelAttribute("cri")SerchCriteria cri)throws Exception{
		model.addAttribute("list",service.listSearch(cri));
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.searchCount(cri));
		model.addAttribute("pageMaker",pageMaker);
		
		return "point/listPage";
	}
	@RequestMapping(value="/read",method=RequestMethod.GET)
	public String read(int pointNo,Model model,@ModelAttribute("cri")SerchCriteria cri)throws Exception{
		Point p = service.pointByno(pointNo);
		model.addAttribute("point",p);
		return "point/read";
	}
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	public String delete(int pointNo,@ModelAttribute("cri") SerchCriteria cri,Model model)throws Exception{
		service.pointDel(pointNo);
		
		model.addAttribute("page",cri.getPage());
		model.addAttribute("searcgType",cri.getSearchType());
		model.addAttribute("keyword",cri.getKeyword());
		
		return "redirect:listPage";
	}
	@RequestMapping(value="/modify",method=RequestMethod.GET)
	public String updateGet(int pointNo,Model model,@ModelAttribute("cri")SerchCriteria cri)throws Exception{
		Point p = service.pointByno(pointNo);
		model.addAttribute("point",p);
		return "point/modify";
	}
	
	@RequestMapping(value="/modify",method=RequestMethod.POST)
	public String updatePost(Point p,RedirectAttributes ba,@ModelAttribute("cri") SerchCriteria cri)throws Exception{
		service.pointUpdate(p);
		ba.addAttribute("pointNo",p.getPointNo());
		return "redirect:read";
	}
}
