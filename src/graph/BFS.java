package graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Point：队列
 * BFS 最少步数走出迷宫问题
 * @author Vitalc
 *
 */
public class BFS {
	
	static int[][] map = {
			{0,0,1,1,1,1,1,1},
			{1,0,0,1,1,1,1,1},
			{1,1,0,0,1,1,1,1},
			{1,1,1,0,0,1,1,1},
			{1,1,1,1,0,0,1,1},
			{1,1,1,1,1,0,0,1},
			{1,1,1,1,1,1,0,0},
			{1,1,1,1,1,1,1,0}
	};
	static int[][] newmap = map;
	public static void main(String[] args) {
		Node node = bfs(0, 0, 7, 7);
		if (node != null) {
			System.out.println(node.depth);
		}
	}
	
	private static Node bfs(int x1, int y1, int x2, int y2) {
		Node node = new Node(x1, y1, 0);
		Queue<Node> q = new LinkedList<Node>();
		q.add(node);
		while (!q.isEmpty()) {
			Node poll = q.poll();
			if (poll.x == x2 && poll.y == y2) {
				return poll;
			}
			if (poll.x - 1 > 0 && map[poll.x - 1][poll.y] != 1 && newmap[poll.x - 1][poll.y] != 1) {	
				q.add(new Node(poll.x - 1, poll.y, poll.depth + 1));
				newmap[poll.x - 1][poll.y] = 1;
			}
			
			if (poll.x + 1 < map.length && map[poll.x + 1][poll.y] != 1 && newmap[poll.x + 1][poll.y] != 1) {
				q.add(new Node(poll.x + 1, poll.y, poll.depth + 1));
				newmap[poll.x + 1][poll.y] = 1;
			}
			
			if (poll.y - 1 > 0 && map[poll.x][poll.y - 1] != 1 && newmap[poll.x][poll.y - 1] != 1) {
				q.add(new Node(poll.x, poll.y - 1, poll.depth + 1));
				newmap[poll.x][poll.y - 1] = 1;
			}
			
			if (poll.y + 1 < map[0].length && map[poll.x][poll.y + 1] != 1 && newmap[poll.x][poll.y + 1] != 1) {
				q.add(new Node(poll.x, poll.y + 1, poll.depth + 1));
				newmap[poll.x][poll.y + 1] = 1;
			}
		}
		return null;
	}
	
	static class Node {
		int x;
		int y;
		int depth = 0;
		
		public Node(int x, int y, int depth) {
			this.x = x;
			this.y = y;
			this.depth = depth;
		}
	}
}
