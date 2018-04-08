package com.lixingzh.study.java.javalearning.parallel.setvsconcurrentset;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.ConcurrentSkipListSet;

public class HashMapVSConcurrentStructure {
	public static void main(String[] args) {
		HashMapVSConcurrentStructure service = new HashMapVSConcurrentStructure();
		//ConcurrentModificationException Throwed
		//service.hashSetDead();
		
		service.concurrentHashSetWork();
	}
	
	void hashSetDead () {
		HashSet<String> set = new HashSet<>();
		set.add("a");
		set.add("b");
		set.add("c");
		
		Iterator<String> iter = set.iterator();
		while(iter.hasNext()) {
			String str = iter.next();
			if("a".equals(str)) {
				set.remove(str);
			}
			else {
				System.out.println(str);
			}
		}
	}
	
	void concurrentHashSetWork () {
		Collection<String> set = new ConcurrentSkipListSet<>();
		set.add("a");
		set.add("b");
		set.add("c");
		
		Iterator<String> iter = set.iterator();
		while(iter.hasNext()) {
			String str = iter.next();
			if("a".equals(str)) {
				set.remove(str);
			}
			else {
				System.out.println(str);
			}
		}
	}
}
