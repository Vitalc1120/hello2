package eight;

import java.util.ArrayList;

public class Demo02 {
	public static void main(String[] args) {
//		���⣺���ֻ���
//		w����ĳ��Ͻ���С��һ������
//		1,2,3...16 ��16�����ַ�Ϊ���顣
//		Ҫ��
//		���������ֵĺ���ͬ��
//		���ң��������ֵ�ƽ����Ҳ��ͬ��
//		���ң��������ֵ�������Ҳ��ͬ��
//		�������ü������ǿ�������������������⡣
//		���ύ1���ڵ��Ǹ�������������֡�
//
//		��Щ����Ҫ��С�������У��������ּ���һ���ո�ֿ���
//		�����ƣ�1 4 5 8 ...  �����Ĵ𰸡�
		ArrayList<Integer> group1;
		ArrayList<Integer> group2;
		int[] sum1;
		int[] sum2;
		int[] sum3;
		int n = 0;
		int[] num = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
		for (int i = 1; i < (1 << num.length) - 1; i += 2) {
			//1Ϊһ��,0Ϊһ��
			group1 = new ArrayList<Integer>();
			group2 = new ArrayList<Integer>();
			sum1 = new int[2];
			sum2 = new int[2];
			sum3 = new int[2];
			for (int j = 0; j <num.length; j++) {
				//�ж϶���������iΪ0����1
				if ((i & (1 << j)) != 0) {
					n = 1;
				} else {
					n = 0;
				}
				//��1����1��
				//��0����2��
				if (n == 1) {
					group1.add(num[j]);
				} else {
					group2.add(num[j]);
				}
				
				sum1[n] += (num[j]);
				sum2[n] += (num[j]) * (num[j]);
				sum3[n] += (num[j]) * (num[j]) * (num[j]);
			}
			if (sum1[0] == sum1[1] & sum2[0] == sum2[1] & sum3[0] == sum3[1]) {
				System.out.println(i);
				for (int j : group1) {
					System.out.print(j + " ");
				}
				return;
			}
		}
	}
}
