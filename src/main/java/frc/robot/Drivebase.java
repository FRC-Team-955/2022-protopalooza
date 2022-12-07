package frc.robot;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.Joystick;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;


public class Drivebase {
    // Talons
    private Joystick mJoy = new Joystick(0);
    public CANSparkMax mSparkMaxTopRight = new CANSparkMax(Constants.DrivebaseConstants.kTalonTopRightId,  CANSparkMaxLowLevel.MotorType.kBrushless);
    public CANSparkMax mSparkMaxBotRight = new CANSparkMax(Constants.DrivebaseConstants.kTalonBotRightId,  CANSparkMaxLowLevel.MotorType.kBrushless);
    public CANSparkMax mSparkMaxTopLeft = new CANSparkMax(Constants.DrivebaseConstants.kTalonTopLeftId,  CANSparkMaxLowLevel.MotorType.kBrushless);
    public CANSparkMax mSparkMaxBotLeft = new CANSparkMax(Constants.DrivebaseConstants.kTalonBotLeftId,  CANSparkMaxLowLevel.MotorType.kBrushless);
    private DifferentialDrive mDiffDrive = new DifferentialDrive(mSparkMaxTopLeft, mSparkMaxTopRight);

    public Drivebase(){
        mSparkMaxTopLeft.set(0);
        mSparkMaxTopLeft.set(0);
        mSparkMaxTopRight.set(0);
        mSparkMaxBotRight.set(0);
        mSparkMaxTopLeft.setInverted(false);
        mSparkMaxTopRight.setInverted(true);
    }
        
    

    public void drive(){
        mSparkMaxBotRight.follow(mSparkMaxTopRight);
        mSparkMaxBotLeft.follow(mSparkMaxTopLeft);
        mDiffDrive.arcadeDrive(mJoy.getRawAxis(1), mJoy.getRawAxis(4));
    }

    // public double getLeftEncoderPos(){
    //     return mSparkMaxTopLeft.getSelectedSensorPosition();
    // }

    // public double getRightEncoderPos(){
    //     return mTalonTopRight.getSelectedSensorPosition();
    // }
}