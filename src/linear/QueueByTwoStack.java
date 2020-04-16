package linear;

import java.util.Stack;

/**
 * 用两个栈实现一个队列
 * @author Vitalc
 *
 */
public class QueueByTwoStack {
	Stack<Integer> stack1 = new Stack<>();
	Stack<Integer> stack2 = new Stack<>();
	
	public void enqueue(int value) {
		if (stack1.isEmpty()) {
			move(stack2, stack1);
		}
		stack1.push(value);
	}
	
	public int dequeue() {
		if (stack2.isEmpty()) {
			move(stack1, stack2);
		}
		int result = stack2.pop();
		return result;
	}
	
	private void move(Stack<Integer> source, Stack<Integer> target) {
		while (!source.isEmpty()) {
			target.push(source.pop());
		}
	}
	
	public static void main(String[] args) {
		QueueByTwoStack queue = new QueueByTwoStack();
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		queue.enqueue(5);
		
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
	}
}
