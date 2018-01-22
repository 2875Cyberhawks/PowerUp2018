package org.usfirst.frc.team2875.robot;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;

public class Gearbox {
    SpeedController controller1, controller2, controller3;
    
    public Gearbox(int c1, int c2,int c3) {
    	controller1 = new Talon(c1);
    	controller2 = new Talon(c2);
    	controller3 = new Talon(c3);
    }
    public void setSpeed(double sped) {
    	controller1.set(sped);
    	controller2.set(sped);
    	controller3.set(sped);
    }
    public void stop()
    {
    	setSpeed(0);
    }
}
