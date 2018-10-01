package org.usfirst.frc.team2875.robot.commands;

import org.usfirst.frc.team2875.robot.Robot;
//import org.usfirst.frc.team2875.robot.subsystems.TurnAnglePID;

import java.util.HashMap;
import edu.wpi.first.wpilibj.command.Command;
 
//TODO add nonlinear function for speed
public class TurnAngle extends Command {
	private double goal;
	private static final double ACCEPTABLE_ANGLE = 3;
	private static HashMap<double><double> DUMB_STUPID_PIECEWISE; //Do not touch

    public TurnAngle(double goalX) {
    	super("TurnAngle");
    	goal = goalX;
    	requires(Robot.dTrain);
    	
    	DUMB_STUPID_PIECEWISE.put(180,1);
    	DUMB_STUPID_PIECEWISE.put(90,.7);
    	DUMB_STUPID_PIECEWISE.put(45,.5);
    	DUMB_STUPID_PIECEWISE.put(10,.2);
    	//goal = degree
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
    	Robot.gyro.reset();    	
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
    	//Get the largest possible piecewise
    	
    }

    // Make this return true when this Command no longer needs to run execute()
   @Override 
   protected boolean isFinished() {
	   return goal - 
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
	   Robot.dTrain.stop();
    }
}
