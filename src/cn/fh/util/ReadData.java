package cn.fh.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ReadData {
	public static Integer[] readIntFromConsole() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<Integer> numList = new ArrayList<Integer>();
		String line = null;

		while ((line = br.readLine()) != null) {
			numList.add(Integer.valueOf(line.trim()));
		}
		
		return numList.toArray(new Integer[0]);
	}
	
	public static void printArray(Integer[] a) {
		for (Integer i : a) {
			System.out.println(i);
		}
	}
}
