// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class intake extends SubsystemBase {
  /** Creates a new intake. */

  private WPI_VictorSPX victor;

  private DoubleSolenoid doubleSolenoid;

  private static intake Intake;

  public intake() {
    victor = new WPI_VictorSPX(12);

    doubleSolenoid = new DoubleSolenoid(2,3);
  }

  public void setIntakeMotor(double power){
    victor.set(ControlMode.PercentOutput, power);
  }

  public void pistonOpen(){
    doubleSolenoid.set(Value.kForward);
  }

  public void pistonClose(){
    doubleSolenoid.set(Value.kReverse);
  }

  public static intake getinstance() {
    if (Intake == null) {
      Intake = new intake();
      
    }
    return Intake;
  }

  public void piston (){
    if (doubleSolenoid.get() == Value.kReverse){
      pistonClose();
    }
    else{
      pistonOpen();
    }
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}

// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

        import frc.robot.subsystems.Mommoth;
        import edu.wpi.first.wpilibj2.command.CommandBase;

public class MommothCommandOut extends CommandBase {
    /** Creates a new MommothCommandOut. */
    private Mommoth

    public MommothCommandOut() {
        // Use addRequirements() here to declare subsystem dependencies.
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {}

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {}

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {}

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return false;
    }
}

