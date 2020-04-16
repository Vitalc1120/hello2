package linear;

import java.util.ArrayList;
/**
 * n个栈，每个栈的长度为size
 * 将二维数组转化为n个这样的栈
 * @author Vitalc
 *
 */
public class SetOfStack {
	public static void main(String[] args) {
		int[][] ope = {
				{1,1},
				{1,2},
				{1,3},
				{1,4}
		};
		ArrayList<ArrayList<Integer>> res = setOfStack(ope, 2);
		for (ArrayList<Integer> arrayList : res) {
			for (Integer integer : arrayList) {
				System.out.print(integer + " ");
			}
			System.out.println();
		}
		
	}
	
	public static ArrayList<ArrayList<Integer>> setOfStack(int[][] ope, int size) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<>();
		ArrayList<Integer> currentStack = new ArrayList<>(size);
		res.add(currentStack);
		
		for (int[] opAndValue : ope) {
			int op = opAndValue[0];
			int value = opAndValue[1];
			
			if (op == 1) {
				if (currentStack.size() == size) {
					currentStack = new ArrayList<>(size);
					res.add(currentStack);
				}
				currentStack.add(value);
			} else {
				if (currentStack.size() == 0) {
					res.remove(currentStack);
					currentStack = res.get(res.size() - 1);
				}
				currentStack.remove(res.size() - 1);
			}
		}
		return res;
	}
}
