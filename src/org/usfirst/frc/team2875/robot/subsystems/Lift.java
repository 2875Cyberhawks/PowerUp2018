package org.usfirst.frc.team2875.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Lift extends Subsystem {
SpeedController controller1;
	public Lift(int pin) {
   controller1 = new Talon(pin);
	}
	
	public void setLift(double speed) {
		//TODO fix this depending on how they set up the lifter.
		controller1.set(speed);
	}
	public void stop()
	{
		controller1.set(0);
	}
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

