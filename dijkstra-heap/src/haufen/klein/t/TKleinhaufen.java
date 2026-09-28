package haufen.klein.t;

import haufen.Haufen;
import java.util.ArrayList;

// Ein Binärbaum, worin jedes Elter kleiner ist.
public class TKleinhaufen<T> {

    // Der Haufen selbst.
    public ArrayList<Integer> liste;

    // Die Partnerzahlen. Die sind nur Partner der Werte jedes Knotens.
    public ArrayList<T> partner;

    // Am Anfang ist der Haufen leer.
    public TKleinhaufen() {
    	this.liste = new ArrayList<Integer>();
	this.partner = new ArrayList<T>();
    }

    void tausche(int i, int j) {
	int izahl = liste.get(i);
	liste.set(i, liste.get(j));
	liste.set(j, izahl);

	T ipartner = partner.get(i);
	partner.set(i, partner.get(j));
	partner.set(j, ipartner);
    }

    // Verhaufe die Zahl nach oben (wenn sie zu klein ist).
    //
    // Gib den neuen Index dieses Knotens aus.
    public int verhaufenoben(int index) {

	int zahl = liste.get(index);
	int elter = Haufen.elter(liste, index);
	int elterzahl = liste.get(elter);

	if (elterzahl > zahl) {
	    tausche(index, elter);
	    return verhaufenoben(elter);
	}

	return index;
    }

    // Verhaufe die Zahl nach unten (wenn sie groß ist).
    void verhaufenunten(int index) {

	int n = liste.size();

	if (2 * (index + 1) > n) {
	    // Der Knoten steht schon an der letzten Zeile des Baumes.
	    // Nichts zu tun.
	    return;
	}

	if (this.liste.size() < 1) {
	    // Es gibt nur einen Knoten im Haufen.
	    // Nichts zu tun.
	    return;
	}

	// Vielleicht gibt es nur einen Knoten im Graphen.
	// Deshalb gibt es beide links und rechts nicht.
	if (this.liste.size() < 2) {
	    // Nichts zu tun.	
	    return;
	}

	int indexwert = liste.get(index);
	int j;
	int jwert;
	
	if (2 * (index + 1) == n) {

	    // Nehme das Ende des Haufens.
	    j = liste.size() - 1;
	    jwert = liste.get(j);
	    
	} else if (Haufen.rechtsindex(index) >= liste.size()) {

	    // Es gibt nur ein Kind.
	    //
	    //                o
	    //               / \
	    //          links   nichts
	    //
	    // Nehme das Kind.

	    j = Haufen.linksindex(index);
	    jwert = liste.get(j);

	} else {


	    // Es gibt zwei Kinder.
	    //
	    //                o
	    //               / \
	    //          links   rechts
	    //
	    // Nehme das Kind mit kleinerem Wert.

	    int linksindex = Haufen.linksindex(index);
	    int linkswert = liste.get(linksindex);
	    int rechtsindex = Haufen.rechtsindex(index);
	    int rechtswert = liste.get(rechtsindex);

	    if (linkswert < rechtswert) {
		j = linksindex;
		jwert = linkswert;
	    } else {
		j = rechtsindex;
		jwert = rechtswert;
	    }
	}

	if (jwert < indexwert) {
	    tausche(index, j);
	    verhaufenunten(j);
	}
    }

    // Füge die Zahl in dem Haufen.
    // Die Größe der Liste wird eine Stelle kleiner.
    //
    // Gib die neue Stelle der Zahl im Haufen aus.
    public int fuege(int zahl, T p) {

	int index = this.liste.size();
	this.liste.add(zahl);
	this.partner.add(p);
	return this.verhaufenoben(index);
    }

    // Lösche die Zahl aus dem Haufen.
    // Die Größe der Liste wird eine Stelle großer.
    //
    // 1. Tausche i mit der letzten Zahl der Liste
    // 2. Lösche die letzte Zahl
    // 3. Verhaufen nach unten.
    //
    public void loesche(int index) {
	int endindex = liste.size() - 1;
	tausche(index, endindex);
	liste.remove(endindex);
	partner.remove(endindex);
	verhaufenunten(index);
    }
}
