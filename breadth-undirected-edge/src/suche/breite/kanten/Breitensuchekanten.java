package suche.breite.kanten;

import graph.Graph;
import graph.Doppelgraph;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.HashSet;
import liste.Liste;

// Nehme die Reihenfolge von Kanten von Breitensuche.
// aus: [[von, bis], ...]
public class Breitensuchekanten  {

    // Die Graph muss verdoppelt sein.
    public static int[][] breitensuchekanten(Doppelgraph dg,
					   int anfangknoten) {

	HashSet<Integer> gesehen = new HashSet<Integer>();
	ArrayList<int[]> kanten = new ArrayList<int[]>();
	LinkedList<Integer> zulaufen = new LinkedList<Integer>();
	
	zulaufen.add(anfangknoten);

	while (zulaufen.size() > 0) {
	    int naechste = zulaufen.remove(0);
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
