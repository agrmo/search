package suche.tiefe.kanten;

import graph.Graph;
import graph.Doppelgraph;
import java.util.Arrays;
import druck.liste.Listedrucker;

// suche.tiefe.kanten.Main

public class Main {

    public static void beispieleins() {
	int[][] paare = {{1,2},{2,0}};
	int groesse = 3;
	Graph g = new Graph(paare, groesse);
	Doppelgraph dg = new Doppelgraph(g);

	int[][] gesehen = Tiefensuchekanten.tiefensuchekanten(dg, 1);
	System.out.println(Listedrucker.drucke(gesehen));	
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
	int[][] gesehenEins = Tiefensuchekanten.tiefensuchekanten(dg, 9);
	System.out.println(Listedrucker.drucke(gesehenEins));

	// Soll [7, 3, 4, 1, 0] geben.
	int[][] gesehenZwei = Tiefensuchekanten.tiefensuchekanten(dg, 7);
	System.out.println(Listedrucker.drucke(gesehenZwei));

	// Soll [1, 7, 3, 0, 4] geben.
	int[][] gesehenDrei = Tiefensuchekanten.tiefensuchekanten(dg, 1);
	System.out.println(Listedrucker.drucke(gesehenDrei));

	// Soll [6,2,8] oder [6,8,2] geben.
	int[][] gesehenVier = Tiefensuchekanten.tiefensuchekanten(dg, 6);
	System.out.println(Listedrucker.drucke(gesehenVier));

	// Soll [8,2,6] oder [8,6,2] geben.
	int[][] gesehenFuenf = Tiefensuchekanten.tiefensuchekanten(dg, 8);
	System.out.println(Listedrucker.drucke(gesehenFuenf));
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

	int[][] gesehenEins = Tiefensuchekanten.tiefensuchekanten(dg, 1);
	System.out.println(Listedrucker.drucke(gesehenEins));
    }
    
    public static void main(String[] args) {
	beispieldrei();
    }
}
