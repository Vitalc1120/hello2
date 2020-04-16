package linear;

/**
 * 双向链表
 * 优势：在单向链表的基础上，可以找到上一个元素
 * @author Vitalc
 *
 */
public class A_06_DoubleLinkList implements A_01_IList{

	//哑元
	protected ListNode first = new ListNode(null);
	protected ListNode last = new ListNode(null);
	
	protected int size = 0;
	
	public int getSize() {
		return size;
	}
	
	public A_06_DoubleLinkList() {
		first.next = last;
		last.pre = first;
	}
	
	@Override
	public void add(Object element) {
		ListNode newNode = new ListNode(element);
		last.pre.next = newNode;
		newNode.pre = last.pre;
		newNode.next = last;
		last.pre = newNode;
		size++;
	}

	@Override
	public void delete(Object element) {
		ListNode p = first.next;
		while (p != last) {
			if (p.data.equals(element)) {
				p.pre.next = p.next;
				p.next.pre = p.pre;
				p.pre = null;
				p.next = null;
				size--;
				return;
			}
			p = p.next;
		}		
		System.out.println("找不到此元素，删除失败");
	}

	@Override
	public void delete(int index) {
		if (index < 0 || index >= size) {
			System.out.println("异常处理");
			return;
		}
		int c = 0;
		ListNode p = first.next;
		while (p != last) {
			if (index == c) {
				p.pre.next = p.next;
				p.next.pre = p.pre;
				p.pre = null;
				p.next = null;
				size--;
				break;
			}
			c++;
			p = p.next;
		}
	}

	@Override
	public void update(int index, Object newElement) {
		if (index < 0  || index >= size) {
			System.out.println("异常处理");
			return;
		}
		int c = 0;
		ListNode p = first.next;
		while (p != last) {
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
		ListNode p = first.next;
		while (p != last) {
			if (p.data.equals(target)) {
				return true;
			}
			p = p.next;
		}
		return false;
	}

	@Override
	public int indexOf(Object element) {
		ListNode p = first.next;
		int index = 0;
		while (p != last) {
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
			return "异常处理";
		}
		ListNode p = first.next;
		int c = 0;
		while (index != c) {
			c++;
			p = p.next;
		}
		return p.data;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("[");
		ListNode p = first.next;
		while (p != last) {
			sb.append(p.data);
			if (p.next != last) {
				sb.append(",");
			}
			p = p.next;
		}
		sb.append("]");
		return sb.toString();
	}
	
	private ListNode now = first;
	@Override
	public boolean hasNext() {
		return now.next != last;
	}
	
	@Override
	public Object next() {
		ListNode next = now.next;
		now = now.next;
		return next.data;
	}
	
}
