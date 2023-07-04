// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

  public static class DrivetrainConstants {
    public static final int kLeftMasterID = 0;
    public static final int kLeftSlaveID = 1;
    public static final int kRightMasterID = 2;
    public static final int kRightSlaveID = 3;
    public static final int kTimeOutEncoder = 20;

  }

  public static class AngulationConstants {
    public static final int kAngleMasterID = 0;
    public static final int kAngleSlave0ID = 1;
    public static final int kAngleSlave1ID = 2;
    public static final int kAngleSlave2ID = 3;
  }

  public static class IntakeConstants {
    public static final int kIntakeLowerID = 0;
    public static final int kIntakeUpperID = 1;

  }
}
