package org.usfirst.frc.team2875.robot.commands;

import org.usfirst.frc.team2875.robot.Robot;
import org.usfirst.frc.team2875.robot.subsystems.TurnAnglePID;

import edu.wpi.first.wpilibj.command.Command;


 
 
//TODO add nonlinear function for speed
public class TurnAngle extends Command {
	private double goal;
	private boolean movingForward = true;
	
    public TurnAngle(double degree) {
    	super("TurnAngle");
    	requires(Robot.dTrain);
    	goal = degree;
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
    	Robot.gyro.reset();
    	if (goal < Robot.gyro.getAngleZ()) movingForward = false;
    	
    }

    // Called repeatedly when this Command is scheduled to run
   @Override
    protected void execute() {
	   Drive.turnAngleGyro(goal);
    }

    // Make this return true when this Command no longer needs to run execute()
   @Override 
   protected boolean isFinished() {
	   if (movingForward)return Robot.gyro.getAngleZ() >= goal;
	   else return Robot.gyro.getAngleZ() <= goal;
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
