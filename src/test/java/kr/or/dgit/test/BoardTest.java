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
	private BoardDao bDao;
	@Autowired
	private ContentDao cDao;
	@Autowired
	private MemberDao mDao;
	
	@Test
	public void insertTest()throws Exception{
		Member m = new Member();
		m.setMemberName("테스트2");
		Board b = new Board();
		b.setBoardTitle("타이틀");
		Content c = new Content();
		c.setBoardContent("내용");
		mDao.memberInsert(m);
		bDao.boardInsert(b);
		cDao.contentInsert(c);
	}
}
