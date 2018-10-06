package org.usfirst.frc.team2875.robot.commands;

import org.usfirst.frc.team2875.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;


/**
 *
 */
public class Drive extends Command {
	private static final double ANGLE_SPEED = 100;
	private static final double STRAIGHT_CONST = 180;
	private static final double MINIMUM_TURN = .1;
	private static boolean isForward = false;
	//private static final double HEIGHT_CONSTANT = .3;


    public Drive() {
    	super("Drive");
    	requires(Robot.dTrain);
    }
    
    public Drive(double[] constantsI)
    {
    	super("Drive");
    	requires(Robot.dTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {}
    
    
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double forward = Robot.oi.getForwardInput();
    	double turning = Robot.oi.getTurningDegree();
    	double heightEffect = ((21-Robot.lift.getDistance())/21);
    	forward *= (.8 + (.3 * heightEffect));
    	turning *= (.8 + (.3 * heightEffect));
    	//System.out.println(Robot.dTrain.getDistances()[0] + " "+ Robot.dTrain.getDistances()[1]);
		if (Math.abs(turning) < MINIMUM_TURN && !isForward)
		{
			Robot.gyro.reset();
			isForward = true;
			straightDriveGyro(forward, 0);
		}else if(Math.abs(turning) > MINIMUM_TURN) {
			isForward = false;
			move(turning, forward);
    	}else if(isForward) {
			straightDriveGyro(forward, 0);
		}
    }
    
    public static void move(double turning, double forward){
    	double speedR, speedL;
    	//double turning = turningX/(HEIGHT_CONSTANT * (Robot.lift.getDistance()/Lift.MAX_HEIGHT));
    	speedL = -forward + turning;
    	speedR = forward + turning;
    	//speedL *= constants[0];
    	//speedR *= constants[1];
    	Robot.dTrain.setSpeed(speedL,speedR);
    }
    
    public static boolean straightDriveGyro(double forward, double goalAngle) {
    	double currentError = Robot.gyro.getAngleZ() - goalAngle;
    	//System.out.println(currentError);
    	if(forward != 0) {
    		move(currentError / STRAIGHT_CONST,forward);
    	}else {
    		move(0,0);
    	}
    	//System.out.println("Moving Straight:");
    	//System.out.println("Current turn error is " + currentError);
    	//System.out.println("Current forward speed is " + forward);
    	//System.out.println("Str: " + currentError + " - " + forward);
    	System.out.println("Encode " + Robot.dTrain.getDistance());
    	//System.out.println(Robot.dTrain.getDistances()[0] + " " + Robot.dTrain.getDistances()[1]);
    	return currentError < 45;
    	
    }
    
    public static void turnAngleGyro(double degree)
    {
    	double diff = degree - Robot.gyro.getAngleZ();
    	int direction = -1;
    	if (diff < 0) direction = 1;
    	double speed = direction * (.55 * (Math.abs(diff)/ANGLE_SPEED) + .45);
    	speed = speed * .7;
    	System.out.println("Turning: " + diff + " - " + speed);
    	//if (diff < 0) speed = 4 * Math.log(1-(-diff/90));
    	//System.out.println("Difference :" + diff);
    	//System.out.println("Degree :" + degree);
    	//System.out.println("Speed :" + speed);
    	move(speed,0);
    }
    
    /*public static boolean straightDriveEncoders(double forward) {
    	double rateDiff = Robot.dTrain.l.getRate() - Robot.dTrain.r.getRate();
    	move(rateDiff / 5, forward);
    	return rateDiff < 90;
    }*/
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.dTrain.stop();
    }
    
    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
    
    
}