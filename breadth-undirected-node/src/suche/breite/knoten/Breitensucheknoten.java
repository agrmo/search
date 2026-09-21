package suche.breite.knoten;

import graph.Graph;
import graph.Doppelgraph;
import java.util.ArrayList;
import java.util.LinkedList;
import liste.Liste;

// Nehme die Reihenfolge von Knoten von Britensuche.

public class Breitensucheknoten  {

    // Die Graph muss verdoppelt sein.
    public static int[] breitensucheknoten(Doppelgraph dg,
					   int anfangknoten) {

	ArrayList<Integer> gesehen = new ArrayList<Integer>();
	LinkedList<Integer> zulaufen = new LinkedList<Integer>();

	// Anfang
	zulaufen.add(anfangknoten);

	while (zulaufen.size() > 0) {
	    int naechste = zulaufen.remove(0);
	    gesehen.add(naechste);
	    ArrayList<Integer> nachbarn = dg.nachbar.get(naechste);
	    for (int nachbar : nachbarn) {
		if (!gesehen.contains(nachbar) && !zulaufen.contains(nachbar)) {
		    zulaufen.add(nachbar);
		}
	    }
	}

	return Liste.nehmeArrayInt(gesehen);
    }
}
