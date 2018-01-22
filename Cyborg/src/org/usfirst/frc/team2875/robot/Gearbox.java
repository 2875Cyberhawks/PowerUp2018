package org.usfirst.frc.team2875.robot;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;

public class Gearbox {
	
	SpeedController controller1, controller2, controller3, controller4;
	public Gearbox(int channel9, int channel8, int channel1, int channel0){
		controller1 = new Talon(channel9);
		controller2 = new Talon(channel8);
		controller3 = new Talon(channel1);
		controller4 = new Talon(channel0);
	}

	public void setStrafe(double speed){
		
	}
	
	public void setSpeed(double speed){
		//accepts speeds from -1 to 1
		controller1.set(speed);
		controller2.set(speed);
		controller3.set(speed);
		controller4.set(speed);
	}
	
	
	public void setSpeed(int i, double speed) {
		if(i == 1) {
			controller1.set(speed);
		}else if(i ==2) {
			controller2.set(speed);
		}else if(i ==3) {
			controller3.set(speed);
		}else if(i == 4) {
			controller4.set(speed);
		}else {
			System.out.println("INVALID MOTOR VAL");
		}			
	}
	//To be updated
	public void stop(){
		setSpeed(0);
	}
}
