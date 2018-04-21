package com.lixingzh.study.java.javalearning.generic;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapPutTest {
	public static void main(String[] args) {
		Map<String, List<String>> map = new HashMap<>();
		String key = "key";
		String value = "value";
		
		List<String> list = Arrays.asList("value");
		map.put(key, list);
		
		System.out.println(map.toString());
		
		value = "value2";
		
		System.out.println(map.toString());
		
		//list.add(12);
	}
}
