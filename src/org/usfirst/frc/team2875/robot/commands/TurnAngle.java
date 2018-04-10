package org.usfirst.frc.team2875.robot.commands;

import org.usfirst.frc.team2875.robot.Robot;
//import org.usfirst.frc.team2875.robot.subsystems.TurnAnglePID;

import edu.wpi.first.wpilibj.command.Command;


 
 
//TODO add nonlinear function for speed
public class TurnAngle extends Command {
	private double goal;
	private static final double ACCEPTABLE_RANGE = 5;
    public TurnAngle(double goalX) {
    	super("TurnAngle");
    	goal = goalX;
    	requires(Robot.dTrain);
    	//goal = degree;
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
    	Robot.gyro.reset();    	
    }

    // Called repeatedly when this Command is scheduled to run
   @Override
    protected void execute() {
	   Drive.turnAngleGyro(goal);
    }

    // Make this return true when this Command no longer needs to run execute()
   @Override 
   protected boolean isFinished() {
	   //System.out.println("Angle is: " + Robot.gyro.getAccelZ());
	   //System.out.println("Goal is: " + goal);
	   //if (movingForward)return Robot.gyro.getAngleZ() >= goal;
	   //else return Robot.gyro.getAngleZ() <= goal;
	   return (Math.abs(Robot.gyro.getAngleZ()-goal) <= ACCEPTABLE_RANGE);
    }

    // Called once after isFinished returns true
   @Override 
   protected void end() {
	   Robot.dTrain.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
   @Override 
   protected void interrupted() {
    }
}
