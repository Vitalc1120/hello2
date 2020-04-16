package tree;

public class isBalanceTree {
	static class TreeNode<E> {
		public E e;
		public TreeNode<E> left = null;
		public TreeNode<E> right = null;	
		public TreeNode(E e, TreeNode<E> left, TreeNode<E> right) {
			this.e = e;
			this.left = left;
			this.right = right;
		}
	}
	static int max = -1;
	static int min = Integer.MAX_VALUE;
	
	public static <E> void depth(TreeNode<E> node, int dep) {
		if (node.left == null && node.right == null) {
			if (dep > max) {
				max = dep;
			}
			if (dep < min) {
				min = dep;
			}
			return;
		}
		dep++;
		if (node.left != null) {
			depth(node.left, dep);
		}
		if (node.right != null) {
			depth(node.right, dep);
		}
	}
	
	public static <E> boolean isBalance(TreeNode<E> node) {	
		return (max - min) <= 1;
	}
	public static void main(String[] args) {
		TreeNode<String> l = new TreeNode<String>("l", null, null);
		TreeNode<String> r = new TreeNode<String>("r", null, null);
		
		TreeNode<String> left = new TreeNode<String>("left", l, r);
		TreeNode<String> right = new TreeNode<String>("right", l, r);

		TreeNode<String> root = new TreeNode<String>("root", left, right);
		System.out.println(isBalance(root));
	}
}
