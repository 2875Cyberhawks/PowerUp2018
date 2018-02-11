package org.usfirst.frc.team2875.robot.subsystems;

import org.usfirst.frc.team2875.robot.Robot;
import org.usfirst.frc.team2875.robot.commands.VoidCommand;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

/**
 *
 */
public class DriveSide extends PIDSubsystem {
	private SpeedControllerGroup control;
	private static final double WHEEL_RAD = 4.000;
	private static final double WHEEL_NORMALIZER = 22500;
	public Encoder encode;
	public boolean right;
	private boolean clutch;
	private static final double[] cluUE = {1,0,0};
	private static final double[] cluE = {1,0,0};
    // Initialize your subsystem here
    
	
	
	public DriveSide(boolean rightSide, int t1,int t2, int t3, int e1, int e2) {
    	super("driveSide",cluUE[0],cluE[1],cluUE[2]);
    	right = rightSide;
    	setAbsoluteTolerance(.05);
    	getPIDController().setContinuous(false);
    	control = new SpeedControllerGroup(new Talon(t1),new Talon(t2), new Talon(t3));
    	encode = new Encoder(e1,e2);
    	encode.setDistancePerPulse(Math.PI * 2 * WHEEL_RAD);
    	enable();
    }
	
    @Override
    public void initDefaultCommand() {
        //Set the default command for a subsystem here.
        setDefaultCommand(new VoidCommand());
    }
    
    public void reset(){
    	encode.reset();
    }
    
    public void setpid(double p, double i, double d){
    	getPIDController().setPID(p, i, d);
    	
    }
    
    
    public void set(double speed)
    {
    	
    	setSetpoint(speed);
    	String side = "Left";
    	if (right)
    		side = "Right";
    	System.out.println(side + " Set: " + speed);
    }
    
    @Override
    protected double returnPIDInput() {
    	if (Robot.clutch.engaged())
    	{
    		this.setPID(cluE[0],cluE[1],cluE[2]);
    	}
    	else
    	{
    		this.setPID(cluUE[0],cluUE[1],cluUE[2]);
    	}
    	double val = encode.getRate();
    	if (right)
    		val *= -1;
    	val = val/WHEEL_NORMALIZER;
    	/*String side = "Left";
    	if (right)side = "Right";
    	System.out.println(side + " PIDInput: " + val);*/
    	return val;
    }
    
    @Override
    protected void usePIDOutput(double output) {
    	/*String side = "Left";
    	if (right)side = "Right";
    	System.out.println(side + " PIDOutput: " + output);*/
        control.set(output);
    }
    
    public double getDistance(){
    	return encode.getDistance();
    }
}