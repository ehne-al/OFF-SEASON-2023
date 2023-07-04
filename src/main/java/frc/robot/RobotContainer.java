// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.subsystems.Angulation;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Intake;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;

public class RobotContainer {

  private final Drivetrain drivetrain = new Drivetrain();
  private final Angulation angulation = new Angulation();
  private final Intake intake = new Intake();

  private final XboxController xboxController0 =
    new XboxController(0);

  private final XboxController xboxController1 =
    new XboxController(1);

  public RobotContainer() {
    drivetrain.setDefaultCommand(new RunCommand(() -> drivetrain.drive(xboxController0) , drivetrain));
    intake.setDefaultCommand(new RunCommand(() -> intake.manualIntaking(xboxController1, 300) , intake));
    angulation.setDefaultCommand(new RunCommand(() -> angulation.manualAngulation(xboxController1, 0.5) , angulation));

    configureBindings();
  }

  private void configureBindings() {
    // Schedule `exampleMethodCommand` when the Xbox controller's B button is pressed,
    // cancelling on release.
    //m_driverController.b().whileTrue(m_exampleSubsystem.exampleMethodCommand());
  }

  public Command getAutonomousCommand() {
    return null;
  }
}
