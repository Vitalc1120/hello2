package five;

import java.util.Arrays;
import java.util.Scanner;

public class Demo05 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		sc.close();
		String res = f(str);
		System.out.println(res);	
	}

	private static String f(String str) {
		int len = str.length();
		for (int i = len - 1; i >= 0; i--) {//控制末端字符的位置,从末端开始
			String res = "";
			String newStr = "";
			for (int j = i - 1; j >= 0; j--) {//移到"第一个小于该字符的字符(p)"前面,如果找不到这样的字符,就从前一个位置开始再次寻找
				if (str.charAt(j) < str.charAt(i)) {
					res = str.substring(0, j) + str.charAt(i) + str.charAt(j);
					newStr = str.substring(j + 1, i) + str.substring(i + 1);
					//对p之后的字符进行升序排列(不包括p)
					char[] ch = newStr.toCharArray();
					Arrays.sort(ch);
					for (char d : ch) {
						res += d;
					}
					return res;
				}
			}
		}
		//该字符是本身可组成的最大字符
		return str;		
	}
}
