/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.*;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.*;
import frc.robot.commands.ExampleCommand;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class ExampleSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  WPI_VictorSPX leftMaster = RobotMap.leftLeader;
  WPI_VictorSPX leftFollower = RobotMap.leftFollower;
  WPI_VictorSPX rightMaster = RobotMap.rightLeader;
  WPI_VictorSPX rightFollower = RobotMap.rightFollower;

  DifferentialDrive drive;

  public ExampleSubsystem(){

  }

  public void init(){

    drive = new DifferentialDrive(leftMaster,rightMaster);

    leftFollower.set(ControlMode.Follower, 30);    
    rightFollower.set(ControlMode.Follower, 40);

  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new ExampleCommand());
  }

  public void arcadeDrive(double throttle){
    drive.arcadeDrive(-Robot.m_oi.getDriverStick().getY() * throttle, Robot.m_oi.getDriverStick().getX() * throttle);
  }
}
