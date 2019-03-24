/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.*;
//Callling in the subsystems and commands so they can be used
import frc.robot.subsystems.*;
import frc.robot.commands.*;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
  //// CREATING BUTTONS
  // One type of button is a joystick button which is any button on a
  //// joystick.
  // You create one by telling it which joystick it's on and which button
  // number it is.
  // Joystick stick = new Joystick(port);
  // Button button = new JoystickButton(stick, buttonNumber);

  // There are a few additional built in buttons you can use. Additionally,
  // by subclassing Button you can create custom triggers and bind those to
  // commands the same as any other Button.

  //// TRIGGERING COMMANDS WITH BUTTONS
  // Once you have a button, it's trivial to bind it to a button in one of
  // three ways:

  // Start the command when the button is pressed and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenPressed(new ExampleCommand());

  // Run the command while the button is being held down and interrupt it once
  // the button is released.
  // button.whileHeld(new ExampleCommand());

  // Start the command when the button is released and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenReleased(new ExampleCommand());

  public static Joystick driverStick;
  public static Joystick scoreStick;

  //Joystick buttons for the Co-Driver
  //The number refers to the number given by driver station as button IDs
  public static JoystickButton score4;
  public static JoystickButton score3;

  public OI(){
    driverStick = new Joystick(0);
    scoreStick = new Joystick(1);

    score3 = new JoystickButton(scoreStick, 3);
    score3.whileHeld(new BallIntake());

    score4 = new JoystickButton(scoreStick, 4);
    score4.whileHeld(new BallDischarge());
  }


  /**
   * @return the driverStick
   */
  public Joystick getDriverStick() {
    return driverStick;
  }
  public Joystick getscoreStick() {
    return scoreStick;
  }
}
