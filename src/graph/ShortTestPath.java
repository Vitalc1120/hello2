package graph;

import java.util.HashSet;
import java.util.Set;

/**
 * 图的最短路径问题
 * @author Vitalc
 *
 */
public class ShortTestPath {
	private static final int[][] graph = {
			{0, 2, 5, 0, 0, 0, 0},
			{2, 0, 4, 6, 9, 0, 0},
			{5, 4, 0, 2, 0, 0, 0},
			{0, 6, 2, 0, 0, 1, 0},
			{0, 9, 0, 0, 0, 3, 5},
			{0, 0, 0, 1, 3, 0, 9},
			{0, 0, 0, 0, 5, 9, 0}
	};

	public static void main(String[] args) {
		int[] shortTestPath = shortTestPath(0);
		for (int i : shortTestPath) {
			System.out.print(i + " ");
		}
	}
	
	private static int[] prev;
	/**
	 * 优化后
	 * @param s
	 * @return
	 */
	@SuppressWarnings("unused")
	private static int[] shortestpath(int s) {
		//顶点个数
		int n = graph.length;
		//记录每个点的前驱
		prev = new int[n];
		//一定要初始化, 前驱为自身
		prev[s] = s;
		//记录s到各顶点的最短距离
		int[] d = new int[n];
		d[s] = 0;//距自己的距离为0
		//记录已经找到最短距离的顶点
		Set<Integer> set = new HashSet<Integer>();
		set.add(s);
		
		/*
		 * 第一步：直接可达的顶点，用距离初始化的d, d[s] = 0, 可直达的把距离记录下来作为特定值
		 */
		for (int i = 0; i < n; i++) {
			if (i != s && graph[s][i] == 0) {
				d[i] = Integer.MAX_VALUE;//不可直达的顶点, 先以最大值作为特定值
			}
			if (i != s && graph[s][i] > 0) {
				d[i] = graph[s][i];//可直达的顶点, 以直达距离作为特定值
				prev[i] = s;//可直达的点，其前驱是原点
			}
		}
		
		while (set.size() < n) {
			/*
			 * 第二步：从特定的距离表中找到最小值，这个值可以作为确定值
			 */
			int min = minIndex(d, set);
			set.add(min);
			if (set.size() == n) {
				break;
			}
			/*
			 * 第三步：看这个新确定的顶点的出度, 看看以源点出发是经过这个顶点到其邻居近还是直达更近, 如果更近的就更新
			 */
			for (int neighbor = 0; neighbor < d.length; neighbor++) {
				int cost = graph[min][neighbor];
				if (cost > 0 && d[neighbor] > d[min] + cost) {
					d[neighbor] = d[min] + cost;
					prev[neighbor] = min;//更新最近路后，需更新i这个点的前驱
				}
			}
		}
		
		
		return d;
	}

	/**
	 * 从未确定的点里找到最小的
	 * @param d
	 * @param set
	 * @return
	 */
	private static int minIndex(int[] d, Set<Integer> set) {
		int index = -1;
		int min = Integer.MIN_VALUE;
		for (int i = 0; i < d.length; i++) {
			if (!set.contains(i) && d[i] < min) {
				min = d[i];
				index = i;
			}
		}
		return index;
	}

	private static int[] shortTestPath(int s) {
		int n = graph.length;
		int[] d = new int[n];
		for (int i = 0; i < n; i++) {
			d[i] = Integer.MAX_VALUE;
		}
		d[s] = 0;
		while (true) {
			boolean update = false;
			for (int i = 0; i < n; i++) {
				if (d[i] == Integer.MAX_VALUE) {
					continue;
				}
				for (int j = 0; j < n; j++) {
					int cost = graph[i][j];
					if (cost > 0) {
						if (d[j] > d[i] + cost) {
							update = true;
							d[j] = d[i] + cost;
						}
					}
				}
			}
			if (!update) {
				break;
			}
		}
		return d;
	}
}
