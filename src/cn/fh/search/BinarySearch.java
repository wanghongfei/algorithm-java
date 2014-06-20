package cn.fh.search;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

import cn.fh.util.Stopwatch;

public class BinarySearch {
	public static int binSearch(int[] arr, int key) {
		int l = 0;
		int r = arr.length - 1;
		
		while (l <= r) {
			int mid = l + (r - l) / 2;
			
			if (key < arr[mid]) {
				r = mid - 1;
			} else if (key > arr[mid]) {
				l = mid + 1;
			} else {
				return mid;
			}
		}
		
		return -1;
	}
	
	public static void main(String[] args) throws Exception {
		/*Scanner scan = new Scanner(System.in);

		Stopwatch watch = new Stopwatch();
		watch.start();
		while(scan.hasNext()) {
			scan.nextInt();
		}
		System.out.println(watch.elapse());*/
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		int ix = 0;
		int[] nums = new int[100 * 10000];
		while ((line = br.readLine()) != null) {
			int i = Integer.valueOf(line.trim());
			nums[ix++] = i;
		}
		Arrays.sort(nums);

		Stopwatch sw = new Stopwatch();
		sw.start();
		binSearch(nums, 938168);
		System.out.println(sw.elapse());
		
		
		Stopwatch sw2 = new Stopwatch();
		sw2.start();
		for (int n : nums) {
			if (n == 938168) {
				System.out.println(sw2.elapse());
				break;
			}
		}
	}
}
