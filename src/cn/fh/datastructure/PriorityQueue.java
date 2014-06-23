package cn.fh.datastructure;


/**
 * 优先队列
 * @author whf
 *
 */
public class PriorityQueue<T extends Comparable<T>> {
	private int size;
	private T[] arr; // discard arr[0]
	
	public PriorityQueue(int capacity) {
		arr = (T[])new Comparable[capacity + 1];
	}
	
	// 测试用例
	public static void main(String[] args) {
		PriorityQueue<Integer> heap = new PriorityQueue<Integer>(100);
		heap.insert(1);
		heap.insert(10);
		heap.insert(-1);
		heap.insert(0);
		heap.insert(100);
		heap.insert(30);
		
		heap.printAll();
		
		heap.delMax();
		heap.printAll();
		
		heap.delMax();
		heap.printAll();

		heap.delMax();
		heap.printAll();
		
		heap.delMax();
		heap.printAll();
	}
	
	/**
	 * 删除并返回最大元素(堆顶元素)
	 * 将堆底元素放至堆顶，然后调用sink()方法将堆恢复至有序
	 * @return
	 */
	public T delMax() {
		T max = arr[1];
		swap(size--, 1);
		arr[size + 1] = null;
		sink(1);
		
		System.out.println("delete : " + max);
		return max;
	}
	
	/**
	 * 插入新元素到堆底
	 * 调用swim()方法将新插入元素调整至合适的位置，恢复堆至有序
	 * @param elem
	 */
	public void insert(T elem) {
		System.out.println("insert:" + elem);
		arr[++size] = elem;
		swim(size);
	}
	
	/**
	 * 上浮结点
	 * @param k
	 */
	private void swim(int k) {
		while (k > 1 && arr[k].compareTo(arr[k / 2]) > 0) {
			swap(k, k / 2);
			k = k / 2;
		}
	}
	
	/**
	 * 下沉结点
	 * @param k
	 */
	private void sink(int k) {
		while (k * 2 <= size) {
			int child = k * 2;
			
			// 找到子节点中值较大的者
			if (arr[child + 1] != null && arr[child].compareTo(arr[child + 1]) < 0) {
				++child;
			}
			
			if (arr[child].compareTo(arr[k]) < 0) {
				break;
			}
			
			swap(k, child);
			k = child;
		}
	}
	
	public int size() {
		return size;
	}
	
	private void swap(int pos1, int pos2) {
		T t = arr[pos1];
		arr[pos1] = arr[pos2];
		arr[pos2] = t;
	}
	
	public void printAll() {
		System.out.println("All elements:");
		for (int ix = 1 ; ix <= size ; ++ix) {
			System.out.println(arr[ix]);
		}
	}
}
