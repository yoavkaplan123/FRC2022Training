// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;

public class Elevator extends SubsystemBase {
  /** Creates a new Elevator. */
  private static Elevator elevator;

  private WPI_TalonFX motor;
  private PIDController pidController;
  private Encoder encoder;
  private double setPoint = 0;



  public Elevator(){
    motor = new WPI_TalonFX(10);
    pidController = new PIDController(0, 0, 0);
    pidController.setSetpoint(setPoint);
    encoder = new Encoder(0 , 1, false, EncodingType.k4X);
    encoder.setDistancePerPulse(1);
  }

  public static Elevator getinstance(){
    if (elevator == null){
      elevator  = new Elevator();
    }
    return elevator;
  }

  public void setPower(){
    if (RobotContainer.Operator_Joystick.getRawAxis(0) > 0){
      pidController.setSetpoint(0);
    }
    else {
      pidController.setSetpoint(setPoint);
    }
    motor.set(pidController.calculate(encoder.getDistance()));
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
