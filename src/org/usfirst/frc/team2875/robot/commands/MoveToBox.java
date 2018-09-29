package org.usfirst.frc.team2875.robot.commands;

import java.util.List;

import org.opencv.core.KeyPoint;
import org.opencv.core.Mat;
import org.opencv.core.MatOfKeyPoint;
import org.opencv.videoio.VideoCapture;
import org.usfirst.frc.team2875.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import autonomous.GripVII;

public class MoveToBox extends Command {
	
	private boolean isDone;
	private final double LEEWAY = .04;
	private final double INTO_ARMS = 428.5;
	private GripVII locator;
	private VideoCapture camera;
    public MoveToBox() {
    	requires(Robot.lift);
        requires(Robot.dTrain);
        isDone = false;
        locator = new GripVII();
        camera = new VideoCapture(0);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.lift.toggleOpenSol();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Mat adragna = new Mat();
    	camera.read(adragna);
		locator.process(adragna);
		MatOfKeyPoint bob = locator.findBlobsOutput();
		List<KeyPoint> roboRoomHyphenTE = bob.toList();
		
		if (roboRoomHyphenTE.size() < 1)
		{
			System.out.println("Could not detect cube");
			return;
		}
		
		int maxIndex = 0;
		float maxVal = -1;
		for (int i = 0; i < roboRoomHyphenTE.size();i++)
		{
			KeyPoint point = roboRoomHyphenTE.get(i);
			if (point.size > maxVal)
			{
				maxIndex = i;
				maxVal = point.size;
			}
		}
		
		KeyPoint majorKey = roboRoomHyphenTE.get(maxIndex);
		//System.out.println("The x value of the box is : " + majorKey.pt.x);
		//System.out.println("The y value of the box is : " + majorKey.pt.y);
		
		
		double robotigersAvg = majorKey.pt.x - 320; //Make as close to 0 as possible
		double robonautsClimbAcc = INTO_ARMS - majorKey.pt.y; //Make as close to 0 as possible
		double turnMag = (robotigersAvg  * majorKey.pt.y)/ (320 * 480);
		double movMag = (robonautsClimbAcc / INTO_ARMS);
		if (Math.abs(turnMag) > LEEWAY)
		{
			Robot.dTrain.setSpeed(turnMag, -turnMag);
		}
		else if (movMag > LEEWAY)
		{
			Robot.dTrain.setSpeed(movMag, movMag);
		}
		else {
			Robot.lift.toggleOpenSol();
			double[] speeds = {-1,-1};
			Robot.lift.wheelMove(speeds);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			speeds[0] = 0; 
			speeds[1] = 0;
			
			Robot.lift.wheelMove(speeds);
			isDone = true;
		}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isDone;
    }

    // Called once after isFinished returns true
    protected void end() {
    	camera.release();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	camera.release();
    }
}
