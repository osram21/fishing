package kr.or.dgit.fishing;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import kr.or.dgit.domain.PointReply;
import kr.or.dgit.domain.Reply;
import kr.or.dgit.service.PointReplyService;

@RestController
@RequestMapping("/ptreply")
public class PointReplyController {
	@Autowired
	PointReplyService service;
	
	private static final Logger logger = LoggerFactory.getLogger(PointReplyController.class);
	
	/*리스트*/
	@RequestMapping(value="/all{pointNo}",method=RequestMethod.GET)
	public ResponseEntity<List<PointReply>>replyList(@PathVariable("pointNo")int pointNo)throws Exception{
		ResponseEntity<List<PointReply>> entity = null;
		try {
			List<PointReply>list = service.replyList(pointNo);
			entity = new ResponseEntity<List<PointReply>>(list,HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<List<PointReply>>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	/*평점 평균 오는거??*/
	/*@RequestMapping(value="/all/{pointNo}/{prF}",method=RequestMethod.GET)
	public ResponseEntity<List<PointReply>>AvgPrf(@PathVariable("prF")double prF,@PathVariable("pointNo")int pointNo)throws Exception{
		ResponseEntity<List<PointReply>> entity = null;
		try {
			Map<String, Object>map = new HashMap<>();
			map.put("pointNo", pointNo);
			map.put("prF", prF);
			List<PointReply>list = service.AvgPrf(map);
			entity = new ResponseEntity<List<PointReply>>(list,HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<List<PointReply>>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	@RequestMapping(value="/all/{pointNo}/{prS}",method=RequestMethod.GET)
	public ResponseEntity<List<PointReply>>AvgPrS(@PathVariable("prS")double prS,@PathVariable("pointNo")int pointNo)throws Exception{
		ResponseEntity<List<PointReply>> entity = null;
		try {
			Map<String, Object> map = new HashMap<>();
			map.put("pointNo", pointNo);
			map.put("prS", prS);
			List<PointReply>list = service.AvgPrs(map);
			entity = new ResponseEntity<List<PointReply>>(list,HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<List<PointReply>>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}*/
	
	/*댓글 추가*/
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public ResponseEntity<String> add(@RequestBody PointReply pr){
		ResponseEntity<String> entity = null;
		
		try {
			service.replyInsert(pr);
			entity = new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	@RequestMapping(value="/{ptNo}",method=RequestMethod.DELETE)
	public ResponseEntity<String>delete(@PathVariable("ptNo")int ptNo){
		ResponseEntity<String> entity = null;
		try {
			service.replyDel(ptNo);
			entity = new ResponseEntity<String>(HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	@RequestMapping(value="/{ptNo}",method=RequestMethod.PUT)
	public ResponseEntity<String>update(@PathVariable("ptNo")int ptNo, @RequestBody PointReply pr){
		ResponseEntity<String> entity = null;
		try {
			pr.setPrNo(ptNo);
			/*r.setReplyContent(replyContent);*/
			
			service.replyUpdate(pr);
			
			entity = new ResponseEntity<String>(HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	@RequestMapping(value="{pointNo}/{page}",method=RequestMethod.GET)
	public ResponseEntity<Map<String, Object>>listPage(@PathVariable("pointNo")int pointNo,@PathVariable("page")int page){
		ResponseEntity<Map<String, Object>> entity = null;
		try {
			//페이지 넣고
			Criteria cri = new Criteria();
			cri.setPage(page);
			List<PointReply> list = service.listPage(pointNo, cri);
			
			//페이지에 대한 카운터 시키는거 70개면 페이징 7개 생성 이런거?? 맞나?? 그러겟지
			PageMaker pageMaker = new PageMaker();
			pageMaker.setCri(cri);
			pageMaker.setTotalCount(service.count(pointNo));
			
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
