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
  // Lift (PCM 0 and 1)
  public static JoystickButton score6; // Lift Up
  public static JoystickButton score7; // Lift Down
  // Hatch (PCM 2 and 3)
  public static JoystickButton score8; // Hatch Out
  public static JoystickButton score9; // Hatch In
  // Hatch Grip (PCM 4 and 5)
  public static JoystickButton score10; // Grip On
  public static JoystickButton score11; // Grip Off
  
  // Ball Grip (Jaguar 2)
  public static JoystickButton score5; // Ball Grip Up
  public static JoystickButton score2; // Ball Grip Down
// Ball Intake / Discharge (Spike or Jaguar 3)
  public static JoystickButton score3; // Intake
  public static JoystickButton score4; // Discharge
  
  public OI(){
    driverStick = new Joystick(0);
    scoreStick = new Joystick(1);

    // Lift Up/Down
    score6 = new JoystickButton(scoreStick, 6); // Up
    score6.whenPressed(new LiftUp());
    score7 = new JoystickButton(scoreStick, 7); // Down
    score7.whenPressed(new LiftDown());

    // Hatch Out / In
    score8 = new JoystickButton(scoreStick, 8); // Out
    score8.whenPressed(new HatchOut());
    score9 = new JoystickButton(scoreStick, 9); // In
    score9.whenPressed(new HatchIn());
  
    // Hatch Grip On/Off
    score10 = new JoystickButton(scoreStick, 10); // On
    score10.whenPressed(new HatchGripOn());
    score11 = new JoystickButton(scoreStick, 11); // Off
    score11.whenPressed(new HatchGripOff());

    // Ball Grip (Jaguar 2, PWM 2)
    score5 = new JoystickButton(scoreStick, 5); // Up
    score5.whileHeld(new BallGripUp());
    score2 = new JoystickButton(scoreStick, 2); // Down
    score2.whileHeld(new BallGripDown());

    // Ball Intake / discharge (Jaguar 3, PWM 3)
    score3 = new JoystickButton(scoreStick, 3); // Intake
    score3.whileHeld(new BallIntake());
    score4 = new JoystickButton(scoreStick, 4); // Discharge
    score4.whileHeld(new BallDischarge());
  }


  /**
   * @return the driverStick
   * e.g. for drivetrain control, in ExampleCommand 
   */
  public Joystick getDriverStick() {
    return driverStick;
  }
  /** 
   * @return secondary / Scor joystick
   * for Tower up/down control, in TowerDefaultCommand
   */
  public Joystick getScoreStick() {
    return scoreStick;
  }
}
