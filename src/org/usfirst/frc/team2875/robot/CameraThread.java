package org.usfirst.frc.team2875.robot;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import org.opencv.core.*;
import org.opencv.imgproc.*;

import edu.wpi.cscore.CvSource;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.cscore.VideoMode.PixelFormat;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
/**
* VisionCode class.
*
* <p>An OpenCV pipeline generated by GRIP.
*
* @author GRIP
*/
public class CameraThread {
	
	UsbCamera camera;
	CvSource outputStream;
	Mat hierarchy;
	public boolean running = true;
	public int targetLocation = 0;
	public boolean hasTarget = false;
	static final int WIDTH = 160;
	static final int HEIGHT = 120;
	static final double[] white = new double[] {1,1,1};
	static {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
	}

	public CameraThread() {
		SmartDashboard.putBoolean("Camera Threshold Mode", false);
		hierarchy = new Mat();
		System.out.println("SETTING UP CAMERAS");
		//SmartDashboard.putNumber("Peg Cam Threshold", 145);
    	//SmartDashboard.putNumber("Peg Cam Threshold Upper", 240);
    	camera = CameraServer.getInstance().startAutomaticCapture();
    	camera.setResolution(WIDTH, HEIGHT);
	    //camera.setExposureManual(-1);
	    camera.setBrightness(1);
	    camera.setFPS(15);
	    camera.setPixelFormat(PixelFormat.kMJPEG);
		outputStream = CameraServer.getInstance().putVideo("Processed", 320, 240);
		System.out.println("Camera Init");
		run();
	}
	
	private void run() {
		Thread thread =  new Thread(()->{
			while(!Thread.interrupted()){
				if(!running){
					outputStream.free();
					CameraServer.getInstance().removeCamera("USB Camera 0");
					
					break;
				}
				Mat input =  Mat.zeros(new Size(WIDTH, HEIGHT), CvType.CV_8UC3);
				if(CameraServer.getInstance().getVideo() != null) {
					try {
						CameraServer.getInstance().getVideo().grabFrame(input);
						process(input);
					}catch(Exception e) {
						System.out.println("Something failed while grabbing a frame from source. ");
						e.printStackTrace();
					}
				}
			}
	    });
		thread.start();
	}
	
	
	public void stop() {
		running = false;
	}
	
	/**
	 * This is the primary method that runs the entire pipeline and updates the outputs.
	 */
	public void process(Mat source) {
		outputStream.putFrame(source);
		source.release();
	}
}