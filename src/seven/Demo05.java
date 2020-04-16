package seven;

import java.util.Scanner;

public class Demo05 {
	private static int N = 0;
	private static int[][] map;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		int[][] flag = new int[N][N];
		int count = 0;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = count;
				count++;
			}
		}
		int[] north = new int[N];
		int[] west = new int[N];
		for (int i = 0; i < north.length; i++) {
			north[i] = sc.nextInt();
		}
		for (int i = 0; i < west.length; i++) {
			west[i] = sc.nextInt();
		}
		sc.close();
		north[0]-=1;
		west[0]-=1;
		dfs(north, west, flag, 0, 0);
		
	}
	
	private static void dfs(int[] north, int[] west, int[][] flag, int x, int y) {
		if (x == N - 1 && y == N - 1) {
			for (int i = 0; i < N; i++) {
				if(north[i]!=0 || west[i]!=0) {
					return;
				}
				if(i==N-1) {
					System.out.println("yes");
				}
			}
		}
		//标记
		flag[x][y] = 1;
		//上
		if (x - 1 >= 0 && north[y] != 0 && west[x - 1] != 0) {
			if (flag[x - 1][y] == 0) {					
				north[y]-=1;
				west[x - 1]-=1;
				dfs(north, west, flag, x - 1, y);
				//回溯
				north[y]+=1;
				west[x - 1]+=1;
				flag[x][y] = 0;
			}
		}
		//下
		if (x + 1 < N && north[y] != 0 && west[x + 1] != 0) {
			if (flag[x + 1][y] == 0) {
				north[y]-=1;
				west[x + 1]-=1;
				dfs(north, west, flag, x + 1, y);
				//回溯
				north[y]+=1;
				west[x + 1]+=1;
				flag[x][y] = 0;
			}
		}
		//左
		if (y - 1 >= 0 && north[y - 1] != 0 && west[x] != 0) {
			if (flag[x][y - 1] == 0) {
				north[y - 1]-=1;
				west[x]-=1;
				dfs(north, west, flag, x, y - 1);
				//回溯
				north[y - 1]+=1;
				west[x]+=1;
				flag[x][y] = 0;			
			}
		}
		//右
		if ((y + 1 < N && north[y + 1] != 0 && west[x] != 0)) {
			if (flag[x][y + 1] == 0) {
				north[y + 1]-=1;
				west[x]-=1;
				dfs(north, west, flag, x, y + 1);
				//回溯
				north[y + 1]+=1;
				west[x]+=1;
				flag[x][y] = 0;				
			}
		}
	}
}
