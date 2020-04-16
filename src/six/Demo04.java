package six;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Demo04 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		int n = sc.nextInt();
		sc.close();
		f(str, n);
	}

	private static void f(String str, int n) {
		StringBuilder res = new StringBuilder(str);
		List<Character> result = null;
		StringBuilder tmp = null;
		int count = 0;
		while (n != 0) {
			result = new ArrayList<Character>();
			tmp = new StringBuilder();
			for (int i = 0; i < res.length(); i++) {
				count = 0;
				if (!result.contains(res.charAt(i))) {
					result.add(res.charAt(i));
					for (int j = i; j < res.length(); j++) {
						if (res.charAt(i) == res.charAt(j)) {
							count++;
						}
					}
					tmp.append(count + "").append(res.charAt(i));
				}
			}
			res = tmp;
			n--;
		}
		System.out.println(res);
	}
}
