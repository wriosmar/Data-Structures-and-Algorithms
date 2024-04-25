package module_13;

import java.util.List;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class GraphAlgorithms {
	
	// WRONG
	public static <T> List<Vertex<T>> bfs(Vertex<T> start, Graph<T> graph) {
		Set<Vertex<T>> VS = new HashSet<>();
		Queue<Vertex<T>> Q = new LinkedList<>();
		
		List<Vertex<T>> visited = new LinkedList<>();
		
		VS.add(start);
		Q.add(start);
		
		visited.add(start);
		
		while(!Q.isEmpty()) {
			Vertex<T> currV = Q.remove();
			List<VertexDistance<T>> neighbors = graph.getAdjList().getOrDefault(currV, new ArrayList<>());
			
			for(VertexDistance<T> currN : neighbors) {
				if(VS.contains(currN.getVertex())) {
					VS.add(currN.getVertex());
					Q.add(currN.getVertex());
					
					visited.add(currN.getVertex());
				}
			}
		}
		
		return visited;
	}
	
	public static <T> List<Vertex<T>> dfs(Vertex<T> start, Graph<T> graph) {
		Set<Vertex<T>> VS = new HashSet<>();
		
		List<Vertex<T>> visited = new LinkedList<>();
		
		dfsR(start, graph, VS, visited);
		
		return visited;
	}
	
	private static <T> void dfsR(Vertex<T> v, Graph<T> graph, Set<Vertex<T>> vs, List<Vertex<T>> vl) {
		vs.add(v);
		
		vl.add(v);
		
		List<VertexDistance<T>> neighbors = graph.getAdjList().getOrDefault(v, new ArrayList<>());
		
		for(VertexDistance<T> currN : neighbors) {
			if(!vs.contains(currN.getVertex())) {
				dfsR(currN.getVertex(), graph, vs, vl);
			}
		}
	}

}
