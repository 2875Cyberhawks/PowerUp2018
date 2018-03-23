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
	public LeftStarting(char gd, char au){
		//addSequential(new CmdRotateAngle(10, .5, 1));
		//addSequential(new MoveDistance(12 * 6,.6));
		//System.out.println("Yes indeed");
		if (gd == 'L')
		{
			if (au == 'C')
				addSequential(new MoveDistance(313.15));
			else if (au =='W')
				addSequential(new MoveDistance(135));
			addSequential(new TurnAngle(90));
			addSequential(new MoveDistance(1.88));
		}
		else
		{
			addSequential(new MoveDistance(40));
			addSequential(new TurnAngle(90));
			//addSequential(new MoveDistance(41.56));
			addSequential(new MoveDistance(214.12));
			addSequential(new TurnAngle(-90));
			if (au == 'C')
				addSequential(new MoveDistance(273.15));
			else if (au == 'W')
				addSequential(new MoveDistance(95));
			addSequential(new TurnAngle(-90));
		}
	}
}
