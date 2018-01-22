package org.usfirst.frc.team2875.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class Input{
	public static final double JOY_DEADZONE = 0.15;
	public static final double TRIGGER_DEADZONE = 0.02;
	//// CREATING BUTTONS
	public Joystick mainController;
	private Joystick subordanateController;
	
	public Input(){
		mainController = new Joystick(0);
		subordanateController = new Joystick(1);
		subordanateController.setRumble(GenericHID.RumbleType.kLeftRumble, 1.0);
		subordanateController.setRumble(GenericHID.RumbleType.kRightRumble,1.0);
	}
	public void init(){
	
	}
	public boolean getAutoAlign(){
		return mainController.getRawButton(1);
	}
	public boolean getEmergencyStop(){
		return false;
			
	}


	public boolean getClutchSwitch(){
		return mainController.getRawButton(3);
	}
	public boolean getAutoAlignCancel(){
		return mainController.getRawButton(5);
	}
	public boolean getGearSwitch(){
		return mainController.getRawButton(4);
	}
	//returns forward and backward movement input
	public double getForwardInput(){
		
		double in = mainController.getRawAxis(1);
		return (Math.abs(in) > JOY_DEADZONE) ? in : 0;
	}
	//returns yaw movement input
	public double getLeftInput(){
		double in = mainController.getRawAxis(2);
		return Math.abs(in)* 1 > TRIGGER_DEADZONE ? in : 0;
	}
	public double getRightInput(){
		double in = mainController.getRawAxis(3);
		return Math.abs(in)* 1 > TRIGGER_DEADZONE ? in : 0;
	}
	
	public double getStrafeInput(){
		double in = mainController.getRawAxis(4);
		return (Math.abs(in) > (JOY_DEADZONE)) ? in : 0;
	}
	
	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

}
