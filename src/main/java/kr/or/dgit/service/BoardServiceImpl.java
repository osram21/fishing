package kr.or.dgit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.dgit.domain.Board;
import kr.or.dgit.persistence.BoardDao;

@Service
public class BoardServiceImpl implements BoardService{
	@Autowired
	private BoardDao dao;
	@Override
	public void boardInsert(Board board) throws Exception {
		dao.boardInsert(board);
	}
}
