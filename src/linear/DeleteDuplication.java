package linear;

import java.util.HashSet;
/**
 * 链表去重
 * @author Vitalc
 *
 */
public class DeleteDuplication {
	public static void main(String[] args) {
		/*
		 * 用hashset去重
		 */
		int[] num = {1,1,2,3,4,2};
		ListNode head = new ListNode(null);
		ListNode p = head;
		for (int i = 0; i < num.length; i++) {
			p.next = new ListNode(num[i]);
			p = p.next;
		}
		ListNode p1 = head;
		ListNode pre = p1;
		HashSet<Object> set = new HashSet<Object>();
		while (p1 != null) {
			if (set.contains(p1.data)) {
				pre.next = p1.next;
			} else {
				set.add(p1.data);
			}
			pre = p1;
			p1 = p1.next;
		}		
		p = head.next;
		
		rr(head);
		while (p != null) {
			System.out.println(p.data);
			p = p.next;
		}
	}
	
	public static void rr(ListNode head) {
		//ListNode pre = head;
		ListNode first = head.next;
		while (first != null) {
			
			first = first.next;
		}
	}
}
