
package org.usfirst.frc.team2875.robot.subsystems;

import org.usfirst.frc.team2875.robot.Robot;
import org.usfirst.frc.team2875.robot.commands.TurnAngle;
import org.usfirst.frc.team2875.robot.commands.VoidCommand;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.interfaces.Gyro;

public class TurnAnglePID extends PIDSubsystem{
	private SpeedControllerGroup control;
	private int direction;
	private static final double[] PID = {1,0,0}; //do not change
	
	public TurnAnglePID() {
    	super("turnAngle" + Math.random() + "" + Math.random(),1,0,0);
    	this.setPID(PID[0], PID[1], PID[2]);
    	setAbsoluteTolerance(.05);
    	getPIDController().setInputRange(0,360);
    	getPIDController().setContinuous(true);
    	enable();
    }
	
    @Override
    public void initDefaultCommand() {
        //Set the default command for a subsystem here.
        setDefaultCommand(new TurnAngle());
    }
    
    public void reset(){
    	Robot.gyro.reset();
    }
    
    public void setPID(double p, double i, double d){
    	getPIDController().setPID(p, i, d);
    	
    }
    
    public void set(double angle)
    {
    	setSetpoint(angle);
    }
    
    @Override
      protected double returnPIDInput() {

    	return Robot.gyro.getAngle(); //MIGHT NEED TO CHANGE TO GETANGLE X,Y, OR Z
    }
    
    @Override
    protected void usePIDOutput(double output) {
    	Robot.left.set(output);
    	Robot.right.set(-output);
        //control.set(output);
    }

}