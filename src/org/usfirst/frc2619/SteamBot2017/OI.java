// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

package org.usfirst.frc2619.SteamBot2017;

import org.usfirst.frc2619.SteamBot2017.commands.*;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());

	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public JoystickButton invertDriveButton;
    public JoystickButton shiftLowButton;
    public JoystickButton joystickButton1;
    public Joystick leftJoystick;
    public JoystickButton shiftHighButton;
    public Joystick rightJoystick;
    public JoystickButton runShooterButton;
    public JoystickButton runPickupButton;
    public JoystickButton runIndexerButton;
    public JoystickButton openDoorsBtn;
    public JoystickButton closeDoorsBtn;
    public JoystickButton extendPlungerBtn;
    public JoystickButton retractPlungerBtn;
    public JoystickButton climbRopeBtn;
    public JoystickButton climbRopeOverrideBtn;
    public JoystickButton driveToWinBtn;
    public JoystickButton stopIndexerBtn;
    public JoystickButton onCameraLightsBtn;
    public JoystickButton offCameraLightsBtn;
    public Joystick buttonBox;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

	public OI() {
		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

        buttonBox = new Joystick(2);
        
        offCameraLightsBtn = new JoystickButton(buttonBox, 12);
        offCameraLightsBtn.whenReleased(new OffCameraLights());
        onCameraLightsBtn = new JoystickButton(buttonBox, 12);
        onCameraLightsBtn.whenPressed(new OnCameraLights());
        stopIndexerBtn = new JoystickButton(buttonBox, 14);
        stopIndexerBtn.whenReleased(new StopIndexer());
        driveToWinBtn = new JoystickButton(buttonBox, 8);
        driveToWinBtn.whenPressed(new DriveToTarget(0));
        climbRopeOverrideBtn = new JoystickButton(buttonBox, 6);
        climbRopeOverrideBtn.whenPressed(new ClimbRobotTimed(0));
        climbRopeBtn = new JoystickButton(buttonBox, 5);
        climbRopeBtn.whileHeld(new ClimbRope());
        retractPlungerBtn = new JoystickButton(buttonBox, 10);
        retractPlungerBtn.whenReleased(new RetractPlunger());
        extendPlungerBtn = new JoystickButton(buttonBox, 10);
        extendPlungerBtn.whenPressed(new ExtendPlunger());
        closeDoorsBtn = new JoystickButton(buttonBox, 9);
        closeDoorsBtn.whenReleased(new CloseDoors());
        openDoorsBtn = new JoystickButton(buttonBox, 9);
        openDoorsBtn.whenPressed(new OpenDoors());
        runIndexerButton = new JoystickButton(buttonBox, 14);
        runIndexerButton.whileHeld(new RunIndexer());
        runPickupButton = new JoystickButton(buttonBox, 16);
        runPickupButton.whileHeld(new RunPickup());
        runShooterButton = new JoystickButton(buttonBox, 13);
        runShooterButton.whileHeld(new RunShooter());
        rightJoystick = new Joystick(1);
        
        shiftHighButton = new JoystickButton(rightJoystick, 2);
        shiftHighButton.whenPressed(new ShiftHigh());
        leftJoystick = new Joystick(0);
        
        joystickButton1 = new JoystickButton(leftJoystick, 3);
        joystickButton1.whenPressed(new TurnNDegreesRelativePID(180));
        shiftLowButton = new JoystickButton(leftJoystick, 2);
        shiftLowButton.whenPressed(new ShiftLow());
        invertDriveButton = new JoystickButton(leftJoystick, 4);
        invertDriveButton.whileHeld(new InvertDrive());


        // SmartDashboard Buttons
        SmartDashboard.putData("ShiftLow", new ShiftLow());
        SmartDashboard.putData("ShiftHigh", new ShiftHigh());
        SmartDashboard.putData("Autonomous Command", new AutonomousCommand());
        SmartDashboard.putData("TankDrive", new TankDrive());
        SmartDashboard.putData("DriveXSeconds", new DriveXSeconds());
        SmartDashboard.putData("InvertDrive", new InvertDrive());
        SmartDashboard.putData("ArcadeDrive", new ArcadeDrive());
        SmartDashboard.putData("ClaytonDrive", new ClaytonDrive());
        SmartDashboard.putData("HaloDrive", new HaloDrive());
        SmartDashboard.putData("XboxDrive", new XboxDrive());
        SmartDashboard.putData("MotionMagicMode", new MotionMagicMode());
        SmartDashboard.putData("DriveXFeetMM: DXF_MM_20", new DriveXFeetMM(0, 0, 20));
        SmartDashboard.putData("DriveXFeetMM: DXF_MM_5", new DriveXFeetMM(0, 0, 5));
        SmartDashboard.putData("DriveXFeetMM: DXF_MM_10", new DriveXFeetMM(0, 0, 10));
        SmartDashboard.putData("DriveXFeetMM: DXF_MM_-5", new DriveXFeetMM(0, 0, -5));
        SmartDashboard.putData("RunShooter", new RunShooter());
        SmartDashboard.putData("OpenDoors", new OpenDoors());
        SmartDashboard.putData("CloseDoors", new CloseDoors());
        SmartDashboard.putData("ExtendPlunger", new ExtendPlunger());
        SmartDashboard.putData("RetractPlunger", new RetractPlunger());
        SmartDashboard.putData("OffLed", new OffLed());
        SmartDashboard.putData("OnLed", new OnLed());
        SmartDashboard.putData("RunLed", new RunLed());
        SmartDashboard.putData("ClimbRope", new ClimbRope());
        SmartDashboard.putData("OnCameraLights", new OnCameraLights());
        SmartDashboard.putData("OffCameraLights", new OffCameraLights());
        SmartDashboard.putData("RunPickup", new RunPickup());
        SmartDashboard.putData("RunIndexer", new RunIndexer());
        SmartDashboard.putData("TurnNDegreesAbsolutePID: FortyFive", new TurnNDegreesAbsolutePID(45));
        SmartDashboard.putData("TurnNDegreesAbsolutePID: NegFortyFive", new TurnNDegreesAbsolutePID(-45));
        SmartDashboard.putData("TurnNDegreesAbsolutePID: OneEighty", new TurnNDegreesAbsolutePID(180));
        SmartDashboard.putData("ClimbRobotTimed: Time", new ClimbRobotTimed(0.5));
        SmartDashboard.putData("AllianceColor", new AllianceColor());
        SmartDashboard.putData("Blink", new Blink());
        SmartDashboard.putData("ChargeColors", new ChargeColors());
        SmartDashboard.putData("OffCANLights", new OffCANLights());
        SmartDashboard.putData("RunCANLights", new RunCANLights());
        SmartDashboard.putData("GearPegRightAutonBlue", new GearPegRightAutonBlue());
        SmartDashboard.putData("GearPegLeftAutonRed", new GearPegLeftAutonRed());
        SmartDashboard.putData("GearPegMiddleAuton", new GearPegMiddleAuton());
        SmartDashboard.putData("DriveToCurrent: 0.1", new DriveToCurrent(0.1));
        SmartDashboard.putData("TurnNDegreesRelativePID: 90", new TurnNDegreesRelativePID(90));
        SmartDashboard.putData("EnableCurrentLimit", new EnableCurrentLimit());
        SmartDashboard.putData("DisableCurrentLimit", new DisableCurrentLimit());
        SmartDashboard.putData("DriveToTarget: 2", new DriveToTarget(2));
        SmartDashboard.putData("DeliverGearWithVision", new DeliverGearWithVision());
        SmartDashboard.putData("DeliverGear", new DeliverGear());
        SmartDashboard.putData("RunPickupReverse", new RunPickupReverse());
        SmartDashboard.putData("DroneDrive", new DroneDrive());
        SmartDashboard.putData("GearPegLeftAutonBlue", new GearPegLeftAutonBlue());
        SmartDashboard.putData("GearPegRightAutonRed", new GearPegRightAutonRed());

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
	}

	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
    public Joystick getLeftJoystick() {
        return leftJoystick;
    }

    public Joystick getRightJoystick() {
        return rightJoystick;
    }

    public Joystick getButtonBox() {
        return buttonBox;
    }


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
}
