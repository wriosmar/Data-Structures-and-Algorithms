package module_13;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GraphAlgorithms_Tester {

	public static void main(String[] args) {
		Set<Vertex<String>> testV = new HashSet<Vertex<String>>();
		Vertex<String> A = new Vertex<String>("A");
		Vertex<String> B = new Vertex<String>("B");
		Vertex<String> C = new Vertex<String>("C");
		Vertex<String> D = new Vertex<String>("D");
		Vertex<String> E = new Vertex<String>("E");
		Vertex<String> F = new Vertex<String>("F");
		Vertex<String> G = new Vertex<String>("G");
		Vertex<String> H = new Vertex<String>("H");
		
		testV.add(A);
		testV.add(B);
		testV.add(C);
		testV.add(D);
		testV.add(E);
		testV.add(F);
		testV.add(G);
		testV.add(H);
		
		Set<Edge<String>> testE = new HashSet<Edge<String>>();
		testE.add(new Edge<String>(H, G, 3));
		testE.add(new Edge<String>(G, H, 3));
		
		testE.add(new Edge<String>(G, F, 5));
		testE.add(new Edge<String>(F, G, 5));
		
		testE.add(new Edge<String>(F, D, 2));
		testE.add(new Edge<String>(D, F, 2));
		
		testE.add(new Edge<String>(F, C, 1));
		testE.add(new Edge<String>(C, F, 1));
		
		testE.add(new Edge<String>(D, E, 7));
		testE.add(new Edge<String>(E, D, 7));
		
		testE.add(new Edge<String>(E, C, 7));
		testE.add(new Edge<String>(C, E, 7));
		
		testE.add(new Edge<String>(C, D, 1));
		testE.add(new Edge<String>(D, C, 1));
		
		testE.add(new Edge<String>(C, B, 8));
		testE.add(new Edge<String>(B, C, 8));
		
		testE.add(new Edge<String>(C, A, 8));
		testE.add(new Edge<String>(A, C, 8));
		
		testE.add(new Edge<String>(A, B, 6));
		testE.add(new Edge<String>(B, A, 6));
		
		Graph<String> testG = new Graph<String>(testV, testE);
		
		List<Edge<String>> testPrims = GraphAlgorithms.prims(H, testG);
		
		for(Edge<String> edge : testPrims) {
			System.out.println(edge.toString());
		}

	}

}
