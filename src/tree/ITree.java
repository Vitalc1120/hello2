package tree;

import java.util.List;

public interface ITree<E> {
	
	/**
	 * 获取树结点数
	 * @return
	 */
	int getSize();
	
	/**
	 * 获取根结点
	 * @return
	 */
	TreeNode<E> getRoot();
	
	/**
	 * 获取x的父结点
	 * @param x
	 * @return
	 */
	TreeNode<E> getParent(TreeNode<E> x);
	
	/**
	 * 获取x的第一个子结点
	 * @param x
	 * @return
	 */
	TreeNode<E> getFirstChild(TreeNode<E> x);
	
	/**
	 * 获取x的下一个结点(同级)
	 * @param x
	 * @return
	 */
	TreeNode<E> getNextSiBing(TreeNode<E> x);
	
	/**
	 * 获取x的深度
	 * @return
	 */
	int getHeight(TreeNode<E> x);
	
	/**
	 * 在x上插入一个子结点
	 * @param x
	 * @param child
	 */
	void insertChild(TreeNode<E> x, TreeNode<E> child);
	
	/**
	 * 删除x的第几个子结点
	 * @param x
	 * @param i
	 */
	void deleteChild(TreeNode<E> x, int i);
	
	/**
	 * 先序遍历
	 * @param x
	 * @return
	 */
	List<TreeNode<E>> preOrder(TreeNode<E> x);
	
	/**
	 * 后序遍历
	 * @param x
	 * @return
	 */
	List<TreeNode<E>> postOrder(TreeNode<E> x);
	
	/**
	 * 层次遍历
	 * @param x
	 * @return
	 */
	List<TreeNode<E>> levelOrder(TreeNode<E> x);
	
}
