package graph.gewicht;

import java.util.ArrayList;

// Ein Gewichtgraph ist eine Art Graph, wobei jede Kante ein Gewicht
// besitzt.
public class Gewichtgraph {

    // Genau eine Nachbarschaftsliste. Aber dieser Variable zeigt das
    // Gewicht nicht.
    public ArrayList<ArrayList<Integer>> nachbar;

    // Dieser Variable zeigt die Gewichte jeder Kante.
    //
    // z.B.
    // nachbar[1][2] = 3, also Knoten 1 ist mit Knoten 3 verbunden.
    // gewicht[1][2] = 5, also die Kente hat Gewicht 5.
    //
    public ArrayList<ArrayList<Integer>> gewicht;

    // Mache einen leeren Gewichtgraph.
    public Gewichtgraph() {
	this.nachbar = new ArrayList<ArrayList<Integer>>();
	this.gewicht = new ArrayList<ArrayList<Integer>>();
    }

    // Mache einen Gewichtgraph mit am Anfang n Knoten.
    public Gewichtgraph(int n) {
	this.nachbar = new ArrayList<ArrayList<Integer>>();
	this.gewicht = new ArrayList<ArrayList<Integer>>();
	
	for (int i = 0; i < n; i++) {
	    this.nachbar.add(new ArrayList<Integer>());
	    this.gewicht.add(new ArrayList<Integer>());
	}
    }

    // Mache einen Gewichtgraph mit n Knoten und füge alle Kanten in
    // die Nachbarschaftsliste ein.
    public Gewichtgraph(int n, int[][] kanten) {

	this.nachbar = new ArrayList<ArrayList<Integer>>();
	this.gewicht = new ArrayList<ArrayList<Integer>>();
	
	for (int i = 0; i < n; i++) {
	    this.nachbar.add(new ArrayList<Integer>());
	    this.gewicht.add(new ArrayList<Integer>());
	}
	
	for (int i = 0; i < kanten.length; i++) {
	    this.neueKante(kanten[i][0], kanten[i][1], kanten[i][2]);
	}
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

	// Füge das Gewicht.

	this.gewicht.get(von).add(gewicht);
    }

    // Die Größe des Graphen.
    int groesse() {
	return this.nachbar.size();
    }
}
