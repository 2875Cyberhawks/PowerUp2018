package org.usfirst.frc.team2875.robot.subsystems;

import org.usfirst.frc.team2875.robot.Robot;
import org.usfirst.frc.team2875.robot.commands.VoidCommand;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

/** 
 * 
 */
public class DriveSide extends PIDSubsystem {
	private SpeedControllerGroup control;
	private static final double WHEEL_RAD = 4.000;
	private static double normalizer=11000;
	public Encoder encode;
	public boolean right;
	private static double[] clutchUnengaged = {1,0,0}; //do not change
	private static double[] clutchEngaged ={1,0,0};  //do not change
    // Initialize your subsystem here
	
	
	public DriveSide(boolean rightSide, int t1,int t2, int t3, int e1, int e2, double[] PVE, double[] PVU) {
    	super("driveSide" + rightSide + Math.random() + "" + Math.random(), 0,0,0);
    	clutchUnengaged = PVU;
    	clutchEngaged = PVE;
    	right = rightSide;
    	this.setPID(clutchUnengaged[0], clutchUnengaged[1], clutchUnengaged[2]);
    	setAbsoluteTolerance(.05);
    	getPIDController().setContinuous(false);
    	control = new SpeedControllerGroup(new Spark(t1),new Spark(t2), new Spark(t3));
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
    
    public void setPID(double p, double i, double d){
    	getPIDController().setPID(p, i, d);
    }
    public void engageClutch() {
    	setPID(clutchEngaged[0],clutchEngaged[1],clutchEngaged[2]);
    	normalizer = 30000;
    }
    public void disengageClutch() {
    	setPID(clutchUnengaged[0],clutchUnengaged[1],clutchUnengaged[2]);
    	normalizer = 11000;
    }
    public void set(double speed)
    {	
    	setSetpoint(speed);
    }
    
    @Override
      protected double returnPIDInput() {
    	double val = encode.getRate();
    	System.out.println(val);
    	return val/normalizer;
    }
    
    @Override
    protected void usePIDOutput(double output) {
        control.set(output);
    }
    
    public double getDistance(){
    	return encode.getDistance();
    }
}