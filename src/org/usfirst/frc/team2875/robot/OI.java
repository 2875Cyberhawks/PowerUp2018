package org.usfirst.frc.team2875.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	public static final double JOY_DEADZONE = 0.15;
	public static final double TRIGGER_DEADZONE = 0.02;
	//// CREATING BUTTONS
	public XboxController driveController;
	public Joystick liftController;
	public OI(){
		driveController = new XboxController(0);
		liftController = new Joystick(1);
		
	}

	public boolean getEmergencyStop(){
		return false;
	}
	//returns forward and backward movement input
	public double getForwardInput(){
		double in = driveController.getY(GenericHID.Hand.kLeft);
		return (Math.abs(in) > JOY_DEADZONE) ? in : 0;
	}

	public double[] getTurning() {
		//From OED:
		//Old English lyft, left �weak� (the left-hand side being regarded as the weaker side of the body), of West Germanic origin.
		//Old English riht (adjective and noun), rihtan (verb), rihte (adverb), of Germanic origin; related to Latin rectus �ruled�, from an Indo-European root denoting movement in a straight line.
		double lyft = driveController.getTriggerAxis(GenericHID.Hand.kLeft);
		double riht = driveController.getTriggerAxis(GenericHID.Hand.kRight);
		double[] out = new double[2];
		out[0] = lyft;
		out[1] = riht;
		return out;
	}

	public double getTurningDegree() {
		double[] raw = getTurning();
		return raw[0]-raw[1];
	}
	public double wheelControl() {
		return driveController.getY(GenericHID.Hand.kRight);
	}
	public double getLift() {
//TODO: Add a konami code for malicious rumble
		double val = liftController.getY();
		return (val > JOY_DEADZONE) ? val : 0;

	}
	
	public boolean isActive() {
		if(button6() && button7() && button10() && button11())
			return true;
		else 
			return false;
	}
	public boolean button6() {
		return liftController.getRawButton(6);
	}
	public boolean button7() {
		return liftController.getRawButton(7);
	}
	public boolean button10() {
		return liftController.getRawButton(10);
	}
	public boolean button11() {
		return liftController.getRawButton(11);
	}
	public void doIt() {
		if(isActive()) {
			driveController.setRumble(GenericHID.RumbleType.kLeftRumble, 1);
			driveController.setRumble(GenericHID.RumbleType.kRightRumble, 1);
		}
	}

	public boolean gearSwitch()
	{
		return driveController.getRawButton(4);
	}
	//returns yaw movement input//**
	//public double getLeftInput(){
	//	double in = mainController.getRawAxis(2);
	//	return Math.abs(in)* 1 > TRIGGER_DEADZONE ? in : 0;
	//}
	//public double getRightInput(){
	//	double in = mainController.getRawAxis(3);
	//	return Math.abs(in)* 1 > TRIGGER_DEADZONE ? in : 0;
	//}
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
}
