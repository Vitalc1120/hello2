package nine;

public class Demo02 {
	public static void main(String[] args) {
		int[] b = new int[12];
		for (int i = 12; i <= 50000; i+=12) {//金币数量
			for (int j = 0; j < b.length ; j++) {
				b[j] = i / 12;//最后一个是最大的
			}
			dfs(b, 11, i);
		}
	}
	
	private static void dfs(int[] b, int max, int sum) {
		if (max < 0) {
			for (int i = 11; i >= 0; i--) {
				System.out.print(b[i] + " ");
			}
			return;
		}
		int money = 0;
		for (int i = 0; i < b.length; i++) {
			if (i == max) {
				continue;
			} else {
				if (b[i] % 2 != 0) {
					return;
				} else {
					b[i] /= 2;
					money += b[i];
				}
			}
		}
		b[max] = sum - money;
		dfs(b, max - 1, sum);
	}
}
