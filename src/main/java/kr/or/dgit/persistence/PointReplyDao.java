package kr.or.dgit.persistence;

import java.util.List;
import java.util.Map;

import kr.or.dgit.domain.Criteria;
import kr.or.dgit.domain.PointReply;

public interface PointReplyDao {
	public List<PointReply> replyList(int pointNo) throws Exception;
	public void replyInsert(PointReply pr)throws Exception;
	public void replyUpdate(PointReply pr)throws Exception;
	public void replyDel(int ptNo)throws Exception;
	
	/*댓글 페이지처리*/
	public List<PointReply>listPage(int pointNo,Criteria cri)throws Exception;
	public int count(int pointNo)throws Exception;
	
	/*평점 맞는지 모르겟음 일딴 쳐넣어봄*/
	public double AvgPrf(int pointNo)throws Exception;
	public double AvgPrs(int pointNo)throws Exception;
}
