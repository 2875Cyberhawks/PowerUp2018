package org.usfirst.frc.team2875.robot;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;

public class Gearbox {
	// TODO make gearbox a subsystem
	boolean inverted = false;
    SpeedController controller1, controller2, controller3;
    
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
}
