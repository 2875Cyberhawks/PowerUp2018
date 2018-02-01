package org.usfirst.frc.team2875.robot;

import org.usfirst.frc.team2875.robot.subsystems.PIDController;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;

public class Gearbox implements SpeedController {
	// TODO make gearbox a subsystem
	boolean inverted = false;
    SpeedController controller1, controller2, controller3;
	private Encoder rightEncoder = new Encoder(6, 7, true, EncodingType.k1X);
	private Encoder leftEncoder = new Encoder(8, 9, true, EncodingType.k1X);
    
    public Gearbox(int c1, int c2,int c3) {
    	controller1 = new Talon(c1);
    	controller2 = new Talon(c2);
    	controller3 = new Talon(c3);
    }
    
    public void setInverted(boolean invertedI)
    {
    	inverted = invertedI;
    }
    
    public void setSpeed(double speed) {
    	double sped = speed;
    	if (inverted) sped *= -1;
    	controller1.set(sped);
    	controller2.set(sped);
    	controller3.set(sped);
    }
    public void stop()
    {
    	setSpeed(0);
    }

	@Override
	public void pidWrite(double output) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public double get() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void set(double speed) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean getInverted() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void disable() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void stopMotor() {
		// TODO Auto-generated method stub
		
	}
}
