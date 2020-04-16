package graph;

import java.util.HashSet;
import java.util.Set;

public class UnionFind {
	public static UFNode find(UFNode x) {
		UFNode p = x;
		Set<UFNode> path = new HashSet<UFNode>();
		while (p.parent != null) {
			path.add(p);
			p = p.parent;
		}
		for (UFNode ppp : path) {
			ppp.parent = p;
		}
		return p;
	}
	
	public static void union(UFNode x, UFNode y) {
		find(y).parent = find(x);
	}
	
	public static class UFNode {
		private UFNode parent;
	}
}
