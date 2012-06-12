package com.g4.java.util;

public class Pair<S, T> {
	
	private S o1;
	private T o2;
	
	public Pair(S o1, T o2) {
		this.o1 = o1;
		this.o2 = o2;
	}
	
	public S getO1() {
		return o1;
	}
	
	public T getO2() {
		return o2;
	}
	
	public void setO1(S o1) {
		this.o1 = o1;
	}
	
	public void setO2(T o2) {
		this.o2 = o2;
	}
	

}
