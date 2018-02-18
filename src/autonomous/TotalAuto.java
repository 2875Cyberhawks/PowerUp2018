package autonomous;

import org.usfirst.frc.team2875.robot.Robot;
import org.usfirst.frc.team2875.robot.commands.MoveDistance;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class TotalAuto extends CommandGroup {
	private char switchSide;
    public TotalAuto(char gd) {
    	switchSide = Character.toUpperCase(gd);
    	if (gd == 'A')switchSide = DriverStation.getInstance().getGameSpecificMessage().charAt(1);
    	requires(Robot.dTrain);
    	requires(Robot.clutch);
    	requires(Robot.lift);
    	//Move back and forth to lower lift to base
    	addSequential(new MoveDistance(-2,-.9));
    	addSequential(new MoveDistance(2));
    	
    	//Take control of box here
    	
    	
    	//Move the bot
    	
    	
    }
}
