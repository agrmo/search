package graph.gewicht;

import java.util.ArrayList;
import graph.gewicht.Gewichtgraph;

// Ein Gewichtgraph, durchgeführt mit einer Nachbarschaftsliste, aber
// auch mit der Arbeit gemacht, daß beide Kanten [a,b] und [b,a] in
// der Nachbarschaftsliste stehen.
//
// Die unterliegende Datenstruktur ist gleich wie Gewichtgraph. Wir
// haben nur die Daten leight verändert.
public class Doppelgewichtgraph {

    public ArrayList<ArrayList<Integer>> nachbar;
    public ArrayList<ArrayList<Integer>> gewicht;

    // Genauso ähnlich wie Doppelgraph aber verdopple auch das Gewicht
    // in der anderen Richtung.
    public Doppelgewichtgraph(Gewichtgraph gg) {

	this.nachbar = gg.nachbar;
	this.gewicht = gg.gewicht;
	
	for (int i = 0; i < this.nachbar.size(); i++) {
	    ArrayList<Integer> knoten = this.nachbar.get(i);

	    for (int j = 0; j < knoten.size(); j++) {
		if (!this.nachbar.get(knoten.get(j)).contains(i)) {

		    // Füge die Kante in die andere Richtung.
		    this.nachbar.get(knoten.get(j)).add(i);

		    // Füge das Gewicht in die andere Richtung.
		    this.gewicht.get(knoten.get(j)).add(this.gewicht.get(i).get(j));
		}
	    }
	}
    }

    // Die Anzahl der Knoten dieses Graphen.
    public int groesse() {
	return this.nachbar.size();
    }

    // Mache einen neuen Knoten, und gib den Index des Knotens aus.
    int neueKnoten() {

	this.nachbar.add(new ArrayList<Integer>());
	this.gewicht.add(new ArrayList<Integer>());

	int index = this.nachbar.size() - 1;
	return index;
    }

    // Füge die Kante
    // von: Die Kante von
    // bis: Die Kante bis
    // gewicht: Das Gewicht der Kante
    void neueKante(int von, int bis, int gewicht) {
	
	if (von >= this.nachbar.size()) {
	    System.out.println("von " + von + " ist zu groß.");
	}
	
	if (bis >= this.nachbar.size()) {
	    System.out.println("bis " + bis + " ist zu groß.");
	}
	
	if (this.nachbar.get(von).contains(bis)) {
	    System.out.println("[" + von + "," + bis + "] schon existiert.");
	}
	
	if (this.nachbar.get(bis).contains(von)) {
	    System.out.println("[" + bis + "," + von + "] schon existiert.");
	}
	
	// Füge die Kante.

	this.nachbar.get(von).add(bis);
	this.nachbar.get(bis).add(von);

	// Füge das Gewicht.

	this.gewicht.get(von).add(gewicht);
	this.gewicht.get(bis).add(gewicht);
    }
}
