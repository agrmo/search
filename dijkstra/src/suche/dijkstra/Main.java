package suche.dijkstra;

// suche.dijkstra.haufen.Main

import graph.gewicht.Gewichtgraph;
import graph.gewicht.Doppelgewichtgraph;
import java.util.Arrays;
import liste.Zweiliste;

public class Main {
    static void beispieleins() {
	// 
	// Graph:
	// 
        //   2   5      1
        // 1 - 7 - 3 ------4   
        //     \   |        \
        //     4\  |2        \3 
        //       \ | 1     3  \   3
        //        0-----8------2------5
        //         \   /        \
        //         9\ /1         \2
        //           10           \
        //                         6
        //                          \
        //                           \3
        //                            \
        //                             9
        //                             

	int n = 11;
	int[][] kanten = {{1,7,2},{7,3,5},{3,4,1},
			  {7,0,4},{3,0,2},{4,2,3},
			  {0,8,1},{8,2,3},{2,5,3},
			  {0,10,9},{8,10,1},{2,6,2},
			  {6,9,3}};
	
	Gewichtgraph gg = new Gewichtgraph(n, kanten);
	Doppelgewichtgraph dgg = new Doppelgewichtgraph(gg);

	Zweiliste zl = Dijkstra.suche(dgg, 1);

	System.out.println(Arrays.toString(zl.eins));
	System.out.println(Arrays.toString(zl.zwei));
    }

    public static void main(String[] args) {
	beispieleins();
    }
}
