package seven;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Demo06 {
	
	static int n, m, k, ans = 0;
	static int mod = 1000000007;
	static String[] S, num;
	static int[] start;
	static Set<String> result = new HashSet<String>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		k = sc.nextInt();
		S = new String[n];
		for (int i = 0; i < n; i++) {
			S[i] = sc.next();
		}
		sc.close();
		start = new int[n];
		num = new String[n];
		dfs(0);
		System.out.println(ans);
	}
	private static void dfs(int ind) {
		if (ind == n) {
			ArrayList<String> set = new ArrayList<String>();
			StringBuffer[] s = new StringBuffer[n];
			for (int i = 0; i < n; i++) {
				s[i] = new StringBuffer("");
			}
			for (int i = 0; i < n; i++) {
				if (!num[i].equals("")) {
					if (set.contains(num[i])) {
						int j = set.indexOf(num[i]);
						s[j].append(i);//�洢�ڼ����ַ�,������ȡ����ʼ��ƴ������,�γɶ�һ�޶����ַ�������,��ֹ�����ظ�
						s[j].append(start[i]);
					} else {
						set.add(num[i]);
						s[set.size() - 1].append(i);
						s[set.size() - 1].append(start[i]);
					}
				}
			}
			for (int i = 0; i < n; i++) {
				if (s[i].toString().length() == 2 * m) {
					if (!result.contains(s[i].toString())) {
						ans = (ans + 1) % mod;
						result.add(s[i].toString());
					}
				}
			}
			return;
		}		
		String str = S[ind];
		num[ind] = "";//��������ַ�������ȡ
		dfs(ind + 1);
		for (int i = 0; i + k <= str.length(); i++) {
			String tmp = str.substring(i, i + k);
			num[ind] = tmp;
			start[ind] = i;//��¼��ǰ�ַ���ȡ����ʼ��
			dfs(ind + 1);//����ѭ����ȡ
		}
	}
	
}
