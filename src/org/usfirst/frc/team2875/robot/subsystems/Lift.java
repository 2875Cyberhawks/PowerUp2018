package org.usfirst.frc.team2875.robot.subsystems;

import org.usfirst.frc.team2875.robot.commands.LiftCmd;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * :D
 *Raffi Stinks
 */
public class Lift extends Subsystem {
	public static final int[][] positions = new int[4][2];
	SpeedController controller1, controller2;
	Encoder en1,en2;
	
	public Lift(int c1,int c2, int e1, int e2, int e3, int e4) {
		controller1 = new Talon(c1);
		controller2 = new Talon(c2);
		en1 = new Encoder(e1,e2);
		en2 = new Encoder(e3,e4);
		en1.reset();
		en2.reset();
	}
		
	public void stop()
	{
		controller1.set(0);
	}
    public void initDefaultCommand() {
        setDefaultCommand(new LiftCmd());
    }
}

