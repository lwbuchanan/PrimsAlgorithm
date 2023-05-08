import java.util.ArrayList;

import org.junit.Test;

public class Testing {
    @Test
    public void CP4_10() {
    	Graph<Integer> g = new Graph<>();
    	for (int i = 0; i < 5; i++) {
    		g.addNode(i);
    	}
    	g.addEdge(0, 1, 4);
    	g.addEdge(0, 2, 4);
    	g.addEdge(0, 3, 6);
    	g.addEdge(0, 4, 6);
    	g.addEdge(1, 2, 2);
    	g.addEdge(2, 3, 8);
    	g.addEdge(3, 4, 9);
    	
    	ArrayList<Graph<Integer>.Edge> al = new ArrayList<>();
    	al = g.primsGetMST(0);
    	System.out.println("CP4.10");
    	int sum = 0;
    	for (Graph<Integer>.Edge e : al) {
    		System.out.println(String.format("S: %d, C: %d, E: %d", e.getStart().getElement(), e.getCost(), e.getOther().getElement()));
    		sum += e.getCost();
    	}
    	System.out.println(sum);
    	System.out.println("\n");
    }
    
    @Test
    public void CP4_14() {
    	Graph<Integer> g = new Graph<>();
    	for (int i = 0; i < 5; i++) {
    		g.addNode(i);
    	}
    	g.addEdge(0, 2, 75);
    	g.addEdge(0, 1, 9);
    	g.addEdge(1, 4, 42);
    	g.addEdge(2, 3, 51);
    	g.addEdge(1, 3, 19);
    	g.addEdge(3, 4, 31);
    	
    	ArrayList<Graph<Integer>.Edge> al = new ArrayList<>();
    	al = g.primsGetMST(0);
    	System.out.println("CP4.14");
    	int sum = 0;
    	for (Graph<Integer>.Edge e : al) {
    		System.out.println(String.format("S: %d, C: %d, E: %d", e.getStart().getElement(), e.getCost(), e.getOther().getElement()));
    		sum += e.getCost();
    	}
    	System.out.println(sum);
    	System.out.println("\n");
    }
    
    @Test
    public void K5() {
    	Graph<Integer> g = new Graph<>();
    	for (int i = 0; i < 5; i++) {
    		g.addNode(i);
    	}
    	g.addEdge(0, 3, 13);
    	g.addEdge(0, 1, 24);
    	g.addEdge(0, 1, 22);
    	g.addEdge(0, 2, 13);
    	g.addEdge(1, 3, 13);
    	g.addEdge(1, 2, 22);
    	g.addEdge(1, 4, 13);
    	g.addEdge(2, 3, 19);
    	g.addEdge(2, 4, 14);
    	g.addEdge(3, 4, 19);
    	
    	ArrayList<Graph<Integer>.Edge> al = new ArrayList<>();
    	al = g.primsGetMST(0);
    	System.out.println("K5");
    	int sum = 0;
    	for (Graph<Integer>.Edge e : al) {
    		System.out.println(String.format("S: %d, C: %d, E: %d", e.getStart().getElement(), e.getCost(), e.getOther().getElement()));
    		sum += e.getCost();
    	}
    	System.out.println(sum);
    	System.out.println("\n");
    }
    
    @Test
    public void Rail() {
    	Graph<Integer> g = new Graph<>();
    	for (int i = 0; i < 10; i++) {
    		g.addNode(i);
    	}
    	for (int i = 0; i < 9; i++) {
    		g.addEdge(i, i+1, 10);
    	}
    	g.addEdge(1, 6, 8);
    	g.addEdge(1, 7, 13);
    	g.addEdge(2, 7, 8);
    	g.addEdge(2, 8, 13);
    	g.addEdge(3, 8, 8);
    	
    	ArrayList<Graph<Integer>.Edge> al = new ArrayList<>();
    	al = g.primsGetMST(0);
    	System.out.println("Rail");
    	int sum = 0;
    	for (Graph<Integer>.Edge e : al) {
    		System.out.println(String.format("S: %d, C: %d, E: %d", e.getStart().getElement(), e.getCost(), e.getOther().getElement()));
    		sum += e.getCost();
    	}
    	System.out.println(sum);
    	System.out.println("\n");
    }
    
    @Test
    public void Tessellation() {
    	Graph<Integer> g = new Graph<>();
    	for (int i = 0; i < 9; i++) {
    		g.addNode(i);
    	}
    	g.addEdge(0, 2, 12);
    	g.addEdge(0, 1, 8);
    	g.addEdge(1, 2, 13);
    	g.addEdge(1, 3, 25);
    	g.addEdge(1, 4, 9);
    	g.addEdge(2, 6, 21);
    	g.addEdge(2, 3, 14);
    	g.addEdge(3, 6, 12);
    	g.addEdge(3, 8, 16);
    	g.addEdge(3, 7, 12);
    	g.addEdge(3, 5, 8);
    	g.addEdge(3, 4, 20);
    	g.addEdge(4, 5, 19);
    	g.addEdge(5, 7, 11);
    	g.addEdge(6, 8, 11);
    	g.addEdge(7, 8, 9);
    	
    	ArrayList<Graph<Integer>.Edge> al = new ArrayList<>();
    	al = g.primsGetMST(0);
    	System.out.println("Tesselation");
    	int sum = 0;
    	for (Graph<Integer>.Edge e : al) {
    		System.out.println(String.format("S: %d, C: %d, E: %d", e.getStart().getElement(), e.getCost(), e.getOther().getElement()));
    		sum += e.getCost();
    	}
    	System.out.println(sum);
    	System.out.println("\n");
    }
}
