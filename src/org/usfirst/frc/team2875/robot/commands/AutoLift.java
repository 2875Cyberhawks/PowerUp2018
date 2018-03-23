package org.usfirst.frc.team2875.robot.commands;

import org.usfirst.frc.team2875.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoLift extends Command {
	private double height;
	private static final double DEADZONE = 3;
	//private static final double speed = .5;
	//private int direction;
	
    public AutoLift(double heightX) {
        requires(Robot.lift);
        height = heightX;
        //if (height > Robot.lift.getDistance()) direction = 1;
        //else direction = -1;
    }
    
    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
    	//this.setTimeout(1.5);
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
    	Robot.lift.raiseLift(-.3);
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
    	//Syste
       //if (direction == -1)
    	System.out.println("Height is: " + Robot.lift.getDistance());
    	System.out.println("Goal is: " + height);
        return Math.abs(Math.abs(Robot.lift.getDistance()) - height) < DEADZONE;
        //return Robot.lift.getDistance() <= height;
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
    	Robot.lift.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
    }
}
