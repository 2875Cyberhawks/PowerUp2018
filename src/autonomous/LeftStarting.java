package autonomous;

import org.usfirst.frc.team2875.robot.Robot;
import org.usfirst.frc.team2875.robot.commands.CmdDriveDistance;
import org.usfirst.frc.team2875.robot.commands.CmdRotateAngle;
import org.usfirst.frc.team2875.robot.commands.MoveDistance;
import org.usfirst.frc.team2875.robot.commands.TurnAngle;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class LeftStarting extends CommandGroup{
	//go to switch and drop
	//right or left
	public LeftStarting(char gd){
		//addSequential(new CmdRotateAngle(10, .5, 1));
		//addSequential(new MoveDistance(12 * 6,.6));
		//System.out.println("Yes indeed");
		if (gd == 'L')
		{
			addSequential(new MoveDistance(313.15));
			addSequential(new TurnAngle().setAngle(90));
			addSequential(new MoveDistance(11.88));
		}
		else
		{
			addSequential(new MoveDistance(40));
			addSequential(new TurnAngle().setAngle(90));
			//addSequential(new MoveDistance(41.56));
			addSequential(new MoveDistance(224.12));
			addSequential(new TurnAngle().setAngle(90));
			addSequential(new MoveDistance(273.15));
			addSequential(new TurnAngle().setAngle(270));
		}
	}
}
