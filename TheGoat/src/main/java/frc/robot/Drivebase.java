package frc.robot;
import com.revrobotics.CANSparkMaxLowLevel;
import com.revrobotics.CANSparkMax;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class Drivebase {
    private CANSparkMax mSparkMaxTopRight = new CANSparkMax(Constants.DrivebaseConstants.kSparkMaxTopRightId, CANSparkMaxLowLevel.MotorType.kBrushless);
    private CANSparkMax mSparkMaxTopLeft = new CANSparkMax(Constants.DrivebaseConstants.kSparkMaxTopLeftId, CANSparkMaxLowLevel.MotorType.kBrushless);
    private CANSparkMax mSparkMaxBotRight = new CANSparkMax(Constants.DrivebaseConstants.kSparkMaxBotRightId, CANSparkMaxLowLevel.MotorType.kBrushless);
    private CANSparkMax mSparkMaxBotLeft = new CANSparkMax(Constants.DrivebaseConstants.kSparkMaxBotLeftId, CANSparkMaxLowLevel.MotorType.kBrushless);
    private DifferentialDrive mDiffDrive = new DifferentialDrive(mSparkMaxTopLeft, mSparkMaxTopRight);

    public Drivebase() {
        mSparkMaxBotLeft.set(0);
        mSparkMaxTopLeft.set(0);
        mSparkMaxBotRight.set(0);
        mSparkMaxTopRight.set(0);
        mSparkMaxTopLeft.setInverted(false);
        mSparkMaxTopRight.setInverted(true);
        mSparkMaxTopLeft.setSmartCurrentLimit(40);
        mSparkMaxBotLeft.setSmartCurrentLimit(40);
    }

    public void drive(double joyPosLeft, double joyPosRight) {
        mSparkMaxBotRight.follow(mSparkMaxTopRight);
        mSparkMaxBotLeft.follow(mSparkMaxTopLeft);
        mDiffDrive.arcadeDrive(joyPosLeft * 0.8, joyPosRight * 0.8);
    }  
}
