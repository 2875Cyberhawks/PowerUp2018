package org.usfirst.frc.team2875.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Marker extends Command {
	private String message;
    public Marker(String msg) {
        message = msg;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	System.out.println(message);
    	//Timer.delay(3);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
