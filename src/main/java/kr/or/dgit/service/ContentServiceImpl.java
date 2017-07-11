package kr.or.dgit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.dgit.domain.Board;
import kr.or.dgit.domain.Content;
import kr.or.dgit.persistence.BoardDao;
import kr.or.dgit.persistence.ContentDao;

@Service
public class ContentServiceImpl implements ContentService{
	@Autowired
	private ContentDao dao;
	@Override
	public void contentInsert(Content content) throws Exception {
		dao.contentInsert(content);
	}
}
