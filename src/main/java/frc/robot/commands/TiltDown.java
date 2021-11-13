// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.text.RuleBasedCollator;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.Robot;
import frc.robot.RobotContainer;

import frc.robot.RobotMap;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class TiltDown extends InstantCommand {
  double endPos;

  public TiltDown() {
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    endPos = ((RobotContainer.m_tilt.getTiltPosition() / RobotMap.PULSES_PER_DEGREE) - 5) * RobotMap.PULSES_PER_DEGREE;
    
    if (endPos < RobotMap.MAGAZINE_LOW) {
      endPos = RobotMap.MAGAZINE_LOW;
    }
    if (endPos > RobotMap.MAGAZINE_VERTICAL) {
      endPos = RobotMap.MAGAZINE_VERTICAL;
    }

    RobotContainer.m_tilt.setTiltAngle(endPos);
  }
}
