package tree;

/**
 * ����ƽ����
 * @author Vitalc
 *
 * @param <K>
 * @param <V>
 */
public class AVLTree<K, V> extends BinarySearchTree<K, V> implements IBinarySearchTree<K, V> {
	@Override
	public Node<K, V> insert(K key, V value) {
		Node<K, V> nnode = super.insert(key, value);
		Node<K, V>[] pqs = firstUnbalance(nnode);
		if (pqs != null) {
			reBalance(pqs);
		}
		return nnode;
	}
	
	private void reBalance(Node<K, V>[] pqs) {
		if (pqs == null) {
			return;
		}
		Node<K, V> p = pqs[0];
		Node<K, V> q = pqs[1];
		Node<K, V> s = pqs[2];
		if (q.isRight() && s.isRight()) {
			leftRotate(p, q);
		} else if (!q.isRight() && !s.isRight()) {
			rightRotate(p, q);
		} else if (!q.isRight() && s.isRight()) {
			leftRotate(q, s);
			rightRotate(p, s);
		} else {
			rightRotate(q, s);
			leftRotate(p, s);
		}
	}
	
	/**
	 * �ҵ���
	 * @param p
	 * @param q
	 */
	private void rightRotate(Node<K, V> p, Node<K, V> q) {
		boolean pIsLeft = p.isLeft();
		Node<K, V> pp = p.parentNode;
		//g��p�����ӵĹ�ϵ
		Node<K, V> x = q.rightNode;
		p.leftNode = x;
		if (x != null) {
			x.parentNode = p;
			x.isLeftNode = true;
		}
		//g��p�Ĺ�ϵ
		q.rightNode = p;
		p.parentNode = q;
		p.isLeftNode = false;
		//p��pp�Ĺ�ϵ
		q.parentNode = pp;
		if (pp == null) {
			root = q;
			return;
		}
		if (pIsLeft) {
			pp.leftNode = q;
			q.isLeftNode = true;
		} else {
			pp.rightNode = q;
			q.isLeftNode = false;
		}
	}
	
	/**
	 * ����
	 * @param p
	 * @param q
	 */
	private void leftRotate(Node<K, V> p, Node<K, V> q) {
		boolean pIsLeft = p.isLeft();
		Node<K, V> pp = p.parentNode;
		//p��q�����ӵĹ�ϵ
		Node<K, V> y = q.leftNode;
		p.rightNode = y;
		if (y != null) {
			y.parentNode = p;
			y.isLeftNode = false;
		}
		//p��q�Ĺ�ϵ
		q.leftNode = p;
		p.parentNode = q;
		p.isLeftNode = true;
		//p��pp�Ĺ�ϵ
		q.parentNode = pp;
		if (pp == null) {
			root = q;
			return;
		}
		if (pIsLeft) {
			pp.leftNode = q;
			q.isLeftNode = true;
		} else {
			pp.rightNode = q;
			q.isLeftNode = false;
		}
	}
	
	@SuppressWarnings("unchecked")
	private Node<K, V>[] firstUnbalance(Node<K, V> n) {
		if (n == null) {
			return null;
		}
		Node<K, V> s = n;
		Node<K, V> p = n.parentNode;
		if (p == null) {
			return null;
		}
		Node<K, V> g = p.parentNode;
		if (g == null) {
			return null;
		}
		if (unBalance(g)) {
			return new Node[]{g, p, s};
		} else {
			return firstUnbalance(p);
		}		
	}
	@Override
	public void remove(K key) {
		
	}
	
	@SuppressWarnings("unused")
	private void reBalance(Node<K, V> node) {
		
	}
}
