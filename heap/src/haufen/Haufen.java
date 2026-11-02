package haufen;

import java.util.ArrayList;

public class Haufen {

    public static int elter(int i) {
	return (int) (i / 2);
    }

    public static int linksindex(int i) {
	return 2 * (i + 1) - 1;
    }

    public static int rechtsindex(int i) {
	return 2 * (i + 1);
    }

    public static int links(ArrayList<Integer> liste, int i) {
	return liste.get(linksindex(i));
    }

    public static int rechts(ArrayList<Integer> liste, int i) {
	return liste.get(rechtsindex(i));
    }

    public static void tausche(ArrayList<Integer> liste, int i, int j) {
	int izahl = liste.get(i);
	liste.set(i, liste.get(j));
	liste.set(j, izahl);
    }
}
