package kr.or.dgit.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.or.dgit.domain.Board;
import kr.or.dgit.domain.Content;
import kr.or.dgit.domain.Member;
import kr.or.dgit.persistence.BoardDao;
import kr.or.dgit.persistence.ContentDao;
import kr.or.dgit.persistence.MemberDao;
import kr.or.dgit.service.BoardService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class BoardTest {
	@Autowired
	private BoardDao dao;
	@Autowired
	private ContentDao cdao;
	
	//@Test
	public void insertTest()throws Exception{
		Board b = new Board();
		b.setBoardNo(16);
		b.setMemberNo(9);
		b.setBoardTitle("타이틀1");
		dao.boardInsert(b);
	}
	
	@Test
	public void contentInsert()throws Exception{
		Content c = new Content();
		c.setBoardNo(7);
		c.setBoardContent("내용1");
		cdao.contentInsert(c);
	}	
}
