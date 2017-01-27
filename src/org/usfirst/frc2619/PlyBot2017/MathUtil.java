package org.usfirst.frc2619.PlyBot2017;

public class MathUtil {
	public static double delinearize(double input, int power) {
		
		double dbY = Robot.driveTrain.DEADBAND_Y;
		
		//returns delinearized power (adjusted for deadband)
		if(input > 0)
			//this is an equation for the curve so that it starts at zero at the edge of the deadband...
			//...and goes up cubically to (1,1)
			return 1/(1 - dbY) * Math.pow(input - dbY, power);
		else if (input < 0)
			//this is the reverse of that equation, in order to make the negative go backward
			return 1/(1 - dbY) * Math.pow(input + dbY, power);
		else
			return 0;
	}

	public static double deadbandCheck(double input, double db) {
		
		// ---------if----- =then=
		return Math.abs(input) < db ? 0 : input;
		// --else-
	}
	public static double calcDirection(double current, double desired) {
		current = Math.toRadians(current);
		desired = Math.toRadians(desired);
		double current_x = Math.cos(current);
		double current_y = Math.sin(current);
		double desired_x = Math.cos(desired);
		double desired_y = Math.sin(desired);
		double direction = Math.signum(current_x * desired_y - desired_x
				* current_y);
		return direction;
	}
}