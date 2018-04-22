package com.lixingzh.study.java.javalearn.codingtrap.terminal;

public class SingleFatory {
	private SingleFatory() {}
	
	private static SingleFatory singleFatory = null;

	public static SingleFatory getSingleFatory(String[] args) {
		if(singleFatory == null) {
			singleFatory = new SingleFatory();
		}
		return singleFatory;
	}
	
	// good for multi-thread34wew4wwe
	private static SingleFatory singleFatory2 = new SingleFatory();
	public static SingleFatory getSingleFatory2(String[] args) {
		return singleFatory;
	}
}
