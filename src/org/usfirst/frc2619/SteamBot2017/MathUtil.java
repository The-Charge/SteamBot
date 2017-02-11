package org.usfirst.frc2619.SteamBot2017;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class MathUtil {
	public static boolean Allow_Delinearization;
	public static final boolean ALLOW_DELINEARIZATION_DEFAULT = true;
	public static final String ALLOW_DELINEARIZATION_KEY = "Allow_Delinearization";

	public static double delinearize(double input, int power) {
		double dbY = Robot.driveTrain.deadband_y;
		double ret;
		Allow_Delinearization = false;
		TheChargeDashboard.putNumber("JoystickPosition", input);
		TheChargeDashboard.putBoolean(ALLOW_DELINEARIZATION_KEY, Allow_Delinearization);
		Allow_Delinearization = SmartDashboard.getBoolean(ALLOW_DELINEARIZATION_KEY, ALLOW_DELINEARIZATION_DEFAULT);

		if (Allow_Delinearization == true) {
			// returns delinearized power (adjusted for deadband)
			if (input > 0) {
				// this is an equation for the curve so that it starts at zero
				// at the edge of the deadband...
				// ...and goes up cubically to (1,1) - this will work even if we
				// change the deadband
				ret = 1 / Math.pow(1 - dbY, power) * Math.pow(input - dbY, power);
			} else if (input < 0) {
				// this is the reverse of that equation, in order to make the
				// negative go backward
				ret = 1 / Math.pow(1 - dbY, power) * Math.pow(input + dbY, power);
			} else {
				ret = 0;
			}
		} else {
			// if delin modifications are off, will return non-fixed
			// delinearization
			ret = Math.pow(input, power);
			ret = input;
		}

		TheChargeDashboard.putNumber("PowerOutput", ret);
		return ret;
	}

	public static double deadbandCheck(double input, double db) {
		return Math.abs(input) < db ? 0 : input;
	}

	public static double calcDirection(double current, double desired) {
		current = Math.toRadians(current);
		desired = Math.toRadians(desired);
		double current_x = Math.cos(current);
		double current_y = Math.sin(current);
		double desired_x = Math.cos(desired);
		double desired_y = Math.sin(desired);
		double direction = Math.signum(current_x * desired_y - desired_x * current_y);
		return direction;
	}
}