package linear;
/**
 * ɾ�����������м��ĳ���ڵ�,�����β�ڵ�,����false,�����򷵻�true
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
