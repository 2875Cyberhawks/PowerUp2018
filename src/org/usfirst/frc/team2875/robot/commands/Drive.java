package org.usfirst.frc.team2875.robot.commands;

import org.usfirst.frc.team2875.robot.Robot;
import org.usfirst.frc.team2875.robot.subsystems.Lift;

import com.analog.adis16448.frc.ADIS16448_IMU;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.command.Command;


/**
 *
 */
public class Drive extends Command {
	private double[] constants = {1,1};
	private static final double HEIGHT_CONSTANT = .3;


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
if (Robot.lift.getDistance() > 36) {
		turning /=4;
}
    	double forward = Robot.oi.getForwardInput();
    	double speedR, speedL;
    	speedL = -turning + forward;
    	speedR = turning + forward;
    	speedL *= constants[0];
    	speedR *= constants[1];
    	Robot.dTrain.setSpeed(speedL,speedR);
    }
    
    public static void move(double turning, double forward){
    	double speedR, speedL;
    	//double turning = turningX/(HEIGHT_CONSTANT * (Robot.lift.getDistance()/Lift.MAX_HEIGHT));
    	speedL = turning + forward;
    	speedR = -turning + forward;
    	//speedL *= constants[0];
    	//speedR *= constants[1];
    	
    	Robot.dTrain.setSpeed(speedL,speedR);
    }
    
    public static boolean straightDriveGyro(double forward, double goalAngle) {
    	double currentError = Robot.gyro.getAngleZ() - goalAngle;
    	System.out.println(currentError);
    	move(currentError / 180,forward);
    	return currentError < 45;
    	
    }
    
    public static void turnAngleGyro(double degree)
    {
    	double diff =degree - Robot.gyro.getAngleZ();
    	double speed = -4 * Math.log(1-(diff/90));
    	if (diff < 0) speed = 4 * Math.log(1-(-diff/90));
    	move(speed,0);
    }
    
    public static boolean straightDriveEncoders(double forward) {
    	double rateDiff = Robot.dTrain.l.getRate() - Robot.dTrain.r.getRate();
    	move(rateDiff / 5, forward);
    	return rateDiff < 90;
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