// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.POVButton;
import frc.robot.commands.ClimbingCommand;
import frc.robot.commands.intake.*;
import frc.robot.commands.mammoth.MammothCommandIn;
import frc.robot.commands.mammoth.MammothCommandOut;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  
  public static Joystick Left_Joystick = new Joystick(0);
  public static Joystick Right_Joystick = new Joystick(1);
  public static XboxController Operator_Joystick = new XboxController(2);
  public static JoystickButton aButton = new JoystickButton(Operator_Joystick, 1);
  public static JoystickButton yButton = new JoystickButton(Operator_Joystick, 2);
  public static JoystickButton xButton = new JoystickButton(Operator_Joystick, 3);
  public static JoystickButton bButton = new JoystickButton(Operator_Joystick, 4);
  public static POVButton upButton = new POVButton(Operator_Joystick ,0);
  public static POVButton downButton = new POVButton(Operator_Joystick ,180);
  public static POVButton rightButton = new POVButton(Operator_Joystick ,90);
  public static POVButton lefButton = new POVButton(Operator_Joystick ,270);


  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    aButton.whileHeld(new MammothCommandIn());
    bButton.whileHeld(new MammothCommandOut());
    yButton.whileHeld(new IntakeCommandIntakeMovement(true));
    xButton.whileHeld(new IntakeCommandIntakeMovement(false));
    upButton.whileHeld(new IntakeCommandIntake());
    downButton.whileHeld(new IntakePiston());
    rightButton.whenPressed(new ClimbingCommand());
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return null;
  }
}
