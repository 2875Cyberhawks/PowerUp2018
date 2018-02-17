package autonomous;

import org.usfirst.frc.team2875.robot.Robot;
import org.usfirst.frc.team2875.robot.commands.CmdDriveDistance;
import org.usfirst.frc.team2875.robot.commands.CmdRotateAngle;
import org.usfirst.frc.team2875.robot.commands.MoveDistance;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class LeftStarting extends CommandGroup{
	//go to switch and drop
	//right or left
	public LeftStarting() {
		//addSequential(new CmdRotateAngle(10, .5, 1));
		addSequential(new MoveDistance(12 * 6,.6));
		//System.out.println("BIG PENER");
	}
}
