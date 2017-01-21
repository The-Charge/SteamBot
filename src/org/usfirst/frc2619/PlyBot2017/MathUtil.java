package org.usfirst.frc2619.PlyBot2017;

public class MathUtil {
	public static double delinearize(double input, int power) {
		return Math.pow(input, power);
	}

	public static double deadbandCheck(double input, double db) {

		// ---------if----- =then=
		return Math.abs(input) < db ? 0 : input;
		// --else-
	}
}
