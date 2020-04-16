package tree;

import java.util.function.Consumer;

public class RedBlackTree {
	private static final boolean RED = true;
	private static final boolean BLACK = false;
	private BRNode root;
	@SuppressWarnings("unused")
	private int size = 0;
	
	/**
	 * 增加结点
	 * @param x
	 */
	public void insert(Object x) {
		if (!(x instanceof Comparable)) {
			System.out.println("无法比较的类型");
		}
		BRNode p = null;
		BRNode curr = root;
		while (curr != null) {
			p = curr;
			if (compare(x, curr.key) < 0) {
				curr = curr.left;
			} else if(compare(x, curr.key) > 0) {
				curr = curr.right;
			} else {
				return;
			}
		}
		curr = new BRNode(x, null, null, null);
		curr.parent = p;
		if (p == null) {
			root = curr;
		} else if (compare(x, p.key) > 0) {
			p.right = curr;
			curr.isLeftChild = false;
			fixAfterInsert(p, curr);
		} else {
			p.left = curr;
			curr.isLeftChild = true;
			fixAfterInsert(p, curr);
		}
		colorBlack(root);//根结点变黑
		size++;
	}
	
	/**
	 * 中序遍历
	 * @param con
	 */
	public void inorder(Consumer<Object> con) {
		inorder(root, con);
	}
	
	/**
	 * 中序消费结点的key
	 * @param p
	 * @param con
	 */
	private void inorder(BRNode p, Consumer<Object> con) {
			
	}
	
	/**
	 * 中序消费node
	 * @param p
	 * @param con
	 */
	@SuppressWarnings("unused")
	private void inorderNode(BRNode p, Consumer<BRNode> con) {
		
	}

	/**
	 * 前序遍历
	 * @param p
	 * @param con
	 */
	@SuppressWarnings("unused")
	private void preOrderNode(BRNode p, Consumer<BRNode> con) {
		
	}
	
	/**
	 * 增加结点后的修正
	 * @param parent
	 * @param newNode
	 */
	private void fixAfterInsert(BRNode parent, BRNode newNode) {
		if (parent == null) {
			root = newNode;
			return;
		}
		//uncle存在且为红
		if (colorOf(parent) == RED && colorOf(newNode) == RED) {
			BRNode grand = parent.parent;
			BRNode uncle = parent.isLeftChild ? grand.right : grand.left;
			if (uncle != null && colorOf(uncle) == RED) {
				colorRed(grand);
				colorBlack(parent);
				colorBlack(uncle);
			} else if (colorOf(uncle) == BLACK) {
				if (parent.isLeftChild && newNode.isLeftChild) {//左左型
					colorRed(grand);
					colorBlack(parent);
					rotateRight(grand);
				} else if (!parent.isLeftChild && !newNode.isLeftChild) {//右右型
					colorRed(grand);
					colorBlack(parent);
					rotateLeft(grand);
				} else if (parent.isLeftChild && !newNode.isLeftChild) {//左右型
					rotateLeft(parent);
					colorRed(grand);
					colorBlack(newNode);
					rotateRight(grand);
				} else {//右左型
					rotateRight(parent);
					colorRed(grand);
					colorBlack(newNode);
					rotateLeft(grand);
				}
			}
		}
	}
	
	/**
	 * 结点颜色设置为红
	 * @param node
	 */
	private void colorRed(BRNode node) {
		node.isRed = true;
	}
	
	/**
	 * 结点颜色设置为黑
	 * @param node
	 */
	private void colorBlack(BRNode node) {
		node.isRed = false;
	}

	/**
	 * key1大于key2，返回正数
	 * @param key1
	 * @param key2
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private int compare(Object key1, Object key2) {
		return ((Comparable<Comparable<?>>)key1).compareTo((Comparable<?>)key2);
	}
	
	/**
	 * 删除结点
	 * @param key
	 */
	public void remove(Object key) {
		
	}
	
	/**
	 * 删除结点后的修正
	 * @param x
	 */
	@SuppressWarnings("unused")
	private void fixAfterDeletion(BRNode x) {
		
	}
	
	/**
	 * 右旋
	 * @param p
	 */
	private void rotateRight(BRNode p) {
		
	}
	
	/**
	 * 左旋
	 * @param p
	 */
	private void rotateLeft(BRNode p) {
		
	}
	
	/**
	 * 设置结点的颜色
	 * @param sib
	 * @param colorOf
	 */
	@SuppressWarnings("unused")
	private void setColor(BRNode sib, boolean colorOf) {
		sib.isRed = colorOf;
	}
	
	/**
	 * 返回右结点
	 * @param parent
	 * @return
	 */
	@SuppressWarnings("unused")
	private BRNode rightOf(BRNode parent) {
		return parent.right;	
	}
	
	/**
	 * 返回左结点
	 * @param parent
	 * @return
	 */
	@SuppressWarnings("unused")
	private BRNode leftOf(BRNode parent) {
		return parent.left;
	}
	
	/**
	 * 返回结点的颜色，red为true
	 * @param x
	 * @return
	 */
	private boolean colorOf(BRNode x) {
		return x.isRed;
	}
	
	/**
	 * 返回后继
	 * @param p
	 * @return
	 */
	@SuppressWarnings("unused")
	private BRNode successor(BRNode p) {
		return p;
	}
	
	/**
	 * 返回查找结点的key
	 * @param key
	 * @return
	 */
	public Object lookup(Object key) {
		return lookupNode(key).key;
	}
	
	/**
	 * 返回查找的结点
	 * @param key
	 * @return
	 */
	private BRNode lookupNode(Object key) {
		return null;
	}
	
	/**
	 * 结点
	 * @author Vitalc
	 *
	 */
	private class BRNode {
		private Object key;
		private BRNode left;
		private BRNode right;
		private BRNode parent;
		private boolean isLeftChild;
		private boolean isRed = true;
		
		public BRNode(Object key, BRNode left, BRNode right, BRNode parent) {
			super();
			this.key = key;
			this.left = left;
			this.right = right;
			this.parent = parent;
		}

		@Override
		public String toString() {
			return "BRNode [key=" + key + "]";
		}
	}
	
	/**
	 * 层次输出
	 * @return
	 */
	public String hierarchyBiTree() {
		return null;
	}
	
}
