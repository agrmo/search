package suche.haufen;

import haufen.klein.zwei.Zweikleinhaufen;
import haufen.Haufen;
import haufen.klein.Kleinhaufen;

// Suche durch einem Kleinhaufen.
//
// Es gibt verschiedene Wege, das Suchen durch einem Haufen zu führen.
//
// Das "findeeins" benutzt einen Zweikleinhaufen, d.i. ein Kleinhaufen
// verbunden bei jedem Knoten zwei Zahlen. Die Funktion findeeins
// findet den Knoten mit der gegebenen Zahl als die erste Zahl.
public class Haufensuche {

    // Finde den Knoten mit dem gegebenen Wert im gegebenen Kleinhaufen.
    // Gib den Index in der Haufenliste aus.
    public static int findewert(Kleinhaufen haufen, int wert) {

	// Anfang
	int index = 0;

	System.out.println("groesse " + haufen.liste.size());
	System.out.println("suche " + wert);

	while (haufen.liste.get(index) != wert) {

	    System.out.println("index " + index + " wert " + haufen.liste.get(index));

	    // Suche für den Wert.
	    //
	    //        o
	    //       / \
	    //      o   o
	    //

	    if (wert > haufen.liste.get(Haufen.linksindex(index))) {

		// Links ist kleiner.
		System.out.println("links");
		index = Haufen.linksindex(index);
		
	    } else {

		// Rechts ist größer.
		System.out.println("links");
		index = Haufen.rechtsindex(index);
	    }
	}

	// Gefunden?
	System.out.println("Gefunden? index " + index + " wert " + haufen.liste.get(index));
	return index;
    }
    
    // Finde den Knoten mit dem gegebenen Wert mit der Zahl in der
    // ersten Stelle.
    //
    // Finde den Index des Knotens mit dem Weg im Haufen.
    // (mit der Annahme, daß der Knoten sicher im Haufen steht)
    // (wir kennen ja schon, was der Weg (Wert) zum Knoten ist)
    public static int findeeins(Zweikleinhaufen haufen, int wert, int zahl) {

	// Anfang
	int index = 0;

	System.out.println("groesse " + haufen.liste.size());
	System.out.println("suche " + wert + " " + zahl);

	while (haufen.eins.get(index) != zahl) {

	    System.out.println("index " + index + " eins " + haufen.eins.get(index) + " wert " + haufen.liste.get(index));

	    // Suche für den Knoten.
	    //
	    //        o
	    //       / \
	    //      o   o
	    //

	    if (wert < haufen.liste.get(index)) {

		// Links ist kleiner.
		System.out.println("links");
		index = Haufen.linksindex(index);
		
	    } else {

		// Rechts ist größer.
		System.out.println("links");
		index = Haufen.rechtsindex(index);
	    }
	}

	// Gefunden?
	System.out.println("Gefunden? index " + index + " zahl " + haufen.eins.get(index));
	return index;
    }
}
