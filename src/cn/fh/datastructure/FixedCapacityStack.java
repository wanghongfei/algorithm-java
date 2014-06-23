package cn.fh.datastructure;

import static java.lang.System.out;

/**
 * 固定容量的栈，用数组实现。
 * 当空间不足时，自动将空间加倍。空间使用少于1/4时，将空间减半
 * @author whf
 *
 * @param <T>
 */
public class FixedCapacityStack<T> {
	private int size;
	private T[] arr;

	public FixedCapacityStack(int capacity) {
		size = 0;
		arr = (T[])new Object[capacity];
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
	
	public static void main(String[] args) {
		FixedCapacityStack<String> st = new FixedCapacityStack<String>(2);
		st.push("neo");
		st.push("bruce");
		st.push("google");

		st.push("neo");
		st.push("bruce");
		st.push("google");
		
		st.pop();
		st.pop();
		st.pop();
		st.pop();
		st.pop();
	}
}
