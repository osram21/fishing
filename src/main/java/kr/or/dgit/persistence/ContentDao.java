package kr.or.dgit.persistence;

import kr.or.dgit.domain.Board;
import kr.or.dgit.domain.Content;

public interface ContentDao {
	public void contentInsert(Content content)throws Exception;
}
