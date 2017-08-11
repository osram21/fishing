package kr.or.dgit.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.dgit.domain.Criteria;
import kr.or.dgit.domain.Point;
import kr.or.dgit.domain.SerchCriteria;
import kr.or.dgit.persistence.PointDao;
import kr.or.dgit.persistence.PointReplyDao;
@Service
public class PointServiceImpl implements PointService{
	@Autowired
	private PointDao dao;
	
	@Autowired
	PointReplyDao prDao;
	
	@Transactional
	@Override
	public void pointInsert(Point point,List<String>files) throws Exception {
		dao.pointInsert(point);
		dao.contentInsert(point);
		int lastId=dao.pointLastInsertId();
		//for(String uploadPfile : point.getUploadPfile()){
		for(String uplpadPfile:files){
			dao.addUpload(uplpadPfile,lastId);
			System.out.println(point.getUploadPfile());
		}
		//}
		System.out.println("오냐"+point.toString());
	}
	
	@Transactional
	@Override
	public List<Point> pointList() throws Exception {
		List<Point> list = dao.pointList();
		List<Point> listContent= dao.ptCntList();
		for(int i=0;i<list.size();i++){
			list.get(i).setPointContent(listContent.get(i).getPointContent());
		}
		/*List<Point> uploadList = dao.uploadList();
		for(int i = 0; i <list.size();i++){
			list.get(i).setUploadPfile(uploadList.get(i).getUploadPfile());
		}*/
		return list;
	}

	@Transactional
	@Override
	public void pointUpdate(Point point) throws Exception {
		dao.pointUpdate(point);
		dao.pointContentUpdate(point);
	}
	
	@Transactional
	@Override
	public Point pointByno(int pointNo) throws Exception {
		Point p = dao.pointRead(pointNo);
		System.out.println("service 아왜 널포인트냐고 "+p);
		p.setPointContent(dao.pointContentRead(pointNo).getPointContent());
		return p;
	}

	@Transactional
	@Override
	public void pointDel(int pointNo) throws Exception {
		dao.pointDel(pointNo);
		dao.contentDel(pointNo);
	}

	@Override
	public void updateCnt(int pointNo) throws Exception {
		dao.updateCnt(pointNo);
	}
	
	
	@Override
	public List<Point> listCriteria(Criteria cri) throws Exception {
		
		
		/*List<Point> list = dao.listCriteria(cri);
		List<Point> conList = dao.listConCriteria(cri);
		for(int i=0;i<list.size();i++){
			list.get(i).setPointContent(listCriteria(cri).get(i).getPointContent());
		}
		return list; */
		return dao.listCriteria(cri);
	}

	@Override
	public int totalCount() throws Exception {
		return dao.totalCount();
	}

	
	@Override
	public List<Point> listSearch(SerchCriteria cri) throws Exception {
		/*List<Point> list = dao.listSearch(cri);*/
		/*List<Point> conList = dao.listConSearch(cri);
		for(int i = 0; i <list.size(); i++){
			list.get(i).setPointContent(listSearch(cri).get(i).getPointContent());
		}*/
		return dao.listSearch(cri);
	}

	@Override
	public int searchCount(SerchCriteria cri) throws Exception {
		return dao.searchCount(cri);
	}

	@Override
	public void uploadDel(String uploadPfile) throws Exception {
		dao.uploadDel(uploadPfile);
	}

	@Override
	public List<String> uploadFileByNo(int pointNo) throws Exception {
		return dao.uploadFileByNo(pointNo);
	}

	/*@Override
	public List<String> uploadList(String pointfile) throws Exception {
		return dao.uploadList(pointfile);
	}*/
}
