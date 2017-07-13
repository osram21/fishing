package kr.or.dgit.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.or.dgit.domain.Board;
import kr.or.dgit.persistence.BoardDao;
import kr.or.dgit.service.BoardService;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class BoardTest {
	@Autowired
	private BoardService service;
	@Autowired
	private BoardDao dao;
	
	//@Test
	public void insertTest()throws Exception{
		Board b = new Board();
		b.setMemberId("osram30");
		b.setBoardTitle("타이틀2");
		b.setBoardContent("내용입니다12.");
		service.boardInsert(b);
	}
	
	@Test
	public void boardSelectWithContent()throws Exception{
		/*List<Board> list = dao.boardRead(1);
		for(Board b : list){
			System.out.println(b);
		}*/
		System.out.println(dao.boardRead(1));
	}
}
