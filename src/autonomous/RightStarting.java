package autonomous;

import org.usfirst.frc.team2875.robot.Robot;
import org.usfirst.frc.team2875.robot.commands.MoveDistance;
import org.usfirst.frc.team2875.robot.commands.TurnAngle;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class RightStarting extends CommandGroup {
	//go to switch and drop
	//right or left
	public RightStarting(char start, char au) {
	
	if (start == 'R')
	{
		if (au == 'C')
			addSequential(new MoveDistance(307.818));
		else if (au == 'W')
			addSequential(new MoveDistance(150));
		addSequential(new TurnAngle(-90));
		addSequential(new MoveDistance(8.219));
	}
	else {
		addSequential(new MoveDistance(40));
		addSequential(new TurnAngle(-90));
		addSequential(new MoveDistance(234.297));
		addSequential(new TurnAngle(90));
		if (au == 'C')
			addSequential(new MoveDistance(267.803));
		else if (au == 'W')
			addSequential(new MoveDistance(110));
		addSequential(new TurnAngle(90));
		//addSequential(new MoveDistance(10));
	}
	}
}
