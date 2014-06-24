package cn.fh.datastructure;

import static java.lang.System.out;

/**
 * 二叉查找树
 * @author whf
 *
 */
public class BinarySearchTree<Key extends Comparable<Key>, Value> {
	private Node root;

	private class Node {
		Key key;
		Value val;
		int nodeAmount;
		Node left;
		Node right;
		
		public Node(Key k, Value v, int tot) {
			this.key = k;
			this.val = v;
			this.nodeAmount = tot;
		}
	}
	
	// test cases
	public static void main(String[] args) {
		BinarySearchTree<String, Integer> tree = new BinarySearchTree<String, Integer>();
		tree.put("dog", 20);
		tree.put("cat", 50);
		tree.put("kitty", 10);
		
		out.println(tree.get("cat"));
		out.println(tree.get("10"));
		out.println(tree.get("kitty"));
	}
	
	/**
	 * Put a new K/V pair into BST, if it does not exist. Otherwise the value associated with 
	 * that key will be updated.
	 * @param k key
	 * @param v value
	 */
	public void put(Key k, Value v) {
		root = put(root, k, v);
	}
	
	/**
	 * Put a new K/V pair into BST.
	 * 
	 * <p>If key has already existed, the value attached with that key will be updated.
	 * If key doesn't exist, a new k/v pair will be created.
	 * @param k key
	 * @param v value
	 */
	private Node put(Node root, Key k, Value v) {
		if (null == root) {
			return new Node(k, v, 1);
		}
		
		int cmp = k.compareTo(root.key);
		if (cmp > 0) {
			root.right = put(root.right, k, v);
		} else if (cmp < 0) {
			root.left = put(root.left, k, v);
		} else {
			root.val = v;
		}
		
		root.nodeAmount = size(root.left) + size(root.right) + 1;
		return root;
	}
	
	/**
	 * Obtain the value of the specified key.
	 * @param k
	 * @return
	 */
	public Value get(Key k) {
		return get(root, k);
	}
	
	/**
	 * Obtain key from particular node.
	 * @param root
	 * @param k
	 * @return Return null if key does not exist.
	 */
	private Value get(Node root, Key k) {
		if (null == root) {
			return null;
		}
		
		int cmp = k.compareTo(root.key);
		if (cmp > 0) {
			return get(root.right, k);
		} else if (cmp < 0) {
			return get(root.left, k);
		} else {
			return root.val;
		}
	}
	
	/**
	 * 返回元素总数
	 * @return
	 */
	public int size() {
		return size(root);
	}
	
	/**
	 * 返回以某一结点为root的子树的结点数
	 * @param root 子树的根结点
	 * @return
	 */
	private int size(Node root) {
		if (null == root) {
			return 0;
		}
		
		return root.nodeAmount;
	}
}
