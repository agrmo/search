package welle;

import druck.graph.gewicht.Gewichtgraphdrucker;
import druck.liste.Listedrucker;
import graph.gewicht.Doppelgewichtgraph;
import graph.gewicht.Gewichtgraph;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/*
  javac -d classes $(find src -type f) \
  && java -cp classes welle.Main
*/

public class Main {

    static void beispieleins() {
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

	HashSet<Integer> gesehen = new HashSet<Integer>();
	gesehen.add(7);

	Doppelgewichtgraph dgg = new Doppelgewichtgraph(gg);
	Welle w = new Welle(dgg);
	ArrayList<int[]> ak = w.ausgehendeKanten();
	
	System.out.println(Listedrucker.drucke(ak));

	// [[7,3],[7,0],[7,1]]
	// Funktioniert!
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
	Doppelgewichtgraph dgg = new Doppelgewichtgraph(gg);
	Welle w = new Welle(dgg);
	w.fuegeKnoten(7);
	w.fuegeKnoten(3);
	ArrayList<int[]> ak = w.ausgehendeKanten();
	
	System.out.println(Listedrucker.drucke(ak));
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
	Doppelgewichtgraph dgg = new Doppelgewichtgraph(gg);
	System.out.println(Gewichtgraphdrucker.drucke(dgg));
	Welle w = new Welle(dgg);
	w.fuegeKnoten(7);
	w.fuegeKnoten(3);
	int[] bk = w.nehmeBilligsteKante();
	System.out.println(Arrays.toString(bk));

	// Aus: [3, 0]
    }
    
    static void beispielvier() {
	/*
	  Darstellung:
	  
	    2   5      1
	  1 - 7 - 3 ------4   
	      \   |        \
	      4\  |2        \3 
	        \ | 1     3  \   3
	         0-----8------2------5
		  \   /        \
		  9\ /1         \2
		    10           \
		                  6
		                   \
				    \3
				     \
				      9
		 
	*/

	int n = 11;
	int[][] kanten = {{1,7,2},{7,3,5},{3,4,1},
			  {7,0,4},{3,0,2},{4,2,3},
			  {0,8,1},{8,2,3},{2,5,3},
			  {0,10,9},{8,10,1},{2,6,2},
			  {6,9,3}};
	
	Gewichtgraph gg = new Gewichtgraph(n, kanten);
	Doppelgewichtgraph dgg = new Doppelgewichtgraph(gg);
	System.out.println(Gewichtgraphdrucker.drucke(dgg));

	Welle w = new Welle(dgg);
	w.fuegeKnoten(0);
	w.fuegeKnoten(8);
	ArrayList<int[]> ak = w.ausgehendeKanten();
	System.out.println(Listedrucker.drucke(ak));

	// [[0,1],[0,2],[0,3],[8,0],[8,1]]
    }

    static void beispielfuenf() {
	/*
	  Darstellung:
	  
	    2   5      1
	  1 - 7 - 3 ------4   
	      \   |        \
	      4\  |2        \3 
	        \ | 1     3  \   3
	         0-----8------2------5
		  \   /        \
		  9\ /1         \2
		    10           \
		                  6
		                   \
				    \3
				     \
				      9
				      
	*/

	int n = 11;
	int[][] kanten = {{1,7,2},{7,3,5},{3,4,1},
			  {7,0,4},{3,0,2},{4,2,3},
			  {0,8,1},{8,2,3},{2,5,3},
			  {0,10,9},{8,10,1},{2,6,2},
			  {6,9,3}};
	
	Gewichtgraph gg = new Gewichtgraph(n, kanten);
	Doppelgewichtgraph dgg = new Doppelgewichtgraph(gg);
	System.out.println(Gewichtgraphdrucker.drucke(dgg));

	Welle w = new Welle(dgg);
	w.fuegeKnoten(1);
	w.fuegeKnoten(7);
	w.fuegeKnoten(0);
	w.fuegeKnoten(8);
	w.fuegeKnoten(10);

	int[] kante = w.nehmeBilligsteKante();

	System.out.println("Billigste: " + Arrays.toString(kante));
    }

    public static void main(String[] args) {
	beispielfuenf();
    }
}
