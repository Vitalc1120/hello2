package math;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ��ƽ���� {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.close();
		//ת����������
		final String x = Integer.toString(N, 3);
		//��ת���������
		char[] arr = new StringBuilder(x).reverse().toString().toCharArray();
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == '2') {
				list.add(0, -1);//-1���ڿ�ͷ
				if (i == arr.length - 1) {
					list.add(0, 1);//���һ���ַ�,��λ
				} else {
					++arr[i + 1];//�������һ������1
				}
			} else if (arr[i] == '3') {
				list.add(0, 0);//����0
				if (i == arr.length - 1) {
					list.add(0, 1);
				} else {
					++arr[i + 1];
				}
			} else {
				list.add(0, arr[i] - '0');
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) == 1) {
				sb.append("+").append((int)Math.pow(3, list.size() - i - 1));
			}
			if (list.get(i) == -1) {
				sb.append("-").append((int)Math.pow(3, list.size() - i - 1));
			}
		}
		System.out.println(sb.substring(1));
	}
}
