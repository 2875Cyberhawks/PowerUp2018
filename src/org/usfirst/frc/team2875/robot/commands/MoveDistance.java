package org.usfirst.frc.team2875.robot.commands;

import org.usfirst.frc.team2875.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class MoveDistance extends Command {
	private double distance;
	private double speed = .9;
	
    public MoveDistance(double distanceI) {
        super("MoveDistance");
        requires(Robot.dTrain);
        this.distance = distanceI;
        if (distance < 0)speed *= -1;
    }
    public MoveDistance(double distanceI, double speedI) {
        super("MoveDistance");
        requires(Robot.dTrain);
        this.distance = distanceI;
        this.speed = speedI;
    }
    

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.dTrain.lEncode.reset();
    	Robot.dTrain.rEncode.reset();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Drive.straightDrive(speed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        double avg = Robot.dTrain.lEncode.getDistance() + Robot.dTrain.rEncode.getDistance();
        avg = avg / 2;
        return avg >= distance;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
