package com.lixingzh.study.java.javalearn.codingtrap.logicprogramming;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/*
 * 到底关闭了吗
 */
public class IOTest {
	public static void main(String[] args) {
		
	}
	
	public static void copy(String src, String dest) throws IOException {
		InputStream in = null;
		OutputStream out = null;
		
		try {
			in = new FileInputStream(src);
			out = new FileOutputStream(dest);
			
			byte[] buf = new byte[1024];
			int n = 0;
			
			while((n = in.read(buf)) > 0 ) {
				out.write(buf, 0, n);
			}
		} finally {
			if(in != null) {
				try {
					in.close();
				} finally {
					in = null;
				}
			}
			if(out != null) {
				try {
					out.close();
				} finally {
					out = null;
				}
			}
		}
	}
}
