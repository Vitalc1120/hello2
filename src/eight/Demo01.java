package eight;

import java.util.Scanner;

public class Demo01 {
	public static void main(String[] args) {
		StringBuilder s = new StringBuilder("");;
		Scanner sc = new Scanner(System.in);
		String tmp = "";
		do {
			tmp = sc.nextLine();
			s.append(tmp);
		} while (sc.hasNextLine() & !tmp.equals(""));
		sc.close();
		System.out.println(s);
	}
}
