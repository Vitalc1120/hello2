package five;

import java.util.Scanner;

public class Demo02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int len = sc.nextInt();
		sc.close();
		long[] num = new long[len + 1];
		for (int i = 1; i < num.length; i++) {
			num[i] = f(i);
			System.out.println(num[i]);
		}
	}
	
	public static long f(int n) {
		if (n == 1) {
			return 1;
		}
		return f(n - 1) * (4 * n - 2) / (n + 1);
	}
	/*
	 * 假设k是最后一个出栈的数.
	 * 比k早进栈且早出栈的有k-1个数,一共有h(k-1)种方案.
	 * 比k晚进栈且早出栈的有n-k个数,一共有h(n-k)种方案.
	 * 所以一共有h(k-1)*h(n-k)种方案
	 */
	//35357670
}
