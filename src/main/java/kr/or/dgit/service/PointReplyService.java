package kr.or.dgit.service;

import java.util.List;
import java.util.Map;

import kr.or.dgit.domain.Criteria;
import kr.or.dgit.domain.PointReply;



public interface PointReplyService {
	public List<PointReply>replyList(int pointNo)throws Exception;
	public void replyInsert(PointReply pr)throws Exception;
	public void replyUpdate(PointReply pr)throws Exception;
	public void replyDel(int ptNo)throws Exception;
	
	public List<PointReply>listPage(int pointNo, Criteria cri)throws Exception;
	public int count(int pointNo)throws Exception;
	
	public List<PointReply>AvgPrf(Map<String, Object>map)throws Exception;
	public List<PointReply>AvgPrs(Map<String, Object>map)throws Exception;
}
