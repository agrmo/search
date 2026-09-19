package suche.dijkstra;

import graph.gewicht.Doppelgewichtgraph;
import graph.gewicht.Gewichtgraph;
import java.util.ArrayList;
import java.util.Arrays;
import welle.Welle;

public class Dijkstra  {

    // Führe den Dijkstra-Algorithmus angefangt mit dem
    // Anfangsknoten. Die Durchführung dieses Algorithmus ist wie eine
    // Welle aufgebaut. Die Welle geht vom Anfangspunkt aus, bis den
    // gesamten Graphen getreten ist.
    //
    // Problem: Der Graph muss nur einen Teil haben, weil der
    // Algorithmus beendet nur wenn die Welle so groß wie der Graph
    // ist.
    static int[] dijkstra(Doppelgewichtgraph dgg,
			  int anfangsknoten) {

	// Die Antwort des Algorithmus: eine Liste von Wegen für jeden Knoten.
	int[] wege = new int[dgg.nachbar.size()];

	// Am Anfang kennen wir den Weg zu jedem Knoten nicht.
	for (int i = 0; i < wege.length; i++) {
	    wege[i] = -1;
	}

	// Wir kennen nur den Weg zum Anfangspunkt: 0.
	wege[anfangsknoten] = 0;
	
	Welle w = new Welle(dgg);

	// Am Anfang anfängt die Welle mit nur einem Knoten.
	w.fuegeKnoten(anfangsknoten);

	// Während die Größe der Welle kleiner als der Graph
	// ist. i.e. während nicht alle Knoten getreten sind.
	while (w.groesse() < dgg.groesse()) {

	    // Nehme die leichteste Kante, die einen schon getretenen
	    // Knoten hat, und einen nicht getretenen Knoten hat.

	    System.out.println("Schritt gesehen " + w.gesehen.toString());
	    
	    // Nehme die Kante, die den kleinsten Weg zum neuen Knoten
	    // hält.
	    int[] kante = w.nehmeKleinstenWeg(wege);

	    System.out.println("Kleinster Weg " + Arrays.toString(kante));

	    // Füge den Knoten am Ende der Kante in der getretenen Menge.
	    int endKnoten = dgg.nachbar.get(kante[0]).get(kante[1]);
	    System.out.println("Füge " + endKnoten);
	    w.fuegeKnoten(endKnoten);

	    // Der Weg dem neuen Knoten ist der Weg zum kante[0]
	    // addiert mit dem Weg zum Endknoten.

	    int kanteGewicht = dgg.gewicht.get(kante[0]).get(kante[1]);
	    int weg = wege[kante[0]] + kanteGewicht;
	    
	    System.out.println("Füge Weg " + weg + " für den Knoten " + endKnoten);
	    
	    wege[endKnoten] = weg;
	}

	return wege;
    }
}
