package org.usfirst.frc.team2875.robot.commands;

import org.usfirst.frc.team2875.robot.Robot;


import edu.wpi.first.wpilibj.command.Command;

public class CmdRotateAngle extends Command {
	public double theta;
	double speed;
	public int direction;
	//left is 0
	//right is 1
	double goal;
	public CmdRotateAngle(double theta, double ispeed, int direction)
	{
		//requires(Robot.drivetrain);
		speed = ispeed;
		this.theta=theta;
		this.direction=direction;
	}

	@Override
	protected void initialize() {
		if(direction==0){
			goal = Robot.gyro.getAngleZ() - theta;
		}else{
			goal = Robot.gyro.getAngleZ() + theta;
		}
		// TODO Auto-generated method stub

	}

	@Override
	protected void execute() {
		System.out.println(Robot.gyro.getAngleZ());
		if(direction==1){
			Robot.right.set(speed);
			Robot.left.set(speed);
		}else{
			Robot.right.set(speed);
			Robot.left.set(speed);
		}
	}

	@Override
	protected boolean isFinished() {	
		if(direction==1&&Robot.gyro.getAngleZ()<goal)
			return false;
		else if(direction==0&&Robot.gyro.getAngleZ()>goal)
			return false;
		else{
			System.out.println("FINISHED");
			
			return true;
		}
	}

	@Override
	protected void end() {
		Robot.dTrain.stop();

	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub

	}

}
