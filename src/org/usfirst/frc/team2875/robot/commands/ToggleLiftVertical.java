package org.usfirst.frc.team2875.robot.commands;

import org.usfirst.frc.team2875.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ToggleLiftVertical extends Command{
	protected void execute() {
		
	}
	
	@Override
	protected boolean isFinished() {
		Robot.lift.toggleLiftSol();
		return true;
	}

}
