// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.IntakeMotor;
import frc.robot.commands.IntakePiston;


public class RobotContainer {

  public static Joystick Left_Joystick = new Joystick(0);
  public static Joystick Right_Joystick = new Joystick(1);
  public static XboxController Operator_Joystick = new XboxController(2);
  public static JoystickButton aButton = new JoystickButton(Operator_Joystick, 1);
  public static JoystickButton yButton = new JoystickButton(Operator_Joystick, 2);
  public static JoystickButton xButton = new JoystickButton(Operator_Joystick, 3);
  public static JoystickButton bButton = new JoystickButton(Operator_Joystick, 4);
  

  public RobotContainer() {

    configureButtonBindings();
  }

  private void configureButtonBindings() {
    aButton.whileHeld(new IntakeMotor(-0.85));
    bButton.whileHeld(new IntakeMotor(0.85));
    xButton.whenPressed(new IntakePiston());

  }


public Command getAutonomousCommand() {
	return null;
}
}
