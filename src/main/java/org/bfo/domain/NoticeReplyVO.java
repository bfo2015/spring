package org.bfo.domain;

import java.util.Date;

public class NoticeReplyVO {

	private Integer rno;
	private Integer nno;
	private String replyText;
	private Integer mno;
	private String nickName;
	private Date regDate;
	private Date updateDate;
	
	public Integer getRno() {
		return rno;
	}
	public void setRno(Integer rno) {
		this.rno = rno;
	}
	public Integer getNno() {
		return nno;
	}
	public void setNno(Integer nno) {
		this.nno = nno;
	}
	public String getReplyText() {
		return replyText;
	}
	public void setReplyText(String replyText) {
		this.replyText = replyText;
	}
	public Integer getMno() {
		return mno;
	}
	public void setMno(Integer mno) {
		this.mno = mno;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	
	@Override
	public String toString() {
		return "NoticeReplyVO [rno=" + rno + ", nno=" + nno + ", replyText=" + replyText + ", mno=" + mno
				+ ", nickName=" + nickName + ", regDate=" + regDate + ", updateDate=" + updateDate + "]";
	}	
}
