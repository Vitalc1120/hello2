package linear;
/**
 * 删除单向链表中间的某个节点,如果是尾节点,返回false,不是则返回true
 * @author Vitalc
 *
 */
public class DeleteNode {
	public static void main(String[] args) {
		ListNode node = new ListNode(null);
		delete(node);
	}
	private static boolean delete(ListNode node) {
		if (node.next == null) {
			return false;
		}
		node.data = node.next.data;
		node.next = node.next.next;
		return true;
	}
}
