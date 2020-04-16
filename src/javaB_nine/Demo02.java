package javaB_nine;

import java.util.Scanner;

public class Demo02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int radius = sc.nextInt();
		sc.close();
		int[][] arr = new int[2 * radius + 1][2 * radius + 1];
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (i <= radius && j <= radius) {
					if ((i - radius) * (i - radius) + (j - radius) * (j - radius) <= 1000 * 1000) {
						count++;
					}
				} else if (i > radius && i < 2 * radius + 1 && j <= radius) {
					if ((i - radius) * (i - radius) + (j - radius) * (j - radius) <= 1000 * 1000) {
						count++;
					}
				} else if (i <= radius && j < 2 * radius + 1 && j > radius) {
					if ((i - radius) * (i - radius) + (j - radius) * (j - radius) <= 1000 * 1000) {
						count++;
					}
				} else if (i > radius && i < 2 * radius + 1 && j <= radius) {
					if ((i - radius) * (i - radius) + (j - radius) * (j - radius) <= 1000 * 1000) {
						count++;
					}
				}	
			}
		}
		System.out.println(count);
	}
}
