package module_13;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Graph<T> {
	
	private Set<Vertex<T>> vertices;
	private Set<Edge<T>> edges;
	private Map<Vertex<T>, List<VertexDistance<T>>> adjList;
	
	public Graph(Set<Vertex<T>> vertices, Set<Edge<T>> edges) {
		if(vertices == null || edges == null) {
			throw new IllegalArgumentException("Arguments cannot be null.");
		}
		
		this.vertices = new HashSet<>(vertices);
		this.edges = new HashSet<>(edges);
		adjList = new HashMap<>();
		
		for(Vertex<T> v : vertices) {
			adjList.put(v, new ArrayList<>());
		}
		for(Edge<T> e : edges) {
			if(adjList.containsKey(e.getU())) {
				adjList.get(e.getU()).add(new VertexDistance<>(e.getV(), e.getWeight()));
			} else {
				throw new IllegalArgumentException("Vertex set must contain all vertices of the graph.");
			}
		}
	}
	
	public Set<Vertex<T>> getVertices() {
		return vertices;
	}
	
	public Set<Edge<T>> getEdges() {
		return edges;
	}
	
	public Map<Vertex<T>, List<VertexDistance<T>>> getAdjList() {
		return adjList;
	}

}
