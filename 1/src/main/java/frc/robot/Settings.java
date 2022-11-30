package frc.robot;

import frc.robot.UniversalMotor.ClassMotorType;

public final class Settings {
    

    public static final int LeftDrive1Port = 3;    
    public static final int LeftDrive2Port = 2;

    public static final int RightDrive1Port = 5;
    public static final int RightDrive2Port = 6;


    public static final UniversalMotor.ClassMotorType DriveMotorType = ClassMotorType.Neo;


    public class DrivePid {
        public static final boolean Enabled = true;


        public static final double P = 0.1;

        public static final double I = 0;

        public static final double D = 0;
    }


    public static final int ArmPort = 4;

    public static final UniversalMotor.ClassMotorType ArmType = ClassMotorType.Falcon;


    public static final int ElevatorMotorPort = 12;

    public static final UniversalMotor.ClassMotorType ElevatorMotorType = ClassMotorType.Falcon;

    public class ElevatorPid {
        public static final boolean Enabled = true;


        public static final double P = 0.1;

        public static final double I = 0;

        public static final double D = 0;
    }
}
