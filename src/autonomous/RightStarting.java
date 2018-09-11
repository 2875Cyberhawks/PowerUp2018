package autonomous;

import org.usfirst.frc.team2875.robot.commands.AutoLift;
import org.usfirst.frc.team2875.robot.commands.MoveDistance;
import org.usfirst.frc.team2875.robot.commands.TurnAngle;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class RightStarting extends CommandGroup {
	//go to switch and drop
	//right or left
	public RightStarting(char gd, char au) {
	
	if (gd == 'R')
	{
		
		if (au == 'W')
			addSequential(new MoveDistance(145));
		addSequential(new TurnAngle(-90));
		addSequential(new MoveDistance(8.219));
		addSequential(new AutoLift(10));
		addSequential(new MoveDistance(23));
	}
	else {
		addSequential(new TurnAngle(-90));
		addSequential(new MoveDistance(234.297));
		addSequential(new TurnAngle(90));
		if (au == 'C')
			addSequential(new MoveDistance(282.818));
		else if (au == 'W')
			addSequential(new MoveDistance(60));
		addSequential(new TurnAngle(90));
		//addSequential(new MoveDistance(10));
	}
	}
}
