package kr.or.dgit.service;

import java.util.List;

import kr.or.dgit.domain.Board;
import kr.or.dgit.domain.Criteria;
import kr.or.dgit.domain.Point;
import kr.or.dgit.domain.SerchCriteria;

public interface PointService {
	public void pointInsert(Point point,List<String>files)throws Exception;
	
	public List<Point> pointList()throws Exception;
	
	public void pointUpdate(Point point)throws Exception;
	
	public Point pointByno(int pointNo)throws Exception;
	
	public void pointDel(int pointNo)throws Exception;
	
	public void updateCnt(int pointNo) throws Exception;
	public List<Point> listCriteria(Criteria cri)throws Exception;
	public int totalCount()throws Exception;
	public List<Point> listSearch(SerchCriteria cri)throws Exception;
	public int searchCount(SerchCriteria cri)throws Exception;
	
	/*public void updateCnt(int pointNo)throws Exception;*/
	public void uploadDel(String uploadPfile)throws Exception;
	/*public List<String>uploadList(String pointfile)throws Exception;*/
	public List<String>uploadFileByNo(int pointNo)throws Exception;
}
