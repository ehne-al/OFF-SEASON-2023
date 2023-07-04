// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.TalonSRXFeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DrivetrainConstants;
import frc.robot.Constants.IntakeConstants;

public class Intake extends SubsystemBase {

  private WPI_TalonSRX intakeUpper = new WPI_TalonSRX(IntakeConstants.kIntakeUpperID);
  private WPI_TalonSRX intakeLower = new WPI_TalonSRX(IntakeConstants.kIntakeLowerID);

  public Intake() {
    intakeUpper.configFactoryDefault();
    intakeLower.configFactoryDefault();

    intakeUpper.configSelectedFeedbackSensor(TalonSRXFeedbackDevice.CTRE_MagEncoder_Relative, 0, DrivetrainConstants.kTimeOutEncoder);
    intakeLower.configSelectedFeedbackSensor(TalonSRXFeedbackDevice.CTRE_MagEncoder_Relative, 0, DrivetrainConstants.kTimeOutEncoder);

    intakeLower.setSensorPhase(true);

    intakeUpper.setInverted(false);
    intakeLower.setInverted(true);

  }
  
  public void manualIntaking(XboxController xboxController, double maxRPM){
    double velUpper;
    double velLower;
    double input;
    if(Math.abs(xboxController.getRightTriggerAxis()) > 0.2 || Math.abs(xboxController.getLeftTriggerAxis()) > 0.2){
      input = xboxController.getRightTriggerAxis() - xboxController.getLeftTriggerAxis();
      velUpper = input * maxRPM * 4096 / 600;
      velLower = (4/3) * velUpper;
      intakeUpper.set(ControlMode.Velocity, velUpper);
      intakeLower.set(ControlMode.Velocity, velLower);
    }
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

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
