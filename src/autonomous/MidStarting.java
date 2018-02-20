package autonomous;

import org.usfirst.frc.team2875.robot.Robot;
import org.usfirst.frc.team2875.robot.commands.Marker;
import org.usfirst.frc.team2875.robot.commands.MoveDistance;
import org.usfirst.frc.team2875.robot.commands.TurnAngle;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class MidStarting extends CommandGroup {
	//go to switch and drop
	//right or left
	
	
	public MidStarting(char startSide, char au) {
		//addSequential(new Marker("Moving the 40"));
		addSequential(new MoveDistance(40));
		//addSequential(new Marker("Started Middle Conditional"));
		if (startSide == 'R') {
			//addSequential(new Marker("Middle Right"));
			addSequential(new TurnAngle(90));
			//addSequential(new Marker("Turned"));
			addSequential(new MoveDistance(114.19));
			//addSequential(new Marker("Moved"));
			addSequential(new TurnAngle(-90));
			//addSequential(new Marker("Turned"));
			if (au == 'C')
				addSequential(new MoveDistance(252.803));
			else if (au == 'W')
				addSequential(new MoveDistance(110));
			//addSequential(new Marker("Moved"));
			addSequential(new TurnAngle(-90));
			//addSequential(new Marker("Done Conditional"));
			//addSequential(new MoveDistance())
		}
		else {
			addSequential(new TurnAngle(-90));
			addSequential(new MoveDistance(112.107));
			addSequential(new TurnAngle(90));
			if  (au == 'C')
				addSequential(new MoveDistance(264.803));
			else if (au == 'W')
				addSequential(new MoveDistance(110.381));
			addSequential(new TurnAngle(90));
		}
		//addSequential(new MoveDistance(10));
		
	}
		
}
