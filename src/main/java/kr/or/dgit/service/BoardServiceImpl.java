package kr.or.dgit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.dgit.domain.Board;
import kr.or.dgit.domain.Content;
import kr.or.dgit.persistence.BoardDao;
import kr.or.dgit.persistence.ContentDao;

@Service
public class BoardServiceImpl implements BoardService{
	@Autowired
	private BoardDao dao;
	
	@Transactional
	@Override
	public void boardInsert(Board board) throws Exception {
		dao.boardInsert(board);
		dao.contentInsert(board);
	}

	@Override
	public List<Board> boardList() throws Exception {
		return dao.boardList();
	}

	@Override
	public Board boardRead(int boardNo) throws Exception {
		return dao.boardRead(boardNo);
	}

	@Override
	public void boardDelete(int boardNo) throws Exception {
		dao.boardDel(boardNo);
		dao.contentDel(boardNo);
	}

	@Override
	public void boardUpdate(Board board) throws Exception {
		dao.boardUpdate(board);
		dao.contentUpdate(board);
	}
}
