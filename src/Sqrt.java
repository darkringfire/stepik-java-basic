
public class Sqrt {

	public static void main(String[] args) {
		System.out.println(sqrt(4));
		System.out.println(sqrt(0));
		System.out.println(sqrt(-1));

	}
	public static double sqrt(double x) {
		if (x < 0) {
			throw new IllegalArgumentException("Expected non-negative number, got " + x);
		}
	    return Math.sqrt(x);
	}

}
