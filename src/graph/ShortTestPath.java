package graph;

import java.util.HashSet;
import java.util.Set;

/**
 * ͼ�����·������
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
	 * �Ż���
	 * @param s
	 * @return
	 */
	@SuppressWarnings("unused")
	private static int[] shortestpath(int s) {
		//�������
		int n = graph.length;
		//��¼ÿ�����ǰ��
		prev = new int[n];
		//һ��Ҫ��ʼ��, ǰ��Ϊ����
		prev[s] = s;
		//��¼s�����������̾���
		int[] d = new int[n];
		d[s] = 0;//���Լ��ľ���Ϊ0
		//��¼�Ѿ��ҵ���̾���Ķ���
		Set<Integer> set = new HashSet<Integer>();
		set.add(s);
		
		/*
		 * ��һ����ֱ�ӿɴ�Ķ��㣬�þ����ʼ����d, d[s] = 0, ��ֱ��İѾ����¼������Ϊ�ض�ֵ
		 */
		for (int i = 0; i < n; i++) {
			if (i != s && graph[s][i] == 0) {
				d[i] = Integer.MAX_VALUE;//����ֱ��Ķ���, �������ֵ��Ϊ�ض�ֵ
			}
			if (i != s && graph[s][i] > 0) {
				d[i] = graph[s][i];//��ֱ��Ķ���, ��ֱ�������Ϊ�ض�ֵ
				prev[i] = s;//��ֱ��ĵ㣬��ǰ����ԭ��
			}
		}
		
		while (set.size() < n) {
			/*
			 * �ڶ��������ض��ľ�������ҵ���Сֵ�����ֵ������Ϊȷ��ֵ
			 */
			int min = minIndex(d, set);
			set.add(min);
			if (set.size() == n) {
				break;
			}
			/*
			 * ���������������ȷ���Ķ���ĳ���, ������Դ������Ǿ���������㵽���ھӽ�����ֱ�����, ��������ľ͸���
			 */
			for (int neighbor = 0; neighbor < d.length; neighbor++) {
				int cost = graph[min][neighbor];
				if (cost > 0 && d[neighbor] > d[min] + cost) {
					d[neighbor] = d[min] + cost;
					prev[neighbor] = min;//�������·�������i������ǰ��
				}
			}
		}
		
		
		return d;
	}

	/**
	 * ��δȷ���ĵ����ҵ���С��
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
