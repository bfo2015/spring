package org.bfo.domain;

import java.util.List;

public class ItemVO {
	
	private List<String> files;
	private List<String> texts;
	
	public List<String> getFiles() {
		return files;
	}
	public void setFiles(List<String> files) {
		this.files = files;
	}
	public List<String> getTexts() {
		return texts;
	}
	public void setTexts(List<String> texts) {
		this.texts = texts;
	}
	@Override
	public String toString() {
		return "ItemVO [files=" + files + ", texts=" + texts + "]";
	}
}
