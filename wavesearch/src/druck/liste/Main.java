package druck.liste;

import java.util.ArrayList;

/*
  javac -d classes $(find src -type f) \
  && java -cp classes druck.liste.Main
*/

public class Main {

    static void beispieleins() {
	ArrayList<int[]> liste = new ArrayList<int[]>();

	liste.add(new int[] {1,2,3});
	liste.add(new int[] {1,2});
	liste.add(new int[] {6,7,1});

	System.out.println(Listedrucker.drucke(liste));
    }

    public static void main(String[] args) {
	beispieleins();
    }
}
