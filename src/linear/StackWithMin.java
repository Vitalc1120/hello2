package linear;

/**
 * O(1),找出栈的最小值
 * @author Vitalc
 *
 */
public class StackWithMin {
	public static void main(String[] args) {
		MyStack stack = new MyStack();
		stack.push(7);
		stack.push(2);
		stack.push(3);
		stack.push(1);
		stack.push(5);
		
		System.out.println(stack.min());
		stack.pop();
		System.out.println(stack.min());
		stack.pop();
		System.out.println(stack.min());
		stack.pop();
		System.out.println(stack.min());
		stack.pop();
		System.out.println(stack.min());
		stack.pop();
	}
}
