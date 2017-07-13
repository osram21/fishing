package kr.or.dgit.domain;

public class SerchCriteria extends Criteria{
	private String searchType;
	private String keyword;
	public String getSearchType() {
		return searchType;
	}
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	@Override
	public String toString() {
		return "SerchCriteria [searchType=" + searchType + ", keyword=" + keyword + "]";
	}
}
