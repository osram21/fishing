package kr.or.dgit.fishing;

import java.util.List;

import javax.print.attribute.standard.Severity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.dgit.domain.Board;
import kr.or.dgit.domain.Content;
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
		return "redirect:listAll";
	}
	
	@RequestMapping(value="/listAll",method=RequestMethod.GET)
	public String listAll(Model model)throws Exception{
		List<Board> list = service.boardList();
		model.addAttribute("list",list);
		return "board/listAll";
	}
	@RequestMapping(value="/read",method=RequestMethod.GET)
	public String read(int boardNo, Model model)throws Exception{
		Board b = service.boardRead(boardNo);
		model.addAttribute("board",b);
		return "board/read";
	}
	
	@RequestMapping(value="delete",method=RequestMethod.POST)
	public String delete(int boardNo)throws Exception{
		service.boardDelete(boardNo);
		return"redirect:listAll";
	}
	@RequestMapping(value="/modify",method=RequestMethod.GET)
	public String updateGet(int boardNo,Model model)throws Exception{
		Board b = service.boardRead(boardNo);
		model.addAttribute("board",b);
		return "board/modify";
	}
	
	@RequestMapping(value="/modify",method=RequestMethod.POST)
	public String updatePost(Board b,Model model)throws Exception{
		service.boardUpdate(b);
		model.addAttribute("board",b);
		return "redirect:read";
	}
}
