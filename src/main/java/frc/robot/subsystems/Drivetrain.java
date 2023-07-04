// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.TalonSRXFeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DrivetrainConstants;

public class Drivetrain extends SubsystemBase {

  private WPI_TalonSRX leftMaster = new WPI_TalonSRX(DrivetrainConstants.kLeftMasterID);
  private VictorSPX leftSlave = new VictorSPX(DrivetrainConstants.kLeftSlaveID);
  private WPI_TalonSRX rightMaster = new WPI_TalonSRX(DrivetrainConstants.kRightMasterID);
  private VictorSPX rightSlave = new VictorSPX(DrivetrainConstants.kRightSlaveID);

  private DifferentialDrive diffDrive = new DifferentialDrive(leftMaster, rightMaster);

  public Drivetrain() {
    rightMaster.configFactoryDefault();
    rightSlave.configFactoryDefault();
    leftMaster.configFactoryDefault();
    leftSlave.configFactoryDefault();

    rightMaster.setInverted(true);
    rightSlave.setInverted(true);

    leftMaster.setInverted(false);
    leftSlave.setInverted(false);

    leftSlave.follow(leftMaster);
    rightSlave.follow(rightMaster);

    rightMaster.configSelectedFeedbackSensor(TalonSRXFeedbackDevice.CTRE_MagEncoder_Absolute, 0, DrivetrainConstants.kTimeOutEncoder);
    leftMaster.configSelectedFeedbackSensor(TalonSRXFeedbackDevice.CTRE_MagEncoder_Absolute, 0, DrivetrainConstants.kTimeOutEncoder);
  }

  public void drive(XboxController xboxController){
    double y = xboxController.getLeftY();
    double x = xboxController.getRightX();

    diffDrive.arcadeDrive(y, x);
  }

  public CommandBase exampleMethodCommand() {
    // Inline construction of command goes here.
    // Subsystem::RunOnce implicitly requires `this` subsystem.
    return runOnce(
        () -> {
          /* one-time action goes here */
        });
  }











  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

}
