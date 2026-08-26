package druck.graph.gewicht;

import graph.gewicht.Gewichtgraph;
import graph.gewicht.Doppelgewichtgraph;

public class Gewichtgraphdrucker {

    public static String drucke(Gewichtgraph gg) {

	/*
	  Beispiel:

	  0: [[1, 5]]
	  1: []

	  Der Graph hat Größe zwei und eine Kante.
	  Die Kante hat Gewicht 5.
	*/
	
	StringBuilder sb = new StringBuilder();
	for (int i = 0; i < gg.nachbar.size(); i++) {
	    sb.append(i);
	    sb.append(": [");

	    for (int j = 0; j < gg.nachbar.get(i).size(); j++) {
		if (j != 0) {
		    sb.append(", [");
		} else {
		    sb.append("[");
		}

		sb.append(gg.nachbar.get(i).get(j));
		sb.append(", ");
		sb.append(gg.gewicht.get(i).get(j));
		sb.append("]");
	    }
	    sb.append("]\n");
	}
	return sb.toString();
    }

    public static String drucke(Doppelgewichtgraph dgg) {

	StringBuilder sb = new StringBuilder();
	for (int i = 0; i < dgg.nachbar.size(); i++) {
	    sb.append(i);
	    sb.append(": [");

	    for (int j = 0; j < dgg.nachbar.get(i).size(); j++) {
		if (j != 0) {
		    sb.append(", [");
		} else {
		    sb.append("[");
		}

		sb.append(dgg.nachbar.get(i).get(j));
		sb.append(", ");
		sb.append(dgg.gewicht.get(i).get(j));
		sb.append("]");
	    }
	    sb.append("]\n");
	}
	return sb.toString();
    }
}
