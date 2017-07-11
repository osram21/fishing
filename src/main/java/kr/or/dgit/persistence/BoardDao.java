package kr.or.dgit.persistence;

import java.util.List;

import kr.or.dgit.domain.Board;

public interface BoardDao {
	public void boardInsert(Board board)throws Exception;
	
	public List<Board>boardSelect()throws Exception;
}
