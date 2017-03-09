// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

package org.usfirst.frc2619.SteamBot2017.subsystems;

import org.usfirst.frc2619.SteamBot2017.MathUtil;
import org.usfirst.frc2619.SteamBot2017.Robot;
import org.usfirst.frc2619.SteamBot2017.RobotMap;
import org.usfirst.frc2619.SteamBot2017.TheChargeDashboard;
import org.usfirst.frc2619.SteamBot2017.commands.*;
import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;
import com.ctre.CANTalon.TalonControlMode;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DriveTrain extends Subsystem {
	private final double TICKS_PER_FOOT = 3655;
	private final int TICKS_PER_REVOLUTION = 1440; // 4 x CPR WILL BE CHANGED
	private final int MAX_TICKS_PER_SECOND = 8691;

	private double Destination = 0;
	private double numFeet = 0;

	public boolean isReversed = false;

	//public float driveLockAngle;
	public boolean driveLocked = false;
	
	public double delin_pow;
	public final double DELIN_POW_DEFAULT = 1;
	public double deadband_x;
	public final double DEADBAND_X_DEFAULT = 0.1;
	public double deadband_y;
	public final double DEADBAND_Y_DEFAULT = 0.1;
	public double deadband_twist;
	public final double DEADBAND_TWIST_DEFAULT = 0.1;
	public double turn_outer_speed;
	public final double TURN_OUTER_SPEED_DEFAULT = 0.5;
	public double turn_inner_speed;
	public final double TURN_INNER_SPEED_DEFAULT = -0.5;
	public double current_limit;
	public final double CURRENT_LIMIT_DEFAULT = 40;
	public double turn_angle;
	public final double TURN_ANGLE_DEFAULT = 0;
	public static boolean Allow_Delinearization = true;
	public static final boolean ALLOW_DELINEARIZATION_DEFAULT = true;

	public static final String DELIN_POW_KEY = "DELIN_POW";
	public static final String DEADBAND_X_KEY = "DEADBAND_X";
	public static final String DEADBAND_Y_KEY = "DEADBAND_Y";
	public static final String DEADBAND_TWIST_KEY = "DEADBAND_TWIST";

	private static final String TURN_OUTER_SPEED_KEY = "TURN_OUTER_SPEED";
	private static final String TURN_INNER_SPEED_KEY = "TURN_INNER_SPEED";

	private static final String CURRENT_LIMIT_KEY = "CURRENT_LIMIT";

	private static final String POSITION_P_KEY = "POSITION_P";
	private static final String POSITION_D_KEY = "POSITION_D";
	private static final String POSITION_I_KEY = "POSITION_I";
	private static final String POSITION_F_KEY = "POSITION_F";
	private static final String ACCELERATION_KEY = "ACCELERATION";
	private static final String VELOCITY_KEY = "VELOCITY";
	private static final String DISTANCE_KEY = "DISTANCE";
	
	public static final String ALLOW_DELINEARIZATION_KEY = "Allow_Delinearization";
	
	private static final String SPEED_P_KEY = "SPEED_P";
	private static final String SPEED_D_KEY = "SPEED_D";
	private static final String SPEED_I_KEY = "SPEED_I";
	private static final String SPEED_F_KEY = "SPEED_F";
	
	private static final String TURN_ANGLE_KEY = "TURN_ANGLE";

	public final static double POSITION_P_CONSTANT = 1.6;
	private final static double POSITION_I_CONSTANT = 0;
	private final static double POSITION_D_CONSTANT = 25;
	private final static double POSITION_F_CONSTANT = 0.17;

	public final static double VELOCITY_CONSTANT = 6000;
	public final static double ACCELERATION_CONSTANT = 4000;
	public final static double DISTANCE_CONSTANT = 36550;
	
	private final static double SPEED_P_CONSTANT = 0.3;
	private final static double SPEED_I_CONSTANT = 0.001;
	private final static double SPEED_D_CONSTANT = 0.0;
	private final static double SPEED_F_CONSTANT = 0.12;

	double position_P = POSITION_P_CONSTANT;
	public final double POSITION_P_DEFAULT = POSITION_P_CONSTANT;
	double position_I = POSITION_I_CONSTANT;
	public final double POSITION_I_DEFAULT = POSITION_I_CONSTANT;
	double position_D = POSITION_D_CONSTANT;
	public final double POSITION_D_DEFAULT = POSITION_D_CONSTANT;
	double position_F = POSITION_F_CONSTANT;
	public final double POSITION_F_DEFAULT = POSITION_F_CONSTANT;

	double velocity = VELOCITY_CONSTANT;
	public final double VELOCITY_DEFAULT = VELOCITY_CONSTANT;
	double acceleration = ACCELERATION_CONSTANT;
	public final double ACCELERATION_DEFAULT = ACCELERATION_CONSTANT;
	double distance = DISTANCE_CONSTANT;
	public final double DISTANCE_DEFAULT = DISTANCE_CONSTANT;
	
	public double speedP = SPEED_P_CONSTANT;
	public final double SPEED_P_DEFAULT = SPEED_P_CONSTANT;
	public double speedI = SPEED_I_CONSTANT;
	public final double SPEED_I_DEFAULT = SPEED_I_CONSTANT;
	public double speedD = SPEED_D_CONSTANT;
	public final double SPEED_D_DEFAULT = SPEED_D_CONSTANT;
	public double speedF = SPEED_F_CONSTANT;
	public final double SPEED_F_DEFAULT = SPEED_F_CONSTANT;
	
	private final static int PID_PROFILE_POSITION = 1;

	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private final CANTalon leftFrontMotor = RobotMap.driveTrainLeftFrontMotor;
    private final CANTalon rightFrontMotor = RobotMap.driveTrainRightFrontMotor;
    private final CANTalon rightRearMotor = RobotMap.driveTrainRightRearMotor;
    private final CANTalon leftRearMotor = RobotMap.driveTrainLeftRearMotor;
    private final AnalogGyro doNotUse = RobotMap.driveTrainDoNotUse;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
	private final AHRS ahrs = RobotMap.driveTrainAHRS;
	
	private CANTalon.TalonControlMode currentControlMode = CANTalon.TalonControlMode.PercentVbus;

	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public void writeDefaultValues() {
		TheChargeDashboard.putNumber(DELIN_POW_KEY, DELIN_POW_DEFAULT);
		TheChargeDashboard.putNumber(DEADBAND_X_KEY, DEADBAND_X_DEFAULT);
		TheChargeDashboard.putNumber(DEADBAND_Y_KEY, DEADBAND_Y_DEFAULT);
		TheChargeDashboard.putNumber(DEADBAND_TWIST_KEY, DEADBAND_TWIST_DEFAULT);
		TheChargeDashboard.putNumber(TURN_OUTER_SPEED_KEY, TURN_OUTER_SPEED_DEFAULT);
		TheChargeDashboard.putNumber(TURN_INNER_SPEED_KEY, TURN_INNER_SPEED_DEFAULT);
		TheChargeDashboard.putNumber(POSITION_P_KEY, POSITION_P_DEFAULT);
		TheChargeDashboard.putNumber(POSITION_I_KEY, POSITION_I_DEFAULT);
		TheChargeDashboard.putNumber(POSITION_D_KEY, POSITION_D_DEFAULT);
		TheChargeDashboard.putNumber(POSITION_F_KEY, POSITION_F_DEFAULT);
		TheChargeDashboard.putNumber(ACCELERATION_KEY, ACCELERATION_DEFAULT);
		TheChargeDashboard.putNumber(VELOCITY_KEY, VELOCITY_DEFAULT);
		TheChargeDashboard.putNumber(DISTANCE_KEY, DISTANCE_DEFAULT);
		TheChargeDashboard.putNumber(SPEED_P_KEY, SPEED_P_DEFAULT);
		TheChargeDashboard.putNumber(SPEED_I_KEY, SPEED_I_DEFAULT);
		TheChargeDashboard.putNumber(SPEED_D_KEY, SPEED_D_DEFAULT);
		TheChargeDashboard.putNumber(SPEED_F_KEY, SPEED_F_DEFAULT);
		TheChargeDashboard.putNumber(CURRENT_LIMIT_KEY, CURRENT_LIMIT_DEFAULT);
		TheChargeDashboard.putNumber(TURN_ANGLE_KEY, TURN_ANGLE_DEFAULT);
		TheChargeDashboard.putBoolean(ALLOW_DELINEARIZATION_KEY, Allow_Delinearization);
	}

	public void readControlValues() {
		delin_pow = SmartDashboard.getNumber(DELIN_POW_KEY, DELIN_POW_DEFAULT);
		deadband_x = SmartDashboard.getNumber(DEADBAND_X_KEY, DEADBAND_X_DEFAULT);
		deadband_y = SmartDashboard.getNumber(DEADBAND_Y_KEY, DEADBAND_Y_DEFAULT);
		deadband_twist = SmartDashboard.getNumber(DEADBAND_TWIST_KEY, DEADBAND_TWIST_DEFAULT);
		turn_outer_speed = SmartDashboard.getNumber(TURN_OUTER_SPEED_KEY, TURN_OUTER_SPEED_DEFAULT);
		turn_inner_speed = SmartDashboard.getNumber(TURN_INNER_SPEED_KEY, TURN_INNER_SPEED_DEFAULT);
		current_limit = SmartDashboard.getNumber(CURRENT_LIMIT_KEY, CURRENT_LIMIT_DEFAULT);
		position_P = SmartDashboard.getNumber(POSITION_P_KEY, POSITION_P_DEFAULT);
		position_I = SmartDashboard.getNumber(POSITION_I_KEY, POSITION_I_DEFAULT);
		position_D = SmartDashboard.getNumber(POSITION_D_KEY, POSITION_D_DEFAULT);
		position_F = SmartDashboard.getNumber(POSITION_F_KEY, POSITION_F_DEFAULT);
		acceleration = SmartDashboard.getNumber(ACCELERATION_KEY, ACCELERATION_DEFAULT);
		velocity = SmartDashboard.getNumber(VELOCITY_KEY, VELOCITY_DEFAULT);
		distance = SmartDashboard.getNumber(DISTANCE_KEY, DISTANCE_DEFAULT);
		speedP = SmartDashboard.getNumber(SPEED_P_KEY, SPEED_P_DEFAULT);
		speedI = SmartDashboard.getNumber(SPEED_I_KEY, SPEED_I_DEFAULT);
		speedD = SmartDashboard.getNumber(SPEED_D_KEY, SPEED_D_DEFAULT);
		speedF = SmartDashboard.getNumber(SPEED_F_KEY, SPEED_F_DEFAULT);
		turn_angle = SmartDashboard.getNumber(TURN_ANGLE_KEY, TURN_ANGLE_DEFAULT);
		Allow_Delinearization = SmartDashboard.getBoolean(ALLOW_DELINEARIZATION_KEY, ALLOW_DELINEARIZATION_DEFAULT);
	}

	public void writeDebugValues() {
		TheChargeDashboard.putNumber("IMU_TotalYaw", ahrs.getAngle());
		TheChargeDashboard.putNumber("IMU_YawRateDPS", ahrs.getRate());
		TheChargeDashboard.putBoolean("IMU_Connected", ahrs.isConnected());
		TheChargeDashboard.putBoolean("IMU_IsCalibrating", ahrs.isCalibrating());
		TheChargeDashboard.putNumber("IMU_Yaw", ahrs.getYaw());
		TheChargeDashboard.putNumber("IMU_Pitch", ahrs.getPitch());
		TheChargeDashboard.putNumber("IMU_Roll", ahrs.getRoll());
		// Connectivity Debugging Support
		TheChargeDashboard.putNumber("IMU_Byte_Count", ahrs.getByteCount());
		TheChargeDashboard.putNumber("IMU_Update_Count", ahrs.getUpdateCount());
		TheChargeDashboard.putNumber("Setpoint", leftFrontMotor.getSetpoint());
		TheChargeDashboard.putNumber("LeftSpeed", leftFrontMotor.getSpeed());
		TheChargeDashboard.putNumber("RightSpeed", rightFrontMotor.getSpeed());
		TheChargeDashboard.putNumber("LeftCurrent", leftFrontMotor.getOutputCurrent());
		//SmartDashboard.putNumber("Timer.getMatchTime()", Timer.getMatchTime());
	}

	public void run(double leftSpeed, double rightSpeed) {
		leftFrontMotor.changeControlMode(TalonControlMode.PercentVbus);
		rightFrontMotor.changeControlMode(TalonControlMode.PercentVbus);
		if(driveLocked == true){
			double avSpeed = (leftSpeed + rightSpeed) / 2.0;
			leftSpeed = avSpeed;
			rightSpeed = avSpeed;
		}
		if (!isReversed) {
			leftFrontMotor.set(leftSpeed);

			rightFrontMotor.set(rightSpeed);

		} else {
			leftFrontMotor.set(-1 * rightSpeed);

			rightFrontMotor.set(-1 * leftSpeed);

		}
	}

	public double getFeet() {
		return (leftFrontMotor.getEncPosition()) / TICKS_PER_FOOT;
	}

	public double getTicks() {
		return (leftFrontMotor.getEncPosition());
	}

	public void sendFeet(double f) {
		Destination = 0;
		numFeet = f;
		Destination = getTicks() + (((numFeet * 1.017) - (12.147 / 12)) * TICKS_PER_FOOT);
		TheChargeDashboard.putNumber("Destination", Destination);
	}

	public boolean isAtDestination() {
		TheChargeDashboard.putNumber("getTicks()", getTicks());
		if (numFeet > 0) {
			return getTicks() >= Destination;
		} else {
			return getTicks() <= Destination;
		}
	}

	public void updateCurrentLimit() {
		// Set Current Limiting value from int CurrentLimit
		RobotMap.driveTrainLeftRearMotor.setCurrentLimit((int)current_limit);
		RobotMap.driveTrainRightRearMotor.setCurrentLimit((int)current_limit);
		RobotMap.driveTrainLeftFrontMotor.setCurrentLimit((int)current_limit);
		RobotMap.driveTrainRightFrontMotor.setCurrentLimit((int)current_limit);
	}

	public void disableCurrentLimit() {
		RobotMap.driveTrainLeftRearMotor.EnableCurrentLimit(false);
		RobotMap.driveTrainRightRearMotor.EnableCurrentLimit(false);
		RobotMap.driveTrainLeftFrontMotor.EnableCurrentLimit(false);
		RobotMap.driveTrainRightFrontMotor.EnableCurrentLimit(false);
	}

	public void enableCurrentLimit() {
		updateCurrentLimit();
		RobotMap.driveTrainLeftRearMotor.EnableCurrentLimit(true);
		RobotMap.driveTrainRightRearMotor.EnableCurrentLimit(true);
		RobotMap.driveTrainLeftFrontMotor.EnableCurrentLimit(true);
		RobotMap.driveTrainRightFrontMotor.EnableCurrentLimit(true);
	}

	public boolean isAtPIDDestination() {
		return (this.leftFrontMotor.getEncPosition() > 1000 || this.leftFrontMotor.getEncPosition() < -1000)
				&& (Math.abs(this.leftFrontMotor.getSetpoint() - this.leftFrontMotor.getEncPosition()) < 1000);
	}

	public void stop() {
		Robot.driveTrain.run(0, 0);
	}

	public double getDegrees() {
		return ahrs.getAngle();
	}

	public double getYaw() {
		return ahrs.getYaw();
	}

	public void relTurn(double turnTo, double speed) {
		double leftSpeed = 0, rightSpeed = 0;
		double direction = MathUtil.calcDirection(getDegrees(), turnTo);
		if (direction >= 0) {
			leftSpeed = speed;
			rightSpeed = 0;
			// run(speed, -speed);
			TheChargeDashboard.putString("Direction", "Right");
		} else if (direction < 0) {
			leftSpeed = 0;
			rightSpeed = speed;
			// run(-speed, speed);
			TheChargeDashboard.putString("Direction", "Left");
		} else {
			leftSpeed = 0;
			rightSpeed = 0;
			// run(0,0);
			TheChargeDashboard.putString("Direction", "None");
		}
		run(leftSpeed, rightSpeed);
	}

	public void absTurn(double degreeChange, double speed) {
		double leftSpeed = 0, rightSpeed = 0;
		if (degreeChange > 0) {
			leftSpeed = turn_outer_speed;
			rightSpeed = -1 * turn_inner_speed;
		} else if (degreeChange < 0) {
			rightSpeed = turn_outer_speed;
			leftSpeed = -1 * turn_inner_speed;
		}
		run(leftSpeed, rightSpeed);
	}
	
	public void dXF_MM(double acceleration, double velocity, double distance) {
		leftFrontMotor.setFeedbackDevice(FeedbackDevice.QuadEncoder);
		rightFrontMotor.setFeedbackDevice(FeedbackDevice.QuadEncoder);

		leftFrontMotor.changeControlMode(CANTalon.TalonControlMode.MotionMagic);
		rightFrontMotor.changeControlMode(CANTalon.TalonControlMode.MotionMagic);

		leftFrontMotor.setPosition(0);
		rightFrontMotor.setPosition(0);

		setProfile(PID_PROFILE_POSITION);
		leftFrontMotor.setProfile(PID_PROFILE_POSITION);
		rightFrontMotor.setProfile(PID_PROFILE_POSITION);
		leftFrontMotor.setPID(position_P, position_I, position_D);
		leftFrontMotor.setF(position_F);
		rightFrontMotor.setPID(position_P, position_I, position_D);
		rightFrontMotor.setF(position_F);

		distance *= TICKS_PER_FOOT;

		rightFrontMotor.setMotionMagicAcceleration(acceleration);
		leftFrontMotor.setMotionMagicAcceleration(acceleration);
		rightFrontMotor.setMotionMagicCruiseVelocity(velocity);
		leftFrontMotor.setMotionMagicCruiseVelocity(velocity);

		rightFrontMotor.setSetpoint(-distance);
		leftFrontMotor.setSetpoint(distance);
	}

	public void motionMagicMode() {
		leftFrontMotor.setFeedbackDevice(FeedbackDevice.QuadEncoder);
		rightFrontMotor.setFeedbackDevice(FeedbackDevice.QuadEncoder);

		leftFrontMotor.changeControlMode(CANTalon.TalonControlMode.MotionMagic);
		rightFrontMotor.changeControlMode(CANTalon.TalonControlMode.MotionMagic);

		leftFrontMotor.setPosition(0);
		rightFrontMotor.setPosition(0);

		// set position PIDF values
		// REQUIRES F VALUE
		setProfile(PID_PROFILE_POSITION);

		leftFrontMotor.setProfile(PID_PROFILE_POSITION);
		rightFrontMotor.setProfile(PID_PROFILE_POSITION);
		leftFrontMotor.setPID(position_P, position_I, position_D);
		leftFrontMotor.setF(position_F);
		rightFrontMotor.setPID(position_P, position_I, position_D);
		rightFrontMotor.setF(position_F);

		// gets ticks per rev??
		// set acceleration and cruising velocity
		// acceleration *= TICKS_PER_REVOLUTION;
		// velocity *= TICKS_PER_REVOLUTION;
		rightFrontMotor.setMotionMagicAcceleration(acceleration);
		leftFrontMotor.setMotionMagicAcceleration(acceleration);
		rightFrontMotor.setMotionMagicCruiseVelocity(velocity);
		leftFrontMotor.setMotionMagicCruiseVelocity(velocity);

		// set target distance
		// distance *= TICKS_PER_FOOT;
		// sendFeet(distance);
		rightFrontMotor.setSetpoint(-distance);
		leftFrontMotor.setSetpoint(distance);
	}

	public void setEncZero() {
		leftFrontMotor.setEncPosition(0);
		rightFrontMotor.setEncPosition(0);
		leftRearMotor.setEncPosition(0);
		rightRearMotor.setEncPosition(0);
	}

	private void setProfile(int profile) {
		leftFrontMotor.setProfile(profile);
		rightFrontMotor.setProfile(profile);
	}
	
	public void initSpeedMode() {
		leftFrontMotor.changeControlMode(TalonControlMode.Speed);
		rightFrontMotor.changeControlMode(TalonControlMode.Speed);		
		
		leftFrontMotor.setPID(speedP, speedI, speedD, speedF, 0, 0, 1);
		rightFrontMotor.setPID(speedP, speedI, speedD, speedF, 0, 0, 1);
		
		leftFrontMotor.setProfile(1);
		rightFrontMotor.setProfile(1);

		leftFrontMotor.configMaxOutputVoltage(12);
		rightFrontMotor.configMaxOutputVoltage(12);
	}
	
	public void setSpeedPID(double setSpeed) {
		leftFrontMotor.setSetpoint(MAX_TICKS_PER_SECOND * setSpeed);
		rightFrontMotor.setSetpoint(MAX_TICKS_PER_SECOND * setSpeed);
	}
	
	public double getCurrent() {
		return leftFrontMotor.getOutputCurrent();
	}
	
	public void initDefaultCommand() {
		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        setDefaultCommand(new TankDrive());

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
	
	public void setControlMode(CANTalon.TalonControlMode controlMode){
		leftFrontMotor.changeControlMode(controlMode);
		rightFrontMotor.changeControlMode(controlMode);
		currentControlMode = controlMode;
	}
	
	
	public CANTalon.TalonControlMode getControlMode(){
		return currentControlMode;
	}
}
