package tree;

import org.junit.Test;

public class BinarySearchTreeTest {

	@Test
	public final void testInorder() {
		BinarySearchTree<Integer, String> tree = new BinarySearchTree<Integer, String>();
		tree.insert(8, "");
		tree.insert(4, "");
		tree.insert(6, "");
		tree.insert(9, "");
		System.out.println(tree.getSize());
		tree.remove(8);
		System.out.println(tree.getSize());
		tree.inorder(K -> {
			
		});
	}

}
