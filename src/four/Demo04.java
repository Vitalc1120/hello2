package four;

import java.util.Scanner;

public class Demo04 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		sc.close();
		String[] nums = str.split(" ");
		Node root = new Node(Integer.valueOf(nums[0]));
		root.currString = nums[0];
		root.preString = "";
		root.varSize = nums[0].length();
		for (int i = 1; i < nums.length; i++) {
			int num = Integer.valueOf(nums[i]);
			insert(num, root);
		}
		printrightTree(root);
	}
	
	/**
	 * �������
	 * @param root
	 */
	private static void printrightTree(Node root) {
		if (root != null) {
			printrightTree(root.right);
			System.out.println(root.currString);
			printrightTree(root.left);
		}
	}
	
	/**
	 * ����ͬ�������
	 * @param root
	 * @param newNode
	 */
	public static void isSameTo(Node root, Node newNode) {
		String prestr = root.preString;
		if (prestr == "") {//���ڵ�Ϊ���ڵ�
			for (int i = 0; i < root.varSize; i++) {
				prestr += ".";
			}
			prestr += ".|";
			newNode.preString = prestr;
			newNode.currString = prestr + "-" + newNode.val;
			return;
		} else {//һ�����
			prestr = prestr.substring(0, prestr.length() - 1);
			prestr += "..";
			for (int i = 0; i < root.varSize; i++) {
				prestr += ".";
			}
			prestr += ".|";
			newNode.preString = prestr;
			newNode.currString = prestr + "-" + newNode.val;
		}
	}
	
	public static void notSameTo(Node root, Node newNode){
		String prestr = root.preString;
		if (prestr == "") {//���ڵ�Ϊ���ڵ�
			for (int i = 0; i < root.varSize; i++) {
				prestr += ".";
			}
			prestr += ".|";
			newNode.preString = prestr;
			newNode.currString = prestr + "-" + newNode.val;
			return;
		} else {//һ�����
			prestr += ".";
			for (int i = 0; i < root.varSize; i++) {
				prestr += ".";
			}
			prestr += ".|";
			newNode.preString = prestr;
			newNode.currString = prestr + "-" + newNode.val;
		}
	}
	
	/**
	 * ���뷽��
	 * @param num
	 * @param root 
	 */
	private static void insert(Integer num, Node root) {
		if (root.val < num) {//�ڸ��ڵ���ұ�
			if (root.right != null) {
				insert(num, root.right);
			} else {
				if (root.left == null) {
					root.currString += "-|";
				}
				Node newNode = new Node(num);
				newNode.isleft = false;
				newNode.varSize = String.valueOf(num).length();//�ַ�����
				root.right = newNode;
				if (root.isleft == newNode.isleft) {//ͬ��
					isSameTo(root, newNode);
				} else {//��ͬ��
					notSameTo(root, newNode);
				}	
			}
		} else {//�ڸ��ڵ�����
			if (root.left != null) {
				insert(num, root.left);
			} else {
				if (root.right == null) {
					root.currString += "-|";
				}
				Node newNode = new Node(num);
				newNode.isleft = true;
				newNode.varSize = String.valueOf(num).length();
				root.left = newNode;
				if (root.isleft == newNode.isleft) {//ͬ��
					isSameTo(root, newNode);
				} else {//��ͬ��
					notSameTo(root, newNode);
				}			
			}
		}
	}
	
	private static class Node {
		public int val;
		public String preString;
		public String currString;
		public Node left;
		public Node right;
		public int varSize;
		public boolean isleft = false;
		public Node(int val) {
			super();
			this.val = val;
		}		
	}
}
