package four;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Demo05 {
	static int count = 0; //路径总数
    static boolean[] visited = null; //是否为访问过
    static int[] way = null; //记录路径  way[k]表示第k步经过的结点
    static int[] cnt = null; //用于统计该点已经走过几次  cnt[k]表示第k个节点被走过的次数
    @SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int station = sc.nextInt();
		int channel = sc.nextInt();
		sc.nextLine();
		        
		visited = new boolean[station];
		way = new int[station];
		cnt = new int[station];
		List<Integer>[] channels = new ArrayList[station];
		for (int i = 0; i < station; i++) {
			channels[i] = new ArrayList<>();
		}
		for (int i = 0; i < channel; i++) {
			int x = sc.nextInt() - 1;
			int y = sc.nextInt() - 1;
			sc.nextLine();
			channels[x].add(new Integer(y));
			channels[y].add(new Integer(x));
		}
		int start = sc.nextInt() - 1;
		int end = sc.nextInt() - 1;
		sc.close();
		dfs(channels, start, end, 0);
		System.out.println(getResult());
    }
    
	public static void dfs(List<Integer>[] channels, int start, int end, int k) {
		visited[start] = true;
		way[k] = start;
		if (start == end) {
			count++;
			for (int i = 0; i < k; i++) {
				cnt[way[i]]++;//将路径经过的每个节点的次数加1
			}
			return;
		}
		for (int i = 0; i < channels[start].size(); i++) {
			int temp = channels[start].get(i); 
			if (!visited[temp]) {
				dfs(channels, temp, end, k + 1);
				visited[temp] = false;
			}
		}
	}
	
	public static int getResult() {
		int sum = 0;
		for (int i = 0; i < cnt.length; i++) {
			if (cnt[i] == count) {//如果该节点的经过次数等于路径的数目，则表明该节点是必经节点
				sum++;
			}
		}
		return sum - 1;
	}
}
