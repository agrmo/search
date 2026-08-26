package graph;

import java.util.ArrayList;

// In dem eifanchen Graph ist jede Kante nicht verdoppelt.
// z.B.
// 0: [1]
// 1: []
//
// Dieser Graph besitzt eine Kante, und diese Kante ist nur einmal in
// den Listen bezeichnet. Doch besitzt der Knoten 1 eine
// Kante. Manchmal wollen wir alle Kanten unmittelbar in ihre Liste
// stehen.
//
// z.B. ein:
// 0: [1]
// 1: []
// aus:
// 0: [1]
// 1: [0]
//
// Baue solche Struktur auf.
public class Doppelgraph extends Graph {

    public Doppelgraph(Graph ein) {
	this.betrag = ein.betrag;

	// Achtung: Wir addieren einen Zeiger! Wir nehmen an, daß der
	// ursprüngliche Graph ein nicht mehr bearbeitet wird.
	this.nachbar = ein.nachbar;

	// Die eigehende Nachbarschaftsliste ist genau gleich wie der
	// eingehende Graph. D.i. die Speicherdaten sind gleich. Nun
	// verdoppele jede Kante.
	
	for (int i = 0; i < this.nachbar.size(); i++) {
	    ArrayList<Integer> knoten = this.nachbar.get(i);

	    // Für jeden Knoten, setzen seine Kanten in den anderen
	    // Knoten ein. 
	    for (int j = 0; j < knoten.size(); j++) {

		/*
		  Diese Kante, j, konnte die ursprüngliche Kante oder
		  die verdoppelte Kante sein.
		  
		  Beispiel:
		  Anfang:
		  0: []
                  1: [2]
                  2: [0]
                  
                  Schritt: [1,2]: Setze ein: Von: 2 bis: 1

		  Schritt: [2,0]: Setze ein: Von: 0 bis: 2

		  Schritt: [2,1]:
		  Beide Kanten [2,1] und [1,2] stehen schon im Graphen.
                  Setze nicht ein: Von: 2 bis: 1

		  Ende:
                  0: [2]
                  1: [2]
                  2: [0, 1]

		  Prüfe ob die Kante schon in der Nachbarschaftsliste
		  steht.
		 */

		if (!this.nachbar.get(knoten.get(j)).contains(i)) {
		    this.nachbar.get(knoten.get(j)).add(i);
		}
	    }
	}
    }
}
