package org.usfirst.frc.team2875.robot.subsystems;

import org.usfirst.frc.team2875.robot.Robot;
import org.usfirst.frc.team2875.robot.commands.Drive;
import edu.wpi.first.wpilibj.Encoder;
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
    	l.setDistancePerPulse(((Math.PI * 2 * 4)/(360/3) * 13/12));
    	r = new Encoder(2,3);
    	r.setDistancePerPulse(((Math.PI * 2 * 4)/(360/3) * 13/12)*2);
    	r.setReverseDirection(true);
	}
	
	public Drivetrain(int t1, int t2, int t3, int t4, int t5, int t6, int e1, int e2, int e3, int e4)
	{
	}
	
	public void setSpeed(double leftI, double rightI)
	{
		Robot.left.set(-leftI);
		Robot.right.set(rightI);
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
		Robot.left.set(0);
		Robot.right.set(0);
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