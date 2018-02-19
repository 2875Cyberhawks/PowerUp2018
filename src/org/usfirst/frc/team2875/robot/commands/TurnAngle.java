package org.usfirst.frc.team2875.robot.commands;

import org.usfirst.frc.team2875.robot.Robot;
import org.usfirst.frc.team2875.robot.subsystems.TurnAnglePID;

import edu.wpi.first.wpilibj.command.Command;


 
 
//TODO add nonlinear function for speed
public class TurnAngle extends Command {
	private double goal;
	
    public TurnAngle() {
    	super("TurnAngle");
    	requires(Robot.pidT);
    	//goal = degree;
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
    	Robot.gyro.reset();
    	
    }

    // Called repeatedly when this Command is scheduled to run
   @Override
    protected void execute() {
	   
    	if (!isFinished()) {
    		Robot.pidT.enable();
    		Robot.pidT.set(goal);
    	}else {
    		end();
    	}
    }
   
   	public TurnAngle setAngle(double an) {
   		goal = an;
   		return this;
   	}

    // Make this return true when this Command no longer needs to run execute()
   @Override 
   protected boolean isFinished() {
	  if (Robot.pidT.onTarget())
		  return true;
	  return false;
    }

    // Called once after isFinished returns true
   @Override 
   protected void end() {
	   Robot.pidT.disable();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
   @Override 
   protected void interrupted() {
    }
}
