/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.OI;
import frc.robot.Robot;

public class TeleopDrive extends Command {
    private static final double DEADZONE = 0.15;

    public TeleopDrive() {
        requires(Robot.drivetrain);
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
        double x = OI.controller.getRawAxis(OI.ControllerMap.RSTICK_X_AXIS);
        double y = OI.controller.getRawAxis(OI.ControllerMap.LSTICK_Y_AXIS);

        if(Math.abs(x) <= DEADZONE) {
            x = 0;
        }
        if(Math.abs(y) <= DEADZONE) {
            y = 0;
        }

        y = -y;

        x = Math.copySign(x * x, x);
        y = Math.copySign(y * y, y);

        Robot.drivetrain.setOutput(y - x, y + x);
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
        Robot.drivetrain.setOutput(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
        Robot.drivetrain.setOutput(0, 0);
    }
}
