package suche.tiefe.kanten.kanten;

import graph.Graph;
import graph.Doppelgraph;
import java.util.Arrays;
import druck.liste.Listedrucker;

// suche.tiefe.kanten.kanten.Main

public class Main {

    public static void beispieleins() {
	int[][] paare = {{1,2},{2,0}};
	int groesse = 3;
	Graph g = new Graph(paare, groesse);
	Doppelgraph dg = new Doppelgraph(g);

	int[][] gesehen = Tiefensuchekantenkanten.suche(dg, 1);
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
	int[][] gesehenEins = Tiefensuchekantenkanten.suche(dg, 9);
	System.out.println(Listedrucker.drucke(gesehenEins));

	// Soll [7, 3, 4, 1, 0] geben.
	int[][] gesehenZwei = Tiefensuchekantenkanten.suche(dg, 7);
	System.out.println(Listedrucker.drucke(gesehenZwei));

	// Soll [1, 7, 3, 0, 4] geben.
	int[][] gesehenDrei = Tiefensuchekantenkanten.suche(dg, 1);
	System.out.println(Listedrucker.drucke(gesehenDrei));

	// Soll [6,2,8] oder [6,8,2] geben.
	int[][] gesehenVier = Tiefensuchekantenkanten.suche(dg, 6);
	System.out.println(Listedrucker.drucke(gesehenVier));

	// Soll [8,2,6] oder [8,6,2] geben.
	int[][] gesehenFuenf = Tiefensuchekantenkanten.suche(dg, 8);
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

	// Verstehen Sie diesen Punkt ganz klar. Die Reihe von Kanten
	// sind gesammelt pro Kante. Also nur eine Kanten von 1 werden
	// durchgelaufen. Also es ist ja Tiefensuche, und die Kanten
	// sind nicht gesammelt. Das heißt "Tiefensuche pro Kante" und
	// nicht "Tiefensuche pro Knoten."

	int[][] paare = {{1,7},{1,2},{1,3},{1,6},{1,8},{1,9},
			 {2,5},{3,4},{6,12},{9,11},{8,10},{7,13}};
	
	int groesse = 14;
	Graph g = new Graph(paare, groesse);
	Doppelgraph dg = new Doppelgraph(g);

	int[][] gesehenEins = Tiefensuchekantenkanten.suche(dg, 1);
	System.out.println(Listedrucker.drucke(gesehenEins));
    }
    
    public static void main(String[] args) {
	beispieldrei();
    }
}
