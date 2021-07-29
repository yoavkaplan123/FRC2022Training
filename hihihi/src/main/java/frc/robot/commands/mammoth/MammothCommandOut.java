package frc.robot.commands.mammoth;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Mammoth;

public class MammothCommandOut extends CommandBase {
    /** Creates a new MommothCommandOut. */
    private Mammoth mammoth;

    public MammothCommandOut() {
      // Use addRequirements() here to declare subsystem dependencies.
      this.mammoth = Mammoth.getinstance();
      addRequirements(mammoth);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {}

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
      this.mammoth.setIntakePower(0.85);
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {}

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return false;
    }
}