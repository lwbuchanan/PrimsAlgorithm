import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.PriorityQueue;

public class Graph<T> {
	private Hashtable<T, Node> nodes;


	public ArrayList<Edge> primsGetMST(T start) {
		if (start == null) throw new NullPointerException(); // 1 time
		ArrayList<Edge> al = new ArrayList<>(); // 1 time
		PriorityQueue<Edge> pq = new PriorityQueue<>(); // 1 time

		Node startPoint = nodes.get(start); // 1 time
		if (startPoint == null) return null; // 1 time

		pq.addAll(startPoint.neighbors); // e*log(e) where e is the number of edges one the startPoint
		HashMap<Node, Boolean> knowns = new HashMap<>(); // 1 time
		knowns.put(startPoint, true); // 1 time
		while (!pq.isEmpty()) { // runs a total of e times where e is the number of edges
			Edge next = pq.poll(); // log(n) time
			if (knowns.get(next.otherNode) != null) continue; // 1 time

			al.add(next); // Amortized O(1)
			pq.addAll(next.otherNode.neighbors); // e*log(e) where e is the number of edges on the current node
			knowns.put(next.otherNode, true); // 1 time
		}
		
		return al;
	}

	public Graph(){
		nodes = new Hashtable<T, Node>();
	}
	
	public class Node {
		private T element;
		private ArrayList<Edge> neighbors;
		
		public Node(T e){
			element = e;
			neighbors = new ArrayList<Edge>();
		}
		
		public void addEdge(T e, int cost) {
			Node otherNode = nodes.get(e);
			neighbors.add(new Edge(this, otherNode, cost));
		}
		
		public T getElement() {
			return element;
		}
		
	}
	
	protected class Edge implements Comparable<Edge> {
		private Node otherNode;
		private Node start;
		private int cost;
		
		public Edge(Node start, Node n, int c){
			this.start = start;
			otherNode = n;
			cost = c;
		}
		
		public Node getStart() {
			return start;
		}
		
		public Node getOther() {
			return otherNode;
		}
		
		public int getCost() {
			return cost;
		}

		@Override
		public int compareTo(Edge o) {
			return this.cost - o.cost;
		}
	}

	public boolean addNode(T e) {
		nodes.put(e, new Node(e));
		return true;
	}
	
	public boolean addEdge(T e1, T e2, int cost) {
		if (!nodes.containsKey(e1) && !nodes.containsKey(e2)) return false;
		nodes.get(e1).addEdge(e2, cost);
		nodes.get(e2).addEdge(e1, cost);
	    return true;
	}


}
