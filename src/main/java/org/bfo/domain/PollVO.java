package org.bfo.domain;

import java.util.Date;

public class PollVO {

	private Integer pno;
	private String pollAddr;
	private String topic;
	private String intro;
	private Date startDate;
	private Date endDate;
	private Integer mno;
	private String categoryCode;
	private String answerCode;
	private String multiOpt;
	private String publicCode;
	private String pollPw;
	
	private String loginCode;

	private String validation;
	private String status;
	
	private Date regDate;
	private Date updateDate;
	
	private String formatDate;

	public Integer getPno() {
		return pno;
	}

	public void setPno(Integer pno) {
		this.pno = pno;
	}

	public String getPollAddr() {
		return pollAddr;
	}

	public void setPollAddr(String pollAddr) {
		this.pollAddr = pollAddr;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Integer getMno() {
		return mno;
	}

	public void setMno(Integer mno) {
		this.mno = mno;
	}

	public String getCategoryCode() {
		return categoryCode;
	}

	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}

	public String getAnswerCode() {
		return answerCode;
	}

	public void setAnswerCode(String answerCode) {
		this.answerCode = answerCode;
	}

	public String getMultiOpt() {
		return multiOpt;
	}

	public void setMultiOpt(String multiOpt) {
		this.multiOpt = multiOpt;
	}

	public String getPublicCode() {
		return publicCode;
	}

	public void setPublicCode(String publicCode) {
		this.publicCode = publicCode;
	}

	public String getPollPw() {
		return pollPw;
	}

	public void setPollPw(String pollPw) {
		this.pollPw = pollPw;
	}

	public String getLoginCode() {
		return loginCode;
	}

	public void setLoginCode(String loginCode) {
		this.loginCode = loginCode;
	}

	public String getValidation() {
		return validation;
	}

	public void setValidation(String validation) {
		this.validation = validation;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public String getFormatDate() {
		return formatDate;
	}

	public void setFormatDate(String formatDate) {
		this.formatDate = formatDate;
	}

	@Override
	public String toString() {
		return "PollVO [pno=" + pno + ", pollAddr=" + pollAddr + ", topic=" + topic + ", intro=" + intro
				+ ", startDate=" + startDate + ", endDate=" + endDate + ", mno=" + mno + ", categoryCode="
				+ categoryCode + ", answerCode=" + answerCode + ", multiOpt=" + multiOpt + ", publicCode=" + publicCode
				+ ", pollPw=" + pollPw + ", loginCode=" + loginCode + ", validation=" + validation + ", status="
				+ status + ", regDate=" + regDate + ", updateDate=" + updateDate + ", formatDate=" + formatDate + "]";
	}
	
	
	
	
	
}
