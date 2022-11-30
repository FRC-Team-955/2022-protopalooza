// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.ctre.phoenix.motorcontrol.NeutralMode;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import frc.robot.Settings.ElevatorPid;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {

  public static Robot Robot;

  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {
    Robot = this;
  }

  @Override
  public void robotPeriodic() {}

  @Override
  public void autonomousInit() {}

  @Override
  public void autonomousPeriodic() {}

  UniversalMotor LeftDrive1;
  UniversalMotor LeftDrive2;

  UniversalMotor RightDrive1;
  UniversalMotor RightDrive2;

  UniversalMotor Arm;


  DoubleSolenoid ElvSolenoid;
  UniversalMotor ElevatorMotor;


  DifferentialDrive Drive;


  InputController Input;


  @Override
  public void teleopInit() {
    
    LeftDrive1 = new UniversalMotor(Settings.LeftDrive1Port, Settings.DriveMotorType, Settings.DrivePid.P, Settings.DrivePid.I, Settings.DrivePid.D, Settings.DrivePid.Enabled);
    LeftDrive2 = new UniversalMotor(Settings.LeftDrive2Port, Settings.DriveMotorType, Settings.DrivePid.P, Settings.DrivePid.I, Settings.DrivePid.D, Settings.DrivePid.Enabled);
    
    RightDrive1 = new UniversalMotor(Settings.RightDrive1Port, Settings.DriveMotorType, Settings.DrivePid.P, Settings.DrivePid.I, Settings.DrivePid.D, Settings.DrivePid.Enabled);
    RightDrive2 = new UniversalMotor(Settings.RightDrive2Port, Settings.DriveMotorType, Settings.DrivePid.P, Settings.DrivePid.I, Settings.DrivePid.D, Settings.DrivePid.Enabled);

    Drive = new DifferentialDrive(new MotorControllerGroup(LeftDrive1.GetMotorController(), LeftDrive2.GetMotorController()), new MotorControllerGroup(RightDrive1.GetMotorController(), RightDrive2.GetMotorController()));

    //ElevatorMotor = new UniversalMotor(Settings.ElevatorMotorPort, Settings.ElevatorMotorType, Settings.ElevatorPid.P, Settings.ElevatorPid.I, Settings.ElevatorPid.D, Settings.ElevatorPid.Enabled);
    //ElevatorMotor.Falcon.setNeutralMode(NeutralMode.Coast);

    

    Arm = new UniversalMotor(Settings.ArmPort, Settings.ArmType);

    //Input = new InputController("/home/lvuser/InputPresets/Default.json", 0);

    TestStick = new Joystick(0);
  }

  double PercentOutput = 0;

  Joystick TestStick;

  @Override
  public void teleopPeriodic() {
    /*
    Drive.arcadeDrive(Input.GetAxis(0) - Input.GetAxis(4), Input.GetAxis(1) - Input.GetAxis(5));

    ElevatorMotor.SetMotorTarget((Input.GetAxis(2) - Input.GetAxis(6)) * 1);

    Arm.SetMotorTarget(Input.GetAxis(3) - Input.GetAxis(7));
    */

    Drive.arcadeDrive(Input.GetAxis(1) * 0.2, Input.GetAxis(4) * 0.2);

    Arm.SetMotorTarget((Input.GetAxis(3) - Input.GetAxis(2)) * 0.05);
  }

  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  @Override
  public void testInit() {}

  @Override
  public void testPeriodic() {}

  @Override
  public void simulationInit() {}

  @Override
  public void simulationPeriodic() {}
}
