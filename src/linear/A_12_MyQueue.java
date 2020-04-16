package linear;

/**
 * 队列
 * 特点：先进先出
 * @author Vitalc
 *
 */
public class A_12_MyQueue<T> extends A_06_DoubleLinkList implements A_11_IQueue{

	@Override
	public void enqueue(Object e) {
		add(e);
	}

	@SuppressWarnings("unchecked")
	@Override
	public T dequeue() {
		if (size <= 0) {
			//throw new EmptyStackException();
		}
		ListNode the = first.next;
		Object res = the.data;
		first.next = the.next;
		the.next.pre = first;
		the.pre = null;
		the.next = null;
		size--;
		return (T) res;
	}

	@Override
	public boolean empty() {
		return getSize() == 0;
	}

	@Override
	public Object peek() {
		return first.next.data;
	}

	@Override
	public int size() {
		return getSize();
	}
	
}
