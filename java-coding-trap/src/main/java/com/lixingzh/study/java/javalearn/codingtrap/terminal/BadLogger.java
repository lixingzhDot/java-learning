package com.lixingzh.study.java.javalearn.codingtrap.terminal;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * 日志的粒度控制
 */
public class BadLogger {
	public static void main(String[] args) {
		Level logLevel = Level.INFO;
		if(args.length != 0) {
			if(args[0].equals("ALL")) {
				logLevel = Level.ALL;
			}
			// ...
			
		}
		BadLogger logex = new BadLogger(logLevel);
		logex.test();
	}
	
	private Logger m_log = null;
	
	public BadLogger(Level level) {
		ConsoleHandler ch = new ConsoleHandler();
		m_log = Logger.getLogger("test");
		m_log.setUseParentHandlers(false);
		m_log.addHandler(ch);
		
		// console handler 需要跟Logger level 一致。
		m_log.setLevel(level);
		ch.setLevel(level);
	}
	
	public void test() {
		System.out.println("level of the log is: " + m_log.getLevel());
		m_log.finest("finest");
		m_log.finer("finer");
		m_log.fine("fine");
		m_log.info("info");
		m_log.warning("warning");
		m_log.severe("severe");
	}
}
