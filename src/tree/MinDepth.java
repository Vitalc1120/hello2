package tree;

/**
 * 二叉树的最小深度
 * 不一定是完全二叉树（可以只有一个结点）！！
 * @author Vitalc
 *
 */
public class MinDepth {
	class TreeNode<E> {
		public E e;
		public TreeNode<E> left = null;
		public TreeNode<E> right = null;	
		public TreeNode(E e, TreeNode<E> left, TreeNode<E> right) {
			this.e = e;
			this.left = left;
			this.right = right;
		}
	}
	
	public static <E> int minDepth(TreeNode<E> node) {
		if (node == null) {
			return 0;
		}
		int depLeft = minDepth(node.left);
		int depRight = minDepth(node.right);
		if (depLeft == 0 || depRight == 0) {
			return 1 + depLeft + depRight;
		}
		return 1 + Math.min(depLeft, depRight);
	}
	
	public static void main(String[] args) {
		MinDepth md = new MinDepth();
		TreeNode<String> l = md.new TreeNode<String>("l", null, null);
		TreeNode<String> r = md.new TreeNode<String>("r", null, null);
		
		TreeNode<String> left = md.new TreeNode<String>("left", l, r);
		TreeNode<String> right = md.new TreeNode<String>("right", l, r);

		TreeNode<String> root = md.new TreeNode<String>("root", left, right);
		System.out.println(minDepth(root));
	}
}
