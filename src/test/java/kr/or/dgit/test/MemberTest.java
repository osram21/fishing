package kr.or.dgit.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.or.dgit.domain.Board;
import kr.or.dgit.domain.Member;
import kr.or.dgit.persistence.BoardDao;
import kr.or.dgit.persistence.MemberDao;
import kr.or.dgit.service.BoardService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class MemberTest {
	@Autowired
	private MemberDao mDao;
	
	//@Test
	public void insertTest()throws Exception{
		Member mb = new Member();
		mb.setMemberId("test1");
		mb.setMemberPass("1234");
		mb.setMemberName("테스트");
		mb.setMemberEmail("test@naver.com");
		mDao.memberInsert(mb);
	}
	
	//@Test
	public void selectByNo()throws Exception{
		mDao.selectByNo("test1");
	}
	
	//@Test
	public void selectList()throws Exception{
		mDao.memberList();
	}
	
	//@Test
	public void update()throws Exception{
		Member m = new Member();
		m.setMemberPass("1234");
		m.setMemberName("테스트3");
		m.setMemberEmail("test3@naver.com");
		m.setMemberId("test1");
		mDao.memberUpdate(m);
	}
	
	//@Test
	public void delete()throws Exception{
		mDao.delete("test1");
	}
	
	@Test
	public void login()throws Exception{
		mDao.Login("osram21", "1234");
	}
}
