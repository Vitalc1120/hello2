package tree;

import java.util.function.Consumer;

public class RedBlackTree {
	private static final boolean RED = true;
	private static final boolean BLACK = false;
	private BRNode root;
	@SuppressWarnings("unused")
	private int size = 0;
	
	/**
	 * ���ӽ��
	 * @param x
	 */
	public void insert(Object x) {
		if (!(x instanceof Comparable)) {
			System.out.println("�޷��Ƚϵ�����");
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
		colorBlack(root);//�������
		size++;
	}
	
	/**
	 * �������
	 * @param con
	 */
	public void inorder(Consumer<Object> con) {
		inorder(root, con);
	}
	
	/**
	 * �������ѽ���key
	 * @param p
	 * @param con
	 */
	private void inorder(BRNode p, Consumer<Object> con) {
			
	}
	
	/**
	 * ��������node
	 * @param p
	 * @param con
	 */
	@SuppressWarnings("unused")
	private void inorderNode(BRNode p, Consumer<BRNode> con) {
		
	}

	/**
	 * ǰ�����
	 * @param p
	 * @param con
	 */
	@SuppressWarnings("unused")
	private void preOrderNode(BRNode p, Consumer<BRNode> con) {
		
	}
	
	/**
	 * ���ӽ��������
	 * @param parent
	 * @param newNode
	 */
	private void fixAfterInsert(BRNode parent, BRNode newNode) {
		if (parent == null) {
			root = newNode;
			return;
		}
		//uncle������Ϊ��
		if (colorOf(parent) == RED && colorOf(newNode) == RED) {
			BRNode grand = parent.parent;
			BRNode uncle = parent.isLeftChild ? grand.right : grand.left;
			if (uncle != null && colorOf(uncle) == RED) {
				colorRed(grand);
				colorBlack(parent);
				colorBlack(uncle);
			} else if (colorOf(uncle) == BLACK) {
				if (parent.isLeftChild && newNode.isLeftChild) {//������
					colorRed(grand);
					colorBlack(parent);
					rotateRight(grand);
				} else if (!parent.isLeftChild && !newNode.isLeftChild) {//������
					colorRed(grand);
					colorBlack(parent);
					rotateLeft(grand);
				} else if (parent.isLeftChild && !newNode.isLeftChild) {//������
					rotateLeft(parent);
					colorRed(grand);
					colorBlack(newNode);
					rotateRight(grand);
				} else {//������
					rotateRight(parent);
					colorRed(grand);
					colorBlack(newNode);
					rotateLeft(grand);
				}
			}
		}
	}
	
	/**
	 * �����ɫ����Ϊ��
	 * @param node
	 */
	private void colorRed(BRNode node) {
		node.isRed = true;
	}
	
	/**
	 * �����ɫ����Ϊ��
	 * @param node
	 */
	private void colorBlack(BRNode node) {
		node.isRed = false;
	}

	/**
	 * key1����key2����������
	 * @param key1
	 * @param key2
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private int compare(Object key1, Object key2) {
		return ((Comparable<Comparable<?>>)key1).compareTo((Comparable<?>)key2);
	}
	
	/**
	 * ɾ�����
	 * @param key
	 */
	public void remove(Object key) {
		
	}
	
	/**
	 * ɾ�����������
	 * @param x
	 */
	@SuppressWarnings("unused")
	private void fixAfterDeletion(BRNode x) {
		
	}
	
	/**
	 * ����
	 * @param p
	 */
	private void rotateRight(BRNode p) {
		
	}
	
	/**
	 * ����
	 * @param p
	 */
	private void rotateLeft(BRNode p) {
		
	}
	
	/**
	 * ���ý�����ɫ
	 * @param sib
	 * @param colorOf
	 */
	@SuppressWarnings("unused")
	private void setColor(BRNode sib, boolean colorOf) {
		sib.isRed = colorOf;
	}
	
	/**
	 * �����ҽ��
	 * @param parent
	 * @return
	 */
	@SuppressWarnings("unused")
	private BRNode rightOf(BRNode parent) {
		return parent.right;	
	}
	
	/**
	 * ��������
	 * @param parent
	 * @return
	 */
	@SuppressWarnings("unused")
	private BRNode leftOf(BRNode parent) {
		return parent.left;
	}
	
	/**
	 * ���ؽ�����ɫ��redΪtrue
	 * @param x
	 * @return
	 */
	private boolean colorOf(BRNode x) {
		return x.isRed;
	}
	
	/**
	 * ���غ��
	 * @param p
	 * @return
	 */
	@SuppressWarnings("unused")
	private BRNode successor(BRNode p) {
		return p;
	}
	
	/**
	 * ���ز��ҽ���key
	 * @param key
	 * @return
	 */
	public Object lookup(Object key) {
		return lookupNode(key).key;
	}
	
	/**
	 * ���ز��ҵĽ��
	 * @param key
	 * @return
	 */
	private BRNode lookupNode(Object key) {
		return null;
	}
	
	/**
	 * ���
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
	 * ������
	 * @return
	 */
	public String hierarchyBiTree() {
		return null;
	}
	
}
