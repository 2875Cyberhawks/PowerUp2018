package org.usfirst.frc.team2875.robot.commands;


import org.usfirst.frc.team2875.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class LiftWheelSpeed extends Command {
	Timer time;
	double totT;
	double speed;
    public LiftWheelSpeed(double speed, double t) {
        requires(Robot.lift);
        time = new Timer();
        this.speed = speed;
        totT = t;
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
    	time.reset();
    	time.start();
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
    	double[] m = {speed,-speed};
    	Robot.lift.wheelMove(m);
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        return time.hasPeriodPassed(totT);
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
    	double[] m = {0,0};
    	Robot.lift.wheelMove(m);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
    }
}
