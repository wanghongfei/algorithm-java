package cn.fh.sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import cn.fh.util.ReadData;
import cn.fh.util.Stopwatch;

public class SelectionSort {
	public static void mysort(Comparable[] arr) {
		for (int i = 0 ; i < arr.length ; ++i) {
			for (int j = i + 1 ; j < arr.length ; ++j) {
				if (arr[i].compareTo(arr[j]) > 0) {
					Comparable t = arr[i];
					arr[i] = arr[j];
					arr[j] = t;
				}
			}
		}
	}
	
	public static void hissort(Comparable[] arr) {
		for (int i = 0 ; i < arr.length ; ++i) {
			int min = i;
			for (int j = i + 1 ; j < arr.length ; ++j) {
				if (arr[j].compareTo(arr[min]) < 0) {
					min = j;
				}
			}
			
			Comparable t = arr[min];
			arr[min] = arr[i];
			arr[i] = t;
		}
	}
	
	public static void main(String[] args) throws Exception {
		Integer[] nums = ReadData.readIntFromConsole();	

		Stopwatch w1 = new Stopwatch();
		Stopwatch w2 = new Stopwatch();
		
		w1.start();
		mysort(nums);
		System.out.println("selection sort : " + w1.elapse() + "ms");

	}
}
