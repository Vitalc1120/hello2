package six;

import java.math.BigInteger;

public class Demo02 {
	public static void main(String[] args) {
		for (int i = 1; i < 200; i++) {
			flag = false;
			f(i);
			if (!flag) {
				System.out.println(i);
			}
		}
	}
	static boolean flag = false;
	private static void f(int i) {
		BigInteger s = new BigInteger(i + "");
		int count = 0;
		while (!flag) {
			if (count > 1000) {
				break;
			}
			String str = s + "";
			String newStr = new StringBuilder(str).reverse().toString();
			BigInteger newNum = new BigInteger(newStr);
			if (str.equals(newStr)) {
				flag = true;
				break;
			}
			s = s.add(newNum);
			count++;
		}
	}
	//196
}
