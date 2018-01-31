package org.usfirst.frc.team2875.robot.subsystems;

import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Encoders extends Subsystem {

	private Encoder rightEncoder;
	private Encoder leftEncoder;

	public Encoders() {

		//TODO set the correct pins
		//TODO calibrate the distance
		rightEncoder = new Encoder(6, 7, true, EncodingType.k1X);
		//rightEncoder.setDistancePerPulse(.148)
		leftEncoder = new Encoder(8, 9, true, EncodingType.k1X);
		//leftEncoder.setDistancePerPulse(.148);
	}

	public double getLeftSpeed() {
		return leftEncoder.getRate();
	}
	public double getRightSpeed() {
		return rightEncoder.getRate();
	}
	
	public void reset() {
		leftEncoder.reset();
		rightEncoder.reset();
	}

	public double getLeftEncoder() {
		return leftEncoder.getDistance();
	}
	public double getRightEncoder() {
		return rightEncoder.getDistance();
	}
	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public void initDefaultCommand() {
		setDefaultCommand(null);
	}
}

