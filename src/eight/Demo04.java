package eight;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Demo04 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int n = sc.nextInt();
		sc.close();
		StringBuilder res = new StringBuilder();
		List<Integer> list = new ArrayList<Integer>();
		do {
			a %= b;
			list.add(a);
			a *= 10;
		} while(!list.contains(a % b));
		int len = list.size();//非循环体+一个循环体
		int loopstart = list.indexOf(a % b);//循环开始的地方,即非循环体的长度
		int looplen = len - loopstart;//循环体的长度
		for (int i = n - 1; i < n + 2; i++) {
			if (i >= loopstart) {
				res.append(list.get((i - loopstart) % looplen + loopstart) * 10 / b);
			} else {
				res.append(list.get(i) * 10 / b);
			}
		}
		System.out.println(res);
	}
}
