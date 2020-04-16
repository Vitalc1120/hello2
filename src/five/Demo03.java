package five;

import java.util.List;
import java.util.Vector;

public class Demo03 {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static List fen(int n, int limit) {
		Vector v = new Vector();
		if (n <= limit) {
			v.add(n);
		}		
		for (int i = 1; i < n; i++) {
			if (n - i > limit) {
				continue;
			}
			List t = fen(i, n - i);
			for (int k = 0; k < t.size(); k++) {
				v.add(n - i + "+" + t.get(k));//Ìî¿ÕÎ»ÖÃ
			}
		}
		return v;
	}
	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {		
		List v = fen(6, 6);		
		for (int i = 0; i < v.size(); i++) {
			System.out.println(v.get(i));
		}
	}
}