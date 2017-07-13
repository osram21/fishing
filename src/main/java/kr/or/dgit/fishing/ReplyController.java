package kr.or.dgit.fishing;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kr.or.dgit.domain.Reply;
import kr.or.dgit.service.ReplyService;

@RestController
@RequestMapping("/reply")
public class ReplyController {
	@Autowired
	ReplyService service;
	
	
	/*댓글 리스트*/
	@RequestMapping(value="/all{boardNo}",method=RequestMethod.GET)
	public ResponseEntity<List<Reply>> replyList(@PathVariable("boardNo")int boardNo){
		ResponseEntity<List<Reply>> entity = null;
		try {
			List<Reply>list = service.replyList(boardNo);
			entity = new ResponseEntity<List<Reply>>(list,HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<List<Reply>>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	/*댓글 추가*/
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public ResponseEntity<String> add(@RequestBody Reply r){
		ResponseEntity<String> entity = null;
		
		try {
			service.replyInsert(r);
			entity = new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	
}
