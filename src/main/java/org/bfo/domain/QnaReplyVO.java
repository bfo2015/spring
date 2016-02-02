package org.bfo.domain;

import java.util.Date;

public class QnaReplyVO {

	private int rno;
	private int qnano;
	private int mno;
	private String replyText;
	private String replyer;
	private Date updateDate;
	private Date regDate;
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public int getQnano() {
		return qnano;
	}
	public void setQnano(int qnano) {
		this.qnano = qnano;
	}
	public int getMno() {
		return mno;
	}
	public void setMno(int mno) {
		this.mno = mno;
	}
	public String getReplyText() {
		return replyText;
	}
	public void setReplyText(String replyText) {
		this.replyText = replyText;
	}
	public String getReplyer() {
		return replyer;
	}
	public void setReplyer(String replyer) {
		this.replyer = replyer;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	@Override
	public String toString() {
		return "ReplyVO [rno=" + rno + ", qnano=" + qnano + ", mno=" + mno + ", replyText=" + replyText + ", replyer="
				+ replyer + ", updateDate=" + updateDate + ", regDate=" + regDate + "]\n";
	}
	
		
	
	
}
