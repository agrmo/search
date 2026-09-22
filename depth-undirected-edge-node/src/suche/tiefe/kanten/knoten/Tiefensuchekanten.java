package suche.tiefe.kanten.knoten;

import graph.Graph;
import graph.Doppelgraph;
import java.util.ArrayList;
import java.util.HashSet;
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
	HashSet<Integer> gesehen = new HashSet<Integer>();
	ArrayList<Integer> zulaufen = new ArrayList<Integer>();
	
	// Anfang
	zulaufen.add(anfangknoten);

	while (zulaufen.size() > 0) {
	    int naechste = zulaufen.remove(zulaufen.size() - 1);
	    gesehen.add(naechste);
	    ArrayList<Integer> nachbarn = dg.nachbar.get(naechste);
	    for (int nachbar : nachbarn) {
		if (!gesehen.contains(nachbar) && !zulaufen.contains(nachbar)) {
		    kanten.add(new int[] {naechste, nachbar});
		    zulaufen.add(nachbar);
		}
	    }
	}

	return Liste.nehmeArrayListArrayInteger(kanten);
    }
}
