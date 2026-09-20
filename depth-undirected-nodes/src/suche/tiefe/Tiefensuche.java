package suche.tiefe;

import graph.Graph;
import graph.Doppelgraph;
import java.util.ArrayList;
import liste.Liste;

public class Tiefensuche  {

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
    public static int[] tiefensuche(Doppelgraph dg, int anfangknoten) {

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
		    zusuchen.add(0, nachbar);
		}
	    }
	}

	return Liste.nehmeArrayInt(gesucht);
    }
}
