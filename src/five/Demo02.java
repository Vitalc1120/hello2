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
	 * ����k�����һ����ջ����.
	 * ��k���ջ�����ջ����k-1����,һ����h(k-1)�ַ���.
	 * ��k���ջ�����ջ����n-k����,һ����h(n-k)�ַ���.
	 * ����һ����h(k-1)*h(n-k)�ַ���
	 */
	//35357670
}
