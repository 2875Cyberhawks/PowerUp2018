package org.usfirst.frc.team2875.robot.subsystems;

import org.usfirst.frc.team2875.robot.commands.ClutchCmd;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Clutch extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	private Solenoid sole;
	private boolean cEngaged;

	public Clutch(int s) {
		super("Clutch");
		sole = new Solenoid(s);
		cEngaged = true;
	}
	
	public void toggleClutch()
	{
		cEngaged = !cEngaged;
		sole.set(cEngaged);
	}
	
    public void initDefaultCommand() {
        setDefaultCommand(new ClutchCmd());
    }
}