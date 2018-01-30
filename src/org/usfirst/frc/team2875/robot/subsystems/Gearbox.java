package org.usfirst.frc.team2875.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;


public class Gearbox extends Subsystem{
	boolean inverted = false;
    SpeedController controller1, controller2, controller3;
    Solenoid toggle;
    
    public Gearbox(int c1, int c2,int c3) {
    	controller1 = new Talon(c1);
    	controller2 = new Talon(c2);
    	controller3 = new Talon(c3);
    }
    public void setInverted(boolean invertedI)
    {
    	inverted = invertedI;
    }
    
    public void inGear(boolean is) {toggle.set(is);}

    public void setSpeed(double sped) {
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
	protected void initDefaultCommand() {
		setDefaultCommand(null);
	}
}
