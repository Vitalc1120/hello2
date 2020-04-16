package linear;

/**
 * 链表的加法，个位排在首位
 * @author Vitalc
 *
 */
public class PlusLinkNode {
	public static void main(String[] args) {
		int[] num1 = {7,4,0,7,5};
		int[] num2 = {2,7,2,3,4};
		ListNode head1 = new ListNode(null);
		ListNode p1 = head1;
		ListNode head2 = new ListNode(null);
		ListNode p2 = head2;
		for (int i = 0; i < num1.length; i++) {
			p1.next = new ListNode(num1[i]);
			p1 = p1.next;
		}
		for (int i = 0; i < num2.length; i++) {
			p2.next = new ListNode(num2[i]);
			p2 = p2.next;
		}
		
		sum(head1, head2);
	}
	public static ListNode sum(ListNode a, ListNode b) {
		ListNode res = new ListNode(null);
		int z = 0;
		while (a != null || b != null) {
			int x = (int)a.data;
			int y = (int)b.data;
			res.next = new ListNode(x + y < 10 ? x + y + z: (x + y) / 10 + z);
			z = x % y;
			a = a.next;
			b = b.next;
		}
		return res;
	}
}
