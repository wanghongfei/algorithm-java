package cn.fh.sort;

import java.io.IOException;
import java.util.Arrays;

import cn.fh.util.ReadData;
import cn.fh.util.Stopwatch;
import cn.fh.util.Test;

public class QuickSort {
	public static void sort(Comparable[] arr, int start, int end) {
		if (end <= start) {
			return;
		}
		
		int left = start;
		int right = end;
		Comparable pivot = arr[left];
		
		while (left < right) {
			while (left < right && arr[right].compareTo(pivot) >= 0) {
				--right;
			}
			arr[left] = arr[right];

			while (left < right && arr[left].compareTo(pivot) <= 0) {
				++left;
			}
			arr[right] = arr[left];
		}
		
		arr[right] = pivot;
		sort(arr, start, right - 1);
		sort(arr, right + 1, end);
		
	}
	
	public static void main(String[] args) throws IOException {
		Integer[] nums = ReadData.readIntFromConsole();
		
		Stopwatch w1 = new Stopwatch();
		w1.start();
		sort(nums, 0, nums.length - 1);
		//Arrays.sort(nums);
		assert Test.isSorted(nums);
		System.out.println("time : " + w1.elapse());
	}
	
	
}
