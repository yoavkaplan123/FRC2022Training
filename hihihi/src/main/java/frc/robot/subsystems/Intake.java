// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;



public class Intake extends SubsystemBase {
  /** Creates a new Intake. */
  private static Intake intake;

  private WPI_TalonFX TalonMotor1;
  private WPI_TalonFX TalonMotor2;

  private WPI_VictorSPX intakeMotor;

  private Solenoid solenoid;
  private PIDController pidController;
  private Encoder encoderTalon1;
  private Encoder encoderTalon2;
  private double setPoint = 0;


  public Intake() {
    TalonMotor1 = new WPI_TalonFX(7);
    TalonMotor2 = new WPI_TalonFX(8);
    TalonMotor2.follow(TalonMotor1);

    intakeMotor = new WPI_VictorSPX(9);

    solenoid = new Solenoid(1, 2);

    pidController = new PIDController(0, 0, 0);
    pidController.setSetpoint(setPoint);

    encoderTalon1 = new Encoder(2, 3, false, EncodingType.k4X);
    encoderTalon1.setDistancePerPulse(1);

    encoderTalon2 = new Encoder(4, 5, false, EncodingType.k4X);
    encoderTalon2.setDistancePerPulse(1);
  }

  public void SetPowerOfTheIntakeMovementPID(boolean power) {
    if (!power){
      pidController.setSetpoint(0);
    }
    else{
      pidController.setSetpoint(setPoint);
    }
    SetPowerOfTheIntakeMovement(pidController.calculate((encoderTalon1.getDistance() + encoderTalon2.getDistance())/2));
  }

  public void SetPowerOfTheIntakeMovement(double power) {
    TalonMotor1.set(ControlMode.PercentOutput, power);
  }

  public void SetIntakeMotorPower(double power) {
    intakeMotor.set(ControlMode.PercentOutput, power);
  }

  public void setSolenoid() {
    if (solenoid.get() == true) {
      solenoid.set(false);
    } else {
      solenoid.set(true);;
    }
  }

  public static Intake getinstance() {
    if (intake == null) {
      intake = new Intake();
    }
    return intake;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("TalonMotor1 Encoder: ", encoderTalon1.getDistance());
    SmartDashboard.putNumber("TalonMotor2 Encoder: ", encoderTalon2.getDistance());
  }
}
