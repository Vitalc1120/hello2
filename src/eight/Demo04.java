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
		int len = list.size();//��ѭ����+һ��ѭ����
		int loopstart = list.indexOf(a % b);//ѭ����ʼ�ĵط�,����ѭ����ĳ���
		int looplen = len - loopstart;//ѭ����ĳ���
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
