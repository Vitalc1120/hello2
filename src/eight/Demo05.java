package eight;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Demo05 {
	private static int res = Integer.MAX_VALUE;
	private static int graph[][];
	private static int n, m;
	private static List<List<Integer>> list = new LinkedList<List<Integer>>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		graph = new int[n + 1][n + 1];
		for (int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			graph[a][b] = graph[b][a] = 1;
		}
		sc.close();
		dfs(1);
		System.out.println(res);
	}

	private static boolean check(int index, int now) {
		for (int i = 0; i < list.get(index).size(); i++) {
			if (graph[now][list.get(index).get(i)] == 1) {
				return false;
			}
		}
		return true;
	}
	
	private static void dfs(int now) {
		if (now == n + 1) {
			res = Math.min(now, list.size());
		}
		if (list.size() >= res) {
			return;
		}
		for (int i = 0; i < list.size(); i++) {
			if (check(i, now)) {
				list.get(i).add(now);
				dfs(now + 1);
				list.get(i).remove(list.get(i).size() - 1);
			}
		}
		List<Integer> temp = new LinkedList<Integer>();
		temp.add(now);
		list.add(temp);
		dfs(now + 1);
		list.remove(list.size() - 1);
	}
}
