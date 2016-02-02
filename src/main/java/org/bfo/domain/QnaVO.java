package org.bfo.domain;

import java.util.Date;

public class QnaVO {

	private int qnano;
	private String nickname;
	private String title;
	private String content;
	private Date updateDate;
	private Date regDate;
	private Integer pw;
	private int mno;
	
	
	
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getMno() {
		return mno;
	}
	public void setMno(int mno) {
		this.mno = mno;
	}
	public Integer getPw() {
		return pw;
	}
	public void setPw(Integer pw) {
		this.pw = pw;
	}
	public int getQnano() {
		return qnano;
	}
	public void setQnano(int qnano) {
		this.qnano = qnano;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
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
		return "QnaVO [qnano=" + qnano + ", nickname=" + nickname + ", title=" + title + ", content=" + content
				+ ", updateDate=" + updateDate + ", regDate=" + regDate + ", pw=" + pw + ", mno=" + mno + "]\n";
	}
	
	
	
	
}
