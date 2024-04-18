package module_13;

public class VertexDistance<T> implements Comparable<VertexDistance<? super T>> {
	
	private final Vertex<T> vertex;
	private final int distance;
	
	public VertexDistance(Vertex<T> vertex, int distance) {
		this.vertex = vertex;
		this.distance = distance;
	}
	
	public Vertex<T> getVertex() {
		return vertex;
	}
	
	public int getDistance() {
		return distance;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o != null && o instanceof VertexDistance<?>) {
			VertexDistance<?> e = (VertexDistance<?>) o;
			return distance == e.distance && vertex.equals(e.vertex);
		} else {
			return false;
		}
	}
	
	@Override
	public int hashCode() {
		return vertex.hashCode() ^ distance;
	}

	@Override
	public int compareTo(VertexDistance<? super T> pair) {
		return this.getDistance() - pair.getDistance();
	}
	
	@Override
	public String toString() {
		return "Pair with vertex " + vertex + " and distance " + distance; 
	}

}
