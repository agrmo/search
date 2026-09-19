package suche.breite;

import graph.Graph;
import graph.Doppelgraph;
import java.util.ArrayList;
import java.util.Arrays;
import liste.Liste;

public class Breitensuche  {

    // Die Graph muss verdoppelt sein.
    public static int[] breitensuche(Doppelgraph dg, int anfangknoten) {

	ArrayList<Integer> gesucht = new ArrayList<Integer>();
	ArrayList<Integer> zusuchen = new ArrayList<Integer>();
	
	zusuchen.add(anfangknoten);

	while (zusuchen.size() > 0) {
	    int naechste = zusuchen.remove(0);
	    gesucht.add(naechste);
	    ArrayList<Integer> nachbarn = dg.nachbar.get(naechste);
	    for (int nachbar : nachbarn) {
		if (!gesucht.contains(nachbar) && !zusuchen.contains(nachbar)) {
		    zusuchen.add(nachbar);
		}
	    }
	}

	return Liste.nehmeArrayInt(gesucht);
    }
}
