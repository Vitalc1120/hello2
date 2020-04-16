package linear;

/**
 * ��ʽ�ṹ
 * ��������
 * ���ƣ���ɾԪ�غܿ�
 * @author Vitalc
 *
 */
public class A_04_SingleLinkList implements A_01_IList{
	ListNode first;
	ListNode last;
	int size = 0;
	@Override
	public void add(Object element) {
		if (first == null) {
			first = new ListNode(element);
			last = first;
		} else {
			last.next = new ListNode(element);
			last = last.next;
		}
		size++;
	}

	@Override
	public void delete(Object element) {
		ListNode p = first;
		ListNode pre = null;
		while (p != null) {
			if (p.data.equals(element)) {//ɾ��1
				if (p == first) {
					first = first.next;
				} else {
					pre.next = p.next;//0 �� 2
				}
				size--;
				return;
			}
			pre = p;
			p = p.next;
		}
		System.out.println("�Ҳ�����Ԫ�أ�ɾ��ʧ��");
	}

	@Override
	public void delete(int index) {
		if (index < 0 || index >= size) {
			System.out.println("�쳣����");
			return;
		}
		ListNode p = first;
		ListNode pre = null;
		int c = 0;
		while (p != null) {
			if (index == c) {//ɾindex
				if (p == first) {
					first = first.next;
				} else {
					pre.next = p.next;//indexָ��index+2					
				}
				size--;
				break;
			}
			c++;
			pre = p;
			p = p.next;
		}
	}

	@Override
	public void update(int index, Object newElement) {
		if (index < 0  || index >= size) {
			System.out.println("�쳣����");
			return;
		}
		ListNode p = first;
		int c = 0;
		while (p != null) {
			if (index == c) {
				p.data = newElement;
				break;
			}
			p = p.next;
			c++;
		}
	}

	@Override
	public boolean contains(Object target) {
		ListNode p = first;
		while (p != null) {
			if (p.data.equals(target)) {
				return true;
			}
			p = p.next;
		}
		return false;
	}

	@Override
	public int indexOf(Object element) {
		ListNode p = first;
		int index = 0;
		while (p != null) {
			if (p.data.equals(element)) {
				return index;
			}
			p = p.next;
			index++;
		}
		return -1;
	}
	
	@Override
	public Object at(int index) {
		if (index < 0  || index >= size) {
			return "�쳣����";
		}
		int c = 0;
		ListNode p = first;
		while (index != c) {
			c++;
			p = p.next;
		}
		return p.data;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("[");
		ListNode p = first;
		while (p != null) {
			sb.append(p.data);
			if (p.next != null) {
				sb.append(",");
			}
			p = p.next;
		}
		sb.append("]");
		return sb.toString();
	}

	@Override
	public boolean hasNext() {
		return false;
	}

	@Override
	public Object next() {
		return null;
	}
	
}
