package org.bfo.domain;

public class CategoryVO {

   private String categoryCode;
   private String categoryName;
   private int categoryNo;
   
	public String getCategoryCode() {
		return categoryCode;
	}
	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public int getCategoryNo() {
		return categoryNo;
	}
	public void setCategoryNo(int categoryNo) {
		this.categoryNo = categoryNo;
	}

	@Override
	public String toString() {
		return "CategoryVO [categoryCode=" + categoryCode + ", categoryName=" + categoryName + ", categoryNo="
				+ categoryNo + "]";
	}
}