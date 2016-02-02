 package org.bfo.domain;

import java.util.Date;

public class FileVO {

	private String fullName;
	private Integer pno;
	private Integer pnoFileNo;
	
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public Integer getPno() {
		return pno;
	}
	public void setPno(Integer pno) {
		this.pno = pno;
	}
	public Integer getPnoFileNo() {
		return pnoFileNo;
	}
	public void setPnoFileNo(Integer pnoFileNo) {
		this.pnoFileNo = pnoFileNo;
	}
	@Override
	public String toString() {
		return "FileVO [fullName=" + fullName + ", pno=" + pno + ", pnoFileNo=" + pnoFileNo
				+ "]";
	}
}
