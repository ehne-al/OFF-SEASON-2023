// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.IMotorController;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.AngulationConstants;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class Angulation extends SubsystemBase {

  private CANSparkMax angleMaster = new CANSparkMax(AngulationConstants.kAngleMasterID, MotorType.kBrushed);
  private CANSparkMax angleSlave0 = new CANSparkMax(AngulationConstants.kAngleSlave0ID, MotorType.kBrushed);
  private CANSparkMax angleSlave1 = new CANSparkMax(AngulationConstants.kAngleSlave1ID, MotorType.kBrushed);
  private VictorSPX angleSlave2 = new VictorSPX(AngulationConstants.kAngleSlave2ID);

  public Angulation() {
    angleMaster.restoreFactoryDefaults();
    angleSlave0.restoreFactoryDefaults();
    angleSlave1.restoreFactoryDefaults();
    angleSlave2.configFactoryDefault();

    angleMaster.setInverted(false);
    angleSlave0.setInverted(false);
    angleSlave1.setInverted(true);
    angleSlave2.setInverted(true);

    angleSlave0.follow(angleMaster);
    angleSlave1.follow(angleMaster);
    //VER SE ISSO AQUI FUNCIONA
    angleSlave2.follow((IMotorController) angleMaster);
  }

  public CommandBase exampleMethodCommand() {
    // Inline construction of command goes here.
    // Subsystem::RunOnce implicitly requires `this` subsystem.
    return runOnce(
        () -> {
          /* one-time action goes here */
        });
  }

  public void manualAngulation(XboxController xboxController, double softenMultiplier){
    double input = xboxController.getLeftY();
    double vel;
    if(input < 0.1){
      vel = 0;
    }else{
      vel = input * softenMultiplier;
    }
    angleMaster.set(vel);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

}
