package cn.fh.datastructure;

import static java.lang.System.out;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;

/**
 * 固定容量的栈，用数组实现。支持for-each循环
 * 当空间不足时，自动将空间加倍。空间使用少于1/4时，将空间减半
 * @author whf
 *
 * @param <T>
 */
public class FixedCapacityStack<T> implements Iterable<T> {
	private int size;
	private T[] arr;

	public FixedCapacityStack(int capacity) {
		size = 0;
		arr = (T[])new Object[capacity];
	}
	
	// 迭代器
	private class StackIterator implements Iterator<T> {
		private int ix = size - 1;

		@Override
		public boolean hasNext() {
			return ix >= 0;
		}

		@Override
		public T next() {
			return arr[ix--];
		}

		/**
		 * 不支持删除操作
		 */
		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
		
		
	}
	
	@Override
	public Iterator<T> iterator() {
		return new StackIterator();
	}
	
	/**
	 * 重新分配栈空间大小
	 * @param capacity 新容量
	 */
	private void resize(int capacity) {
		T[] temp = (T[])new Object[capacity];
		
		// 复制数组
		for (int ix = 0 ; ix < size ; ++ix) {
			temp[ix] = arr[ix];
		}
		
		arr = temp;
		out.println("resize capacity to : " + capacity);
	}
	
	public T pop() {
		T elem = arr[--size];
		arr[size] = null;
		
		// 如果元素数量少于1/4,则将空间减少一半
		if (size <= arr.length / 4) {
			resize(arr.length / 2);
		}
		
		out.println("pop:" + elem);
		return elem;
	}
	
	public void push(T elem) {
		if (true == isFull()) {
			resize(arr.length * 2);
		}
		
		arr[size++] = elem;
		out.println("push:" + elem);
	}
	
	public boolean isFull() {
		return size >= arr.length;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	/**
	 * 从 Stdin 中读入4W个整数进行测试
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		FixedCapacityStack<String> st = new FixedCapacityStack<String>(2);
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		while ((line = br.readLine()) != null) {
			st.push(line);
		}
		
		/*st.push("neo");
		st.push("bruce");
		st.push("google");

		st.push("neo");
		st.push("bruce");
		st.push("google");
		
		st.pop();
		
		for (String s : st) {
			out.println(s);
		} */
	}
}
