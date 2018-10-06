package autonomous;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team2875.robot.commands.Drive;
import org.usfirst.frc.team2875.robot.Robot;

public class HailMary extends Command {
	private static final double WAIT_TIME = 1.5;
	private static final double SPEED = .5;
	private Timer t;
	public HailMary() {
		System.out.println("God help you");
		t = new Timer();
	}
	
	@Override
	protected void initialize() {
		System.out.println("Moving at " + SPEED + " for " + WAIT_TIME);
		t.start();
	}
	
	@Override
	protected void execute() {
		Drive.straightDriveGyro(SPEED,0);
	}
	
	@Override
	protected boolean isFinished() {
		return t.hasPeriodPassed(WAIT_TIME);
	}
	
	@Override
	protected void end() {
		t.stop();
		Robot.dTrain.stop();
	}
}