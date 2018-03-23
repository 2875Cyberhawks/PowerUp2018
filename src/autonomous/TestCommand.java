package autonomous;

import org.usfirst.frc.team2875.robot.commands.AutoLift;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class TestCommand extends CommandGroup {

    public TestCommand() {
        addSequential(new AutoLift(25));
    }
}
