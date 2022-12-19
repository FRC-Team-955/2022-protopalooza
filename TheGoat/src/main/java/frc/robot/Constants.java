package frc.robot;

public class Constants {
    public static final class JoystickConstants {
        // Joystick Ids
        public static int kMechJoyId = 0;
        public static int kDriveJoyId = 1;
    }

    public static final class DrivebaseConstants {
        // SparkMax Motor Ids
        public static int kSparkMaxTopRightId = 2;
        public static int kSparkMaxBotRightId = 3;
        public static int kSparkMaxTopLeftId = 6;
        public static int kSparkMaxBotLeftId = 5;
    }

    public static final class ElevatorConstants {
        // Elevator Motor and Limit Switches Ids
        public static int kElevatorMotorId = 12;
        public static int kTopLimitSwitchId = 4;
        public static int kBotLimitSwitchId = 1;
    }

    public static final class IntakeConstants {
        public static int kFrontIntakeMotorId = 1;
        public static int kBackIntakeMotorId = 4;
    }
}
