package com.lixingzh.study.java.javalearn.codingtrap.terminal;

import java.util.Iterator;
import java.util.Vector;

public class BadVisitor {
	public static void main(String[] args) {
		Vector<String> v = new Vector<String>();
		
		v.add("a");
		v.add("b");
		v.add("c");
		v.add("d");
		
		Iterator<String> iter = v.iterator();
		while(iter.hasNext()) {
			String s = iter.next();
			if(s.equals("c")) {
				// Exception
				//v.remove(s);
				iter.remove();
			} else {
				System.out.println(s);
			}
		}
		
		System.out.println("What's really there...");
		System.out.println(v.toString());
	}
}
