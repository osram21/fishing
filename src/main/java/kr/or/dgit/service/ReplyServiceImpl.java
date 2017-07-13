package kr.or.dgit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.dgit.domain.Criteria;
import kr.or.dgit.domain.Reply;
import kr.or.dgit.persistence.ReplyDao;

@Service
public class ReplyServiceImpl implements ReplyService{
	@Autowired
	private ReplyDao dao;
	
	@Override
	public List<Reply> replyList(int boardNo) throws Exception {
		return dao.replyList(boardNo);
	}

	@Override
	public void replyInsert(Reply r) throws Exception {
		dao.replyInsert(r);
	}

	@Override
	public void replyUpdate(Reply r) throws Exception {
		dao.replyUpdate(r);
	}

	@Override
	public void replyDel(int replyNo) throws Exception {
		dao.replyDel(replyNo);
	}

	@Override
	public List<Reply> listPage(int boardNo, Criteria cri) throws Exception {
		return dao.listPage(boardNo, cri);
	}

	@Override
	public int count(int boardNo) throws Exception {
		return dao.count(boardNo);
	}

}
