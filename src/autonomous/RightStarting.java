package autonomous;

import org.usfirst.frc.team2875.robot.Robot;
import org.usfirst.frc.team2875.robot.commands.MoveDistance;
import org.usfirst.frc.team2875.robot.commands.TurnAngle;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class RightStarting extends CommandGroup {
	//go to switch and drop
	//right or left
	public RightStarting(char start) {
	
	if (start == 'R')
	{
		addSequential(new MoveDistance(307.818));
		addSequential(new TurnAngle(270));
		addSequential(new MoveDistance(28.219));
	}
	else {
		addSequential(new MoveDistance(40));
		addSequential(new TurnAngle(270));
		addSequential(new MoveDistance(234.297));
		addSequential(new TurnAngle(90));
		addSequential(new MoveDistance(267.803));
		addSequential(new TurnAngle(90));
		addSequential(new MoveDistance(10));
	}
	}
}
