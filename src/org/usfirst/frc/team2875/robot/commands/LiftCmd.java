package org.usfirst.frc.team2875.robot.commands;

import org.usfirst.frc.team2875.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class LiftCmd extends Command {
	private boolean liftHasBeenPressed = false;
	private boolean openHasBeenPressed = false;
	//private final static double speed = 1;
    public LiftCmd() {
    	requires(Robot.lift);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {/*
    	if(Robot.oi.getLift1()) {
    		Robot.lift.liftTo(0);
    	} else if(Robot.oi.getLift2()) {
    		Robot.lift.liftTo(1);
    	} else if(Robot.oi.getLift3()) {
    		Robot.lift.liftTo(2);
    	} else if(Robot.oi.getLift4()) {
    		Robot.lift.liftTo(3);
    	}*/
    	double lv = Robot.oi.lift();
    	Robot.lift.raiseLift(lv);
    	//System.out.println(Robot.oi.liftUp() + " " + Robot.oi.liftDown());
    	//grasper
    	Robot.lift.wheelMove(Robot.oi.cubeIntake());
    	if(!liftHasBeenPressed && Robot.oi.getLiftSol()) {
    		liftHasBeenPressed = true;
    		Robot.lift.toggleLiftSol();
    	}else if(!Robot.oi.getLiftSol()){
    		liftHasBeenPressed = false;
    	}
    	if(!openHasBeenPressed && Robot.oi.getOpenSol()) {
    		openHasBeenPressed = true;
    		Robot.lift.toggleOpenSol();
    	}else if(!Robot.oi.getOpenSol()) {
    		openHasBeenPressed = false;
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
