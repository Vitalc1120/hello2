package Ã‚;

import java.util.Scanner;

public class POJ_2109 {
	public static void main(String[] args) {
		double n, p;
		Scanner sc = new Scanner(System.in);
		String tmp = "";
		while (!((tmp=sc.nextLine()).equals(""))) {
			String[] str = tmp.split(" ");
			n = Double.parseDouble(str[0]);
			p = Double.parseDouble(str[1]);
			int res = (int)(Math.pow(p, 1 / n) + 0.5);
			System.out.println(res);
		}
		sc.close();
	}
}
