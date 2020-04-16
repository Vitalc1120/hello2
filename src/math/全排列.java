package math;

public class 全排列 {
	public static void main(String[] args) {
		f(new int[] {1, 2, 3, 4}, 0);
	}
	
	public static void f(int[] x, int k) {
		if (k == x.length) {
			System.out.println("" + x[0] + x[1] + x[2] + x[3]);
			return;
		}
		for (int i = k; i < x.length; i++) {
			{
				int tmp = x[k];
				x[k] = x[i];
				x[i] = tmp;
			}
			f(x, k + 1);
			{
				int tmp = x[k];
				x[k] = x[i];
				x[i] = tmp;
			}
		}
	}
	
	/**
	 * 升序的全排列
	 * @param data
	 * @param cur
	 */
	static void f(char[] data, int cur) {
		if (cur == data.length - 1) {
			System.out.println(new String(data));
			return;
		}
		for (int i = cur; i < data.length; i++) {
			if (data[i] == data[cur] && i != cur) {
				continue;
			}
			char tmp = data[i];
			for (int j = i - 1; j >= cur; j--) data[j + 1] = data[j];
			data[cur] = tmp;

			f(data, cur + 1);

			tmp = data[cur];
			for (int j = cur; j <= i - 1; j++) data[j] = data[j + 1];//填空
			data[i] = tmp;
		}
	}
}
