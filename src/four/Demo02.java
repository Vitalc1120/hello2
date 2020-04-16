package four;

public class Demo02 {
	public static void main(String[] args) {
		int count = 0;
		for (int x = 1; x < 10000; x++) {
			for (int y = x + 1; y < 10000; y++) {
				if (x * y * 2 == (x + y) * 45) {
					count++;
					System.out.println(x + " " + y);
				}
			}
		}
		System.out.println(count);
	}
}
