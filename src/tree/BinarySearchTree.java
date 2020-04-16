package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.function.Consumer;

/**
 * 二叉树
 * @author Vitalc
 *
 * 性质：
 * 1.在非空二叉树中, 第i层的结点总数不超过2^(i - 1), i >= 1
 * 2.深度为h的二叉树最多有(2^h) - 1个结点(h >= 1), 最少有h个结点
 * 3.对于任意一棵二叉树, 如果其叶结点数为N0,而度数为2的结点总数为N2, 则N0 = N2 + 1
 * 4.具有n个结点的完全二叉树的深度为[log2(n)] + 1(注：[]表示向下取整)
 * 5.给定N个节点, 能构成h(N)种不同的二叉树
 *   h(N)为卡特兰数的第N项
 *   h(n) = C(2*n, n) / (n + 1)
 * @param <K>
 * @param <V>
 */
public class BinarySearchTree<K, V> implements IBinarySearchTree<K, V> {

	protected Node<K, V> root;
	private int size;
	//private Comparator comparator;
	
	public BinarySearchTree() {
		
	}
	
//	public BinarySearchTree(Comparator comparator) {
//		this.comparator = comparator;
//	}
	@SuppressWarnings("hiding")
	protected class Node<K, V> {
		public K key;
		public V value;
		public Node<K, V> leftNode;
		public Node<K, V> rightNode;
		public Node<K, V> parentNode;
		public boolean isLeftNode;
		
		public int height;
		/**
		 * 在二叉树里的编号
		 */
		public int num;
		
		public Node() {
			
		}
	
		public Node(K key, V value, Node<K, V> leftNode, Node<K, V> rightNode, Node<K, V> parentNode) {
			super();
			this.key = key;
			this.value = value;
			this.leftNode = leftNode;
			this.rightNode = rightNode;
			this.parentNode = parentNode;
		}
		
		public boolean isLeft() {
			return isLeftNode;
		}
		
		public boolean isRight() {
			return !isLeftNode;
		}
		
		@Override
		public String toString() {
			return "Node [key=" + key + "]";
		}
	}

	@Override
	public Node<K, V> insert(K key, V value) {
		if (!(key instanceof Comparable)) {
			System.out.println("无法比较的类型");
		}
		Node<K, V> parent = null;
		Node<K, V> curr = root;
		while (curr != null) {
			parent = curr;
			if (compare(key, curr.key) < 0) {
				curr = curr.leftNode;
			} else if(compare(key, curr.key) > 0) {
				curr = curr.rightNode;
			} else {
				return curr;
			}
		}
		curr = new Node<K, V>(key, value, null, null, null);
		curr.parentNode = parent;
		if (parent == null) {
			root = curr;
		} else if (compare(key, parent.key) > 0) {
			parent.rightNode = curr;
			curr.isLeftNode = false;
		} else {
			parent.leftNode = curr;
			curr.isLeftNode = true;
		}
		size++;
		updateHeight(curr);
		return curr;
	}

	/**
	 * 前大于后返回正数
	 * @param key
	 * @param key2
	 * @return
	 */
	private int compare(K key, K key2) {
		return (int)key - (int)key2;
	}

	/**
	 * 更新树的高度
	 * @param curr
	 */
	private void updateHeight(Node<K, V> curr) {
		
	}

	@Override
	public void inorder(Consumer<K> con) {
		if (root != null) {
			inorder(root, con);
		}
	}

	protected void inorder(Node<K, V> p, Consumer<K> con) {
		if (p != null) {
			inorder(p.leftNode, con);
			System.out.println(p.key);
			//con.accept(p.key);
			inorder(p.rightNode, con);
		}		
	}

	@Override
	public V lookupValue(K key) {
		Node<K, V> lookupNode = lookupNode(key);
		return lookupNode == null ? null : lookupNode.value;
	}

	protected Node<K, V> lookupNode(K key) {
		Node<K, V> p = root;
		while (p != null && compare(key,  p.key) != 0) {
			if (compare(key,  p.key) < 0) {
				p = p.leftNode;
			} else {
				p = p.rightNode;
			}
		}
		return p;
	}

	@Override
	public K min() {
		return minNode(root).key;
	}

	protected Node<K, V> minNode(Node<K, V> p) {
		while (p.leftNode != null) {
			p = p.leftNode;
		}
		return p;
	}
	
