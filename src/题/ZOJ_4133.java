package Ã‚;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ZOJ_4133 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long[] y1 = new long[n];
		long[] m1 = new long[n];
		long[] d1 = new long[n];
		long[] y2 = new long[n];
		long[] m2 = new long[n];
		long[] d2 = new long[n];
		String[] date = new String[n];
		for (int i = 0; i < n; i++) {
			y1[i] = sc.nextInt();
			m1[i] = sc.nextInt();
			d1[i] = sc.nextInt();
			date[i] = sc.next();
			y2[i] = sc.nextInt();
			m2[i] = sc.nextInt();
			d2[i] = sc.nextInt();
		}
		for (int i = 0; i < n; i++) {
			System.out.println(f(y1[i], m1[i], d1[i], date[i], y2[i], m2[i], d2[i]));			
		}
		sc.close();
	}

	private static String f(long y1, long m1, long d1, String date, long y2, long m2, long d2) {
		List<String> list = new ArrayList<String>();
		list.add("Monday");
		list.add("Tuesday");
		list.add("Wednesday");
		list.add("Thursday");
		list.add("Friday");
		int index = list.indexOf(date) + 1;
		long days = 0;
		boolean flag = true;
		if (y1 < y2) {
			days = d2 + (m2 - 1) * 30 + (y2 - 1 - y1) * 12 * 30 + 12 * 30 - (d1 + (m1 - 1) * 30);
		} else if (y1 > y2) {
			days = d1 + (m1 - 1) * 30 + (y1 - 1 - y2) * 12 * 30 + 12 * 30 - (d2 + (m2 - 1) * 30);
			flag = !flag;
		} else {
			if (m1 > m2) {
				days = d1 + (m1 - 1 - m2) * 30 + 30 - d2;
				flag = !flag;
			} else if (m1 < m2) {
				days = d2 + (m2 - 1 - m1) * 30 + 30 - d1;
			} else {
				days = Math.abs(d1 - d2);
			}
		}
		long yu = days % 5;
		if (flag) {
			while (yu != 0) {
				if (index == 5) {
					index = 1;
				} else {
					index++;
				}
				yu--;
			}
		} else {
			while (yu != 0) {
				if (index == 1) {
					index = 5;
				} else {
					index--;
				}
				yu--;
			}
		}	
		return list.get(index - 1);
	}
}
