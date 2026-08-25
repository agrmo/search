package welle;

import graph.gewicht.Doppelgewichtgraph;
import java.util.HashSet;
import druck.liste.Listedrucker;
import java.util.ArrayList;

// Eine Welle ist eine Menge von Knoten eines Graphen, die in einer
// unbestimmten Richtung ausgehen.
//
// Was ist der Nutzen? Der Dijkstra Algorithmus erzeugt eine Welle,
// die von einem Anfangspunkt ausgeht.
//
// Es ist total möglich, die Welle in zwei Orten zu erzeugen. D.i.
//
//     x---o
//     |
//     o      o--x----o
//
// Wobei x sind in der gesehenen Menge, und o sind noch night
// gesehen. D.i. x sind in die Welle, und o sind nicht in die Welle.
//
public class Welle {
    
    public Doppelgewichtgraph graph;
    public HashSet<Integer> gesehen;

    public Welle(Doppelgewichtgraph graph) {
	this.graph = graph;
	this.gesehen = new HashSet<Integer>();
    }
    
    // Nehme eine Liste von allen ausgehenden Kanten von der Welle.
    // 
    // Die Welle wird nicht hinein wiederlaufen.
    // 
    // ein:
    // - Doppelgewichtgraph
    // - Die Welle: eine Liste von gesehenen Knoten 
    // aus:
    // - Liste von Kanten ([von, bis])
    public ArrayList<int[]> ausgehendeKanten() {

	ArrayList<int[]> aus = new ArrayList<int[]>();

	// Für jeden gesehenen Knoten.
	for (int knoten : this.gesehen) {

	    // Für jeden Nachbarn des Knoten.
	    ArrayList<Integer> nachbarn = this.graph.nachbar.get(knoten);

	    for (int i = 0; i < nachbarn.size(); i++) {

		// Nehme den Nachbar.
		int nachbar = nachbarn.get(i);

		// Falls der Endknoten noch nicht getreten ist, füge
		// die Kante ein.
		
		if (!this.gesehen.contains(nachbar)) {

		    // Füge den Index des beiden Knotens.
		    // Knoten ist ein Index, i ist auch ein Index.
		    aus.add(new int[] {knoten, i});
		}
	    }
	}

	return aus;
    }

    // Nehme die billigste Kante, die noch nicht gesehen ist, aber mit
    // einem gesehenen Knoten verbunden ist.
    //
    // Einfach der einzige wichtige Schritt des Dijkstra-Algorithmus.
    //
    public int[] nehmeBilligsteKante() {

	// Nehme eine Liste der ausgehenden Kanten.
	ArrayList<int[]> ak = this.ausgehendeKanten();

	System.out.println("ak " + Listedrucker.drucke(ak));

	// Grundfall
	// Der Index der billigste Kante in ak.
	int index = 0;

	// Für jede ausgehende Kante
	for (int i = 0; i < ak.size(); i++) {

	    // Nehme das Gewicht einer der ausgehenden Kanten.
	    int neu = this.graph.gewicht.get(ak.get(i)[0]).get(ak.get(i)[1]);
	    int kleinste = this.graph.gewicht.get(ak.get(index)[0]).get(ak.get(index)[1]);

	    // Falls das neue Gewicht leichter als das billigste Gewicht
	    // ist, dann wechseln wir den Index.
	    if (neu < kleinste) {
		index = i;
	    }
	}

	// Daraus nehmen wir nur die billigste Kante.
	return ak.get(index);
    }

    // Füge einen neuen Knoten in die Welle hinein.
    public void fuegeKnoten(int knoten) {
	this.gesehen.add(knoten);
    }

    // Die Größe der Welle.
    public int groesse() {
	return this.gesehen.size();
    }
}
