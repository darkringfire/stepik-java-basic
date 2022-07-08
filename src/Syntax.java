
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

	/**
	 * Flips one bit of the given <code>value</code>.
	 *
	 * @param value     any number
	 * @param bitIndex  index of the bit to flip, 1 <= bitIndex <= 32
	 * @return new value with one bit flipped
	 */
	public static int flipBit(int value, int bitIndex) {
	    return value ^ (1 << (bitIndex - 1));
	}

	public static char charExpression(int a) {
	    return (char)('\\' + a);
	}
	
	/**
	 * Checks if given <code>value</code> is a power of two.
	 *
	 * @param value any number
	 * @return <code>true</code> when <code>value</code> is power of two, <code>false</code> otherwise
	 */
	public static boolean isPowerOfTwo(int value) {
	    return Integer.bitCount(Math.abs(value)) == 1;
	}
	
	/**
	 * Checks if given <code>text</code> is a palindrome.
	 *
	 * @param text any string
	 * @return <code>true</code> when <code>text</code> is a palindrome, <code>false</code> otherwise
	 */
	public static boolean isPalindrome(String text) {
		String lettersOnly = text.replaceAll("[^A-Za-z0-9]", "");
	    return lettersOnly.equalsIgnoreCase(new StringBuilder(lettersOnly).reverse().toString()); 
	}
}
