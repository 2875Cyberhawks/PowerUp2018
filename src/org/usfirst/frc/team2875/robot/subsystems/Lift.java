package org.usfirst.frc.team2875.robot.subsystems;

import org.usfirst.frc.team2875.robot.commands.LiftCmd;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * :D
 *Raffi Stinks
 */
public class Lift extends PIDSubsystem {
	public static final int[][] positions = new int[4][2];
	SpeedController controller;
	Encoder encoder;
	
	public Lift(int c1, int e1, int e2) {
		//Name and P, I, D constants
		super("Lift", 2.0, 0.0, 0.0);
		this.setAbsoluteTolerance(0.05);
		this.getPIDController().setContinuous(false);
		controller = new Talon(c1);
	}
		
	public void stop()
	{
		controller.set(0);
	}
	
    public void initDefaultCommand() {
        setDefaultCommand(new LiftCmd());
    }

	@Override
	protected double returnPIDInput() {
		// MIGHT HAVE TO CONVERT
		return encoder.getRate();
	}

	@Override
	protected void usePIDOutput(double output) {
		controller.pidWrite(output);
	}
}