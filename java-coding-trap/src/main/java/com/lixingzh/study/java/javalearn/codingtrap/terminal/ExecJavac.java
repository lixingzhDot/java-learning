package com.lixingzh.study.java.javalearn.codingtrap.terminal;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/*
 * 打开 Javac 进程
 */
public class ExecJavac {
	public static void main(String[] args) {
		try {
			Runtime rt = Runtime.getRuntime();
			Process proc = rt.exec("javac");
			// exception throwed proc doesn't exits before exitValue() get called
			//int exitVal = proc.exitValue();
			int exitVal = proc.waitFor();
			System.out.println("Process exitValue: " + exitVal);
		} catch (Throwable t) {
			t.printStackTrace();
		}
		
		// some function 
		try {
			Runtime rt = Runtime.getRuntime();
			Process proc = rt.exec("javac");
			
			// 无法直接waitFor， 因为错误信息阻塞了退出
			InputStream stderr = proc.getErrorStream();
			InputStreamReader isr = new InputStreamReader(stderr);
			BufferedReader br = new BufferedReader(isr);
			
			String line = null;
			
			System.out.println("</ERROR>");
			while((line = br.readLine()) != null) {
				System.out.println(line);
			}
			System.out.println("</ERROR>");

			//int exitVal = proc.exitValue();
			int exitVal = proc.waitFor();
			System.out.println("Process exitValue: " + exitVal);
		} catch (Throwable t) {
			t.printStackTrace();
		}
	}
}
