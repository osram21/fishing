package kr.or.dgit.persistence;

import kr.or.dgit.domain.Board;

public interface BoardDao {
	public void boardInsert(Board board)throws Exception;
}
