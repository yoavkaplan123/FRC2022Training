// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Climbing extends SubsystemBase {
  /** Creates a new Climbing. */
  private DoubleSolenoid doubleSolenoid;

  private static Climbing climbing;
  
  public Climbing() {
    doubleSolenoid = new DoubleSolenoid(3, 4);
  }

  public static Climbing getinstance() {
    if (climbing == null) {
      climbing = new Climbing();
    }
    return climbing;
  }

  public void setDoubleSolenoid() {
    if (doubleSolenoid.get() == Value.kReverse) {
      doubleSolenoid.set(Value.kForward);
    } else {
      doubleSolenoid.set(Value.kReverse);
    }
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
