package kr.or.dgit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.dgit.domain.Board;
import kr.or.dgit.domain.Criteria;
import kr.or.dgit.domain.SerchCriteria;
import kr.or.dgit.persistence.BoardDao;


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

	@Override
	public void updatecnt(int boardNo) throws Exception {
		dao.updatecnt(boardNo);
	}

	@Override
	public List<Board> listCriteria(Criteria cri) throws Exception {
		return dao.listCriteria(cri);
	}

	@Override
	public int totalCount() throws Exception {
		return dao.totalCount();
	}

	@Override
	public List<Board> listSearch(SerchCriteria cri) throws Exception {
		return dao.listSearch(cri);
	}

	@Override
	public int searchCount(SerchCriteria cri) throws Exception {
		return dao.searchCount(cri);
	}
}
