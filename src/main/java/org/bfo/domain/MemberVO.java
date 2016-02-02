package org.bfo.domain;

import java.util.Date;

public class MemberVO {

	private 	Integer mno;
	private		String 	userMail;
	private		String	userPw;
	private		String	nickName;
	private 	boolean useCookie;
	
	
	public boolean isUseCookie() {
		return useCookie;
	}
	public void setUseCookie(boolean useCookie) {
		this.useCookie = useCookie;
	}
	public Integer getMno() {
		return mno;
	}
	public void setMno(Integer mno) {
		this.mno = mno;
	}
	public String getUserMail() {
		return userMail;
	}
	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}
	public String getUserPw() {
		return userPw;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	@Override
	public String toString() {
		return "MemberVO [mno=" + mno + ", userMail=" + userMail + ", userPw=" + userPw + ", nickName=" + nickName
				+ ", useCookie=" + useCookie + "]";
	}
	

	
	
	
	
}
