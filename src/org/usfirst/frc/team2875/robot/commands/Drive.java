package org.usfirst.frc.team2875.robot.commands;

import org.usfirst.frc.team2875.robot.Robot;
import com.analog.adis16448.frc.ADIS16448_IMU;
import edu.wpi.first.wpilibj.command.Command;


/**
 *
 */
public class Drive extends Command {
	private double[] constants = {1,1};

    public Drive() {
    	super("Drive");
    	requires(Robot.dTrain);
    }
    
    public Drive(double[] constantsI)
    {
    	super("Drive");
    	requires(Robot.dTrain);
    	this.constants = constantsI;
    }

    // Called just before this Command runs the first time
    protected void initialize() {}
    
    
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double turning = Robot.oi.getTurningDegree();
    	double forward = Robot.oi.getForwardInput();
    	if (turning == 0)straightDrive(forward);
    	else
    	{
    		double speedR, speedL;
    		speedL = turning + forward;
    		speedR = -turning + forward;
    		speedL *= constants[0];
    		speedR *= constants[1];
    		Robot.dTrain.setSpeed(speedL,speedR);
    	}
    	if (Robot.oi.getClutch()) Robot.dTrain.toggleClutch();
    }
    protected static void straightDrive(double forward)
    {
    	System.out.println("F: " + forward);
    	double speedL,speedR;
    	double lEncode = Robot.dTrain.lEncode.getRate();
    	double rEncode = Robot.dTrain.rEncode.getRate();
    	speedL = forward * (lEncode/rEncode);
    	speedR = forward * (rEncode/lEncode);
    	System.out.println("L: " + speedL);
    	System.out.println("R: " + speedR);
    	Robot.dTrain.setSpeed(speedL,speedR);
    }
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.dTrain.stop();
    }
    
    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
    
    
}