package cn.fh.util;

/**
 * 工具类，验证输出结果是否正确
 * @author whf
 *
 */
public class Test {
	/**
	 * 测试数据元素是否为升序
	 * @param arr
	 * @return
	 */
	public static boolean isSorted(Comparable[] arr) {
		int LEN = arr.length;
		for (int ix = 1 ; ix < LEN ; ++ix) {
			if (arr[ix].compareTo(arr[ix - 1]) < 0) {
				return false;
			}
		}
		
		return true;
	}
}
