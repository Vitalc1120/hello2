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
		for (int i = len - 1; i >= 0; i--) {//����ĩ���ַ���λ��,��ĩ�˿�ʼ
			String res = "";
			String newStr = "";
			for (int j = i - 1; j >= 0; j--) {//�Ƶ�"��һ��С�ڸ��ַ����ַ�(p)"ǰ��,����Ҳ����������ַ�,�ʹ�ǰһ��λ�ÿ�ʼ�ٴ�Ѱ��
				if (str.charAt(j) < str.charAt(i)) {
					res = str.substring(0, j) + str.charAt(i) + str.charAt(j);
					newStr = str.substring(j + 1, i) + str.substring(i + 1);
					//��p֮����ַ�������������(������p)
					char[] ch = newStr.toCharArray();
					Arrays.sort(ch);
					for (char d : ch) {
						res += d;
					}
					return res;
				}
			}
		}
		//���ַ��Ǳ������ɵ�����ַ�
		return str;		
	}
}
