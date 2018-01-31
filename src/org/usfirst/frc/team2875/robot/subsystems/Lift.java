package org.usfirst.frc.team2875.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Lift extends Subsystem {
SpeedController controller1, controller2;
	public Lift(int pin1,int pin2) {
   controller1 = new Talon(pin1);
   controller2 = new Talon(pin2);
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
    //TODO find out how many motors for box intake
    public void boxIn(double speed) {
    	if (speed > 0)
    		controller2.set(1);
    	else if (speed == 0)
    		controller2.set(0);
    	else if (speed<0)	
    		controller2.set(-1);
    }
}

