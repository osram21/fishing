package kr.or.dgit.service;

import java.util.List;

import kr.or.dgit.domain.Board;
import kr.or.dgit.domain.Content;

public interface BoardService {
	public void boardInsert(Board board,Content content)throws Exception;
	
	public List<Board>boardSelect()throws Exception;
}
