package six;

public class Demo01 {
	public static void main(String[] args) {
		for (int i = 0; i <= 100; i++) {
			for (int j = 0; j <= 100; j++) {
				for (int k = 0; k <= 100; k++) {
					if (i + j + k == 100) {
						if (i * 8 + 6 * j + 4 * k == 600) {
							if (i + 3 * j + 4 * k == 280) {
								System.out.println(j);
								System.exit(0);
							}
						}
					}
				}
			}
		}
	}
	//60
}
