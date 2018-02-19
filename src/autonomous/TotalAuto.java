package autonomous;

import org.usfirst.frc.team2875.robot.Robot;
import org.usfirst.frc.team2875.robot.commands.AutoLift;
import org.usfirst.frc.team2875.robot.commands.LiftWheelSpeed;
import org.usfirst.frc.team2875.robot.commands.MoveDistance;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class TotalAuto extends CommandGroup {
	private char switchSide;
	private char start; //Either (L)eft, (M)iddle, (R)ight
	//The starting positions are either all the way left or right, or directly to the right of the center line
    public TotalAuto(char gd, char startingPos) {
    	start = startingPos;
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
    	switch (start) {
    		case 'L':
    			addSequential(new LeftStarting(switchSide));
    			break;
    		case 'M':
    			addSequential(new MidStarting(switchSide));
    			break;
    		default :
    			addSequential(new RightStarting(switchSide));
    			break;
    	}
    	
    	//Lift to the scale
    	addSequential(new AutoLift(5.5 * 12));
    	addSequential(new MoveDistance(1,.9));
    	addSequential(new LiftWheelSpeed(1,.3));
    	addSequential(new MoveDistance(-1,-.9));
    	addSequential(new AutoLift(3));
    }
}