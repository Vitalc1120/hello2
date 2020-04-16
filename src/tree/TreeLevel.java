package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * øÌÀ—”√∂”¡–
 * @author Vitalc
 *
 */
public class TreeLevel {
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
	
	static class Node {
		public Integer e;
		public Node next = null;
		public Node() {

		}
		public Node(Integer e) {
			this.e = e;
		}
	}
	
	public static List<Node> levelLink(TreeNode root){
		if (root == null) {
			return null;
		}
		List<Node> res = new ArrayList<Node>();
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		Node node = new Node();
		
		TreeNode last = root;
		TreeNode p = null;
		q.add(root);
		res.add(node);
		while (!q.isEmpty()) {
			TreeNode peek = q.peek();
			if (peek.left != null) {
				q.add(peek.left);
				p = peek.left;
			}
			if (peek.right != null) {
				q.add(peek.right);
				p = peek.right;
			}
			
			node.e = peek.e;
			node.next = new Node();			
			node = node.next;
			
			q.poll();
			if (peek == last && !q.isEmpty()) {
				node = new Node();
				res.add(node);
				last = p;
			}
		}	
		return res;
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
		
		List<Node> list = levelLink(root);
		for (Node node : list) {
			while (node.next != null) {
				System.out.print(node.e + " ");
				node = node.next;
			}
			System.out.println();
		}
	}
}
