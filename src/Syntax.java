
public class Syntax {

	public static void main(String[] args) {
	}


	public static boolean booleanExpression(boolean a, boolean b, boolean c, boolean d) {
		return ((a ^ b) == (c ^ d)) && ((a ^ c) == (b ^ d)) && ((a ^ b) || (a ^ c));
	}
}