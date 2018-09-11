package autonomous;

import org.usfirst.frc.team2875.robot.commands.MoveDistance;
import org.usfirst.frc.team2875.robot.commands.TurnAngle;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class BaseLine extends CommandGroup {

	public BaseLine(char start) {
		if(start == 'M') {
			addSequential(new TurnAngle(90));
			addSequential(new MoveDistance(45));
			addSequential(new TurnAngle(-90));
			addSequential(new MoveDistance(65));
		}else {
			addSequential(new MoveDistance(85));
		}
	}
	
}
