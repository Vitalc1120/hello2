package linear;

/**
 * 不知链表长度的情况下，找到倒数第k个元素
 * 双行指针
 * 1.将一个指针移动到距离另一个指针k
 * 2.两个指针一起移动，位于后面的指针走到最后一个的时候，前一个指针就是要找的节点
 * @author Vitalc
 *
 */
public class FindNode {
	public static void main(String[] args) {
		A_04_SingleLinkList list = new A_04_SingleLinkList();
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		list.add("5");
		list.add("6");
		list.add("7");
		ListNode head = list.first;
		System.out.println(findNode(head, 7));
	}

	private static Object findNode(ListNode head, int k) {
		if (head == null || k <= 0) {
			return null;
		}
		ListNode p = head;
		int count = 1;
		boolean flag = false;
		while (head.next != null) {
			if (count == k) {
				flag = true;
			}
			if (flag) {
				p = p.next;
			}
			head = head.next;				
			count++;
		}
		if (count < k) {
			return null;
		}
		return p.data;
	}
}
