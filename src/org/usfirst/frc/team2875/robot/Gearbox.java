package org.usfirst.frc.team2875.robot;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;

public class Gearbox {
	SpeedController controller1, controller2, controller3;
	public Gearbox(int channel1, int channel2, int channel3){
		controller1 = new Spark(channel1);
		controller2 = new Spark(channel2);
		controller3 = new Spark(channel3);
	}

	public void setStrafe(double speed){
		
	}
	public void setSpeed(double speed){
		//accepts speeds from -1 to 1
		controller1.set(speed);
		controller2.set(speed);
		controller3.set(speed);
	}
	//To be updated
	public void stop(){
		setSpeed(0);
	}
}