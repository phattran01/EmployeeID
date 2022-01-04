package graph;

public class GraphTester {

	private static DiGraph graph;

	public static void main(String[] args) {

		DiGraph graph = new DiGraphImpl();

		GraphNode n1 = new GraphNode("1");
		GraphNode n2 = new GraphNode("2");
		GraphNode n3 = new GraphNode("3");
		GraphNode n4 = new GraphNode("4");
		GraphNode n5 = new GraphNode("5");
		GraphNode n6 = new GraphNode("6");

		graph.addNode(n1);
		graph.addNode(n2);
		graph.addNode(n3);
		graph.addNode(n4);
		graph.addNode(n5);
		graph.addNode(n6);

		graph.addEdge(n1, n2, 1);
		graph.addEdge(n1, n3, 2);
		graph.addEdge(n2, n3, 3);
		graph.addEdge(n3, n4, 4);
		graph.addEdge(n3, n6, 5);
		graph.addEdge(n4, n5, 6);
		graph.addEdge(n5, n6, 7);

		System.out.println(graph.getNodes());

		graph.nodeIsReachable(n1, n6);

		graph.hasCycles();

		graph.fewestHops(n5, n6);

		graph.shortestPath(n1, n6);

	}

}
