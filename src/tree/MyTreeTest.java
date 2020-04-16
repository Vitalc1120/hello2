package tree;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class MyTreeTest {

	MyTree<String> tree = new MyTree<String>(new TreeNode<String>("a"));

	@Before
	public final void test() throws Exception {
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
		
	}

	@Test
	public final void testPreOrder() {
		fail("尚未实现");
	}

	@Test
	public final void testPostOrder() {
		fail("尚未实现");
	}

	@Test
	public final void testLevelOrder() {
		List<TreeNode<String>> res = tree.levelOrder(tree.getRoot());
		for (TreeNode<String> treeNode : res) {
			System.out.println(treeNode.key);
		}
	}

}
