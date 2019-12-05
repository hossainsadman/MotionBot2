/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static int leftMotor = 1;
    // public static int rightMotor = 2;

    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;

    public static final VictorSPX motor = new VictorSPX(7);
    public static final VictorSPX rvictor = new VictorSPX(0);
    public static final TalonSRX rtalon1 = new TalonSRX(1);
    public static final TalonSRX rtalon2 = new TalonSRX(2);
    public static final VictorSPX lvictor = new VictorSPX(3);
    public static final TalonSRX ltalon1 = new TalonSRX(4);
    public static final TalonSRX ltalon2 = new TalonSRX(5);

    public static void init() {
        rtalon1.follow(rvictor);
        rtalon2.follow(rvictor);
        ltalon1.follow(lvictor);
        ltalon2.follow(lvictor);

        RobotMap.lvictor.setNeutralMode(NeutralMode.Brake);
        RobotMap.rvictor.setNeutralMode(NeutralMode.Brake);
        RobotMap.ltalon1.setNeutralMode(NeutralMode.Brake);
        RobotMap.ltalon2.setNeutralMode(NeutralMode.Brake);
        RobotMap.rtalon1.setNeutralMode(NeutralMode.Brake);
        RobotMap.rtalon2.setNeutralMode(NeutralMode.Brake);
    }
}
