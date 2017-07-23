package kr.or.dgit.fishing;

import java.util.List;

import javax.print.attribute.standard.Severity;

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
import kr.or.dgit.domain.SerchCriteria;
import kr.or.dgit.service.BoardService;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	@Autowired
	private BoardService service;
	
	@RequestMapping(value="/register",method=RequestMethod.GET)
	public String registerGet()throws Exception{
		return "board/insertForm";
	}
	
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String registerPost(Board b)throws Exception{
		service.boardInsert(b);
		return "redirect:listPage";
	}
	
	@RequestMapping(value="/listAll",method=RequestMethod.GET)
	public String listAll(Model model)throws Exception{
		List<Board> list = service.boardList();
		model.addAttribute("list",list);
		return "board/listAll";
	}
	@RequestMapping(value="/read",method=RequestMethod.GET)
	public String read(int boardNo, Model model,@ModelAttribute("cri")SerchCriteria cri)throws Exception{
		/*Board b = service.boardRead(boardNo);*/
		Board b = service.boardReadTest(boardNo);
		
		logger.info("===============================read============");
		model.addAttribute("board",b);
		return "board/read";
	}
	
	@RequestMapping(value="delete",method=RequestMethod.POST)
	public String delete(int boardNo,@ModelAttribute("cri") SerchCriteria cri,Model model)throws Exception{
		service.boardDelete(boardNo);
		model.addAttribute("page",cri.getPage());
		model.addAttribute("searcgType",cri.getSearchType());
		model.addAttribute("keyword",cri.getKeyword());
		return"redirect:listPage";
	}
	@RequestMapping(value="/modify",method=RequestMethod.GET)
	public String updateGet(int boardNo,Model model,@ModelAttribute("cri")SerchCriteria cri)throws Exception{
		logger.info("----------modify--------");
		Board b = service.boardRead(boardNo);
		logger.info("번호 받아오니??"+b);
		model.addAttribute("board",b);
		return "board/modify";
	}
	
	@RequestMapping(value="/modify",method=RequestMethod.POST)
	public String updatePost(Board b,RedirectAttributes rdt,@ModelAttribute("cri") SerchCriteria cri)throws Exception{
		logger.info("------------modify post ------------");
		service.boardUpdate(b);
		logger.info("번호 오는 널이니??"+b);
		rdt.addAttribute("boardNo",b.getBoardNo());
		return "redirect:read";
	}
	
	@RequestMapping(value="/listPage",method=RequestMethod.GET)
	public String listPage(@ModelAttribute("cri")SerchCriteria cri,Model model)throws Exception{
		logger.info("-----------------------떠라=----------------------");
		model.addAttribute("list",service.listSearch(cri));
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.searchCount(cri));
		model.addAttribute("pageMaker",pageMaker);
		return "board/listPage";
	}
}
