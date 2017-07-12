package kr.or.dgit.persistence;

import java.util.List;

import kr.or.dgit.domain.Board;
import kr.or.dgit.domain.Content;

public interface BoardDao {
	public void boardInsert(Board board)throws Exception;
	public void contentInsert(Board board)throws Exception;
	
	public List<Board>boardList()throws Exception;
	
	public Board boardRead(int boardNo)throws Exception;
	
	public void boardDel(int boardNo)throws Exception;
	public void contentDel(int boardNo)throws Exception;
	
	public void boardUpdate(Board board)throws Exception;
	public void contentUpdate(Board board)throws Exception;
}
