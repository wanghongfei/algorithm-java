package cn.fh.datastructure;

public class LinkedQueue<T> {
	private Node first;
	private Node last;
	private int size;

	private class Node {
		T data;
		Node next;
	}
	
	/**
	 * 在队尾插入元素
	 * @param elem
	 */
	public void enqueue(T elem) {
		Node oldLast = last;
		last = new Node();
		last.data = elem;
		last.next = null;
		
		if (true == isEmpty()) {
			first = last;
		} else {
			oldLast.next = last;
		}
		
		++size;
	}
	
	public T dequeue() {
		Node oldFirst = first;
		first = first.next;
		--size;
		
		if (true == isEmpty()) {
			last = null;
		}
		
		return oldFirst.data;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
}
