package kr.or.dgit.persistence;

import java.util.List;

import kr.or.dgit.domain.Criteria;
import kr.or.dgit.domain.Reply;

public interface ReplyDao {
	public List<Reply> replyList(int boardNo)throws Exception;
	public void replyInsert(Reply r)throws Exception;
	public void replyUpdate(Reply r)throws Exception;
	public void replyDel(int replyNo)throws Exception;
	
	public List<Reply> listPage(int boardNo, Criteria cri)throws Exception;
	public int count(int boardNo)throws Exception;
}
