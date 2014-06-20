package cn.fh.util;

public class Stopwatch {
	private long startTime;
	
	public void start() {
		startTime = System.currentTimeMillis();
	}
	
	public long elapse() {
		return System.currentTimeMillis() - startTime;
	}
}
