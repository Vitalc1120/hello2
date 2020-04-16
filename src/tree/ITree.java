package tree;

import java.util.List;

public interface ITree<E> {
	
	/**
	 * ��ȡ�������
	 * @return
	 */
	int getSize();
	
	/**
	 * ��ȡ�����
	 * @return
	 */
	TreeNode<E> getRoot();
	
	/**
	 * ��ȡx�ĸ����
	 * @param x
	 * @return
	 */
	TreeNode<E> getParent(TreeNode<E> x);
	
	/**
	 * ��ȡx�ĵ�һ���ӽ��
	 * @param x
	 * @return
	 */
	TreeNode<E> getFirstChild(TreeNode<E> x);
	
	/**
	 * ��ȡx����һ�����(ͬ��)
	 * @param x
	 * @return
	 */
	TreeNode<E> getNextSiBing(TreeNode<E> x);
	
	/**
	 * ��ȡx�����
	 * @return
	 */
	int getHeight(TreeNode<E> x);
	
	/**
	 * ��x�ϲ���һ���ӽ��
	 * @param x
	 * @param child
	 */
	void insertChild(TreeNode<E> x, TreeNode<E> child);
	
	/**
	 * ɾ��x�ĵڼ����ӽ��
	 * @param x
	 * @param i
	 */
	void deleteChild(TreeNode<E> x, int i);
	
	/**
	 * �������
	 * @param x
	 * @return
	 */
	List<TreeNode<E>> preOrder(TreeNode<E> x);
	
	/**
	 * �������
	 * @param x
	 * @return
	 */
	List<TreeNode<E>> postOrder(TreeNode<E> x);
	
	/**
	 * ��α���
	 * @param x
	 * @return
	 */
	List<TreeNode<E>> levelOrder(TreeNode<E> x);
	
}
