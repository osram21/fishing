package kr.or.dgit.persistence;

import java.util.List;

import kr.or.dgit.domain.Board;
import kr.or.dgit.domain.Content;

public interface ContentDao {
	public void contentInsert(Content content)throws Exception;
	
	public List<Content> contentList()throws Exception;
	
	public Content contentByno(int boardNo)throws Exception;
}
