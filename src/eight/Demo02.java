package eight;

import java.util.ArrayList;

public class Demo02 {
	public static void main(String[] args) {
//		标题：数字划分
//		w星球的长老交给小明一个任务：
//		1,2,3...16 这16个数字分为两组。
//		要求：
//		这两组数字的和相同，
//		并且，两组数字的平方和也相同，
//		并且，两组数字的立方和也相同。
//		请你利用计算机的强大搜索能力解决这个问题。
//		并提交1所在的那个分组的所有数字。
//
//		这些数字要从小到大排列，两个数字间用一个空格分开。
//		即类似：1 4 5 8 ...  这样的答案。
		ArrayList<Integer> group1;
		ArrayList<Integer> group2;
		int[] sum1;
		int[] sum2;
		int[] sum3;
		int n = 0;
		int[] num = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
		for (int i = 1; i < (1 << num.length) - 1; i += 2) {
			//1为一组,0为一组
			group1 = new ArrayList<Integer>();
			group2 = new ArrayList<Integer>();
			sum1 = new int[2];
			sum2 = new int[2];
			sum3 = new int[2];
			for (int j = 0; j <num.length; j++) {
				//判断二进制数第i为0还是1
				if ((i & (1 << j)) != 0) {
					n = 1;
				} else {
					n = 0;
				}
				//是1存入1组
				//是0存入2组
				if (n == 1) {
					group1.add(num[j]);
				} else {
					group2.add(num[j]);
				}
				
				sum1[n] += (num[j]);
				sum2[n] += (num[j]) * (num[j]);
				sum3[n] += (num[j]) * (num[j]) * (num[j]);
			}
			if (sum1[0] == sum1[1] & sum2[0] == sum2[1] & sum3[0] == sum3[1]) {
				System.out.println(i);
				for (int j : group1) {
					System.out.print(j + " ");
				}
				return;
			}
		}
	}
}
