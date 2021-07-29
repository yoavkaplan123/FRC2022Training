// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.intake;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.Intake;

public class IntakePiston extends InstantCommand {
  /** Creates a new IntakePiston. */
  private Intake intake;

  public IntakePiston() {
    // Use addRequirements() here to declare subsystem dependencies.
    intake = Intake.getinstance();
    addRequirements(intake);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    intake.setSolenoid();
  }
}
