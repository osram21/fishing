package kr.or.dgit.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.dgit.domain.Criteria;
import kr.or.dgit.domain.Point;
import kr.or.dgit.domain.PointReply;
import kr.or.dgit.persistence.PointDao;
import kr.or.dgit.persistence.PointReplyDao;

@Service
public class PointReplyServiceImpl implements PointReplyService{
	@Autowired
	private PointReplyDao dao;
	@Autowired
	PointDao pDao;
	@Override
	public List<PointReply> replyList(int pointNo) throws Exception {
		return dao.replyList(pointNo);
	}
	@Transactional
	@Override
	public void replyInsert(PointReply pr) throws Exception {
		dao.replyInsert(pr);
		
		Point p = new Point();
		p.setPrfavg(dao.AvgPrf(pr.getPointNo()));
		p.setPrsavg(dao.AvgPrs(pr.getPointNo()));
		p.setPointNo(pr.getPointNo());
		
		pDao.pointPrfavg(p);
		pDao.pointPrsavg(p);
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

	

}
