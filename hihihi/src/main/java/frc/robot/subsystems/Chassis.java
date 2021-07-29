// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Chassis extends SubsystemBase {
  /** Creates a new Chassis. */

  private CANSparkMax frontLeftMotor;
  private CANSparkMax backLeftMotor;
  private CANSparkMax frontRightMotor;
  private CANSparkMax backRightMotor;

  private static Chassis chassis;

  public Chassis() {
    frontLeftMotor = new CANSparkMax(1, MotorType.kBrushless);
    backLeftMotor = new CANSparkMax(2, MotorType.kBrushless);
    backLeftMotor.follow(frontLeftMotor);
    frontLeftMotor.setIdleMode(IdleMode.kBrake);
    backLeftMotor.setIdleMode(IdleMode.kBrake);

    frontRightMotor = new CANSparkMax(3, MotorType.kBrushless);
    backRightMotor = new CANSparkMax(4, MotorType.kBrushless);
    backRightMotor.follow(frontRightMotor);
    frontRightMotor.setIdleMode(IdleMode.kBrake);
    backRightMotor.setIdleMode(IdleMode.kBrake);
  }

  public void setPowerLeft(double powerLeft) {
    frontLeftMotor.set(powerLeft);
  }

  public void setPowerRight(double powerRight) {
    frontLeftMotor.set(powerRight);
  }

  public static Chassis getinstance() {
    if (chassis == null) {
      chassis = new Chassis();
    }
    return chassis;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
