package graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class POJ {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = "";
		while (!(s = sc.nextLine()).equals("0")) {
			if (s.length() == 0) {
				continue;
			}
			String[] pr = s.split(" ");
			int p = Integer.parseInt(pr[0]);
			int r = Integer.parseInt(pr[1]);
			if (r > 0) {
				List<Edge<Integer>> list = new ArrayList<Edge<Integer>>();
				for (int i = 0; i < r; i++) {
					list.add(new Edge<Integer>(sc.nextInt(), sc.nextInt(), sc.nextInt()));
				}
				Kruskal<Integer> obj = new Kruskal<Integer>(list, p);
				obj.buildMST();
				System.out.println(obj.weight);
			} else if (r == 0) {
				System.out.println(0);
			}
		}
		sc.close();
	}
}
