package five;

import java.util.Scanner;

public class Demo04 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		@SuppressWarnings("unused")
		long N = sc.nextInt();
		long L = sc.nextInt();
		long R = sc.nextInt();
		sc.close();
		long sum = R - L + 1;//��������
		for (long i = (long) Math.sqrt(L); i * i <= R; i++) {
			if (i * i >= L) {
				sum--;//�رչ�Դ
			}
		}
		System.out.println(sum);
	}
}
