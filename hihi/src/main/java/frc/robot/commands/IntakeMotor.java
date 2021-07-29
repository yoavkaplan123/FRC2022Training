// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

//import org.graalvm.compiler.asm.amd64.AMD64Assembler.OperandDataAnnotation;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.intake;

public class IntakeMotor extends CommandBase {
  /** Creates a new IntakeMotor. */

  private intake intakeMotor;

  private Double intakePower;

  public IntakeMotor(double IntakePower) {
    intakeMotor = intakeMotor.getinstance();
    intakePower = IntakePower;
    addRequirements(intakeMotor);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    //AButton = new JoystickButton(OperatingJoystick, RobotConstanst.A);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    intakeMotor.setIntakeMotor(intakePower);
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

package frc.robot.commands;

        import edu.wpi.first.wpilibj2.command.CommandBase;
        import frc.robot.subsystems.Mammoth;

public class MommothCommandOut extends CommandBase {
    /** Creates a new MommothCommandOut. */
    private Mammoth mommoth;

    public MommothCommandOut() {
        // Use addRequirements() here to declare subsystem dependencies.
        this.mommoth = new Mammoth();
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {}

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        this.mommoth.setIntakePower(0.85);
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
