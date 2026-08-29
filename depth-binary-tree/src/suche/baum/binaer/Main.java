package suche.baum.binaer;

import baum.binaer.Binaerbaum;
import java.util.ArrayList;
import java.util.Arrays;

/*
  javac -d classes $(find src -type f) \
  && java -cp classes suche.baum.binaer.Main;
*/

public class Main {

    static void beispieleins() {
	//
	//      3
	//     / \
	//    5   2
	//
	
	Binaerbaum b = new Binaerbaum(3,
				      new Binaerbaum(5),
				      new Binaerbaum(2));

	int[] pfad = Binaerbaumtiefensuche.suche(b, 2);
	System.out.println(Arrays.toString(pfad));
    }

    static void beispielzwei() {
	//
	//            3
	//           / \
	//          /   \
	//         /     \
	//        5       2
	//       / \     / \
	//      1   9   5   8
	
	Binaerbaum b = new Binaerbaum(3,
				      new Binaerbaum(5,
						     new Binaerbaum(1),
						     new Binaerbaum(9)),
				      new Binaerbaum(2,
						     new Binaerbaum(5),
						     new Binaerbaum(8)));
	
	int[] pfad = Binaerbaumtiefensuche.suche(b, 8);
	System.out.println(Arrays.toString(pfad));
    }

    public static void main(String[] args) {
	beispielzwei();
    }
}
