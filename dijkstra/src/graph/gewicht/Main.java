package graph.gewicht;

import druck.graph.gewicht.Gewichtgraphdrucker;

/*
  javac -d classes $(find src -type f) \
  && java -cp classes graph.gewicht.Main
*/

public class Main {
    
    static void beispieleins() {
	Gewichtgraph gg = new Gewichtgraph();
	gg.neueKnoten();
	gg.neueKnoten();
	gg.neueKante(0,1,5);
	System.out.println(Gewichtgraphdrucker.drucke(gg));
    }

    static void beispielzwei() {
	/*
	  Darstellung:
	  
	  9
	  
	    2   5   1
	  1 - 7 - 3 - 4
	      \   |
	      7\  |3
	        \ |
	         0
		 
	    9   2
	  6 - 2 - 8
	  |       |
	  ---------
	      8
	 */

	int n = 10;
	int[][] kanten = {{1,7,2},{7,3,5},{3,4,1},{3,0,3},
			  {7,0,7},{6,2,9},{2,8,2},{6,8,8}};
	
	
	Gewichtgraph gg = new Gewichtgraph(n, kanten);
        System.out.println(Gewichtgraphdrucker.drucke(gg));
    }

    static void beispieldrei() {
	/*
	  Darstellung:
	  
	  9
	  
	    2   5   1
	  1 - 7 - 3 - 4
	      \   |
	      7\  |3
	        \ |
	         0
		 
	    9   3
	  6 - 2 - 8
	  |       |
	  ---------
	      4
	*/

	int n = 10;
	int[][] kanten = {{1,7,2},{7,3,5},{3,4,1},{3,0,3},
			  {7,0,7},{6,2,9},{2,8,3},{6,8,4}};
	
	Gewichtgraph gg = new Gewichtgraph(n, kanten);
	Doppelgewichtgraph dgg = new Doppelgewichtgraph(gg);
	
        System.out.println(Gewichtgraphdrucker.drucke(dgg));

	/* aus:
	   0: [[3, 3], [7, 7]]
	   1: [[7, 2]]
	   2: [[8, 3], [6, 9]]
	   3: [[4, 1], [0, 3], [7, 5]]
	   4: [[3, 1]]
	   5: []
	   6: [[2, 9], [8, 4]]
	   7: [[3, 5], [0, 7], [1, 2]]
	   8: [[2, 3], [6, 4]]
	   9: []
	*/
    }
    
    public static void main(String[] args) {
	beispieldrei();
    }
}
