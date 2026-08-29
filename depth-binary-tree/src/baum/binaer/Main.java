package baum.binaer;

/*
  javac -d classes $(find src -type f) \
  && java -cp classes baum.binaer.Main
*/

public class Main {
    static void beispieleins() {
	Binaerbaum baum = new Binaerbaum(3,
					 new Binaerbaum(5),
					 new Binaerbaum(2));
    }

    public static void main(String[] args) {
	beispieleins();
    }
}
