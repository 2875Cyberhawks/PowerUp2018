package org.usfirst.frc.team2875.robot;

import edu.wpi.first.wpilibj.XboxController;

/**
 * This class is the ducktape and zipties that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	public static final double JOY_DEADZONE = 0.15;
	public static final double TRIGGER_DEADZONE = 0.02;
	//// CREATING BUTTONS
	public XboxController driveController;
	public XboxController liftController;
	public OI(){
		driveController = new XboxController(0);
		liftController = new XboxController(1);
	}

	public boolean getEmergencyStop(){
		return false;
	}
	
	//returns forward and backward movement input
	public double getForwardInput(){
		double in = -1 * driveController.getRawAxis(1);
		return (Math.abs(in) > JOY_DEADZONE) ? in : 0;
	}

	public double[] getTurning() {
		//From OED:
		//Old English lyft, left �weak� (the left-hand side being regarded as the weaker side of the body), of West Germanic origin.
		//Old English riht (adjective and noun), rihtan (verb), rihte (adverb), of Germanic origin; related to Latin rectus �ruled�, from an Indo-European root denoting movement in a straight line.
		double lyft = driveController.getRawAxis(3);
		double riht = driveController.getRawAxis(2);
		if (lyft < JOY_DEADZONE) lyft = 0;
		if (riht < JOY_DEADZONE) riht = 0;
		double[] out = new double[2];
		out[1] = lyft;
		out[0] = riht;
		return out;
	}

	public double getTurningDegree() {
		double[] raw = getTurning();
		return raw[0]-raw[1]; 
	}
	public int wheelControl() {
		return 0;
		/*double speed =  driveController.getY(GenericHID.Hand.kRight);
		if (Math.abs(speed) < JOY_DEADZONE) {
			return 0;
		}
		else if(speed < 0) {
			return -1;
		}
		else {
			return 1;
		}*/
	}
	

	
	/*public boolean button6() {
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
	*/
	/*
	public boolean getLift1(){
		return liftController.getAButton();
	}
	
	public boolean getLift2(){
		return liftController.getBButton();
	}

	public boolean getLift3(){
		return liftController.getXButton();
	}

	public boolean getLift4(){
		return liftController.getYButton();
	}*/
	public double lift(){
		double v = liftController.getRawAxis(2) - liftController.getRawAxis(3);
		double rV = -.55 * Math.log10(1-Math.abs(v));
		if (v < 0) rV *= -1;
		return rV;
	}

	//driver A
	
	//driver B
	public double[] cubeIntake() {
		double[] m = new double[2];
		m[0] = liftController.getRawAxis(0);
		m[1] = liftController.getRawAxis(4);
		return m;
	}
	
	
	//might want to reverse clutch and switch buttons
	
	public boolean getClutch(){
		return driveController.getRawButton(3);
	}
	
	public boolean getLiftSol() {
		return liftController.getRawButton(3);
	}
	
	public boolean getOpenSol() {
		return driveController.getRawButton(2) || liftController.getRawButton(4);
	}
	
	//driver X
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
