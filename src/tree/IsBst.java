package tree;

/**
 * 判断一个二叉树是否是BST
 * @author Vitalc
 *
 */
public class IsBst {
	static class TreeNode {
		public Integer e;
		public TreeNode left = null;
		public TreeNode right = null;
		public TreeNode() {

		}
		public TreeNode(Integer e) {
			this.e = e;
		}
	}
	
	public static boolean isBST(TreeNode node) {
		if (node == null) {
			return false;
		} else {
			return isBst(node);
		}
	}
	
	private static boolean isBst(TreeNode node) {
		if (node.left == null && node.right == null)
			return true;
		if (node.left != null && node.right == null)
			return leftMax(node.left) < node.e && isBst(node.left);	
		if (node.left == null && node.right != null)
			return node.e < rightMin(node.right) && isBst(node.right);
		return leftMax(node.left) < node.e && node.e < rightMin(node.right) && isBst(node.left) && isBst(node.right);
	}
	
	private static int rightMin(TreeNode node) {
		while (node.left != null) {
			node = node.left;
		}
		return node.e;
	}
	
	private static int leftMax(TreeNode node) {
		while (node.right != null) {
			node = node.right;
		}
		return node.e;
	}
	
	
	private static int preValue = Integer.MIN_VALUE;
	public static boolean checkBST(TreeNode root) {
		if (root == null) {
			return true;
		}
		//检查左子树，如果左子树不是bst返回false
		boolean leftIsBST = checkBST(root.left);
		if (!leftIsBST) {
			return false;
		}
		//根的值小于等于左子树的最大值，返回false
		if (root.e <= preValue) {
			return false;
		}
		//更新最后访问的值，检查右子树
		preValue = root.e;
		return checkBST(root.right);
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
		System.out.println(isBST(root));
		System.out.println(checkBST(root));
	}
}
