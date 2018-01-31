package org.usfirst.frc.team2875.robot.subsystems;

import org.usfirst.frc.team2875.robot.Robot;
import org.usfirst.frc.team2875.robot.commands.Drive;

import edu.wpi.first.wpilibj.command.Subsystem;
/**
 *
 */
public class Drivetrain extends Subsystem {
	private final static double[] constants = {1,1};
	
	public void setSpeed(double forward, double turning)
	{
		double speedR, speedL;
		speedL = turning + forward;
		speedR = -turning + forward;
		Robot.lGearbox.setSpeed(speedR * constants[0]);
		Robot.rGearbox.setSpeed(speedL * constants[1]);
	}
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	public void stop()
	{
		Robot.lGearbox.setSpeed(0);
		Robot.rGearbox.setSpeed(0);
	}
    public void initDefaultCommand() {
    	setDefaultCommand(new Drive());
    }
}

