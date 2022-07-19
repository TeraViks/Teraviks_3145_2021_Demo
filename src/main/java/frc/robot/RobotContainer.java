/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.*;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

import frc.robot.subsystems.*;



/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...

  // Declare Subsystem Objects
  public static Drivetrain m_drivetrain = new Drivetrain();
  public static Gyro m_gyro = new Gyro();
  public static ShooterCam m_shooterCam = new ShooterCam();
  public static IntakeCam m_intakeCam = new IntakeCam();
  public static ColorAndZipline m_colorAndZipline = new ColorAndZipline();
  public static LED m_led = new LED();
  public static Magazine m_magazine = new Magazine();
  public static Shooter m_shooter = new Shooter();
  public static Intake m_intake = new Intake();
  public static Lift m_lift = new Lift();
  public static Tilt m_tilt = new Tilt();

  // Instantiate Command Objects
  //private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);
  private final CalibrateDriveTrain m_CalibrateDriveTrain = new CalibrateDriveTrain();
  private final CrabMode m_CrabMode = new CrabMode();
  private final Drive m_Drive = new Drive();
  private final FieldCentric m_FieldCentric = new FieldCentric();
  private final GetColor m_GetColor = new GetColor();
  private final RobotCentric m_RobotCentric = new RobotCentric();
  private final SnakeMode m_SnakeMode = new SnakeMode();
  private final RotateWheelToColor m_RotateWheelToColor = new RotateWheelToColor();
  private final RotateWheel3Times m_RotateWheel3Times = new RotateWheel3Times();
  public final static LoadMagazine m_LoadMagazine = new LoadMagazine();
  public final static ShootBall m_ShootBall = new ShootBall();
  private final IntakeBall m_IntakeBall = new IntakeBall();
  private final StopIntake m_StopIntake = new StopIntake();
  private final ReverseIntake m_ReverseIntake = new ReverseIntake();
  private final InvertDrivetrain m_InvertDrivetrain = new InvertDrivetrain();
  private final RetractWinch m_RetractWinch = new RetractWinch();
  private final TargetTrackModeEngage m_TargetTrackModeEngage = new TargetTrackModeEngage();
  private final TargetTrackModeDisengage m_TargetTrackModeDisengage = new TargetTrackModeDisengage();
  private final TiltToControlWheel m_TiltToControlWheel = new TiltToControlWheel();
  private final TiltDown m_TiltDown = new TiltDown();
  private final TiltUp m_TiltUp = new TiltUp();
  // private final MoveZipline m_MoveZipline = new MoveZipline();
  private final TiltMagToLow m_TiltMagToLow = new TiltMagToLow();
  // private final TiltNudge m_TiltNudge = new TiltNudge();
  // private final Command m_autoCommand;

  //Instantiate the Object, SwerveJoy, the joystick that controls the swervedrive
  private static Joystick swerveJoy = new Joystick(0);

  //Instantiate the buttons 0-11
  private static JoystickButton btnX = new JoystickButton(swerveJoy, 1); //Square Button - Rotate 180 CCW
  private static JoystickButton btnA = new JoystickButton(swerveJoy, 2); //X Button
  private static JoystickButton btnB = new JoystickButton(swerveJoy, 3); //O Button - Rotate 180 CW
  private static JoystickButton btnY = new JoystickButton(swerveJoy, 4); //Triange Button
  private static JoystickButton btnLB = new JoystickButton(swerveJoy, 5); //L1 Button - Ball Targetting / Normal Drive Camera While !Pressed
  private static JoystickButton btnRB = new JoystickButton(swerveJoy, 6); //R1 Button - Field Centric
  private static JoystickButton btnLT = new JoystickButton(swerveJoy, 7); //L2 Button - Hatch Targetting / Normal Drive Camera While !Pressed
  private static JoystickButton btnRT = new JoystickButton(swerveJoy, 8); //R2 Button - Robot Centric
  private static JoystickButton btnBack = new JoystickButton(swerveJoy, 9); //Select Button - Level 2 Climb
  private static JoystickButton btnStart = new JoystickButton(swerveJoy, 10); //Start Button - Level 3 Climb
  private static JoystickButton btnLeftStick = new JoystickButton(swerveJoy, 11); //Left Stick Button
  private static JoystickButton btnRightStick = new JoystickButton(swerveJoy, 12); //Right Stick Button

  // ***** The container for the robot. Contains subsystems, OI devices, and
  // commands.

  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be
   * created by instantiating a {@link GenericHID} or one of its subclasses
   * ({@link edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then
   * passing it to a {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    // Driver Buttons

    btnB.whenPressed(m_InvertDrivetrain, false);
    btnRT.whenPressed(m_ShootBall, true);
    btnRB.whenPressed(m_IntakeBall, false);
    btnRB.whenReleased(m_StopIntake, false);
    btnLB.whenPressed(m_ReverseIntake, false);
    btnLB.whenReleased(m_StopIntake, false);
    btnA.whenPressed(m_TiltDown, false);
    btnY.whenPressed(m_TiltUp, false);
    btnX.whenPressed(m_TiltMagToLow, false);

  }

  public static double getDriverX() {
    return swerveJoy.getX();
  }

  public static double getDriverY() {
    return swerveJoy.getY();
  }

  public static double getDriverZ() {
    return swerveJoy.getZ();
  }

  public static boolean getShootButtonState() {
    return btnRT.get();
  }

  public static boolean getMediumSpeedDriveButtonState() {
    return btnLT.get();
  }

  public static boolean getLowSpeedDriveButtonState() {
    return btnLB.get();
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  /*public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }*/
}
