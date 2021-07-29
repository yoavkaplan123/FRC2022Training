// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class Mammoth extends SubsystemBase {

  /** Creates a new mammoth. */

  private WPI_VictorSPX intake;
  private WPI_TalonSRX MammothMotor;
  private static Mammoth mammoth;
  private Encoder MammothMotorEncoder;
  private PIDController pidController;
  private DigitalInput limit;
  

  public Mammoth() {
    this.intake = new WPI_VictorSPX(5);
    this.MammothMotor = new WPI_TalonSRX(6);
    MammothMotorEncoder = new Encoder(6,7, false, EncodingType.k4X);
    MammothMotorEncoder.setDistancePerPulse(1);
    
    limit = new DigitalInput(8);

    pidController = new PIDController(0, 0, 0);
    pidController.setSetpoint(0);
  }

  public void setIntakePower(double power) {
    this.intake.set(ControlMode.PercentOutput, power);
  }

  public void setMammothMotorPower(double power){
    this.MammothMotor.set(ControlMode.PercentOutput, power);
  }

  public void setMammothMotorPowerPID(){
    this.MammothMotor.set(ControlMode.PercentOutput, pidController.calculate(MammothMotorEncoder.getDistance()));
  }

  public static Mammoth getinstance() {
    if (mammoth == null) {
      mammoth = new Mammoth();
    }
    return mammoth;
  }

  public void resetEncoder (){
    MammothMotorEncoder.reset();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("Talon Encoder", MammothMotorEncoder.getDistance());
    if (limit.get()){
      resetEncoder();
    }
  }
}
