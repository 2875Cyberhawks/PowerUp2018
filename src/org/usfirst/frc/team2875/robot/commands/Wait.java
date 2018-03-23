package org.usfirst.frc.team2875.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class Wait extends Command{
	double startTime;
	double timeToFinish;
	public Wait(double time) {
		startTime = Timer.getFPGATimestamp();
		timeToFinish = time;
	}


	@Override
	protected boolean isFinished() {
		
		return (Timer.getFPGATimestamp() - startTime) >= timeToFinish;
	}

}
