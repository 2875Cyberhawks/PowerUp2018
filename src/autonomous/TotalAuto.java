package autonomous;

import org.usfirst.frc.team2875.robot.Robot;
import org.usfirst.frc.team2875.robot.commands.LiftWheelSpeed;
import org.usfirst.frc.team2875.robot.commands.Marker;
import org.usfirst.frc.team2875.robot.commands.ToggleLiftVertical;
import org.usfirst.frc.team2875.robot.commands.Wait;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class TotalAuto extends CommandGroup {
	private char scaleSide;
	private char auto;
	private char switchSide;
	private char start; //Either (L)eft, (M)iddle, (R)ight
	//The starting positions are either all the way left or right, or directly to the right of the center line
    public TotalAuto(char aC,char sP,char cP,char wP) {
    	Robot.dTrain.reset();
    	start = sP;
    	scaleSide = cP;
    	auto = aC;
    	switchSide = wP;
    	if (cP == 'A' || wP == 'A')
    	{
    		String message = DriverStation.getInstance().getGameSpecificMessage();
        	if (cP == 'A')scaleSide = message.charAt(1);
        	if (wP == 'A')switchSide = message.charAt(0);
    	}
    	char sideUsed = scaleSide;
    	if (auto == 'W')sideUsed = switchSide;
    	if (auto == 'N')start = 'N';
    	boolean exit = true;
    	//addSequential(new AutoLift(10));
    	
    	if(exit) {
    	//	return;
    	}
    	//Take control of box here
    	addSequential(new ToggleLiftVertical());
    	addSequential(new Wait(1));
    	addSequential(new LiftWheelSpeed(.5,.3));
    	addSequential(new ToggleLiftVertical());
    	//addSequential(new ToggleLift());
    	//Move the bot
    	addSequential(new Marker("start position is: " + start));
    	switch (start) {
    		case 'L':
    			addSequential(new Marker("Found L case"));
    			addSequential(new LeftStarting(sideUsed,auto));
    			break;
    		case 'M':
    			addSequential(new Marker("Found M case"));
    			addSequential(new MidStarting(sideUsed,auto));
    			break;
    		case 'R' :
    			addSequential(new Marker("Found R case"));
    			addSequential(new RightStarting(sideUsed,auto));
    			break;
    		default :
    			break;
    	}
    	
    	addSequential(new Marker("Movement finished, starting lift"));
    	switch (auto) {
    		case 'C':
    			//addSequential(new Marker("Starting Lift for scale"));
    		//	addSequential(new AutoLift(25));
    			//addSequential(new Marker("AutoLift finished"));
    			//addSequential(new MoveDistance(15));
    		//	addSequential(new LiftWheelSpeed(-1,1.5));
    			//addSequential(new MoveDistance(-5,-.5));
    			//addSequential(new AutoLift(0));
    			//addSequential(new Marker("Finished lift for scale"));
    			break;
    		case 'W':
    			//addSequential(new Marker("Starting Lift for switch"));
    			//addSequential(new AutoLift(15));
    			//addSequential(new MoveDistance(5));
    			//addSequential(new LiftWheelSpeed(-1,.5));
    			//addSequential(new MoveDistance(-5,-.5));
    			//addSequential(new AutoLift(0));
    			//addSequential(new Marker("Finished lift for switch"));
    			break;
    		default :
    			break;
    	}
    	
    }
}
