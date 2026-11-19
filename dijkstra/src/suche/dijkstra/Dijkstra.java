package suche.dijkstra;

import druck.liste.Listedrucker;
import liste.Liste;
import graph.gewicht.Doppelgewichtgraph;
import haufen.Haufen;
import haufen.klein.eins.Einskleinhaufen;
import java.util.ArrayList;
import java.util.HashSet;
import liste.Zweiliste;

public class Dijkstra {

    // Gebe eine Liste aus, die zeigt, was die Wege sind.
    // Gebe eine Liste aus, die zeigt, wer die Eltern sind.
    public static Zweiliste suche(Doppelgewichtgraph dgg, int anfangknoten) {

        // haufen.liste = wege
        // haufen.eins = knoten
        Einskleinhaufen haufen = new Einskleinhaufen();
	
        // Die Liste mit Größe V, die zeigt, was der Weg zu jedem Knoten ist.
        int[] wege = new int[dgg.groesse()];

        // Liste, die zeigt, wer das Elter jedes Knotens ist.
        int[] eltern = new int[dgg.groesse()];

        // Die Stelle jedes Knotens im Haufen.
        int[] stellen = new int[dgg.groesse()];

        for (int i = 0; i < stellen.length; i++) {
            stellen[i] = -1;
        }
        
        // Anfang
        // Der Anfangknoten ist nicht wesentlich der Knoten mit Index 0.
        // Der Weg zum Anfangknoten ist 0.
        // Das Elter des Anfangsknotens ist der Knoten selbst.
        // Der Anfangsknoten steht im Haufen.
        // Haufen: [weg, knoten]
        haufen.fuege(0, anfangknoten);
        stellen[anfangknoten] = 0;
        eltern[anfangknoten] = anfangknoten;
	    
        while (haufen.liste.size() > 0) {

            // Nehme den nächsten Knoten mit dem kleinsten Weg
            int naechsterweg = haufen.liste.get(0);
	    
            // Der nächste Knoten
            int naechsterknoten = haufen.eins.get(0);

            System.out.println(naechsterknoten + " " + naechsterweg);

            // Verarbeite die Nachbarn
            for (int i = 0; i < dgg.nachbar.get(naechsterknoten).size(); i++) {

                // Der Nachbar
                int nachbar = dgg.nachbar.get(naechsterknoten).get(i);
                System.out.println("nb " + nachbar);

                // Das Gewicht dieser Kante
                int gewicht = dgg.gewicht.get(naechsterknoten).get(i);
		    
                // Der neue Weg zum Nachbar
                int wegneu = naechsterweg + gewicht;

                // Ist der Nachbar schon im Haufen?
                if (stellen[nachbar] < 0) {

                    // Der Nachbar hat zurzeit keinen Weg zu ihm.
                    // [weg, knoten]
                    wege[nachbar] = wegneu;
                    eltern[nachbar] = naechsterknoten;
                    System.out.println("wn " + wegneu + " " + nachbar);
                    int stelle = haufen.fuege(wegneu, nachbar);
                    stellen[nachbar] = stelle;
                    System.out.println(Listedrucker.druckeliste(haufen.liste));
                    System.out.println(Listedrucker.druckeliste(haufen.eins));

                } else {
                    
                    // Der Nachbar hat ja einen Weg. Vergleiche die Wege.

                    if (wegneu < haufen.liste.get(stellen[nachbar])) {

                        // Der neue Weg zum Nachbar ist besser.
                        wege[nachbar] = wegneu;
                        eltern[nachbar] = naechsterknoten;
                        haufen.liste.set(stellen[nachbar], wegneu);
                        int stelle = haufen.verhaufenoben(stellen[nachbar]);
                        stellen[nachbar] = stelle;
                    }
                }
            }

            // Nach Verfügung lösche den Knoten vom Haufen.
            haufen.loesche(0);

            for (int i = 0; i < stellen.length; i++) {
                if (stellen[i] > 0) {
                    stellen[i] -= 1;
                }
            }
        }

        return new Zweiliste(wege, eltern);
    }
}
