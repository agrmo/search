package suche.breite.kanten;

import graph.Graph;
import graph.Doppelgraph;
import druck.liste.Listedrucker;

// suche.breite.kanten.Main

public class Main {

    public static void beispieleins() {
	int[][] paare = {{1,2},{2,0}};
	int groesse = 3;
	Graph g = new Graph(paare, groesse);
	Doppelgraph dg = new Doppelgraph(g);

	int[][] kanten = Breitensuchekanten.suche(dg, 1);
	System.out.println(Listedrucker.drucke(kanten));	
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

	// Es gibt 3 Teile.
	
	int[][] paare = {{1,7},{7,3},{3,4},{3,0},{7,0},{6,2},{2,8},{6,8}};
	int groesse = 10;
	Graph g = new Graph(paare, groesse);
	Doppelgraph dg = new Doppelgraph(g);

	// Soll 9 geben.
	int[][] kantenEins = Breitensuchekanten.suche(dg, 9);
	System.out.println(Listedrucker.drucke(kantenEins));

	// Soll [7, 1, 0, 3, 4] geben.
	int[][] kantenZwei = Breitensuchekanten.suche(dg, 7);
	System.out.println(Listedrucker.drucke(kantenZwei));

	// Soll [1, 7, 3, 0, 4] geben.
	int[][] kantenDrei = Breitensuchekanten.suche(dg, 1);
	System.out.println(Listedrucker.drucke(kantenDrei));
	
	// Soll [6,2,8] oder [6,8,2] geben.
	int[][] kantenVier = Breitensuchekanten.suche(dg, 6);
	System.out.println(Listedrucker.drucke(kantenVier));

	// Soll [8,2,6] oder [8,6,2] geben.
	int[][] kantenFuenf = Breitensuchekanten.suche(dg, 8);
	System.out.println(Listedrucker.drucke(kantenFuenf));
    }

    public static void beispieldrei() {
	//
	//          5       4
	//           \     /
	//            2   3
	//             \ /
	//         13-7-1-6-12
	//             / \
	//            8   9
	//           /     \
	//          10      11
	//

	int[][] paare = {{1,7},{1,2},{1,3},{1,6},{1,8},{1,9},
			 {2,5},{3,4},{6,12},{9,11},{8,10},{7,13}};
	
	int groesse = 14;
	Graph g = new Graph(paare, groesse);
	Doppelgraph dg = new Doppelgraph(g);

	int[][] kanten = Breitensuchekanten.suche(dg, 1);
	System.out.println(Listedrucker.drucke(kanten));
    }
    
    public static void main(String[] args) {
	beispieldrei();
    }
}
