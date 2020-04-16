package linear;

import java.util.EmptyStackException;
/**
 * 为了解决StackWithMin问题的特殊栈
 * @author Vitalc
 *
 */
public class MyStack extends A_06_DoubleLinkList implements A_08_IStack{

	@Override
	public void push(Object e) {
		add(e);
		if (brother.empty()) {
			brother.push(e);
		} else {
			int peek = (int) brother.peek();
			if ((int)e < peek) {
				brother.push(e);
			} else {
				brother.push(peek);
			}
		}
	}
	private A_09_MyStack brother = new A_09_MyStack();
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
		brother.pop();
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
	
	public int min() {
		return (int)brother.peek();
	}
}
