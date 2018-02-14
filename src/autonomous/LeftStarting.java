package autonomous;

import org.usfirst.frc.team2875.robot.Robot;

public class LeftStarting {
	//go to switch and drop
	//right or left
	public LeftStarting() {
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
