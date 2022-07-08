import java.math.BigInteger;
import java.util.Arrays;

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
	 * @param value    any number
	 * @param bitIndex index of the bit to flip, 1 <= bitIndex <= 32
	 * @return new value with one bit flipped
	 */
	public static int flipBit(int value, int bitIndex) {
		return value ^ (1 << (bitIndex - 1));
	}

	public static char charExpression(int a) {
		return (char) ('\\' + a);
	}

	/**
	 * Checks if given <code>value</code> is a power of two.
	 *
	 * @param value any number
	 * @return <code>true</code> when <code>value</code> is power of two,
	 *         <code>false</code> otherwise
	 */
	public static boolean isPowerOfTwo(int value) {
		return Integer.bitCount(Math.abs(value)) == 1;
	}

	/**
	 * Checks if given <code>text</code> is a palindrome.
	 *
	 * @param text any string
	 * @return <code>true</code> when <code>text</code> is a palindrome,
	 *         <code>false</code> otherwise
	 */
	public static boolean isPalindrome(String text) {
		String lettersOnly = text.replaceAll("[^A-Za-z0-9]", "");
		return lettersOnly.equalsIgnoreCase(new StringBuilder(lettersOnly).reverse().toString());
	}

	/**
	 * Calculates factorial of given <code>value</code>.
	 *
	 * @param value positive number
	 * @return factorial of <code>value</code>
	 */
	public static BigInteger factorial(int value) {
		BigInteger result = BigInteger.valueOf(1);
		for (; value > 1; value--) {
			result = result.multiply(BigInteger.valueOf(value));
		}
		return result;
	}

	/**
	 * Merges two given sorted arrays into one
	 *
	 * @param a1 first sorted array
	 * @param a2 second sorted array
	 * @return new array containing all elements from a1 and a2, sorted
	 */
	public static int[] mergeArrays(int[] a1, int[] a2) {
		int[] result = new int[a1.length + a2.length];
		int i1 = 0;
		int i2 = 0;
		while (i1 + i2 < result.length) {
			if (i2 >= a2.length) {
				result[i1 + i2] = a1[i1++];
			} else if (i1 >= a1.length) {
				result[i1 + i2] = a2[i2++];
			} else if (a1[i1] < a2[i2]) {
				result[i1 + i2] = a1[i1++];
			} else {
				result[i1 + i2] = a2[i2++];
			}
		}
		return result;
	}

}
