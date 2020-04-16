package linear;

import org.junit.Test;

public class A_13_MyQueueTest {

	@Test
	public final void test() {
		A_12_MyQueue<Integer> queue = new A_12_MyQueue<Integer>();
		queue.add(1);
		queue.add(2);
		queue.add(3);
		queue.add(4);
		queue.add(5);
		System.out.println(queue.size());
		while (!queue.empty()) {
			System.out.print(queue.peek() + " ");
			queue.dequeue();
		}
		System.out.println(queue.size());
	}

}
