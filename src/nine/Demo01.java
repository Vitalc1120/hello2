package nine;

public class Demo01 {
	public static void main(String[] args) {
		for (int x = 1; x < 120; x++) {
			for (int i = 1; i < 120; i++) {
				if (x - 20 == (i - 20) * 2 && x == i * 1.5) {
					System.out.println(x + " " + i);
					break;
				}
			}
		}
		//´ð°¸:40
	}
}
