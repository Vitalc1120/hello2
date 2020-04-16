package nine;

import java.util.ArrayList;
import java.util.Scanner;

public class Demo06 {
	public static void main(String[] args) {
		//n		1	2	3	4	5	6	7	8	9	10	11	12	13
		//G(n)	1	2	2	3	3	4	4	4	5	5	5	6	6
		
		//G(n)	1	2	3	4	5	6	7	8	9	10	11	12	13    i
		//n		1	3	5	8	11	15	19	23	28	33	38	44	50    list.get(i)
		Scanner sc = new Scanner(System.in);
		long a = sc.nextLong();
		sc.close();
		ArrayList<Long> list = new ArrayList<Long>();
		list.add((long) 0);
		list.add((long) 1);
		list.add((long) 3);
		if (a == 1) {
			System.out.println(1);
			return;
		}
		int i = 3;
		int j = 2;
		while (list.get(i - 1) < a) {
			if (list.get(j) < i) {
				j++;
			}
			list.add(j + list.get(i - 1));
			i++;
		}
		System.out.println(list.size() - 1);
	}
}
