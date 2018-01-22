package org.usfirst.frc.team2875.robot.commands;

import org.usfirst.frc.team2875.robot.*;

import edu.wpi.first.wpilibj.command.Command;

/**
 * This command allows xbox 360 controller to drive the robot. It is always running
 * except when interrupted by another command.
 */
public class Drive extends Command {
	public Drive() {
		requires(Robot.driveTrainSys);
	}

	protected void initialize() {
	}

	protected void execute() {
		Robot.driveTrainSys.drive(Robot.in.getForwardInput(),Robot.in.getLeftInput(),Robot.in.getRightInput(),Robot.in.getStrafeInput());
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
		Robot.driveTrainSys.stop();
	}

	protected void interrupted() {
		end();
	}
}