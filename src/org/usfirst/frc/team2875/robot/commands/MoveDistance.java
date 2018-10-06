package org.usfirst.frc.team2875.robot.commands;

import org.usfirst.frc.team2875.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;


public class MoveDistance extends Command {
	private double distance;
	private double speed = .70;
	
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
    @Override
    protected void initialize() {
    	Robot.gyro.reset();
    	Robot.dTrain.reset();
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
    	//Drive.move(0,speed);
    	System.out.println("MD: " + distance + " - " + getDistance());
    	if (Math.abs(distance - getDistance()) <= 10){
    		Drive.straightDriveGyro(((speed * .4) + (speed * (Math.abs(distance - getDistance()))/10)*.4), 0);
    	}else{
    		Drive.straightDriveGyro(speed, 0);
    	}
    	//System.out.println(Robot.dTrain.getDistances() [0]);
    	//if (isFinished()) end();
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected double getDistance() {
    	return Robot.dTrain.getDistance();
    }
    @Override
    protected boolean isFinished() {
    	double avg = getDistance();
        //System.out.println(avg);
        return Math.abs(avg) >= Math.abs(distance);
    }

    // Called once after isFinished returns true
    protected void end() {
    	//System.out.println("ran");
    	Robot.dTrain.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
