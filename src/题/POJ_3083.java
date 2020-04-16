package Ã‚;

import java.util.Scanner;

public class POJ_3083 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		char[][] c = new char[m][n];
		char[][] map = new char[m][n];
		for (int i = 0; i < c.length; i++) {
			c[i] = sc.next().toCharArray();
		}
		for (int i = 0; i < map.length; i++) {
			map[i] = c[i];
		}
		sc.close();
		int x = 0, y = 0;
		for (int i = 0; i < c.length; i++) {
			for (int j = 0; j < c[i].length; j++) {
				if (c[i][j] == 'S') {
					x = i;
					y = j;
				}
			}
		}
		dfs(map, c, x, y);
	}
	private static int cnt = 0, n, m;
	private static boolean dfs(char[][] map, char[][] c, int x, int y) {
		if (c[x][y] == 'E') {
			System.out.println(++cnt);
			System.exit(0);
		}
		boolean f1 = false;
		boolean f2 = false;
		boolean f3 = false;
		boolean f4 = false;			
		map[x][y] = '#';
		if (x - 1 > 0) {
			if (c[x - 1][y] != '#' && map[x - 1][y] != '#') {
				cnt++;
				f1 = dfs(map, c, x - 1, y);
				map[x - 1][y] = '.';
				cnt--;
			}
		}
		if (x + 1 < m) {
			if (c[x + 1][y] != '#' && map[x + 1][y] != '#') {
				cnt++;
				f2 = dfs(map, c, x + 1, y);
				map[x + 1][y] = '.';
				cnt--;
			}
		}
		if (y - 1 > 0) {
			if (c[x][y - 1] != '#' && map[x][y - 1] != '#') {
				cnt++;
				f3 = dfs(map, c, x, y - 1);
				map[x][y - 1] = '.';
				cnt--;
			}
		}
		if (y + 1 < n) {
			if (c[x][y + 1] != '#' && map[x][y + 1] != '#') {
				cnt++;
				f4 = dfs(map, c, x, y + 1);
				map[x][y + 1] = '.';
				cnt--;
			}
		}
		return f1 || f2 || f3 || f4;
	}
}
