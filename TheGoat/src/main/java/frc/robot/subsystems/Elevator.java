package frc.robot.subsystems;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.SupplyCurrentLimitConfiguration;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import edu.wpi.first.wpilibj.DigitalInput;
import frc.robot.Constants;

public class Elevator {
    public TalonFX mElevatorMotor = new TalonFX(Constants.ElevatorConstants.kElevatorMotorId);
    private DigitalInput mTopLimitSwitch = new DigitalInput(Constants.ElevatorConstants.kTopLimitSwitchId);
    public DigitalInput mBotLimitSwitch = new DigitalInput(Constants.ElevatorConstants.kBotLimitSwitchId);
    private SupplyCurrentLimitConfiguration mCurrentLimit = new SupplyCurrentLimitConfiguration(true, 40, 40, 0);

    public Elevator() {
        mElevatorMotor.setNeutralMode(NeutralMode.Brake);
        mElevatorMotor.configSupplyCurrentLimit(mCurrentLimit);
        mElevatorMotor.setSelectedSensorPosition(0);
    }

    public void moveElevator(double joyPos) {
        joyPos = -joyPos;
        if (mBotLimitSwitch.get() == false){
            resetPos();
        }
        
        if (joyPos < 0 && mElevatorMotor.getSelectedSensorPosition() <= 5000){
            mElevatorMotor.set(ControlMode.PercentOutput, 0);
        } else if (joyPos > 0 && mTopLimitSwitch.get() == true){
            mElevatorMotor.set(ControlMode.PercentOutput, 0);
        } else{
            mElevatorMotor.set(ControlMode.PercentOutput, joyPos * .5);
        }
    }

    public void resetPos() {
        mElevatorMotor.setSelectedSensorPosition(0);
    }
}
