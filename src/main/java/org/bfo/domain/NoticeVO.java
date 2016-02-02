package org.bfo.domain;

import java.util.Date;

public class NoticeVO {

	private Integer nno;
	private String title;
	private String content;
	private Integer mno;
	private String nickName;
	private Date regDate;
	private Date updateDate;
	private Integer viewCnt;
	private Integer highlight;
	
	public Integer getNno() {
		return nno;
	}
	public void setNno(Integer nno) {
		this.nno = nno;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
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
	public Integer getViewCnt() {
		return viewCnt;
	}
	public void setViewCnt(Integer viewCnt) {
		this.viewCnt = viewCnt;
	}
	public Integer getHighlight() {
		return highlight;
	}
	public void setHighlight(Integer highlight) {
		this.highlight = highlight;
	}
	
	@Override
	public String toString() {
		return "NoticeVO [nno=" + nno + ", title=" + title + ", content=" + content + ", mno=" + mno + ", nickName="
				+ nickName + ", regDate=" + regDate + ", updateDate=" + updateDate + ", viewCnt=" + viewCnt
				+ ", highlight=" + highlight + "]";
	}
}