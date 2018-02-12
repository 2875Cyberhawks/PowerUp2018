package org.usfirst.frc.team2875.robot.subsystems;

import org.usfirst.frc.team2875.robot.Robot;
import org.usfirst.frc.team2875.robot.commands.VoidCommand;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

/** 
 * 
 */
public class DriveSide extends PIDSubsystem {
	private SpeedControllerGroup control;
	private static final double WHEEL_RAD = 4.000;
	private static double normalizer = 11000;
	public Encoder encode;
	public boolean right;
	private boolean clutch;
	private static double[] clutchUnengaged = {1,0,0}; //do not change
	private static double[] clutchEngaged ={1,0,0};  //do not change
    // Initialize your subsystem here
	
	
	public DriveSide(boolean rightSide, int t1,int t2, int t3, int e1, int e2, double PE, double IE , double DE, double PU, double IU, double DU) {
    	super("driveSide" + rightSide + Math.random() + "" + Math.random(), PU,IU,DU);
    	clutchUnengaged[0] = PU;
    	clutchUnengaged[1] = IU;
    	clutchUnengaged[2] = DU;
    	clutchEngaged[0] = PE;
    	clutchEngaged[1] = IE;
    	clutchEngaged[2] = DE;
    	right = rightSide;
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
    
    public void setpid(double p, double i, double d){
    	getPIDController().setPID(p, i, d);
    	
    }
    public void engageClutch() {
    	setpid(clutchEngaged[0],clutchEngaged[1],clutchEngaged[2]);
    	normalizer = 33000;
    	System.out.println("pener");
    }
    public void disengageClutch() {
    	setpid(clutchUnengaged[0],clutchUnengaged[1],clutchUnengaged[2]);
    	normalizer = 11000;
    }
    public void set(double speed)
    {	
    	setSetpoint(speed);
    	//System.out.println((right ? "Right" : "Left") + " Set: " + speed);
    	//System.out.println(encode.getRate());
    }
    
    @Override
      protected double returnPIDInput() {
    	double val = encode.getRate();
    	
    	if (right)
    		val *= -1;
    	val = val/normalizer;
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