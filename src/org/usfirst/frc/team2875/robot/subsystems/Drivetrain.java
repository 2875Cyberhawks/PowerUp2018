package org.usfirst.frc.team2875.robot.subsystems;

import org.usfirst.frc.team2875.robot.Robot;
import org.usfirst.frc.team2875.robot.commands.Drive;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 */
 
public class Drivetrain extends Subsystem {
	public static final double wRadius = 4;
//	public DriveSide right;
//	public DriveSide left;
	public Encoder l;
	public Encoder r;

	public Drivetrain() {
		l = new Encoder(0,1);
    	l.setDistancePerPulse((Math.PI * 2 * 4)/(360/3) * 13/12);
    	r = new Encoder(2,3);
    	r.setDistancePerPulse((Math.PI * 2 * 4)/(360/3) * 13/12);
    	r.setReverseDirection(true);
	}
	
	public Drivetrain(int t1, int t2, int t3, int t4, int t5, int t6, int e1, int e2, int e3, int e4)
	{	
		double[] lEn = {1,0,0};
		double[] rEn = {1,0,0};
		double[] lUn = {1,0,0};
		double[] rUn = {1,0,0};
		//left = new DriveSide(false,t4,t5,t6,e3,e4,lEn,lUn);
		//right = new DriveSide(true,t1,t2,t3,e1,e2,rEn,rUn);
	}
	
	public void setSpeed(double leftI, double rightI)
	{
		Robot.left.setSpeed(-leftI);
		Robot.right.setSpeed(rightI);
		//left.set(leftI);
		//right.set(rightI);
	}
	
	public void reset()
	{
		l.reset();
		r.reset();
	}
	

	public void stop()
	{
		Robot.left.setSpeed(0);
		Robot.right.setSpeed(0);
	}
    public void initDefaultCommand() {
    	setDefaultCommand(new Drive());
    }
    
    public double[] getDistances()
    {
    	double[] m = new double[2];
    	m[0] = r.getDistance();
    	m[1] = l.getDistance();
    	return m;
    }
}