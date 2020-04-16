package tree;

public class SuccessorBST {
	static class TreeNode {
		public Integer e;
		public TreeNode left = null;
		public TreeNode right = null;
		public TreeNode parent = null;		
		public TreeNode() {

		}
		public TreeNode(Integer e) {
			this.e = e;
		}
	}
	
	public static TreeNode successor(TreeNode node) {
		if (node == null) {
			return null;
		}
		if (node.right != null) {
			return min(node.right);
		}
		TreeNode parent = node.parent;
		while (parent != null && parent.e < node.e) {
			parent = parent.parent;
			node = node.parent;
		}
		return parent;
	}
	
	private static TreeNode min(TreeNode node) {
		while (node.left != null) {
			node = node.left;
		}
		return node;
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(4);
		TreeNode node1 = new TreeNode(2);
		TreeNode node2 = new TreeNode(6);
		TreeNode node3 = new TreeNode(1);
		TreeNode node4 = new TreeNode(3);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(7);
		root.left = node1;
		root.right = node2;
		node1.left = node3;
		node1.right = node4;
		node2.left = node5;
		node2.right = node6;

		node1.parent = node2.parent = root;
		node3.parent = node4.parent = node1;
		node5.parent = node6.parent = node2;
		System.out.println(successor(node1).e);
	}
}
