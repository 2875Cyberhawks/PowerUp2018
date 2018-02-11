package org.usfirst.frc.team2875.robot.subsystems;

import org.usfirst.frc.team2875.robot.commands.Drive;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Drivetrain extends Subsystem {
	public static final double wRadius = 4;
	public DriveSide right;
	public DriveSide left;
	
	public Drivetrain(int t1, int t2, int t3, int t4, int t5, int t6, int e1, int e2, int e3, int e4)
	{	
		left = new DriveSide(false,t4,t5,t6,e3,e4,1,0,0,1,0,.2);
		right = new DriveSide(true,t1,t2,t3,e1,e2,1,0,0,1,0,0);
		
		
	}
	
	public void setSpeed(double leftI, double rightI)
	{
		left.set(leftI);
		right.set(rightI);
	}
	
	public void reset()
	{
		left.reset();
		right.reset();
	}
	

	public void stop()
	{
		left.set(0);
		right.set(0);
	}
    public void initDefaultCommand() {
    	setDefaultCommand(new Drive());
    }
    
    public double[] getDistances()
    {
    	double[] m = new double[2];
    	m[0] = right.getDistance();
    	m[1] = left.getDistance();
    	return m;
    }
}