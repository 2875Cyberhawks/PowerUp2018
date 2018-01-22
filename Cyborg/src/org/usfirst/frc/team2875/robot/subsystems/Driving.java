package org.usfirst.frc.team2875.robot.subsystems;

import org.usfirst.frc.team2875.robot.Robot;
import org.usfirst.frc.team2875.robot.commands.Drive;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Driving extends Subsystem{

	public Driving() {
	
	}
	
	public void drive(double forward, double left, double right, double strafe) {
		forward *= -.75;
		left *= -.75;
		right *= -.75;
		strafe *= -.75;
		
		double speedL1 = forward;
		double speedR1 = forward;
		double speedL2 = forward;
		double speedR2 = forward;
		speedL1 -= left;
		speedL2 -= left;
		speedR1 -= right;
		speedR2 -= right;
		
		speedL1 += right;
		speedL2 += right;
		speedR1 += left;
		speedR2 += left;
		
		//depends on which way the XBox contr. works
		speedL1 -= strafe;
		speedL2 += strafe;
		speedR1 += strafe;
		speedR2 -= strafe;
		
		Robot.gearBox.setSpeed(1,speedL1*SmartDashboard.getNumber("Rback", 1));
		Robot.gearBox.setSpeed(2, speedL2*SmartDashboard.getNumber("Rback", 1));
		Robot.gearBox.setSpeed(3,speedR1*SmartDashboard.getNumber("Lback", 1));
		Robot.gearBox.setSpeed(4, speedR2*SmartDashboard.getNumber("Lfront", 1));
	
}
public void stop() {
		Robot.gearBox.stop();
	}

@Override
protected void initDefaultCommand() {
	setDefaultCommand(new Drive());
}
	
}
