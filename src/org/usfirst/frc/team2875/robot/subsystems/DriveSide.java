package org.usfirst.frc.team2875.robot.subsystems;

import org.usfirst.frc.team2875.robot.commands.VoidCommand;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

/**
 *
 */
public class DriveSide extends PIDSubsystem {
	private SpeedControllerGroup control;
	private static final double wheelRad = 4.0;
	private static final double maxWheelSpeed = 22500;
	public Encoder encode;
	public boolean right;
    // Initialize your subsystem here
    
	public DriveSide(boolean rightSide, int t1,int t2, int t3, int e1, int e2) {
    	super("driveSide",1,0,0);
    	right = rightSide;
    	setAbsoluteTolerance(.05);
    	getPIDController().setContinuous(false);
    	control = new SpeedControllerGroup(new Talon(t1),new Talon(t2), new Talon(t3));
    	encode = new Encoder(e1,e2);
    	enable();
    }
    @Override
    public void initDefaultCommand() {
        //Set the default command for a subsystem here.
        setDefaultCommand(new VoidCommand());
    }
    public void reset(){encode.reset();}
    
    public void set(double speed)
    {
    	setSetpoint(speed);
    	String side = "Left";
    	if (right)side = "Right";
    	System.out.println(side + " Set: " + speed);
    	encode.setDistancePerPulse(Math.PI * 2 * wheelRad);
    }
    @Override
    protected double returnPIDInput() {
    	double val = encode.getRate();
    	if  (right) val *= -1;
    	val = val/maxWheelSpeed;
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
    
    public double getDistance(){return encode.getDistance();}
}
