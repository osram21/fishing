package kr.or.dgit.domain;

import java.util.Date;

public class PointReply {
	private int prNo;
	private String memberId;
	private int pointNo;
	private double prF;
	private double prS;
	private String prContent;
	private Date prDate;
	public int getPrNo() {
		return prNo;
	}
	public void setPrNo(int prNo) {
		this.prNo = prNo;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public int getPointNo() {
		return pointNo;
	}
	public void setPointNo(int pointNo) {
		this.pointNo = pointNo;
	}
	public double getPrF() {
		return prF;
	}
	public void setPrF(double prF) {
		this.prF = prF;
	}
	public double getPrS() {
		return prS;
	}
	public void setPrS(double prS) {
		this.prS = prS;
	}
	public String getPrContent() {
		return prContent;
	}
	public void setPrContent(String prContent) {
		this.prContent = prContent;
	}
	public Date getPrDate() {
		return prDate;
	}
	public void setPrDate(Date prDate) {
		this.prDate = prDate;
	}
	
	@Override
	public String toString() {
		return "PointReply [prNo=" + prNo + ", memberId=" + memberId + ", pointNo=" + pointNo + ", prF=" + prF
				+ ", prS=" + prS + ", prContent=" + prContent + ", prDate=" + prDate + "]";
	}	
}
