package suche.tiefe.kanten;

import graph.Graph;
import graph.Doppelgraph;
import java.util.ArrayList;
import liste.Liste;

// Tiefensuche. Gib nur die Reihe von Kanten aus.

public class Tiefensuchekanten {

    // Der Graph muss verdoppelt sein.
    //
    //   o       o   o
    //    \     /   /
    //     o   o---o---o
    //      \ /
    //       o---o----o
    //  o   / \   \
    //  |  /   o   \
    //  o--         o
    //
    // aus: [[von, bis], [von, bis], ...]
    public static int[][] tiefensuchekanten(Doppelgraph dg, int anfangknoten) {

	ArrayList<int[]> kanten = new ArrayList<int[]>();
	ArrayList<Integer> gesucht = new ArrayList<Integer>();
	ArrayList<Integer> zusuchen = new ArrayList<Integer>();

	// Anfang
	zusuchen.add(anfangknoten);

	while (zusuchen.size() > 0) {
	    int naechste = zusuchen.remove(0);
	    gesucht.add(naechste);
	    ArrayList<Integer> nachbarn = dg.nachbar.get(naechste);
	    for (int nachbar : nachbarn) {
		if (!gesucht.contains(nachbar) && !zusuchen.contains(nachbar)) {
		    kanten.add(new int[] {naechste, nachbar});
		    zusuchen.add(0, nachbar);
		}
	    }
	}

	return Liste.nehmeArrayListArrayInteger(kanten);
    }
}
