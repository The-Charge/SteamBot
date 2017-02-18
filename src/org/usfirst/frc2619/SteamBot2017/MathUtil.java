package org.usfirst.frc2619.SteamBot2017;

import org.usfirst.frc2619.SteamBot2017.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class MathUtil {
	public static double delinearize(double input, double power) {
		return delinearize(input, power, DriveTrain.Allow_Delinearization);
	}
	public static double delinearize(double input, double power, boolean Allow_Delinearization) {
		double dbY = Robot.driveTrain.deadband_y;
		double ret;
		TheChargeDashboard.putNumber("JoystickPosition", input);

		if (Allow_Delinearization == true) {
			// returns delinearized power (adjusted for deadband)
			if (input > 0) {
				// this is an equation for the curve so that it starts at zero
				// at the edge of the deadband...
				// ...and goes up cubically to (1,1) - this will work even if we
				// change the deadband
				ret = Math.pow(input - dbY, power) / Math.pow(1 - dbY, power);
			} else if (input < 0) {
				// this is the reverse of that equation, in order to make the
				// negative go backward
				ret = Math.pow(input + dbY, power) / Math.pow(1 - dbY, power);
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