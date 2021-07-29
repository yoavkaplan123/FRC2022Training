// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.Climbing;

public class ClimbingCommand extends InstantCommand {
  /** Creates a new Climbing. */
  private Climbing climbing;

  public ClimbingCommand() {
    // Use addRequirements() here to declare subsystem dependencies.
    climbing = Climbing.getinstance();
    addRequirements(climbing);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    climbing.setDoubleSolenoid();
  }
}
