package suche.baum.binaer;

import baum.binaer.Binaerbaum;
import java.util.ArrayList;
import java.util.HashMap;

// Suche durch einem binärschen Baum nach einer Zahl.
public class Binaerbaumtiefensuche {

    // Gegeben eine Abbildung und eine gefundene Zielzahl, berechne
    // den Pfad zurück zum Ursprung.
    public static int[] nehmepfad(HashMap<Integer,Integer> elter,
				  int ziel) {

	ArrayList<Integer> pfad = new ArrayList<Integer>();
	int jetzt = ziel;

	// Während die Zahl hat noch ein Elter, sind wir noch nicht am
	// Ursprung. Geh weiter.
	while (elter.containsKey(jetzt)) {	    
	    pfad.add(jetzt);
	    jetzt = elter.get(jetzt);
	}

	// Und endlich füge den Ursprung in der Liste.
	pfad.add(jetzt);

	int size = pfad.size();
	int[] pfadarray = new int[size];

	// Der Pfad ist vom Ende bis Anfang geschrieben.
	// Wir sollen die Liste umkehren.
	
	for (int i = 0; i < size; i++) {
	    pfadarray[size - 1 - i] = pfad.get(i);
	}
	
	return pfadarray;
    }

    // Gib den Pfad zu der Zahl im binärschen Baum aus.
    // Nehmen wir an, daß jede Zahl im Baum nur einmal benutzt ist.
    public static int[] suche(Binaerbaum bb, int ziel) {

	ArrayList<Binaerbaum> zusuchen = new ArrayList<Binaerbaum>();
	HashMap<Integer,Integer> elter = new HashMap<Integer,Integer>();

	// Grundfall
	// Der Ursprung hat kein Elter.
	zusuchen.add(bb);

	while (zusuchen.size() > 0) {

	    Binaerbaum naechste = zusuchen.remove(0);
	    
	    if (naechste.wert == ziel) {
		return nehmepfad(elter, ziel);
	    }

	    if (naechste.links != null) {
		elter.put(naechste.links.wert, naechste.wert);
		zusuchen.add(naechste.links);
	    }

	    if (naechste.rechts != null) {
		elter.put(naechste.rechts.wert, naechste.wert);
		zusuchen.add(naechste.rechts);
	    }
	    
	}

	// Nicht gefunden. Gib eine leere Liste aus.
	return new int[] {};
    }
}
