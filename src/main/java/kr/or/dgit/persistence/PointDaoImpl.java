package kr.or.dgit.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.or.dgit.domain.Criteria;
import kr.or.dgit.domain.Point;
import kr.or.dgit.domain.SerchCriteria;
@Repository
public class PointDaoImpl implements PointDao{
	@Autowired
	private SqlSession session;
	
	private static String namespace = "kr.or.dgit.persistence.PointDao";
	
	@Override
	public void pointInsert(Point point) throws Exception {
		session.insert(namespace+".pointInsert",point);
	}

	@Override
	public void contentInsert(Point point) throws Exception {
		session.insert(namespace+".contentInsert",point);
	}

	@Override
	public List<Point> pointList() throws Exception {
		return session.selectList(namespace+".pointList");
	}

	@Override
	public List<Point> ptCntList() throws Exception {
		return session.selectList(namespace+".ptCntList");
	}

	@Override
	public Point pointRead(int pointNo) throws Exception {
		return session.selectOne(namespace+".pointRead",pointNo);
	}

	@Override
	public Point pointContentRead(int pointNo) throws Exception {
		return session.selectOne(namespace+".pointContentRead",pointNo);
	}

	@Override
	public void pointUpdate(Point p) throws Exception {
		session.update(namespace+".pointUpdate",p);
	}

	@Override
	public void pointContentUpdate(Point p) throws Exception {
		session.update(namespace+".pointContentUpdate",p);
	}

	@Override
	public void pointDel(int pointNo) throws Exception {
		session.delete(namespace+".pointDel",pointNo);
	}

	@Override
	public void contentDel(int pointNo) throws Exception {
		session.delete(namespace+".contentDel",pointNo);
	}

	@Override
	public List<Point> listPage(int page) throws Exception {
		if(page<=0){
			page = 1;
		}
		page = (page-1)*10;
		return session.selectList(namespace+".listPage",page);
	}

	@Override
	public void updateCnt(int pointNo) throws Exception {
		session.update(namespace+".updateCnt",pointNo);
	}

	@Override
	public List<Point> listCriteria(Criteria cri) throws Exception {
		return session.selectList(namespace+".listCriteria",cri);
	}

	@Override
	public int totalCount() throws Exception {
		return session.selectOne(namespace+".totalCount");
	}

	@Override
	public List<Point> listSearch(SerchCriteria cri) throws Exception {
		return session.selectList(namespace+".listSearch",cri);
	}

	@Override
	public int searchCount(SerchCriteria cri) throws Exception {
		return session.selectOne(namespace+".searchCount",cri);
	}

	@Override
	public List<Point> listConPage(int page) throws Exception {
		if(page<=0){
			page = 1;
		}
		page = (page-1)*10;
		return session.selectList(namespace+".listConPage",page);
	}

	@Override
	public List<Point> listConCriteria(Criteria cri) throws Exception {
		return session.selectList(namespace+".listConCriteria",cri);
	}

	@Override
	public List<Point> listConSearch(SerchCriteria cri) throws Exception {
		return session.selectList(namespace+".listConSearch",cri);
	}

	@Override
	public void pointPrfavg(Point p) throws Exception {
		session.update(namespace+".pointPrfavg",p);
	}

	@Override
	public void pointPrsavg(Point p) throws Exception {
		session.update(namespace+".pointPrsavg",p);
	}

	@Override
	public void addUpload(String uploadPfile) throws Exception {
		session.insert(namespace+".addUpload",uploadPfile);
	}

	@Override
	public void uploadDel(String uploadPfile) throws Exception {
		session.delete(namespace+".uploadDel",uploadPfile);
		
	}

	@Override
	public List<Point> uploadList() throws Exception {
		return session.selectList(namespace+".uploadList");
	}
}
