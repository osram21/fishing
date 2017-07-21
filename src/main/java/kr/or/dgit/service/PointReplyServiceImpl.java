package kr.or.dgit.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.dgit.domain.Criteria;
import kr.or.dgit.domain.Point;
import kr.or.dgit.domain.PointReply;
import kr.or.dgit.persistence.PointReplyDao;

@Service
public class PointReplyServiceImpl implements PointReplyService{
	@Autowired
	private PointReplyDao dao;
	@Override
	public List<PointReply> replyList(int pointNo) throws Exception {
		return dao.replyList(pointNo);
	}

	@Override
	public void replyInsert(PointReply pr) throws Exception {
		dao.replyInsert(pr);
	}

	@Override
	public void replyUpdate(PointReply pr) throws Exception {
		dao.replyUpdate(pr);
	}

	@Override
	public void replyDel(int ptNo) throws Exception {
		dao.replyDel(ptNo);
	}

	@Override
	public List<PointReply> listPage(int pointNo, Criteria cri) throws Exception {
		return dao.listPage(pointNo, cri);
	}

	@Override
	public int count(int pointNo) throws Exception {
		return dao.count(pointNo);
	}

	@Override
	public List<PointReply> AvgPrf(Map<String, Object>map) throws Exception {
		return dao.AvgPrf(map);
	}

	@Override
	public List<PointReply> AvgPrs(Map<String, Object>map) throws Exception {
		return dao.AvgPrs(map);
	}

}
