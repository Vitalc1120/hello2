package linear;

import java.util.Stack;

/**
 * 用两个栈进行升序排列
 * @author Vitalc
 *
 */
public class TwoStackSort {
	public static void main(String[] args) {
		int[] num = {1,3,3,2,6,5};
		Stack<Integer> res = twoStackSort(num);
		while (!res.isEmpty()) {
			System.out.println(res.pop());
		}
	}
	
	public static Stack<Integer> twoStackSort(int[] num){
		Stack<Integer> source = new Stack<Integer>();
		Stack<Integer> target = new Stack<Integer>();
		for (int i = num.length - 1; i >= 0; i--) {
			source.push(num[i]);
		}
		while (!source.isEmpty()) {
			int temp = source.pop();
			if (target.isEmpty()) {
				target.push(temp);
			} else {
				while (!target.isEmpty()) {
					if (temp >= target.peek()) {
						target.push(temp);
						break;
					}
					source.push(target.pop());
				}
			}
		}
		return target;
	}
}
