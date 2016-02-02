package org.bfo.domain;

import java.util.List;

public class AllVO extends PollVO {

	private List<FileVO> files;
	private List<TextVO> texts;

	
	
	
	
	
	
	public List<FileVO> getFiles() {
		return files;
	}
	public void setFiles(List<FileVO> files) {
		this.files = files;
	}
	public List<TextVO> getTexts() {
		return texts;
	}
	public void setTexts(List<TextVO> texts) {
		this.texts = texts;
	}
	@Override
	public String toString() {
		return "AllVO [files=" + files + ", texts=" + texts  + "]";
	}
	
}
