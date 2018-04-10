package org.usfirst.frc.team2875.robot.commands;

//import org.usfirst.frc.team2875.robot.Debug;
import org.usfirst.frc.team2875.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class CmdDriveDistance extends Command{
	private double distance;
	private double speed;
	private double straight;
	public CmdDriveDistance(double dist,double ispeed){
		distance = dist;
		speed = ispeed;
	}
	@Override
	protected void initialize(){
		System.out.println("command starting");
		Robot.dTrain.reset();
		straight = Robot.gyro.getAngle();
		
	}
	@Override
	protected void execute(){
		
		double forward = speed;
		Double cur = Robot.gyro.getAngle() - straight;
		//Debug.log("Straight", straight);
		
			if (cur> 0){
				Robot.left.set((forward-Math.abs(cur)/90));
				Robot.right.set((forward+Math.abs(cur)/90));
			}else if(cur <0 ){
				Robot.right.set((forward-Math.abs(cur)/90));
				Robot.left.set((forward+Math.abs(cur)/90));
			}else{
				Robot.right.set(forward);
				Robot.left.set(forward);
			}
		
		}
	
	@Override
	protected boolean isFinished() {
	//	double totalDelta = (originDistL - Robot.encoders.getLeftEncoder()) + (originDistR - Robot.encoders.getRightEncoder()) / 2;
		double[] encodes = Robot.dTrain.getDistances();
		if(encodes[0] >= distance || encodes[1] >= distance){
			//Robot.driveTrainSys.straightdrive_delay=4;
			Robot.dTrain.stop();
			return true;
		}else{
			return false;
		}
	}
	
	
}
