package module_13;

import java.util.List;
//import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
//import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class GraphAlgorithms {
	
	// Breadth First Search.
	public static <T> List<Vertex<T>> bfs(Vertex<T> start, Graph<T> graph) {
		Set<Vertex<T>> visitedSet = new HashSet<>();
		Queue<Vertex<T>> queue = new LinkedList<>();
		// List to be returned. 
		List<Vertex<T>> visitedList = new LinkedList<>();
		
		visitedSet.add(start);
		queue.add(start);
		
		visitedList.add(start);
		
		while(!queue.isEmpty()) {
			Vertex<T> currV = queue.remove();
			List<VertexDistance<T>> neighbors = graph.getAdjList().getOrDefault(currV, new ArrayList<>());
			
			for(VertexDistance<T> currN : neighbors) {
				// adjacent vertex.
				Vertex<T> adjVertex = currN.getVertex();
				
				if(!visitedSet.contains(adjVertex)) {
					visitedSet.add(adjVertex);
					queue.add(adjVertex);
					
					visitedList.add(adjVertex);
				}
			}
		}
		
		return visitedList;
	}
	
	// Depth Breadth Search.
	public static <T> List<Vertex<T>> dfs(Vertex<T> start, Graph<T> graph) {
		Set<Vertex<T>> visitedSet = new HashSet<>();
		// List to be returned. 
		List<Vertex<T>> visitedList = new LinkedList<>();
		// recursive implementation. 
		dfsR(start, graph, visitedSet, visitedList);
		
		return visitedList;
	}
	
	/* Depth Breadth Search Helper Method. 
	v is vertex.
	g is graph.
	vs is visited set.
	vl is visited list. */
	private static <T> void dfsR(Vertex<T> v, Graph<T> g, Set<Vertex<T>> vs, List<Vertex<T>> vl) {
		// add to visited set.
		vs.add(v);
		// add to visited list.
		vl.add(v);
		
		// get the list of adjacent neighbors. 
		List<VertexDistance<T>> neighbors = g.getAdjList().getOrDefault(v, new ArrayList<>());
		
		for(VertexDistance<T> currN : neighbors) {
			// adjacent vertex.
			Vertex<T> adjVertex = currN.getVertex();
			
			if(!vs.contains(adjVertex)) {
				dfsR(adjVertex, g, vs, vl);
			}
		}
	}

	// Prim's Algorithm.
	public static <T> Set<Edge<T>> prims(Vertex<T> start, Graph<T> graph) {
		return null;
	}
}
