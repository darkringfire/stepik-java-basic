
public class Syntax {

	public static void main(String[] args) {
	}


	public static boolean booleanExpression(boolean a, boolean b, boolean c, boolean d) {
		return ((a ^ b) == (c ^ d)) && ((a ^ c) == (b ^ d)) && ((a ^ b) || (a ^ c));
	}

	public static int leapYearCount(int year) {
		return year / 4 - year / 100 + year / 400;
	}

	public static boolean doubleExpression(double a, double b, double c) {
		final double e = 1e-4;
		return Math.abs(a + b - c) < e;
	}
}
