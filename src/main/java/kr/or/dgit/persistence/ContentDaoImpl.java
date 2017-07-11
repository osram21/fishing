package kr.or.dgit.persistence;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.or.dgit.domain.Board;
import kr.or.dgit.domain.Content;

@Repository
public class ContentDaoImpl implements ContentDao{
	
	@Autowired
	private SqlSession session;
	
	private static String namespace = "kr.or.dgit.persistence.ContentDao";
	@Override
	public void contentInsert(Content content) throws Exception {
		session.insert(namespace+".contentInsert",content);
	}

}
