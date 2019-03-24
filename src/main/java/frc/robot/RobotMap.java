/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;


/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
  // For example to map the left and right motors, you could define the
  // following variables to use with your drivetrain subsystem.
  // public static int leftMotor = 1;
  // public static int rightMotor = 2;

  // If you are using multiple modules, make sure to define both the port
  // number and the module. For example you with a rangefinder:
  // public static int rangefinderPort = 1;
  // public static int rangefinderModule = 1;

  public static WPI_VictorSPX leftLeader, leftFollower, rightLeader, rightFollower;
  public static void init(){
    leftLeader = new WPI_VictorSPX(30);
    leftFollower = new WPI_VictorSPX(10);

    rightLeader = new WPI_VictorSPX(40);
    rightFollower = new WPI_VictorSPX(20);

  }
  //public static Jaguar liftJaguar = new Jaguar(0);
  //public static Jaguar grabberJaguar = new Jaguar(1);
}
