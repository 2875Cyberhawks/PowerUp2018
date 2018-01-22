package org.usfirst.frc.team2875.robot;

import org.usfirst.frc.team2875.robot.subsystems.Driving;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
//thomas eats good pizza well from rozas
public class Robot extends IterativeRobot {
	//Create Static
	public static Gearbox gearBox;
	public static final Input in = new Input();
	public static Driving driveTrainSys;

	//Settings
	final int pin1 = 9;
	final int pin2 = 8;
	final int pin3 = 1;
	final int pin4 = 0;
	
	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		SmartDashboard.putNumber("Lback",1);
		SmartDashboard.putNumber("Lfront",1);
		SmartDashboard.putNumber("Rback",1);
		SmartDashboard.putNumber("Rfront",1);
		in.init();
		gearBox = new Gearbox(pin1, pin2, pin3, pin4);
		driveTrainSys = new Driving();
	}
	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {
	
	}
	@Override
	public void disabledPeriodic() {
		gearBox.setSpeed(0);
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
	public void teleopInit() {
		Scheduler.getInstance().run();
	}
	/**
	 * This function is called periodically during operator control
	 */

	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		//gearBox.setSpeed(Math.sin(Timer.getFPGATimestamp()));
		
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		gearBox.setSpeed(.4);
	}
}

