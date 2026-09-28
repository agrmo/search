package suche.dijkstra.haufen;

import ganz.vektor.GZweivektor;
import graph.gewicht.Doppelgewichtgraph;
import haufen.klein.t.TKleinhaufen;
import java.util.ArrayList;
import liste.Zweiliste;

public class Dijkstra {

    // Gebe eine Liste aus, die zeigt, was die Wege sind.
    // Gebe eine Liste aus, die zeigt, wer die Eltern sind.
    public static Zweiliste suche(Doppelgewichtgraph dgg, int anfangknoten) {
	
	TKleinhaufen<GZweivektor> haufen = new TKleinhaufen<GZweivektor>();

	// Die Liste mit Größe V, die zeigt, was der Weg zu jedem Knoten ist.
	int[] wege = new int[dgg.groesse()];

	// Die Liste mit Größe V, die zeigt, wer das Elter jedes Knotens ist.
	int[] eltern = new int[dgg.groesse()];

	// Die Liste mit Größe V, die die Stelle jedes Knotens im Haufen zeigt.
	int[] stellen = new int[dgg.groesse()];
	for (int i = 0; i < stellen.length; i++)  {
	    stellen[i] = -1;
	}

	// Anfang
	// Der Anfangknoten ist nicht wesentlich der Knoten mit Index 0.
	// Der Weg zum Anfangknoten ist 0.
	// Das Elter des Anfangsknotens ist der Knoten selbst.
	// [weg, [knoten, elter]]
	haufen.fuege(0, new GZweivektor(anfangknoten, anfangknoten));
	stellen[anfangknoten] = 0;
	    
	while (haufen.liste.size() > 0) {

	    // Nehme den nächsten Knoten mit dem kleinsten Weg
	    int naechsterweg = haufen.liste.get(0);
	    GZweivektor naechst = haufen.partner.get(0);

	    // naechst.eins ist der nächste Knoten
	    int naechsterknoten = naechst.eins;

	    // naechst.zwei ist das Elter des nächsten Knotens
	    int naechsteselter = naechst.zwei;

	    // Füge den Weg zum Knoten und das Elter des Knotens
	    wege[naechsterknoten] = naechsterweg;
	    eltern[naechsterknoten] = naechsteselter;
		
	    // Verarbeite die Wege zu den Nachbarknoten
	    for (int i = 0; i < dgg.nachbar.get(naechsterknoten).size(); i++) {

		// Der Nachbar
		int nachbar = dgg.nachbar.get(naechsterknoten).get(i);

		// Das Gewicht dieser Kante
		int gewicht = dgg.gewicht.get(naechsterknoten).get(i);

		// Der neue Weg zum Nachbar
		int wegneu = wege[naechsterknoten] + gewicht;

		// Ist der Nachbar schon im Haufen?
		if (stellen[nachbar] < 0) {

		    // Der Nachbar hat zurzeit keinen Weg zu ihm.
		    int stelle = haufen.fuege(wegneu,
					      new GZweivektor(nachbar,
							      naechsterknoten));
		    stellen[nachbar] = stelle;
		    
		} else {

		    // Vergleiche die Wege.
		    if (wegneu < haufen.liste.get(stellen[nachbar])) {

			// Der neue Weg zum Nachbar ist besser.
			haufen.liste.set(stellen[nachbar], wegneu);

			// Sortiere den Knoten im Haufen noch mal.
			int stelleneu = haufen.verhaufenoben(stellen[nachbar]);

			// Danach steht der Nachbar irgendwo anders.
			stellen[nachbar] = stelleneu;
		    }
		}
	    }

	    // Nach Verfügung lösche den Knoten vom Haufen.
	    haufen.loesche(0);

	    // Leider müssen wir alle Stellen mit Eins subtrahieren.
	    for (int i = 0; i < stellen.length; i++) {
		if (stellen[i] > 0) {
		    stellen[i] -= 1;
		}
	    }
	}

	return new Zweiliste(wege, eltern);
    }
}
