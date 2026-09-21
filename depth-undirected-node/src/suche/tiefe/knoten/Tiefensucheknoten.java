package suche.tiefe.knoten;

import graph.Graph;
import graph.Doppelgraph;
import java.util.ArrayList;
import liste.Liste;

// Tiefensuche. Gib nur die Reihe von Knoten aus.

public class Tiefensucheknoten {

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
    public static int[] tiefensucheknoten(Doppelgraph dg, int anfangknoten) {

	ArrayList<Integer> gesucht = new ArrayList<Integer>();
	ArrayList<Integer> zulaufen = new ArrayList<Integer>();

	// Anfang
	zulaufen.add(anfangknoten);

	while (zulaufen.size() > 0) {
	    int naechste = zulaufen.remove(zulaufen.size() - 1);
	    gesucht.add(naechste);
	    ArrayList<Integer> nachbarn = dg.nachbar.get(naechste);
	    for (int nachbar : nachbarn) {
		if (!gesucht.contains(nachbar) && !zulaufen.contains(nachbar)) {
		    zulaufen.add(nachbar);
		}
	    }
	}

	return Liste.nehmeArrayInt(gesucht);
    }
}
