package kr.or.dgit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.dgit.domain.Board;
import kr.or.dgit.domain.Content;
import kr.or.dgit.persistence.BoardDao;
import kr.or.dgit.persistence.ContentDao;

@Service
public class BoardServiceImpl implements BoardService{
	@Autowired
	private BoardDao dao;
	
	@Autowired
	private ContentDao cdao;

	@Override
	public void boardInsert(Board board,Content content) throws Exception {
		dao.boardInsert(board);
		cdao.contentInsert(content);
	}

	@Override
	public List<Board> boardSelect() throws Exception {
		return dao.boardSelect();
	}
	
}
