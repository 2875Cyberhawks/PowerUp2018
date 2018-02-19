/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2875.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team2875.robot.commands.CmdRotateAngle;
//import org.usfirst.frc.team2875.robot.commands.MoveDistance;
//import org.usfirst.frc.team2875.robot.commands.TurnAngle;
import org.usfirst.frc.team2875.robot.subsystems.Clutch;
//import org.usfirst.frc.team2875.robot.subsystems.DTrain2;
import org.usfirst.frc.team2875.robot.subsystems.Drivetrain;
import org.usfirst.frc.team2875.robot.subsystems.Lift;
//import org.usfirst.frc.team2875.robot.subsystems.TurnAnglePID;

import com.analog.adis16448.frc.ADIS16448_IMU;

import autonomous.LeftStarting;
import autonomous.TotalAuto;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */

 public class Robot extends IterativeRobot {
	
	public static final OI oi = new OI();
	//public static Gearbox left = new Gearbox(3,4,5);
	//public static Gearbox right = new Gearbox(0,1,2);
	public static SpeedControllerGroup left;
	public static SpeedControllerGroup right;
	public static Drivetrain dTrain;
	public static DigitalInput lsLow;
	public static DigitalInput lsHigh;
	public static Lift lift;
	public static Clutch clutch;
	public static int iter = 0;
	public static boolean leftSwitch;
	Command auto;
	SendableChooser<Command> chooser;
	public static ADIS16448_IMU gyro;
	//public static TurnAnglePID pidT;
//	public static CameraThread vis;

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		UsbCamera a = CameraServer.getInstance().startAutomaticCapture();
		a.setResolution(640, 480);
		dTrain = new Drivetrain();
		left = new SpeedControllerGroup(new Spark(0),new Spark(1),new Spark(2));
		right = new SpeedControllerGroup(new Spark(3),new Spark(4),new Spark(5));
		right.setInverted(true);
		//dTrain = new Drivetrain(3,4,5,0,1,2,0,1,2,3);
		clutch = new Clutch(0);
		lift = new Lift(8,9,6,7,8,9,1);
		lsLow = new DigitalInput(6);
		lsHigh = new DigitalInput(7);
		chooser = new SendableChooser<>();
		SmartDashboard.putData(dTrain);
		SmartDashboard.putData(lift);
		gyro = new ADIS16448_IMU();
		//pidT = new TurnAnglePID();
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {
		lift.enable();
		lift.raiseToPost(0);
	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	
	@Override
	public void autonomousInit() {
		auto = new TotalAuto('M','R');
		auto.start();
	/*	m_autonomousCommand = chooser.getSelected();
		//TODO how to get scale information
		String gameData;
		gameData = DriverStation.getInstance().getGameSpecificMessage();
		leftSwitch = (gameData.charAt(0) == 'L') ? true : false;
		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 * = new MyAutoCommand(); break; case "Default Auto": default:
		 * autonomousCommand = new ExampleCommand(); break; }
		 *SOOOOOOOOOOOOOOOOONnNnNnNnNnnnnnnnnNNNn/

		// schedule the autonomous command (example)
		//if (m_autonomousCommand != null) {
			//m_autonomousCommand.start();
			//m_autonomousCommand = new LeftStarting();
			//m_autonomousCommand.start();
		*/
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (auto != null) {
			auto.cancel();
		}	
		
	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		//System.out.println(gyro.getAngleZ());
		SmartDashboard.putBoolean("Clutch engaged", oi.getClutch());
		//System.out.println(""+ dTrain.lEncode.getRate());
		//System.out.println("" + dTrain.rEncode.getRate());
		//System.out.println("X" + gyro.getAccelX());
		if (iter == 10) {
		//System.out.println("Y " + gyro.getAccelY());
		iter =0;
		}
		iter++;
		//System.out.println("Z" + gyro.getAccelZ());
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testInit() {
		//m_autonomousCommand = new LeftStarting();
		//m_autonomousCommand.start();
	}
	@Override
	public void testPeriodic() {
		Scheduler.getInstance().run();
	}
}
