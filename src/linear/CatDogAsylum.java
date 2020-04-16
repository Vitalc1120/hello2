package linear;

import java.util.ArrayList;

/**
 * 
 * @author Vitalc
 *
 */
public class CatDogAsylum {
	public static void main(String[] args) {
		int[][] ope = {
				{1,1},
				{1,-1},
				{1,1},
				{2,0},
				{2,0},
				{2,-1}
		};
		ArrayList<int[]> res = catDogAsylum(ope);
		for (int[] is : res) {
			System.out.println(is[1] + " ");
		}
	}
	
	public static ArrayList<int[]> catDogAsylum(int[][] ope) {
		int[][] temp = new int[ope.length][];
		for (int i = 0; i < temp.length; i++) {
			temp[i] = new int[3];
		}
		for (int i = 0; i < ope.length; i++) {
			for (int j = 0; j < ope[i].length; j++) {
				temp[i][j] = ope[i][j];
			}
		}
		
		ArrayList<int[]> res = new ArrayList<>();		
		A_12_MyQueue<int[]> dog = new A_12_MyQueue<>();
		A_12_MyQueue<int[]> cat = new A_12_MyQueue<>();

		int count = 0;
		
		for (int[] opAndValue : temp) {
			int op = opAndValue[0];
			int value = opAndValue[1];
			if (op == 1) {//动物进入			
				if (value == 1) {//狗
					count++;
					opAndValue[2] = count;
					dog.enqueue(opAndValue);
				} else if (value == -1) {//猫
					count++;
					opAndValue[2] = count;
					cat.enqueue(opAndValue);
				} else {//不合法的数据
					continue;
				}
			} else {//动物有人收养
				if (value == 1) {//狗
					if (dog.peek() == null) {
						continue;
					}
					res.add(dog.dequeue());
				} else if (value == -1) {//猫
					if (cat.peek() == null) {
						continue;
					}
					res.add(cat.dequeue());
				} else if (value == 0) {//收养最早的
					if (cat.peek() == null & dog.peek() == null) {
						continue;
					}
					if (cat.peek() == null) {
						res.add(dog.dequeue());
						continue;
					}
					if (dog.peek() == null) {
						res.add(cat.dequeue());
						continue;
					}
					int[] d = (int[]) dog.peek();
					int[] c = (int[]) dog.peek();
					if (d[2] > c[2]) {
						res.add(cat.dequeue());
					} else {
						res.add(dog.dequeue());
					}
				} else {//不合法的数据
					continue;
				}
			}
		}
		return res;
	}
}
