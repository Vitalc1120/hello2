package nine;

import java.util.Scanner;

/**
 * 模板技术:以结果的类型推
 * @author Vitalc
 *
 */
public class Demo05 {
	private static int count = 0;
	private static int numa = 0;
	private static int min = Integer.MAX_VALUE;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		sc.close();
		char[] a = str.toCharArray();
		if (show(a)) {
			System.out.println(count);
		} else {
			for (int i = 0; i < a.length; i++) {
				if (a[i] == 'A') {
					numa++;
				}
			}
			f(a);
			char[] a1 = new char[a.length];
			for (int i = 0; i < a.length; i++) {
				a1[i] = a[a.length - 1 - i];
			}
			f(a1);
			System.out.println(min);
		}
	}

	private static void f(char[] a) {
		//Axx
		char[] b = new char[a.length];
		for (int i = 0; i < a.length; i++) b[i] = a[i];
		sort(0, a.length - 1, 'A', b);
		int numAxx = count;
		
		//ABT TBA
		char[] c = new char[a.length];
		for (int i = 0; i < a.length; i++) c[i] = b[i];
		sort(numa, a.length - 1, 'B', c);
		int numABT = count;
		min = min > numABT ? numABT : min;
		
		//ATB BTA
		count = numAxx;
		c = new char[a.length];
		for (int i = 0; i < a.length; i++) c[i] = b[i];
		sort(numa, a.length - 1, 'T', c);
		int numATB = count;	
		min = min > numATB ? numATB : min;
		count = 0;
		
		
		//Txx
		b = new char[a.length];
		for (int i = 0; i < a.length; i++) b[i] = a[i];		
		sort(0, a.length-1, 'T', b);
		
		//TAB BAT
		c = new char[a.length];	
		for (int i = 0; i < a.length; i++) c[i] = b[i];
		sort(numa, a.length - 1, 'A', c);
		int numTAB = count;	
		min = min > numTAB ? numTAB : min;
		count = 0;	
	}
	
	/**
	 * 交换位置
	 * @param arr
	 * @param m
	 * @param n
	 */
	private static void temp(char[] arr, int m, int n) {
		char tmp = arr[m];
		arr[m] = arr[n];
		arr[n] = tmp;
		count++;
	}
	
	/**
	 * 在start到end这个范围内,把字符c排在最前:cccccc....
	 * @param start
	 * @param end
	 * @param ch
	 * @param a
	 */
	private static void sort(int start, int end, char ch, char[] a) {
		for (int i = end; i >= start; i--) {
			if (ch == a[i]) {
				boolean flag = true;
				while (flag) {
					if (a[start] != ch) {//不等,就交换,左缩短
						temp(a, start, i);
						start += 1;
						flag = false;
					} else {//相等就不用,并且左缩短
						start += 1;
						if (start >= i) {
							return;
						}
					}
				}
			}
		}
	}
	
	
	/**
	 * 需不需要进行排序
	 * @param c
	 * @return
	 */
	private static boolean show(char[] c) {
		char ch = c[0];
		int cnt = 1;
		for (int i = 0; i < c.length; i++) {
			if (ch != c[i]) {
				cnt++;
				ch = c[i];
				if (cnt > 3) {
					return false;
				}
			}
		}
		return true;
	}
}
