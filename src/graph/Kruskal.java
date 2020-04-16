package graph;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import graph.UnionFind.UFNode;

public class Kruskal<T> {
	private final List<Edge<T>> edgeList;
	private final int n;//顶点数
	private Map<T, UFNode> pntAndNode = new HashMap<T, UFNode>();
	public int weight;//权重
	
	private Set<Edge<T>> set = new HashSet<Edge<T>>();
	public Set<Edge<T>> getT(){
		buildMST();
		return set;
	}
	
	public Kruskal(List<Edge<T>> list, int n) {
		this.edgeList = list;
		for (Edge<T> edge : list) {
			pntAndNode.put(edge.getStart(), new UnionFind.UFNode());
			pntAndNode.put(edge.getEnd(), new UnionFind.UFNode());
		}
		this.n = n;
	}
	
	public void buildMST() {
		int k = 0;
		Collections.sort(edgeList);
		for (Edge<T> e : edgeList) {
			UnionFind.UFNode x = (UnionFind.UFNode)pntAndNode.get(e.getStart());
			UnionFind.UFNode y = (UnionFind.UFNode)pntAndNode.get(e.getEnd());
			if (UnionFind.find(x) == UnionFind.find(y)) {
				continue;
			}
			UnionFind.union(x, y);
			set.add(e);
			k++;
			weight = e.getDistance();
			if (k == n - 1) {
				return;
			}
		}
	}
}
