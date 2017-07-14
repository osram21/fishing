package kr.or.dgit.fishing;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kr.or.dgit.domain.Criteria;
import kr.or.dgit.domain.PageMaker;
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
	
	@RequestMapping(value="/{replyNo}",method=RequestMethod.DELETE)
	public ResponseEntity<String>delete(@PathVariable("replyNo")int replyNo){
		ResponseEntity<String> entity = null;
		try {
			service.replyDel(replyNo);
			entity = new ResponseEntity<String>(HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	@RequestMapping(value="/{replyNo}",method=RequestMethod.PUT)
	public ResponseEntity<String>update(@PathVariable("rno")int replyNo, @RequestBody Reply r){
		ResponseEntity<String> entity = null;
		try {
			r.setReplyNo(replyNo);
			service.replyUpdate(r);
			entity = new ResponseEntity<String>(HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	@RequestMapping(value="{boardNo}/{page}",method=RequestMethod.GET)
	public ResponseEntity<Map<String, Object>>listPage(@PathVariable("boardNo")int boardNo,@PathVariable("page")int page){
		ResponseEntity<Map<String, Object>> entity = null;
		try {
			//페이지 넣고
			Criteria cri = new Criteria();
			cri.setPage(page);
			List<Reply> list = service.listPage(boardNo, cri);
			
			//페이지에 대한 카운터 시키는거 70개면 페이징 7개 생성 이런거?? 맞나?? 그러겟지
			PageMaker pageMaker = new PageMaker();
			pageMaker.setCri(cri);
			pageMaker.setTotalCount(service.count(boardNo));
			
			//위에 두개를 맵으로 받아서 보내버림
			Map<String, Object> map = new HashMap<>();
			map.put("list", list);
			map.put("pageMaker", pageMaker);
			
			entity = new ResponseEntity<>(map,HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<Map<String,Object>>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
}
