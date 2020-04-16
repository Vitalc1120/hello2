package graph;

import java.util.ArrayList;
import java.util.List;

/**
 * 邻接表 表示 图
 * @author Vitalc
 *
 */
public class GraphNode_AL {
	public int val;
	private List<GraphNode_AL> neighbors;
	
	public boolean checked = false;
	
	public GraphNode_AL(int val) {
		this.val = val;
	}
	
	public GraphNode_AL getNeighbor(int i) {
		return neighbors.get(i);
	}
	
	public void add(GraphNode_AL node) {
		if (this.neighbors == null)
			this.neighbors = new ArrayList<>();
		this.neighbors.add(node);
	}
	
	public int size() {
		return this.neighbors.size();
	}
}
