package cn.fh.datastructure;

import static java.lang.System.out;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;

/**
 * 基于链表的栈
 * @author whf
 *
 * @param <T>
 */
public class LinkedStack<T> implements Iterable<T> {
	private Node first;
	private int size;
	

	private class Node {
		T data;
		Node next;
	}
	
	private class StackIterator implements Iterator<T> {
		private Node curNode = first;

		@Override
		public boolean hasNext() {
			return curNode != null;
		}

		@Override
		public T next() {
			T elem = curNode.data;
			curNode = curNode.next;

			return elem;
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
		
	}
	
	public Iterator<T> iterator() {
		return new StackIterator();
	}
	
	public void push(T elem) {
		Node oldFirst = first;
		first = new Node();
		first.data = elem;
		first.next = oldFirst;
		
		++size;
	
		out.println("push:" + elem);
	}
	
	public T pop() {
		if (true == isEmpty()) {
			return null;
		}
		
		Node oldFirst = first;
		first = first.next;
		--size;
		
		out.println("pop:" + oldFirst.data);
		
		return oldFirst.data;
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public static void main(String[] args) throws IOException {
		LinkedStack<String> st = new LinkedStack<String>();
		
		/*BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		while ((line = br.readLine()) != null) {
			st.push(line);
		}	*/
		
		st.push("Neo");
		st.push("Bruce");
		st.push("Lee");
		
		for (String s : st) {
			out.println(s);
		}
		out.println("size:" + st.size());
	}
}
