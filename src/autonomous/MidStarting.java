package autonomous;

import org.usfirst.frc.team2875.robot.Robot;

public class MidStarting {
	//go to switch and drop
	//right or left
	public MidStarting() {
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
