package linear;

import java.util.EmptyStackException;

/**
 * 栈
 * 特点：先进后出
 * @author Vitalc
 *
 */
public class A_09_MyStack extends A_06_DoubleLinkList implements A_08_IStack {

	@Override
	public void push(Object e) {
		add(e);
	}

	@Override
	public Object pop() {
		if (size <= 0) {
			throw new EmptyStackException();
		}
		ListNode the = last.pre;
		Object res = the.data;
		the.pre.next = last;
		last.pre = the.pre;
		the.pre = null;
		the.next = null;
		size--;
		return res;
	}

	@Override
	public boolean empty() {
		return getSize() == 0;
	}

	@Override
	public int size() {
		return getSize();
	}

	@Override
	public Object peek() {
		return last.pre.data;
	}
	
}
