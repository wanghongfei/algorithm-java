package cn.fh.search;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import cn.fh.util.ReadData;
import cn.fh.util.Stopwatch;

/**
 * 用2个线程来查找一个数组中最大的元素
 * @author whf
 *
 */
public class MultithreadSearch {
	public static void main(String[] args) throws Exception {
		Integer[] arr = ReadData.readIntFromConsole();
		
		FindMaxJob j1 = new FindMaxJob(0, arr.length / 2, arr);
		FindMaxJob j2 = new FindMaxJob(arr.length / 2, arr.length, arr);
		
		ExecutorService service = Executors.newFixedThreadPool(2);
		Future<Integer> f1 = service.submit(j1);
		Future<Integer> f2 = service.submit(j2);
		
		Stopwatch w1 = new Stopwatch();
		w1.start();
		Math.max(f1.get(), f2.get());
		System.out.println(w1.elapse());
		
	}
}

class FindMaxJob implements Callable {
	private int start;
	private int end;
	private Integer[] arr;
	
	public FindMaxJob(int start, int end, Integer[] arr) {
		this.start = start;
		this.end = end;
		this.arr = arr;
	}

	@Override
	public Integer call() throws Exception {
		Integer max = Integer.MIN_VALUE;
		for (int ix = start ; ix < end ; ++ix) {
			if (arr[ix].compareTo(max) > 0) {
				max = arr[ix];
			}
		}
		
		return max;
	}
	
}
