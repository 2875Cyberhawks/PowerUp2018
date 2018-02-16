package org.usfirst.frc.team2875.robot.subsystems;

import org.usfirst.frc.team2875.robot.Robot;
import org.usfirst.frc.team2875.robot.commands.VoidCommand;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.interfaces.Gyro;

public class TurnAnglePID extends PIDSubsystem{
	private SpeedControllerGroup control;
	private static final double[] PID = {1,0,0}; //do not change
	
	public TurnAnglePID(int t1,int t2, int t3, int t4 ,int t5, int t6) {
    	super("driveSide" + Math.random() + "" + Math.random(),1,0,0);
    	this.setPID(PID[0], PID[1], PID[2]);
    	setAbsoluteTolerance(.05);
    	getPIDController().setContinuous(true);
    	control = new SpeedControllerGroup(new Spark(t1),new Spark(t2), new Spark(t3),new Spark(t4),new Spark(t5), new Spark(t6));
    	this.getPIDController().setInputRange(0,360);
    	enable();
    }
	
    @Override
    public void initDefaultCommand() {
        //Set the default command for a subsystem here.
        setDefaultCommand(new VoidCommand());
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
        control.set(output);
    }

}
