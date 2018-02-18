package org.usfirst.frc.team2875.robot.subsystems;

import org.usfirst.frc.team2875.robot.commands.LiftCmd;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * :D
 */
public class Lift extends Subsystem {
	//Liam smells good
	//TODO set position values
	//public static final double[] positions = {0,0,0,0};
	SpeedController lIntake,rIntake;
	SpeedControllerGroup lift;
	Encoder encoder;
	Solenoid sol;
	
	public Lift(int li,int lii, int wl,int wr, int e1, int e2,int so) {
		//Name and P, I, D constants
		super("Lift");
		Spark lift1 = new Spark(li);
		Spark lift2 = new Spark(lii);
		lift = new SpeedControllerGroup(lift1,lift2);
		rIntake = new Spark(wl);
		lIntake = new Spark(wr);
		rIntake.setInverted(true);
		encoder = new Encoder(e1,e2);
		encoder.setDistancePerPulse((.75*Math.PI)/360);
		sol = new Solenoid(so);
	}
		
	public void stop(){
		lift.set(0);
		lIntake.set(0);
		rIntake.set(0);
	}
	
    public void initDefaultCommand() {
        setDefaultCommand(new LiftCmd());
    }
    
    /*public void liftTo(int position){
    	this.setSetpoint(positions[position]);
    }*/
    
    public void raiseLift(double speed)
    {
    	lift.set(speed);
    }
    
    public void wheelMove(double speed){
    	lIntake.set(speed);
    	rIntake.set(speed);
    }
    
    public void toggleSol()
    {
    	sol.set(!sol.get());
    }
    public boolean getSol()
    {
    	return sol.get();
    }
    public double getDistance()
    {
    	return encoder.getDistance();
    }
    
    public void reset()
    {
    	encoder.reset();
    }
    /*
	@Override
	protected double returnPIDInput() {
		// MIGHT HAVE TO CONVERT
		return encoder.getDistance();
	}

	@Override
	protected void usePIDOutput(double output) {
		lift.pidWrite(output);
	}*/
}