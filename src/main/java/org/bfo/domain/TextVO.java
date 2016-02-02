package org.bfo.domain;

public class TextVO {
	
	private Integer selectItemNo;
	private String selectItem;
	private Integer pno;
	private Integer pnoItemNo;
	
	public Integer getSelectItemNo() {
		return selectItemNo;
	}
	public void setSelectItemNo(Integer selectItemNo) {
		this.selectItemNo = selectItemNo;
	}
	public String getSelectItem() {
		return selectItem;
	}
	public void setSelectItem(String selectItem) {
		this.selectItem = selectItem;
	}

	public Integer getPno() {
		return pno;
	}
	public void setPno(Integer pno) {
		this.pno = pno;
	}
	public Integer getPnoItemNo() {
		return pnoItemNo;
	}
	public void setPnoItemNo(Integer pnoItemNo) {
		this.pnoItemNo = pnoItemNo;
	}
	@Override
	public String toString() {
		return "ItemVO [selectItemNo=" + selectItemNo + ", selectItem=" + selectItem + ", pno=" + pno + ", pnoItemNo=" + pnoItemNo + "]";
	}
}
