package cn.fh.sort;

import java.io.IOException;
import java.util.Arrays;

import cn.fh.util.ReadData;
import cn.fh.util.Stopwatch;
import cn.fh.util.Test;
import static java.lang.System.out;

/**
 * sort()为标准代码，sortX()为练习代码
 * @author whf
 *
 */
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
	
	public static void sort2(Comparable[] arr) {
		int LEN = arr.length;
		int d = LEN;
		
		while (d >= 1) {
			d = d / 2;
			
			for (int f = 0 ; f < d ; ++f) {
				for (int i = f + d ; i < LEN ; i += d) {
					for (int j = i ; j - d >= 0 && arr[j].compareTo(arr[j - d]) < 0 ; j -= d) {
						swap(arr, j, j - d);
					}
				}
			}
		}
	}
	
	public static void sort3(Comparable[] arr) {
		int LEN = arr.length;
		int d = LEN;
		
		while (d >= 1) {
			d = d / 2;
			
			for (int first = 0 ; first < d ; ++ first) {
				for (int i = first + d ; i < LEN ; i += d) {
					for (int j = i ; j - d >= 0 && arr[j].compareTo(arr[j - d]) < 0 ; j -= d) {
						swap(arr, j, j - d);
					}
				}
			}
		}
	}
	
	public static void sort4(Comparable[] arr) {
		int LEN = arr.length;                                                                                                                                                                                  
		int d = LEN;
		
		while (d >= 1) {
			d = d / 2;
			
			for (int first = 0 ; first < d ; ++first) {
				for (int i = first + d ; i < LEN ; i += d) {
					for (int j = i ; j - d >= 0 && arr[j].compareTo(arr[j - d]) < 0 ; j -= d) {
						swap(arr, j, j - d);
					}
				}
			}
		}
	}
	
	private static void swap(Comparable[] arr, int p1, int p2) {
		Comparable t = arr[p1];
		arr[p1] = arr[p2];
		arr[p2] = t;
	}
	
	
	public static void main(String[] args) throws IOException {
		Integer[] nums = ReadData.readIntFromConsole();
		
		Stopwatch w1 = new Stopwatch();
		w1.start();
		sort4(nums);
		assert Test.isSorted(nums);
		//ReadData.printArray(nums);
		out.println("time : " + w1.elapse() + "ms");
	}

}
