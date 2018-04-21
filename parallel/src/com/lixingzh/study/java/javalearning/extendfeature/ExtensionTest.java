package com.lixingzh.study.java.javalearning.extendfeature;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExtensionTest {

	/**
	 * a List<HashMap<String,String>>
	 * is a List<? extends Map<String,String>>
	 * but not a List<Map<String,String>>
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<HashMap<String,String>> hashMaps = new ArrayList<HashMap<String,String>>();

		
		//List<Map<String,String>> maps = hashMaps; // Won't compile,
		                                          // but imagine that it could

		Map<String,String> aMap = Collections.singletonMap("foo","bar"); // Not a HashMap

		//hashMaps.add( aMap ); // Perfectly legal (adding a Map to a List of Maps)

		// But maps and hashMaps are the same object, so this should be the same as

		//hashMaps.add( aMap ); // Should be illegal (aMap is not a HashMap)
	}

}