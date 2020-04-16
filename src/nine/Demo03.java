package nine;

public class Demo03 {
	static void f(char[] data, int cur) {
		if(cur == data.length - 1){
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
			for (int j = cur; j <= i - 1; j++) data[j] = data[j + 1];//МоїХ
			data[i] = tmp;
		}
	}
	
	static void aaa(String x) {
		f(x.toCharArray(), 0);
	}
	
	public static void main(String[] args) {
		aaa("1233");
	}
}