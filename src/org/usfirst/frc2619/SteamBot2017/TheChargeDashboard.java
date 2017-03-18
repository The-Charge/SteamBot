package org.usfirst.frc2619.SteamBot2017;

import org.usfirst.frc2619.SteamBot2017.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.NamedSendable;
import edu.wpi.first.wpilibj.Sendable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class TheChargeDashboard {

	private static String[] whiteList = {
			// DriveTrain.DELIN_POW_KEY, DriveTrain.DEADBAND_X_KEY,
			// DriveTrain.DEADBAND_Y_KEY, DriveTrain.DEADBAND_TWIST_KEY,
			// "PowerOutput", "JoystickPosition", "Allow_Delinearization",
			// "TURN_OUTER_SPEED", "TURN_INNER_SPEED", "TURN_ANGLE",
			// "FinalDegrees",
			// "CURRENT_LIMIT",
			// "POSITION_P", "POSITION_I", "POSITION_D", "POSITION_F",
			// "ACCELERATION", "VELOCITY", "DISTANCE",
			// "SPEED_P", "SPEED_I", "SPEED_D", "SPEED_F",
			// "IMU_TotalYaw", "IMU_YawRateDPS", "IMU_Connected",
			"IMU_IsCalibrating", "IMU_Yaw", "IMU_Pitch", "IMU_Roll",
			// "IMU_Byte_Count", "IMU_Update_Count",
			// "Setpoint",
			// "LeftSpeed", "RightSpeed", "LeftCurrent",
			// "Direction",
			// "ShooterSpeedP", "ShooterSpeedI", "ShooterSpeedD",
			// "ShooterSpeedF",
			// "PickupSpeedP", "PickupSpeedI", "PickupSpeedD", "PickupSpeedF",
			// //"PickupSetpoint", "PickupMotorControlSpeed", "PickupMscOutput",
			// "PickupMotorVelocity",
			"IndexerSpeedP" , "IndexerSpeedI", "IndexerSpeedD",
			"IndexerSpeedF", //"IndexerSetPoint", "IndexerError",
			// "IndexMeasuredValue", "IndexerDI",
			// "driveTrain",
			"AutoMode",
			// "CANLightRed", "CANLightGreen", "CANLightBlue", "CANLightHue",
			// "LEDOutput",
			// "ForwardFactor", "TurnFactor", "TargetLeftSpeed",
			// "TargetRightSpeed",
			// "ClimbRopeDebug"
	};

	public static void putNumber(String key, double value) {
		for (int x = 0; x < whiteList.length; x++) {
			if (key.equals(whiteList[x])) {
				SmartDashboard.putNumber(key, value);
			}
		}
	}

	public static void putBoolean(String key, boolean value) {
		for (int x = 0; x < whiteList.length; x++) {
			if (key.equals(whiteList[x])) {
				SmartDashboard.putBoolean(key, value);
			}
		}
	}

	public static void putString(String key, String value) {
		for (int x = 0; x < whiteList.length; x++) {
			if (key.equals(whiteList[x])) {
				SmartDashboard.putString(key, value);
			}
		}
	}

	public static void putData(String key, Sendable value) {
		for (int x = 0; x < whiteList.length; x++) {
			if (key.equals(whiteList[x])) {
				SmartDashboard.putData(key, value);
			}
		}
	}

	public static void putData(NamedSendable value) {
		for (int x = 0; x < whiteList.length; x++) {
			if (value.getName().equals(whiteList[x])) {
				SmartDashboard.putData(value);
			}
		}
	}
}
