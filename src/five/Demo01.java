package five;

public class Demo01 {
	public static void main(String[] args) {
		for (int i = 1900; i < 2014; i++) {
			String bir = i + "";
			int age = 2014 - i;
			int sum = 0;
			for (int j = 0; j < bir.length(); j++) {
				sum += Integer.parseInt(bir.charAt(j) + "");
			}
			if (sum == age) {
				System.out.println(i + ":" + age);
			}
		}
	}
	//´ð°¸:1988
}
