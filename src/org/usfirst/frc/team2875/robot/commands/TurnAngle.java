package org.usfirst.frc.team2875.robot.commands;

import org.usfirst.frc.team2875.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
//TODO add nonlinear function for speed
public class TurnAngle extends Command {
	private double goal;
	private boolean movingL = false;
	private static final double mVal = -.7;
	private static final double bVal = 1;
	
	
    public TurnAngle(double degree) {
    	super("TurnAngle");
    	requires(Robot.dTrain);
    	goal = degree;
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
    	Robot.gyro.reset();
    	if (goal < 0)movingL=true;
    	goal = Math.abs(goal);
    }

    // Called repeatedly when this Command is scheduled to run
   @Override
    protected void execute() {
    	double speed = bVal + (mVal * (Robot.gyro.getAngle() / goal));
    	if (movingL) speed *= -1;
    	if(goal < Robot.gyro.getAngle())Robot.dTrain.setSpeed(-speed, speed);
    	else Robot.dTrain.setSpeed(speed,-speed);
    }

    // Make this return true when this Command no longer needs to run execute()
   @Override 
   protected boolean isFinished() {
       return Math.abs(Robot.gyro.getAngle()) >=goal;
    }

    // Called once after isFinished returns true
   @Override 
   protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
   @Override 
   protected void interrupted() {
    }
}
