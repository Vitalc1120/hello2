package linear;
/**
 * 以数值X为基准将链表分为两部分,小余X的在大于等于X的前面,给你头指针
 * @author Vitalc
 *
 */
public class PartionLinkNode {
	public static void main(String[] args) {
		A_04_SingleLinkList list = new A_04_SingleLinkList();
		list.add(5);
		list.add(4);
		list.add(1);
		list.add(7);
		list.add(2);
		list.add(3);
		list.add(6);
		ListNode p = test(list.first, 2);
		while (p.next != null) {
			System.out.print(p.data);
			p = p.next;
		}
	}
	
	static ListNode test(ListNode head, int x) {
		ListNode leftFirst = null;
		ListNode leftTail = null;
		ListNode rightFirst = null;
		ListNode rightTail = null;
		ListNode p = head;
		while (p.next != null) {
			int val = (int)p.data;
			if (val < x) {
				if (leftFirst == null) {
					leftFirst = p;
					leftTail = p;
				} else {
					leftTail.next = p;
					leftTail = leftTail.next;
				}
			} else {
				if (rightFirst == null) {
					rightFirst = p;
					rightTail = p;
				} else {
					rightTail.next = p;
					rightTail = rightTail.next;
				}
			}
			p = p.next;
		}
		if (leftFirst == null) {
			return rightFirst;
		}
		leftTail.next = rightFirst;
		if (rightTail != null) {
			rightTail.next = null;
		}
		return leftFirst;
	}
}
