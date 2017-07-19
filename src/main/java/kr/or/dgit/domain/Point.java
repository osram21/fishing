package kr.or.dgit.domain;

import java.util.Date;

public class Point {
	private int pointNo;
	private String memberId;
	//사진파일
	private String pointWhere;
	private String pointTitle;
	private double pointLatiude;
	private double pointHardness;
	private int pointCount;
	private Date pointDate;
	private int pointGood;
	private String pointContent;
	
	
	public String getPointContent() {
		return pointContent;
	}
	public void setPointContent(String pointContent) {
		this.pointContent = pointContent;
	}
	public int getPointNo() {
		return pointNo;
	}
	public void setPointNo(int pointNo) {
		this.pointNo = pointNo;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getPointWhere() {
		return pointWhere;
	}
	public void setPointWhere(String pointWhere) {
		this.pointWhere = pointWhere;
	}
	public String getPointTitle() {
		return pointTitle;
	}
	public void setPointTitle(String pointTitle) {
		this.pointTitle = pointTitle;
	}
	public double getPointLatiude() {
		return pointLatiude;
	}
	public void setPointLatiude(double pointLatiude) {
		this.pointLatiude = pointLatiude;
	}
	public double getPointHardness() {
		return pointHardness;
	}
	public void setPointHardness(double pointHardness) {
		this.pointHardness = pointHardness;
	}
	public int getPointCount() {
		return pointCount;
	}
	public void setPointCount(int pointCount) {
		this.pointCount = pointCount;
	}
	public Date getPointDate() {
		return pointDate;
	}
	public void setPointDate(Date pointDate) {
		this.pointDate = pointDate;
	}
	public int getPointGood() {
		return pointGood;
	}
	public void setPointGood(int pointGood) {
		this.pointGood = pointGood;
	}
	@Override
	public String toString() {
		return "Point [pointNo=" + pointNo + ", memberId=" + memberId + ", pointWhere=" + pointWhere + ", pointTitle="
				+ pointTitle + ", pointLatiude=" + pointLatiude + ", pointHardness=" + pointHardness + ", pointCount="
				+ pointCount + ", pointDate=" + pointDate + ", pointGood=" + pointGood + ", pointContent="
				+ pointContent + "]";
	}
}
