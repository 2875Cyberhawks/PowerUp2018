package autonomous;

import org.usfirst.frc.team2875.robot.commands.AutoLift;
import org.usfirst.frc.team2875.robot.commands.Marker;
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
			addSequential(new Marker("Starting Lift for scale"));
			//addSequential(new AutoLift(21));
			addSequential(new Marker("AutoLift finished"));
			if (au == 'C')
				addSequential(new MoveDistance(288.15));
			else if (au =='W')
				addSequential(new MoveDistance(145));

			addSequential(new TurnAngle(90));
			addSequential(new MoveDistance(1.88));
			addSequential(new AutoLift(10));
			addSequential(new MoveDistance(23));
		}
		else
		{
			addSequential(new TurnAngle(90));
			//addSequential(new MoveDistance(41.56));
			addSequential(new MoveDistance(214.12));
			addSequential(new TurnAngle(-90));
			if (au == 'C')
				addSequential(new MoveDistance(288.15));
			else if (au == 'W')
				addSequential(new MoveDistance(60));
			addSequential(new TurnAngle(-90));
		}
	}
}
