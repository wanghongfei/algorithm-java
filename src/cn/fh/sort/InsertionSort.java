package cn.fh.sort;

import static java.lang.System.out;

import java.io.IOException;

import cn.fh.util.ReadData;
import cn.fh.util.Stopwatch;

public class InsertionSort {
	public static void sort(Comparable[] arr) {
		for (int i = 1 ; i < arr.length ; ++i) {
			for (int j = i ; j > 0 && arr[j].compareTo(arr[j - 1]) < 0 ; --j) {
				Comparable t = arr[j];
				arr[j] = arr[j - 1];
				arr[j - 1] = t;
			}
		}
	}
	
	public static boolean isSorted(Comparable[] a) {
		for (int ix = 1 ; ix < a.length ; ++ix) {
			if (a[ix].compareTo(a[ix - 1]) < 0) {
				return false;
			}
		}
		
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		Integer[] nums = ReadData.readIntFromConsole();

		Stopwatch w1 = new Stopwatch();
		w1.start();
		sort(nums);
		out.println("insertion sort : " + w1.elapse() + "ms");

	}
}
