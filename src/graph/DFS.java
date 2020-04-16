package graph;

public class DFS {
	static int[][] map = {
			{0,0,1,0,0,0,0,0,0,0},
			{0,0,1,1,1,0,0,0,0,0},
			{0,0,0,0,1,1,1,1,1,0},
			{0,0,0,1,1,0,0,0,1,0},
			{1,1,1,1,0,1,0,0,1,0},
			{0,0,0,0,0,1,0,0,1,0},
			{0,0,0,0,0,1,0,0,1,1},
			{0,1,1,1,1,1,1,0,0,0},
			{0,0,0,0,0,1,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0}
	};
	static int[][] newmap = {
			{0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0}
	};
	private static int row = map.length;
	private static int col = map[0].length;
	public static void main(String[] args) {
		System.out.println(test(0, 0, 9, 9));
		System.out.println(test(0, 2, 6, 8));
		System.out.println(test(4, 4, 4, 6));
	}
	
	private static boolean test(int y1, int x1, int y2, int x2) {
		int p1 = map[y1][x1];
		int p2 = map[y2][x2];
		if (p1 != p2) {
			return false;
		}		
		return dfs(y1, x1, y2, x2);
	}
	
	public static boolean dfs(int y1, int x1, int y2, int x2) {
		if (y1 == y2 && x1 == x2) {
			return true;
		}
		boolean f1 = false;
		boolean f2 = false;
		boolean f3 = false;
		boolean f4 = false;
		newmap[y1][x1] = 1;
		int value = map[y1][x1];
		if ((y1 - 1 >= 0)) {
			if ((value == map[y1 - 1][x1]) && (newmap[y1 - 1][x1] != 1)) {
				f1 = dfs(y1 - 1, x1, y2, x2);
				newmap[y1 - 1][x1] = 0;
			}
		}
		if ((y1 + 1 < row)) {
			if ((value == map[y1 + 1][x1]) && (newmap[y1 + 1][x1] != 1)) {
				f2 = dfs(y1 + 1, x1, y2, x2);
				newmap[y1 + 1][x1] = 0;
			}
		}
		if ((x1 - 1 >= 0)) {
			if ((value == map[y1][x1 - 1]) && (newmap[y1][x1 - 1] != 1)) {
				f3 = dfs(y1, x1 - 1, y2, x2);
				newmap[y1][x1 - 1] = 0;
			}
		}
		if ((x1 + 1 < col)) {
			if ((value == map[y1][x1 + 1]) && (newmap[y1][x1 + 1] != 1)) {
				f4 = dfs(y1, x1 + 1, y2, x2);
				newmap[y1][x1 + 1] = 0;
			}
		}
		return f1 || f2 || f3 || f4;
	}
}
