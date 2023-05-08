import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.PriorityQueue;

public class Graph<T> {
	private Hashtable<T, Node> nodes;


	public ArrayList<Edge> primsGetMST(T start) {
		if (start == null) throw new NullPointerException();
		ArrayList<Edge> al = new ArrayList<>();
		PriorityQueue<Edge> pq = new PriorityQueue<>();

		Node startPoint = nodes.get(start);
		if (startPoint == null) return null;

		pq.addAll(startPoint.neighbors);
		HashMap<Node, Boolean> knowns = new HashMap<>();
		knowns.put(startPoint, true);
		while (!pq.isEmpty()) {
			Edge next = pq.poll();
			if (knowns.get(next.otherNode) == true) continue;

			al.add(next);
			pq.addAll(next.otherNode.neighbors);
			knowns.put(next.otherNode, true);
		}
		
		return al;
	}

	public Graph(){
		nodes = new Hashtable<T, Node>();
	}
	
	private class Node {
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
	    return true;
	}


}
