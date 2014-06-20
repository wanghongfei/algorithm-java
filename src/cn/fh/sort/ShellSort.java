package cn.fh.sort;

import java.io.IOException;
import java.util.Arrays;

import cn.fh.util.ReadData;
import cn.fh.util.Stopwatch;
import static java.lang.System.out;

public class ShellSort {
	public static void sort(Comparable[] arr) {
		int LEN = arr.length;
		int d = LEN;
		
		while( d >= 1) {
			d = d / 2;
			//out.println("取 d = " + d);
			
			for (int first = 0 ;  first < d ; ++first) {
				for (int i = first + d ; i < LEN ; i += d) {
					for(int j = i ; j - d >= 0 && arr[j].compareTo(arr[j - d]) < 0 ; j -= d) {
						Comparable t = arr[j];
						arr[j] = arr[j - d];
						arr[j - d] = t;
					}
				}
			}
		}
	} // method ends
	
	public static void main(String[] args) throws IOException {
		Integer[] nums = ReadData.readIntFromConsole();
		
		Stopwatch w1 = new Stopwatch();
		w1.start();
		//Arrays.sort(nums);
		sort(nums);
		//ReadData.printArray(nums);
		out.println("time : " + w1.elapse() + "ms");
	}

}
