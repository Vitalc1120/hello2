package tree;

import java.util.List;

public class Demo {
	public static void main(String[] args) {
		MyTree<String> tree = new MyTree<String>(new TreeNode<String>("a"));
		TreeNode<String> b = new TreeNode<String>("b");
		tree.insertChild(tree.getRoot(), b);
		TreeNode<String> c = new TreeNode<String>("c");
		tree.insertChild(tree.getRoot(), c);
		TreeNode<String> d = new TreeNode<String>("d");
		tree.insertChild(tree.getRoot(), d);
		TreeNode<String> e = new TreeNode<String>("e");
		tree.insertChild(tree.getRoot(), e);
		TreeNode<String> f = new TreeNode<String>("f");
		tree.insertChild(tree.getRoot(), f);
		TreeNode<String> g = new TreeNode<String>("g");
		tree.insertChild(tree.getRoot(), g);
		TreeNode<String> h = new TreeNode<String>("h");
		tree.insertChild(b, h);
		TreeNode<String> i = new TreeNode<String>("i");
		tree.insertChild(b, i);
		TreeNode<String> j = new TreeNode<String>("j");
		tree.insertChild(i, j);
		
//		List<TreeNode<String>> list = tree.levelOrder(tree.getRoot());
//		for (TreeNode<String> treeNode : list) {
//			System.out.print(treeNode.key + " ");
//		}
		
		
		List<List<TreeNode<String>>> res = tree.levelOrder2(tree.getRoot());
		for (List<TreeNode<String>> l : res) {
			for (TreeNode<String> treeNode : l) {
				System.out.print(treeNode.key + " ");				
			}
			System.out.println();
		}
		
		System.out.println(tree.getSize());
		tree.deleteChild(tree.getRoot(), 0);
		System.out.println(tree.getSize());
		
		res = tree.levelOrder2(tree.getRoot());
		for (List<TreeNode<String>> l : res) {
			for (TreeNode<String> treeNode : l) {
				System.out.print(treeNode.key + " ");				
			}
			System.out.println();
		}
	}
}
