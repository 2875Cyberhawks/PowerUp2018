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
	//Liam smells good
	//TODO set position values
	public static final double[] positions = {0,0,0,0};
	SpeedController lift,wheelL,wheelR;
	Encoder encoder;
	
	public Lift(int li, int wl,int wr, int e1, int e2) {
		//Name and P, I, D constants
		super("Lift", 2.0, 0.0, 0.0);
		this.setAbsoluteTolerance(0.05);
		this.getPIDController().setContinuous(false);
		lift = new Talon(li);
		wheelL = new Talon(wl);
		wheelR = new Talon(wr);
		wheelR.setInverted(true);
		encoder = new Encoder(e1,e2);
	}
		
	public void stop(){
		lift.set(0);
		wheelL.set(0);
		wheelR.set(0);
	}
	
    public void initDefaultCommand() {
        setDefaultCommand(new LiftCmd());
    }
    
    public void liftTo(int position)
    {
    	this.setSetpoint(positions[position]);
    }
    
    public void wheelMove(int pos)
    {
    	wheelL.set(pos);
    	wheelR.set(pos);
    }

	@Override
	protected double returnPIDInput() {
		// MIGHT HAVE TO CONVERT
		return encoder.getDistance();
	}

	@Override
	protected void usePIDOutput(double output) {
		lift.pidWrite(output);
	}
}