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
	private SpeedControllerGroup rControl;
	private SpeedControllerGroup lControl;
	private Encoder lEncode;
	private Encoder rEncode;
	private Solenoid sole;
	
	public Drivetrain(int t1, int t2, int t3, int t4, int t5, int t6, int e1, int e2, int e3, int e4, int s)
	{	
		rControl = new SpeedControllerGroup(new Talon(t1), new Talon(t2), new Talon(t3));
		lControl = new SpeedControllerGroup(new Talon(t4), new Talon(t5), new Talon(t6));
		lEncode = new Encoder(e1,e2);
		rEncode = new Encoder(e3,e4);
		sole = new Solenoid(s);
	}
	
	public void setSpeed(double left, double right)
	{
		lControl.set(left);
		rControl.set(right);
	}
	
	public void reset()
	{
		lEncode.reset();
		rEncode.reset();
	}
	
	public void setClutch(boolean on)
	{
		sole.set(on);
	}
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	public void stop()
	{
		lControl.set(0);
		rControl.set(0);
	}
    public void initDefaultCommand() {
    	setDefaultCommand(new Drive());
    }
}