package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 概念：
 * (1)结点层：根结点为1，根的孩子为2，以此类推
 * (2)树的度：树中最大的结点数
 * (3)结点的度：结点子树的个数
 * (4)树的深度：树的最大结点层
 *  
 * @author Vitalc
 *
 * @param <E>
 */
public class MyTree<E> implements ITree<E> {

	private int size = 0;
	private TreeNode<E> root;//根结点
	
	public MyTree() {//空树
		
	}
	
	public MyTree(TreeNode<E> root) {
		this.root = root;
		size++;
	}

	@Override
	public int getSize() {
		return size;
	}

	@Override
	public TreeNode<E> getRoot() {
		return root;
	}

	@Override
	public TreeNode<E> getParent(TreeNode<E> x) {
		return x.parent;
	}

	@Override
	public TreeNode<E> getFirstChild(TreeNode<E> x) {
		return x.children.get(0);
	}

	@Override
	public TreeNode<E> getNextSiBing(TreeNode<E> x) {
		List<TreeNode<E>> children = x.parent.children;
		int i = children.indexOf(x);
		try {
			return children.get(i + 1);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public int getHeight(TreeNode<E> x) {
		if (x.children == null) {
			return 0;
		} else {
			int h = 0;
			for (int i = 0; i < x.children.size(); i++) {
				h = Math.max(h, getHeight(x.children.get(i)));
			}
			return h + 1;
		}
	}
	
	/**
	 * 整棵树的高度
	 * @return
	 */
	public int getHeight() {
		return getHeight(root);
	}

	@Override
	public void insertChild(TreeNode<E> x, TreeNode<E> child) {
		if (x.children == null) {
			x.children = new ArrayList<>();
		}
		x.children.add(child);
		child.parent = x;
		size++;
	}

	@Override
	public void deleteChild(TreeNode<E> x, int i) {
		if (i >= 0 && i < x.children.size() - 1) {
			TreeNode<E> node = x.children.remove(i);
			Queue<TreeNode<E>> q = new LinkedList<TreeNode<E>>();
			q.add(node);
			while (!q.isEmpty()) {
				TreeNode<E> peek = q.peek();
				if (peek.children != null) {
					for (TreeNode<E> treeNode : peek.children) {
						q.add(treeNode);
						size--;
					}
				}
				q.poll();
			}
		} else {
			System.out.println("输入有误");
		}
	}

	@Override
	public List<TreeNode<E>> preOrder(TreeNode<E> x) {
		
		return null;
	}

	@Override
	public List<TreeNode<E>> postOrder(TreeNode<E> x) {
		
		return null;
	}

	@Override
	public List<TreeNode<E>> levelOrder(TreeNode<E> x) {
		List<TreeNode<E>> res = new ArrayList<TreeNode<E>>();
		Queue<TreeNode<E>> q = new LinkedList<TreeNode<E>>();
		res.add(x);
		q.add(x);
		while (!q.isEmpty()) {
			TreeNode<E> peek = q.peek();
			if (peek.children != null) {
				q.addAll(peek.children);
			}
			res.add(peek);
			q.poll();
		}
		return res;
	}
	
	/**
	 * 分层输出
	 * @param x
	 * @return
	 */
	public List<List<TreeNode<E>>> levelOrder2(TreeNode<E> x) {
		List<List<TreeNode<E>>> res = new ArrayList<List<TreeNode<E>>>();
		List<TreeNode<E>> l = new ArrayList<TreeNode<E>>();
		Queue<TreeNode<E>> q = new LinkedList<TreeNode<E>>();
		TreeNode<E> last = x;
		TreeNode<E> p = null;
		q.add(x);
		res.add(l);
		while (!q.isEmpty()) {
			TreeNode<E> peek = q.peek();
			if (peek.children != null) {
				q.addAll(peek.children);
				p = peek.children.get(peek.children.size() - 1);
			}
			l.add(q.poll());
			if (peek == last && !q.isEmpty()) {
				l = new ArrayList<TreeNode<E>>();
				res.add(l);
				last = p;
			}
		}
		return res;
	}
}
