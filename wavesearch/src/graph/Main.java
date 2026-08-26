package graph;

/*
  javac src/graph/*.java -d classes \
  && java -cp classes graph.Main
*/

public class Main {
    
    static void beispielzwei() {
	/*
	  Darstellung:

	  0   1
           \ /
	    2
	    
	*/
	int[][] paare = {{1,2},{2,0}};
	int n = 3;
	Graph g = new Graph(paare, n);
    }

    static void beispieldrei() {
	// Mach eine Doppelgraph.
	int[][] paare = {{1,2},{2,0}};
	int betrag = 3;
	Graph g = new Graph(paare, 3);
	Doppelgraph dg = new Doppelgraph(g);
    }

    static void beispielvier() {

	// Mache eine Graph, aber eine Kante ist zweimal in den Paaren
	// geschrieben ([1,2], [2,1]).
	
	int[][] paare = {{1,2},{2,0},{2,1}};
	int betrag = 3;
	Graph g = new Graph(paare, 3);

	// "Die Kante 2, 1 schon existiert."
    }
    
    public static void main(String[] args) {
	beispielvier();
    }
}
