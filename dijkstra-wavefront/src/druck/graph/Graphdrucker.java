package druck.graph;

import graph.Graph;

// Ein Objekt, das einen Graph darstellen können. Die Art von
// Darstellung wird nur schriftlich aus Text angegeben.
public class Graphdrucker {

    // Drucke einen Graph.
    public static String drucke(Graph n) {
	StringBuilder sb = new StringBuilder();
	for (int i = 0; i < n.nachbar.size(); i++) {
	    sb.append(i);
	    sb.append(": ");
	    sb.append(n.nachbar.get(i));
	    sb.append("\n");
	}
	return sb.toString();
    }

    
}
