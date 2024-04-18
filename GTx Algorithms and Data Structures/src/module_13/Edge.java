package module_13;

public class Edge<T> implements Comparable<Edge<? super T>> {
	
	private Vertex<T> u;
	private Vertex<T> v;
	private int weight;
	
	public Edge(Vertex<T> u, Vertex<T> v, int weight) {
		if(u == null || v == null) {
			throw new IllegalArgumentException("Arguments cannpt be null.");
		}
		this.u = u;
		this.v = v;
		this.weight = weight;
	}
	
	public int getWeight() {
		return weight;
	}
	
	public Vertex<T> getU() {
		return u;
	}
	
	public Vertex<T> getV() {
		return v;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o != null && o instanceof Edge<?>) {
			Edge<?> e = (Edge<?>) o;
			return weight == e.weight && u.equals(e.u) && v.equals(e.v);
		} else {
			return false;
		}
	}
	
	@Override
	public int hashCode() {
		return u.hashCode() ^ v.hashCode() ^ weight;
	}

	@Override
	public int compareTo(Edge<? super T> e) {
		return weight - e.getWeight();
	}
	
	@Override
	public String toString() {
		return "Edge from " + u + " to " + v + " with weight " + weight;
	}

}
