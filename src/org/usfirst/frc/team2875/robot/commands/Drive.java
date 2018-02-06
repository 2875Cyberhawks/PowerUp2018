package org.usfirst.frc.team2875.robot.commands;

import org.usfirst.frc.team2875.robot.Robot;

import com.analog.adis16448.frc.ADIS16448_IMU;

import edu.wpi.first.wpilibj.command.Command;
import com.analog.adis16448.frc.ADIS16448_IMU;


/**
 *
 */
public class Drive extends Command {
	private double[] constants = {1,1};
	private ADIS16448_IMU gyro;

    public Drive() {
    	super("Drive");
    	requires(Robot.dTrain);
		gyro = new ADIS16448_IMU();
    }
    
    public Drive(double[] constantsI)
    {
    	super("Drive");
    	requires(Robot.dTrain);
    	this.constants = constantsI;
		gyro = new ADIS16448_IMU();
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double turning = Robot.oi.getTurningDegree();
    	double forward = Robot.oi.getForwardInput();
		double speedR, speedL;
		speedL = turning + forward;
		speedR = -turning + forward;
		speedL *= constants[0];
		speedR *= constants[1];
    	Robot.dTrain.setSpeed(speedL,speedR);
    	if (Robot.oi.getClutch()) Robot.dTrain.toggleClutch();
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
