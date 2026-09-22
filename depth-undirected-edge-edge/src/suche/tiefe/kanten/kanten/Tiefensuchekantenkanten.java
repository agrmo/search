package suche.tiefe.kanten.kanten;

import graph.Graph;
import graph.Doppelgraph;
import java.util.ArrayList;
import java.util.HashSet;
import liste.Liste;

// Tiefensuche. Gib nur die Reihe von Kanten aus.

public class Tiefensuchekantenkanten {

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
    public static int[][] suche(Doppelgraph dg, int anfangknoten) {

	ArrayList<int[]> kanten = new ArrayList<int[]>();
	HashSet<Integer> gesehen = new HashSet<Integer>();
	ArrayList<int[]> zulaufen = new ArrayList<int[]>();
	
	// Anfang
	// Füge alle die Kanten des Anfangknotens
	for (int anfangnachbar : dg.nachbar.get(anfangknoten)) {
	    zulaufen.add(new int[] {anfangknoten, anfangnachbar});
	}

	while (zulaufen.size() > 0) {

	    int[] naechste = zulaufen.remove(zulaufen.size() - 1);
	    kanten.add(naechste);
	    gesehen.add(naechste[0]);
	    
	    ArrayList<Integer> nachbarn = dg.nachbar.get(naechste[1]);
	    for (int nachbar : nachbarn) {
		if (!gesehen.contains(nachbar)) {
		    zulaufen.add(new int[] {naechste[1], nachbar});
		}
	    }
	}

	return Liste.nehmeArrayListArrayInteger(kanten);
    }
}
