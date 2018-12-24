// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc4079.RobotBuilderProject1;

import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc4079.RobotBuilderProject1.commands.DriveDistance;
import org.usfirst.frc4079.RobotBuilderProject1.commands.*;
import org.usfirst.frc4079.RobotBuilderProject1.subsystems.*;

import com.ctre.phoenix.motorcontrol.ControlMode;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in 
 * the project.
 */
public class Robot extends TimedRobot {
    
    Command autonomousCommand;
    SendableChooser<Command> chooser = new SendableChooser<>();
    Timer timer;
    private Preferences prefs;
    double testAngle;
    
    public static OI oi;
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static DriveTrain driveTrain;
    public static Elevator elevator;
    public static Intake intake;
    public static Wrist wrist;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    @Override
    public void robotInit() {
        RobotMap.init();
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        driveTrain = new DriveTrain();
        elevator = new Elevator();
        intake = new Intake();
        wrist = new Wrist();

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        // OI must be constructed after subsystems. If the OI creates Commands
        //(which it very likely will), subsystems are not guaranteed to be
        // constructed yet. Thus, their requires() statements may grab null
        // pointers. Bad news. Don't move it.
        driveTrain.resetEncoders();
        timer = new Timer();
        oi = new OI();
        
        // Add commands to Autonomous Sendable Chooser
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS

       // chooser.addDefault("Autonomous Command", new AutonomousCommand());

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS
        chooser.addDefault("Command GrouP", new CommandGroupTest());
        chooser.addObject("Autonomous Command", new GetCube(0.4,0.5));
        chooser.addObject("Drive Distance", new DriveDistance(100.0, 4.5));
        chooser.addObject("Turn By Angle", new TurnByAngle(90, 3.0));
        
        SmartDashboard.putData("Auto mode", chooser);
        
		
        prefs = Preferences.getInstance();
       // prefs.putDouble("Test Angle", 90 );
        
       // testAngle=prefs.getDouble("Test Angle", 45);
		
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    @Override
    public void disabledInit(){

    }

    @Override
    public void disabledPeriodic() {
        Scheduler.getInstance().run();
    }

    @Override
    public void autonomousInit() {
    	driveTrain.resetEncoders();
    	Timer.delay(0.1);
        autonomousCommand = chooser.getSelected();
        // schedule the autonomous command (example)
        if (autonomousCommand != null) autonomousCommand.start();
        
    }

    /**
     * This function is called periodically during autonomous
     */
    @Override
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
        driveTrain.outputToSmartDashboard();
    }

    @Override
    public void teleopInit() {
        // This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
        driveTrain.resetEncoders();
        
    }

    /**
     * This function is called periodically during operator control
     */
    @Override
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        driveTrain.outputToSmartDashboard();
    }
    
    @Override
    public void testInit() {
    	testAngle=prefs.getDouble("Test Angle", 45);
    	driveTrain.resetEncoders();
    	
    	timer.start();
    	// driveTrain.driveToTarget(60, -60);
    	//driveTrain.turnByAngle(90);
    }

    @Override
    public void testPeriodic() {
    	
    /*	if (timer.get() < 5) {
    	driveTrain.driveToTarget(60, -60);
    	}
    	else {
    		driveTrain.driveToTarget(20, -20);
    	}
   */
    	
    	driveTrain.turnToAngle(testAngle);
    	SmartDashboard.putNumber("time ", timer.get());
    	 driveTrain.outputToSmartDashboard();
    }
}
