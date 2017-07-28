package kr.or.dgit.persistence;

import java.util.List;

import kr.or.dgit.domain.Criteria;
import kr.or.dgit.domain.Point;
import kr.or.dgit.domain.SerchCriteria;

public interface PointDao {
	public void pointInsert(Point point)throws Exception;
	public void contentInsert(Point point)throws Exception;
	
	public List<Point> pointList()throws Exception;
	public List<Point> ptCntList()throws Exception;
	
	public Point pointRead(int pointNo)throws Exception;
	public Point pointContentRead(int pointNo)throws Exception;
	
	public void pointUpdate(Point p)throws Exception;
	public void pointContentUpdate(Point p)throws Exception;
	
	public void pointDel(int pointNo)throws Exception;
	public void contentDel(int pointNo)throws Exception;
	
	public List<Point> listPage(int page)throws Exception;
	public List<Point> listConPage(int page)throws Exception;
	
	public void updateCnt(int pointNo) throws Exception;
	
	public List<Point> listCriteria(Criteria cri)throws Exception;
	public List<Point> listConCriteria(Criteria cri)throws Exception;
	
	public int totalCount()throws Exception;
	
	public List<Point> listSearch(SerchCriteria cri)throws Exception;
	public List<Point> listConSearch(SerchCriteria cri)throws Exception;
	
	public int searchCount(SerchCriteria cri)throws Exception;
	/*public void updateCnt(int pointNo)throws Exception;*/
	
	/*평균 함수*/
	public void pointPrfavg(Point p)throws Exception;
	public void pointPrsavg(Point p)throws Exception;
	
	/*업로드*/
	public void addUpload(String uploadPfile)throws Exception;
	public void uploadDel(String uploadPfile)throws Exception;
	public List<Point>uploadList()throws Exception;
}
