package seven;

import java.util.HashSet;
import java.util.Set;

public class Demo01 {
	public static void main(String[] args) {
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 10; i <= 10000; i++) {
			if (Math.sqrt(i) * 10 % 10 != 0) {
				continue;
			}
			set.add(i % 100);
		}
		System.out.println(set.size());
	}
}
