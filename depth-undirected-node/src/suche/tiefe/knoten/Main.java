package suche.tiefe.knoten;

import graph.Graph;
import graph.Doppelgraph;
import java.util.Arrays;

// suche.tiefe.knoten.Main

public class Main {

    public static void beispieleins() {
	int[][] paare = {{1,2},{2,0}};
	int groesse = 3;
	Graph g = new Graph(paare, groesse);
	Doppelgraph dg = new Doppelgraph(g);

	int[] gesehen = Tiefensucheknoten.tiefensucheknoten(dg, 1);
	System.out.println(Arrays.toString(gesehen));	
    }

    public static void beispielzwei() {
	//
	// Darstellung:
	// 
	// 9
	// 
	// 1 - 7 - 3 - 4
	//     \   |
	//      \  |
	//       \ |
	//        0
	//
	// 6 - 2 - 8
	// |       |
	// ---------
	//

	// Es gibt 3 Teile.
	
	int[][] paare = {{1,7},{7,3},{3,4},{3,0},{7,0},{6,2},{2,8},{6,8}};
	int groesse = 10;
	Graph g = new Graph(paare, groesse);
	Doppelgraph dg = new Doppelgraph(g);

	// Soll 9 geben.
	int[] gesehenEins = Tiefensucheknoten.tiefensucheknoten(dg, 9);
	System.out.println(Arrays.toString(gesehenEins));

	// Soll [7, 3, 4, 1, 0] geben.
	int[] gesehenZwei = Tiefensucheknoten.tiefensucheknoten(dg, 7);
	System.out.println(Arrays.toString(gesehenZwei));

	// Soll [1, 7, 3, 0, 4] geben.
	int[] gesehenDrei = Tiefensucheknoten.tiefensucheknoten(dg, 1);
	System.out.println(Arrays.toString(gesehenDrei));

	// Soll [6,2,8] oder [6,8,2] geben.
	int[] gesehenVier = Tiefensucheknoten.tiefensucheknoten(dg, 6);
	System.out.println(Arrays.toString(gesehenVier));

	// Soll [8,2,6] oder [8,6,2] geben.
	int[] gesehenFuenf = Tiefensucheknoten.tiefensucheknoten(dg, 8);
	System.out.println(Arrays.toString(gesehenFuenf));
    }

    public static void beispieldrei() {
	//
	//           5       4
	//            \     /
	//             2   3
	//              \ /
	//          13-7-1-6-12
	//              / \
	//             8   9
	//            /     \
	//           10      11
	//

	// Soll etwas sinnvolles geben...
	int[][] paare = {{1,7},{1,2},{1,3},{1,6},{1,8},{1,9},
			 {2,5},{3,4},{6,12},{9,11},{8,10},{7,13}};
	
	int groesse = 14;
	Graph g = new Graph(paare, groesse);
	Doppelgraph dg = new Doppelgraph(g);

	int[] gesehenEins = Tiefensucheknoten.tiefensucheknoten(dg, 1);
	System.out.println(Arrays.toString(gesehenEins));
    }
    
    public static void main(String[] args) {
	beispieldrei();
    }
}
