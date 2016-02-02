package org.bfo.domain;

import java.util.Arrays;

public class MyPollArray {

	int length;
	String[] arr;
	
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public String[] getArr() {
		return arr;
	}
	public void setArr(String[] arr) {
		this.arr = arr;
	}
	
	@Override
	public String toString() {
		return "MyPollArray [length=" + length + ", arr=" + Arrays.toString(arr) + "]\n";
	}
	
	
	
}
