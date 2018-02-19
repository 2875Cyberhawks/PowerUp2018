package autonomous;

import org.usfirst.frc.team2875.robot.Robot;
import org.usfirst.frc.team2875.robot.commands.MoveDistance;
import org.usfirst.frc.team2875.robot.commands.TurnAngle;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class MidStarting extends CommandGroup {
	//go to switch and drop
	//right or left
	
	
	public MidStarting(char startSide) {
		addSequential(new MoveDistance(40));
		if (startSide == 'R') {
			
			addSequential(new TurnAngle().setAngle(90));
			addSequential(new MoveDistance(114.19));
			addSequential(new TurnAngle().setAngle(270));
			addSequential(new MoveDistance(267.803));
			addSequential(new TurnAngle().setAngle(270));
			//addSequential(new MoveDistance())
		}
		else {
			addSequential(new TurnAngle().setAngle(270));
			addSequential(new MoveDistance(118.107));
			addSequential(new TurnAngle().setAngle(90));
			addSequential(new MoveDistance(267.803));
			addSequential(new TurnAngle().setAngle(90));
		}
		addSequential(new MoveDistance(10));
		
	}
		
}
