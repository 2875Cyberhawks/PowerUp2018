package autonomous;

import org.usfirst.frc.team2875.robot.commands.AutoLift;
import org.usfirst.frc.team2875.robot.commands.Marker;
import org.usfirst.frc.team2875.robot.commands.MoveDistance;
import org.usfirst.frc.team2875.robot.commands.TurnAngle;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class MidStarting extends CommandGroup {
	//go to switch and drop
	//right or left
	public MidStarting(char gd, char au) {
		//addSequential(new Marker("Moving the 40"));
		//Moved 40 already
		addSequential(new Marker("Started Middle Conditional"));
		if (gd == 'R') {
			addSequential(new Marker("Started R"));
			addSequential(new TurnAngle(90));
			addSequential(new Marker("Finished turn"));
			//if (au == 'C')
			//	addSequential(new MoveDistance(119.823));d
			if (au == 'W')
			{
				addSequential(new MoveDistance(53.188));
				addSequential(new Marker("Finished MoveDistance"));
			}
			addSequential(new TurnAngle(-90));
			addSequential(new Marker("Starting Lift for switch"));

			addSequential(new Marker("Finished turn"));
			//if (au == 'C')
			//{
			//	addSequential(new MoveDistance(279.33));
			//	addSequential(new TurnAngle(-90));
			//}
			addSequential(new AutoLift(12));
			if (au == 'W')
			{
				addSequential(new MoveDistance(81));
			}
		}
		else {
			addSequential(new Marker("Started L"));
			addSequential(new TurnAngle(-90));
			if (au == 'W')
				addSequential(new MoveDistance(69));
			//else if (au == 'C')
			//	addSequential(new MoveDistance(131.199));
			addSequential(new TurnAngle(90));
			addSequential(new Marker("Starting Lift for switch"));
			addSequential(new AutoLift(12));
			//if  (au == 'C') {
			//	addSequential(new MoveDistance(279.33));
			//	addSequential(new TurnAngle(90));
			//}
			if (au == 'W')
				addSequential(new MoveDistance(80.910));
			
		}
	}	
}

