package kao.stepik.basic;

import java.util.function.DoubleUnaryOperator;

public class Integrator {

	public static void main(String[] args) {
		System.out.println(integrate(x -> 1, 0, 10));

	}

	public static double integrate(DoubleUnaryOperator f, double a, double b) {
		final double STEP = 1e-6;
		double x = a;
		double integral = 0;
		while (x < b) {
			integral += f.applyAsDouble(x) * STEP;
			x += STEP;
		}
		return integral;
	}

}
