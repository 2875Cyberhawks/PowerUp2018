package autonomous;

import org.usfirst.frc.team2875.robot.Robot;
import org.usfirst.frc.team2875.robot.commands.AutoLift;
import org.usfirst.frc.team2875.robot.commands.LiftWheelSpeed;
import org.usfirst.frc.team2875.robot.commands.Marker;
import org.usfirst.frc.team2875.robot.commands.MoveDistance;
import org.usfirst.frc.team2875.robot.commands.MoveToBox;
import org.usfirst.frc.team2875.robot.commands.ToggleLift;
import org.usfirst.frc.team2875.robot.commands.ToggleLiftVertical;
import org.usfirst.frc.team2875.robot.commands.Wait;
import autonomous.HailMary;
import org.usfirst.frc.team2875.robot.commands.TurnAngle;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;
//TODO purge
public class TotalAuto2 extends CommandGroup {
	

    public TotalAuto2() {
    	Robot.dTrain.reset();

    	//Take control of box here
    	addSequential(new AutoLift(1));
    	addSequential(new Wait(5));
    	addSequential(new LiftWheelSpeed(.5,.5));
    	addSequential(new ToggleLiftVertical());
    	
    	addSequential(new HailMary());
    	
    }
}