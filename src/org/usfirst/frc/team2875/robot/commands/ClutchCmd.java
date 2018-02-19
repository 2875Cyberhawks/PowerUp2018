package org.usfirst.frc.team2875.robot.commands;

import org.usfirst.frc.team2875.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ClutchCmd extends Command {

    public ClutchCmd() {
    	requires(Robot.clutch);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (Robot.oi.getClutch())
    		System.out.println("Clutch wants to toggle");
    		//Robot.clutch.toggleClutch();
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }
}