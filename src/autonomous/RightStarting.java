package autonomous;

import org.usfirst.frc.team2875.robot.Robot;

public class RightStarting {
	//go to switch and drop
	//right or left
	public RightStarting() {
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
