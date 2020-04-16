package Ã‚;

import java.util.Scanner;

public class POJ_1753 {
	static int cnt = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[][] piece = new char[4][4];
		for (int i = 0; i < piece.length; i++) {
			piece[i] = sc.next().toCharArray();
		}	
		sc.close();
	}

}