	protected Node<K, V> maxNode(Node<K, V> p) {
		while (p.rightNode != null) {
			p = p.rightNode;
		}
		return p;
	}

	@Override
	public K max() {		
		return maxNode(root).key;
	}

	@Override
	public void remove(K key) {
		removeNode(lookupNode(key));
		size--;
	}

	private void removeNode(Node<K, V> x) {
		Node<K, V> p = x.parentNode;
		Node<K, V> c;
		if (x.leftNode == null && x.rightNode == null) {//叶结点
			if (p == null) {//x为根结点
				root = null;
				return;
			}
			if (x.isLeft()) {
				p.leftNode = null;
			} else {
				p.rightNode = null;
			}
			p = null;
			x = null;
		} else if (x.leftNode == null) {//右单支结点
			c = x.rightNode;
			if (x.isLeft()) {
				p.leftNode = c;
			} else {
				p.rightNode = c;
			}
			c.parentNode = p;
			x = null;
		} else if (x.rightNode == null) {//左单支结点
			c = x.leftNode;
			if (x.isLeft()) {
				p.leftNode = c;
			} else {
				p.rightNode = c;
			}
			c.parentNode = p;
			x = null;
		} else {//双支结点
			Node<K, V> min = minNode(x.rightNode);
			x.key = min.key;
			x.value = min.value;
			removeNode(min);
		}
		
	}

	@Override
	public K successor(K x) {
		Node<K, V> xNode = lookupNode(x);
		if (xNode == null) {
			return null;
		}
		if (xNode.rightNode != null) {
			return minNode(xNode.rightNode).key;
		}
		Node<K, V> yNode = xNode.parentNode;
		while (yNode != null && xNode == yNode.rightNode) {
			xNode = yNode;
			yNode = yNode.parentNode;
		}
		return yNode == null ? null : yNode.key;
	}

	@Override
	public K predecessor(K x) {
		Node<K, V> xNode = lookupNode(x);
		if (xNode == null) {
			return null;
		}
		if (xNode.leftNode != null) {
			return maxNode(xNode.leftNode).key;
		}
		Node<K, V> yNode = xNode.parentNode;
		while (yNode != null && xNode.isLeftNode) {
			xNode = yNode;
			yNode = yNode.parentNode;
		}
		return yNode == null ? null : yNode.key;
	}

	@Override
	public boolean isBalance() {
		return !unBalance(root);
	}

	protected boolean unBalance(Node<K, V> g) {
		if (g ==null) {
			return false;
		}
		int minus = getHeight(g.leftNode) - getHeight(g.rightNode);
		return Math.abs(minus) > 1 || unBalance(g.leftNode) || unBalance(g.rightNode);
	}

	@Override
	public int getSize() {		
		return size;
	}

	@Override
	public int getHeight() {
		return getHeight(root);
	}
	
	protected int getHeight(Node<K, V> node) {
		if (node == null) {
			return 0;
		}
		int l = getHeight(node.leftNode);
		int r = getHeight(node.rightNode);
		return 1 + Math.max(l, r);
	}

	public List<List<Node<K, V>>> leverOrder(Node<K, V> x) {
		List<List<Node<K, V>>> res = new ArrayList<List<Node<K, V>>>();
		List<Node<K, V>> l = new ArrayList<Node<K, V>>();
		Queue<Node<K, V>> q = new LinkedList<Node<K, V>>();
		Node<K, V> last = x;
		Node<K, V> p = null;
		q.add(x);
		res.add(l);
		while (!q.isEmpty()) {
			Node<K, V> peek = q.peek();
			if (peek.leftNode != null) {
				peek.leftNode.num = peek.num * 2;
				q.add(peek.leftNode);
				p = peek.leftNode;
			}
			if (peek.rightNode != null) {
				peek.rightNode.num = peek.num * 2 + 1;
				q.add(peek.rightNode);
				p = peek.rightNode;
			}
			l.add(q.poll());
			if (peek == last && !q.isEmpty()) {
				l = new ArrayList<Node<K, V>>();
				res.add(l);
				last = p;
			}
		}
		return res;
	}

	@Override
	public List<List<Node<K, V>>> leverOrder() {
		root.num = 1;
		return leverOrder(root);
	}
}
