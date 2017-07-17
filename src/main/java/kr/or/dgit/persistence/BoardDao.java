package kr.or.dgit.persistence;

import java.util.List;
import kr.or.dgit.domain.Board;
import kr.or.dgit.domain.Criteria;
import kr.or.dgit.domain.SerchCriteria;

public interface BoardDao {
	public void boardInsert(Board board)throws Exception;
	public void contentInsert(Board board)throws Exception;
	
	public List<Board>boardList()throws Exception;
	
	public Board boardRead(int boardNo)throws Exception;
	
	public void boardDel(int boardNo)throws Exception;
	public void contentDel(int boardNo)throws Exception;
	
	public void boardUpdate(Board board)throws Exception;
	public void contentUpdate(Board board)throws Exception;
	
	public List<Board> listPage(int page)throws Exception;
	public void updatecnt(int boardNo) throws Exception;
	public List<Board> listCriteria(Criteria cri)throws Exception;
	public int totalCount()throws Exception;
	public List<Board> listSearch(SerchCriteria cri)throws Exception;
	public int searchCount(SerchCriteria cri)throws Exception;
	
	/*================================================================*/
	
	public Board boardReadWithTest(int boardNo)throws Exception;
	public Board contentReadWithTest(int boardNo)throws Exception;
}
