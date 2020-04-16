package tree;

import java.util.List;

public class TreeNode<E> {
	public E key;//����
	public TreeNode<E> parent;//���ڵ�
	public List<TreeNode<E>> children;//�ӽڵ�
	
	public TreeNode(E key, TreeNode<E> parent) {
		this.key = key;
		this.parent = parent;
	}
	
	public TreeNode(E key) {
		this.key = key;
	}

	@Override
	public String toString() {
		return "Node [key=" + key + "]";
	}
}
