package org.usfirst.frc.team2875.robot.commands;

import org.usfirst.frc.team2875.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class LiftCmd extends Command {

    public LiftCmd() {
    	requires(Robot.lift);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//Lift movement
    	if(Robot.oi.getLiftA()) {
    		Robot.lift.liftTo(0);
    	} else if(Robot.oi.getLiftX()) {
    		Robot.lift.liftTo(1);
    	} else if(Robot.oi.getLiftB()) {
    		Robot.lift.liftTo(2);
    	} else if(Robot.oi.getLiftY()) {
    		Robot.lift.liftTo(3);
    	}    	
    	
    	//grasper
    	if(Robot.oi.cubeIntake()) {
    		Robot.lift.wheelMove(1);
    	} else if(Robot.oi.cubeRelease()) {
    		Robot.lift.wheelMove(-1);
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.lift.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
   
}