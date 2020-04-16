package linear;

import org.junit.Test;

public class A_10_MyStackTest {

	@Test
	public final void test() {
		A_09_MyStack stack = new A_09_MyStack();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		System.out.println(stack.peek());
		System.out.println(stack.size());
		while (!stack.empty()) {
			System.out.print(stack.pop() + " ");
		}
	}

}
