package autonomous;

import org.usfirst.frc.team2875.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class RightStarting extends CommandGroup {
	//go to switch and drop
	//right or left
	public RightStarting(char start) {
	if(Robot.leftSwitch) {
	//go left switch	
		Scale.fromLeftSwitch();
	}
	else
	{
		//go right switch
		Scale.fromRightSwitch();
	}
	
	}
}
