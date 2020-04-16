package linear;

/**
 * ��֪�����ȵ�����£��ҵ�������k��Ԫ��
 * ˫��ָ��
 * 1.��һ��ָ���ƶ���������һ��ָ��k
 * 2.����ָ��һ���ƶ���λ�ں����ָ���ߵ����һ����ʱ��ǰһ��ָ�����Ҫ�ҵĽڵ�
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
