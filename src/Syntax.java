
public class Syntax {

	public static void main(String[] args) {
		booleanExpressionTest();
	}

	public static void booleanExpressionTest() {
		System.out.println(booleanExpression(false, false, false, false) == false);
		System.out.println(booleanExpression(false, false, false, true) == false);
		System.out.println(booleanExpression(false, false, true, false) == false);
		System.out.println(booleanExpression(false, false, true, true) == true);

		System.out.println(booleanExpression(false, true, false, false) == false);
		System.out.println(booleanExpression(false, true, false, true) == true);
		System.out.println(booleanExpression(false, true, true, false) == true);
		System.out.println(booleanExpression(false, true, true, true) == false);

		System.out.println(booleanExpression(true, false, false, false) == false);
		System.out.println(booleanExpression(true, false, false, true) == true);
		System.out.println(booleanExpression(true, false, true, false) == true);
		System.out.println(booleanExpression(true, false, true, true) == false);

		System.out.println(booleanExpression(true, true, false, false) == true);
		System.out.println(booleanExpression(true, true, false, true) == false);
		System.out.println(booleanExpression(true, true, true, false) == false);
		System.out.println(booleanExpression(true, true, true, true) == false);
	}

	public static boolean booleanExpression(boolean a, boolean b, boolean c, boolean d) {
		return ((a ^ b) == (c ^ d)) && ((a ^ c) == (b ^ d)) && ((a ^ b) || (a ^ c));
	}

}
