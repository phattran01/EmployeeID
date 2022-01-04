package graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DiGraphImpl implements DiGraph {

	private List<GraphNode> nodeList = new ArrayList<>();

	public Boolean addNode(GraphNode node) {
		if (getNode(node.getValue()) == null) {
			nodeList.add(node);
			return true;
		}
		return false;
	}

	@Override
	public Boolean setNodeValue(GraphNode node, String newNodeValue) {
		if (getNode(newNodeValue) == null) {
			GraphNode targetNode = getNode(node.getValue());
			targetNode.setValue(newNodeValue);
			return true;
		}

		return false;
	}

	@Override
	public Boolean addEdge(GraphNode fromNode, GraphNode toNode, Integer weight) {
		GraphNode targetFromNode = getNode(fromNode.getValue());
		GraphNode targetToNode = getNode(toNode.getValue());

		if (targetFromNode == null || targetToNode == null)
			return false;

		return targetFromNode.addNeighbor(targetToNode, weight);
	}

	@Override
	public GraphNode getNode(String nodeValue) {
		for (GraphNode thisNode : nodeList) {
			if (thisNode.getValue().equals(nodeValue))
				return thisNode;
		}
		return null;
	}

	@Override
	public String getNodeValue(GraphNode node) {
		return node.getValue();
	}

	@Override
	public List<GraphNode> getAdjacentNodes(GraphNode node) {
		return node.getNeighbors();
	}

	public List<GraphNode> getNodes() {
		return nodeList;
	}

	@Override
	public Integer getEdgeValue(GraphNode fromNode, GraphNode toNode) {

		return fromNode.getDistanceToNeighbor(toNode);
	}

	public int fewestHops(GraphNode fromNode, GraphNode toNode) {
		Set<GraphNode> visited = new HashSet<GraphNode>();
		int hops = 0;
		for (GraphNode adj : fromNode.getNeighbors()) {
			visited.add(adj);
			hops++;
			for (GraphNode n : adj.getNeighbors()) {
				visited.add(n);
				hops++;
			}
			for (GraphNode e : adj.getNeighbors()) {
				visited.add(e);
				hops++;
			}
			for (GraphNode f : adj.getNeighbors()) {
				visited.add(f);
				hops++;
			}
			for (GraphNode g : adj.getNeighbors()) {
				visited.add(g);
				hops++;
			}
		}
		return hops;
	}

	public int shortestPath(GraphNode fromNode, GraphNode toNode) {
		return 0;
	}

	@Override
	public Boolean hasCycles() {
		for (GraphNode n : nodeList) {
			if (nodeIsReachable(n, n))
				return true;
		}
		return false;
	}

	@Override
	public Boolean nodesAreAdjacent(GraphNode fromNode, GraphNode toNode) {

		if (fromNode.getNeighbors().contains(toNode))
			return true;
		return false;
	}

	@Override
	public Boolean nodeIsReachable(GraphNode fromNode, GraphNode toNode) {
		Set<GraphNode> reach = new HashSet<GraphNode>();
		reach.add(fromNode);

		while (!reach.contains(toNode)) {
			List<GraphNode> adj = getAdjacentNodes(fromNode);
			int u = 0;
			reach.addAll(adj);
			for (GraphNode p : adj) {
				reach.add(getAdjacentNodes(p).get(u));
			}
		}

		if (reach.contains(toNode))
			return true;
		return false;
	}

	@Override

	public Boolean removeNode(GraphNode node) {
		int previous = nodeList.indexOf(node) - 1;
		int next = nodeList.indexOf(node) + 1;
		removeEdge(nodeList.get(previous), node);
		removeEdge(node, nodeList.get(next));
		addEdge(nodeList.get(previous), nodeList.get(next),
				nodeList.get(previous).getDistanceToNeighbor(nodeList.get(next)));
		return null;
	}

	@Override
	public Boolean removeEdge(GraphNode fromNode, GraphNode toNode) {
		GraphNode targetFromNode = getNode(fromNode.getValue());
		GraphNode targetToNode = getNode(toNode.getValue());

		if (targetFromNode == null || targetToNode == null)
			return false;

		return targetFromNode.removeNeighbor(targetToNode);
	}

	@Override
	public Boolean setEdgeValue(GraphNode fromNode, GraphNode toNode, Integer newWeight) {
		removeEdge(fromNode, toNode);
		addEdge(fromNode, toNode, newWeight);
		return true;
	}
}
