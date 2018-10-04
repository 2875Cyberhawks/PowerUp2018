package org.usfirst.frc.team2875.robot.commands;

import org.usfirst.frc.team2875.robot.Robot;
//import org.usfirst.frc.team2875.robot.subsystems.TurnAnglePID;

import java.util.HashMap;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
 
//TODO add nonlinear function for speed
public class TurnAngle extends Command {
	private double goal;
	private int direc; // -1 is left, 1 is right
	private double deltaTheta;
	private static final double ACCEPTABLE_ANGLE = 3;
	private static final double ROBOT_RADIUS = .32; //in m
	private static final double MAX_TURN_SPEED = 100; //in m/s
	private static HashMap<Double,Double> DUMB_STUPID_PIECEWISE; //Do not touch

    public TurnAngle(double goalX) {
    	super("TurnAngle");
    	goal = Math.abs(goalX);
    	direc = (int)(goalX / goal);
    	deltaTheta = goal;
    	
    	requires(Robot.dTrain);
    	
    	DUMB_STUPID_PIECEWISE.put(180.0,1.0);
    	DUMB_STUPID_PIECEWISE.put(90.0,.7);
    	DUMB_STUPID_PIECEWISE.put(45.0,.5);
    	DUMB_STUPID_PIECEWISE.put(10.0,.2);
    	DUMB_STUPID_PIECEWISE.put(5.0,.1);
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
    	Robot.gyro.reset();    	
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
    	//Get the largest possible piecewise
    	double speed;
    	double theta;
    	
    	if (deltaTheta <= 5)
    		theta = deltaTheta;
    	else if (deltaTheta <= 10)
    		theta = 10;
    	else if (deltaTheta <= 45)
    		theta = 45;
    	else if (deltaTheta <= 90)
    		theta = 90;
    	else
    		theta = 180;
    	
    	speed = theta <= 5 ? DUMB_STUPID_PIECEWISE.get(5) : DUMB_STUPID_PIECEWISE.get(theta);
    	speed *= direc;
    	
    	Robot.right.set(speed);
		Robot.left.set(-speed);
    	
		double arcLength = (Math.PI * ROBOT_RADIUS * theta) / 180;
		double carVel = MAX_TURN_SPEED * speed; // rotational velocity && "the snack that smiles back goldfish" - Paige Vegna, 2018
		double deltaTPose = arcLength * Math.abs(carVel); // delta-spacito
		
		Timer.delay(deltaTPose);
    }

    // Make this return true when this Command no longer needs to run execute()
   @Override 
   protected boolean isFinished() {
	   deltaTheta = goal - Robot.gyro.getAngleZ();
	   return deltaTheta <= ACCEPTABLE_ANGLE;
    }

    // Called once after isFinished returns true
   @Override 
   protected void end() {
	   Robot.dTrain.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
   @Override 
   protected void interrupted() {
	   Robot.dTrain.stop();
    }
}
