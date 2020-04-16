package eight;

import java.util.Scanner;

/**
 * 并查集 逆序思路
 * @author Vitalc
 *
 */
public class Demo0602 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] arr = new int[n * m + 1];
		for (int i = 1; i < arr.length; i++) {
			arr[i] = i;
		}
		int count = n * m;
		for (int i = 0; i < k; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int fa = find(a, arr);
			int fb = find(b, arr);
			if (fa != fb) {
				arr[fa] = fb;
				count--;
			}
		}
		sc.close();
		System.out.println(count);
	}
	
	/**
	 * 递归压缩路径
	 * 首先找到arr[i]能到达的最远点,然后将路径上的所有点的最远点改为这个点
	 * @param i
	 * @param arr
	 * @return
	 */
	private static int find(int i, int[] arr) {
		if (arr[i] == i) {
			return i;
		}
		return arr[i] = find(arr[i], arr);
	}
}