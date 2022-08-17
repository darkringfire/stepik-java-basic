package kao.stepik.basic.streams;

import java.io.InputStream;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		printDouble(Sum(System.in));
	}

	public static double Sum(InputStream is) {
		double sum = 0;
		try (Scanner scanner = new Scanner(is)) {
			while (scanner.hasNext()) {
				try {
					sum += Double.parseDouble(scanner.next());
				} catch (NumberFormatException ignore) {
				}
			}
		}
		return sum;
	}

	private static void printDouble(double x) {
		System.out.printf("%.6f\n", x);
	}

}
