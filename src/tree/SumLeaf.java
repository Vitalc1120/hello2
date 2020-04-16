package tree;

/**
 * 一条从根到叶路上每个结点的数即为一个整数，求这棵树每条通路的和
 * @author Vitalc
 *
 */
public class SumLeaf {
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
	
	static int sum = 0;
	
	public static <E> void leafSum(TreeNode<E> node, String num) {
		num += node.e;
		if (node.left == null && node.right == null) {
			sum += Integer.parseInt(num);
			return;
		}
		if (node.left != null) {
			leafSum(node.left, num);
		}
		if (node.right != null) {
			leafSum(node.right, num);
		}
	}
	
	
	public static void main(String[] args) {
		TreeNode<Integer> l = new TreeNode<Integer>(1, null, null);
		TreeNode<Integer> r = new TreeNode<Integer>(1, null, null);
		
		TreeNode<Integer> left = new TreeNode<Integer>(1, l, r);
		TreeNode<Integer> right = new TreeNode<Integer>(1, l, r);

		TreeNode<Integer> root = new TreeNode<Integer>(1, left, right);
		leafSum(root, "");
		System.out.println(sum);
	}
}
