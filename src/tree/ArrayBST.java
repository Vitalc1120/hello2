package tree;

/**
 * ��һ���������е�����ʵ��һ��BST
 * @author Vitalc
 *
 */
public class ArrayBST {
	
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
	
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		//f(arr, root);
		TreeNode root = createMinBst(arr, 0, arr.length - 1);
		inorder(root);		
	}
	
	/**
	 * �������
	 * @param p
	 */
	private static void inorder(TreeNode p) {
		if (p != null) {
			inorder(p.left);
			System.out.println(p.e);
			inorder(p.right);
		}
	}

	/**
	 * 
	 * @param arr ���������
	 * @param p	��Ҫ�����Ľ��
	 */
	public static void f(int[] arr, TreeNode p) {
		if (arr.length == 0) {
			return;
		}
		int mid = arr.length / 2;
		p.e = arr[mid];
		int[] left = new int[mid];
		for (int i = 0; i < left.length; i++)
			left[i] = arr[i];
		
		int[] right = new int[arr.length - 1 - mid];
		for (int i = 0; i < right.length; i++)
			right[i] = arr[i + mid + 1];
		
		if (left.length > 0) {
			p.left = new TreeNode();
			f(left, p.left);
		}
		if (right.length > 0) {
			p.right = new TreeNode();
			f(right, p.right);
		}
	}
	
	static TreeNode createMinBst(int[] arr, int start, int end) {
		if (start > end) {
			return null;
		}	
		int mid = start + ((end - start) >> 1);
		TreeNode left = createMinBst(arr, start, mid - 1);
		TreeNode right = createMinBst(arr, mid + 1, end);
		TreeNode res = new TreeNode(arr[mid]);
		res.left = left;
		res.right = right;
		return res;
	}
}
