package four;

public class Demo03 {
	public static void main(String[] args) {
		test();
	}
	
	static boolean isPrime(int n) {
		if (n <= 1) {
			return false;
		}
		for (int i = 2; i * i <= n; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	static void test() {
		int[] x = {1,3,5,7,9};
		f(x, 0);
	}
	
	static int count = 0;
	static void f(int[] x, int k) {
		if (k == x.length) {//���λ��
			if (isPrime(x[0] * 10000 + x[1] * 1000 + x[2] * 100 + x[3] * 10 + x[4]) &&
				isPrime(x[1] * 100 + x[2] * 10 + x[3]) &&
				isPrime(x[2])) {
				count--;
				System.out.println("***" + x[0] + x[1] + x[2] + x[3] + x[4]);
			}
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
}
