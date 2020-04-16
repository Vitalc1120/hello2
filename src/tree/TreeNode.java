package tree;

import java.util.List;

public class TreeNode<E> {
	public E key;//数据
	public TreeNode<E> parent;//父节点
	public List<TreeNode<E>> children;//子节点
	
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
