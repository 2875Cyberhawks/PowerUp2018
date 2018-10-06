package autonomous;

import org.usfirst.frc.team2875.robot.commands.AutoLift;
import org.usfirst.frc.team2875.robot.commands.Marker;
import org.usfirst.frc.team2875.robot.commands.MoveDistance;
import org.usfirst.frc.team2875.robot.commands.ToggleLiftVertical;
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
			if (au == 'C') {
				addSequential(new Marker("Moving 150 inches"));
				addSequential(new MoveDistance(140 + 10));}
			else if (au == 'W') {
				addSequential(new Marker("Moving 120 inches"));
				addSequential(new MoveDistance(119.823));}
			addSequential(new Marker("Turning Left"));
			addSequential(new TurnAngle(-90));
			addSequential(new Marker("Starting Lift for switch"));
			addSequential(new Marker("Finished turn"));
			if (au == 'C')
			{
				addSequential(new Marker("Moving 310 inches"));
				addSequential(new MoveDistance(280 + 30)); //CAD Distance + Manual Offset
				addSequential(new Marker("Turn to the left"));
				addSequential(new TurnAngle(-90));
				addSequential(new ToggleLiftVertical());
				addSequential(new AutoLift(26));
			}
			if (au == 'W')
			{
				addSequential(new AutoLift(12));
				addSequential(new Marker("Move 81 inches"));
				addSequential(new MoveDistance(81));
			}
		}
		else {
			addSequential(new Marker("Started L"));
			addSequential(new Marker("Turning to the left"));
			addSequential(new TurnAngle(-90));
			if (au == 'W')
				addSequential(new MoveDistance(69));
			else if (au == 'C')
				addSequential(new MoveDistance(140 + 10));
			addSequential(new TurnAngle(90 + 3.5));
			addSequential(new Marker("Starting Lift for switch"));
			
			if  (au == 'C') {
				addSequential(new MoveDistance(280 + 30)); //CAD Distance + Manual Offset
				addSequential(new TurnAngle(90));
				addSequential(new ToggleLiftVertical());
				addSequential(new AutoLift(26));
			}
			if (au == 'W') {
				addSequential(new AutoLift(12));
				addSequential(new MoveDistance(80.910));
			}
		}
	}	
}

