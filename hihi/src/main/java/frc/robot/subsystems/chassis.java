// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class chassis extends SubsystemBase {

  private CANSparkMax frontLeftMotor;
  private CANSparkMax backLeftMotor;
  private CANSparkMax frontRightMotor;
  private CANSparkMax backRightMotor;

  private static chassis drive;

  /** Creates a new tankDrive. */
  public chassis() {
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

  public void setPowerLeft(Double powerLeft) {
    frontLeftMotor.set(powerLeft);
  }

  public void setPowerRight(Double powerRight) {
    frontLeftMotor.set(powerRight);
  }

  public void printVlue() {
    SmartDashboard.putNumber("left power:", frontLeftMotor.get());
    SmartDashboard.putNumber("right power:", frontRightMotor.get());
  }

  public static chassis getinstance() {
    if (drive == null) {
      drive = new chassis();
    }
    return drive;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    printVlue();
  }
}
