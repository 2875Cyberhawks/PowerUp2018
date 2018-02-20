package org.usfirst.frc.team2875.robot.subsystems;

import org.usfirst.frc.team2875.robot.Robot;
import org.usfirst.frc.team2875.robot.commands.LiftCmd;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * :D
 */
public class Lift extends PIDSubsystem {
	//Liam smells good
	//TODO set position values
	//public static final double[] positions = {0,0,0,0};
	private final static double[][] pids = {{1,0,0},{.3,.6,0}};//auto,teleop
	SpeedController lIntake,rIntake;
	SpeedControllerGroup lift;
	Encoder encoder;
	Solenoid openSol;
	Solenoid liftSol;
	double height;
	private static final double MAX_ENCODER_SPEED = 17;
	private static final double SPOOLING_CONSTANT = 1.01;//Constant to account for spooling of the motor
	public static final double MAX_HEIGHT = 10;
	boolean teleop = false;
	
	public Lift(int li,int lii, int wl,int wr, int e1, int e2,int so, int so2) {
		//Name and P, I, D constants
		super("Lift",0,0,0);
		Spark lift1 = new Spark(li);
		Spark lift2 = new Spark(lii);
		lift = new SpeedControllerGroup(lift1,lift2);
		setAbsoluteTolerance(.01);
		rIntake = new Spark(wl);
		lIntake = new Spark(wr);
		//rIntake.setInverted(true);
		//lIntake.setInverted(true);
		encoder = new Encoder(e1,e2);
		//encoder.setReverseDirection(true);
		encoder.setDistancePerPulse(SPOOLING_CONSTANT * ((.75*Math.PI)/360));
		openSol = new Solenoid(so);
		liftSol = new Solenoid(so2);
		height = 0;
		//lift.setInverted(true);
		enable();
		
	}
		
	public void stop(){
		disable();
		lift.set(0);
		lIntake.set(0);
		rIntake.set(0);
	}
	
	@Override
    public void initDefaultCommand() {
        setDefaultCommand(new LiftCmd());
    }
    
    public void raiseLift(double speed)
    {
    	teleop = true;
    	getPIDController().setPID(pids[1][0], pids[1][1], pids[1][2]);
    	//if (Math.abs(speed) <= .1) {
    		//getPIDController().setI(.6);
    	//getPIDController().setP(.3);
    	//System.out.println("Speed: " + speed);
    	//System.out.println("High Switch: " + Robot.lsHigh.get());
    	if (speed > 0 && !Robot.lsLow.get())
    		speed = 0;
    	if  (speed < 0 && !Robot.lsHigh.get())
    		speed = 0;
    	if (Math.abs(speed) < .05) {
    		enable();
    		setSetpoint(0);
    	}else {
    		disable();
    		lift.set(speed);
    	}
    	//setSetpoint(speed);
    	//System.out.println("Setpoint: " + speed);
    	//raiseToPost(encoder.getDistance() + (speed* MANUAL_SPEED_CONSTANT));
    }
    
    public void raiseToPost(double pos)
    {
    	//enable();
    	teleop = false;
    	getPIDController().setPID(pids[0][0], pids[0][1], pids[1][1]);
    	height = pos;
    	if (Robot.lsLow.get() || Robot.lsHigh.get())
    		pos = encoder.getDistance();
    	setSetpoint(pos);
    	//System.out.println("Setpoint at: " + pos);
    }
    
    public void wheelMove(double[] speed){
    	lIntake.set(speed[0]);
    	rIntake.set(speed[1]);
    }
    
    public void toggleOpenSol()
    {
    	openSol.set(!openSol.get());
    }
    public boolean getOpenSol()
    {
    	return openSol.get();
    }
    public void toggleLiftSol()
    {
    	liftSol.set(!liftSol.get());
    }
    public boolean getLiftSol() {return liftSol.get();}
    
    public double getDistance()
    {
    	return encoder.getDistance();
    }
    
    public void reset()
    {
    	encoder.reset();
    }
    
	@Override
	protected double returnPIDInput() {
		// MIGHT HAVE TO CONVERT
		//System.out.println("PID loop in: " + encoder.getDistance());
		if (teleop)
		{
			//System.out.println("Encoder rate: " + (encoder.getRate()/MAX_ENCODER_SPEED));
			return encoder.getRate() / MAX_ENCODER_SPEED;
		}
		return encoder.getDistance();
	}

	@Override
	protected void usePIDOutput(double output) {
		if (teleop)
		{
			lift.set(output);
			//System.out.println("PIDOut: " + output);
			return;
		}
		lift.pidWrite(output);
		//System.out.println("PID loop out: " + output);
	}
}