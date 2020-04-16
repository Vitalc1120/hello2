package math;

public class GCD {
	/**
	 * 最大公约数
	 * @param m
	 * @param n
	 * @return
	 */
	private static long gcd(long m, long n) {
		return n == 0 ? m : gcd(n, m % n);
	}
	
	/**
	 * 最小公倍数
	 * @param a
	 * @param b
	 * @return
	 */
	@SuppressWarnings("unused")
	private static long lcm(long a, long b) {
		return a * b / gcd(a, b);
	}
	
	static long x, y;
	/**
	 * 扩展欧几里得
	 * x, y是ax + by = gcd(a, b)的解
	 * @param a
	 * @param b
	 * @return
	 */
	private static long ext_gcd(long a, long b) {
		if (b == 0) {
			x = 1;
			y = 0;
			return a;
		}
		long res = ext_gcd(b, a % b);
		long x1 = x;
		x = y;
		y = x1 - a / b  * y;
		return res;
	}
	
	private static long linearEquation(long a, long b, long m) throws Exception {
		long d = ext_gcd(a, b);
		if (m % d != 0) {
			throw new Exception("无解");
		}
		long n = m / d;//约一下,考虑m是d的倍数
		x *= n;
		y *= n;
		return d;
	}
	
	/**
	 * 求逆元
	 * @param a
	 * @param mo
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unused")
	private static long inversetElment(long a, long mo) throws Exception {
		long d = linearEquation(a, mo, 1);
		x = (x % mo + mo) % mo;
		return d;
	}
}
