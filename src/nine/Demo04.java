package nine;

import java.util.Queue;
import java.util.Scanner;

public class Demo04 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		sc.close();
		System.out.println(f(n, k));
	}
	
	/**
	 * Ô¼Éª·ò¹«Ê½
	 * @param n
	 * @param k
	 * @return
	 */
	public static int f(int n, int k) {
		int p = 0;
		for (int i = 2; i <= n; i++) {
			p = (p + k) % i;
		}
		return p + 1;
	}
	
	
	public static void f(Queue<Integer> q, int n, int k) {
		while (q.size() != 1) {
			int count = 1;
			if (count == k) {
				q.poll();
				count = 1;
			}
			q.add(q.poll());
			count++;
		}
	}
}
