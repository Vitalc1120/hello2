package linear;

import java.util.Stack;
/**
 * �жϻ�������
 * @author Vitalc
 *
 */
public class ReverseNode {
	public static void main(String[] args) {
		A_04_SingleLinkList list = new A_04_SingleLinkList();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(3);
		list.add(1);
		System.out.println(reverseNode(list.first));
	}
	
	public static boolean reverseNode(ListNode head) {
		ListNode f = head;
		ListNode s = head;
		boolean flag = true;		
		Stack<ListNode> stack = new Stack<ListNode>();
		while (f != null && f.next != null) {
			stack.push(s);
			s = s.next;
			f = f.next.next;
			if (f == null) {
				flag = false;
			}
		}
		if (flag) {//�����ڵ�next,�����м���Ǹ�ֵ
			s = s.next;
		}
		
		while (!stack.isEmpty()) {
			if (stack.pop().data != s.data) {
				return false;
			} else {
				s = s.next;
			}
		}
		return true;
	}
}
