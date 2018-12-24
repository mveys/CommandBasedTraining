package org.usfirst.frc4079.RobotBuilderProject1;

public class Constants {
	/* ROBOT PHYSICAL CONSTANTS */
    // Encoder
    public static double kSensorUnitsPerRotation = 80;
    public static double kGearRatio = 7.31;

    // Wheels
    public static double kDriveWheelDiameterInches = 6.0;
    public static double kTrackWidthInches = 23.75;
    
    public static double kDriveStraightKp = 0.2;
    public static double kDriveStraightKi = 0.0;
    public static double kDriveStraightKd = 0.0;
    public static double kDriveStraightKf = 1.6;
    public static int kDriveStraightIZone = 100;
    public static double kDriveStraightPeakOutput = 1;
    public static int kDriveStraightCruiseVelocity = 400;
    public static int kDriveStraightAcceleration = 2000;

    public static double kDriveTurnKp = 1.4;
    public static double kDriveTurnKi = 0.0;
    public static double kDriveTurnKd = 0.0;
    public static double kDriveTurnKf = 2.0;
    public static int kDriveTurnIZone = 100;
    public static double kDriveTurnPeakOutput = 1;
    public static int kDriveTurnCruiseVelocity = 400;
    public static int kDriveTurnAcceleration = 2000;

    public static int kTimeoutMs = 10;

    public static int kStatus_13_TimeMs = 10; // Default 160
    public static int kStatus_10_TimeMs = 10; // Default 160
}
