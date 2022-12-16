package frc.robot.subsystems;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import frc.robot.Constants;

public class Intake {
    private TalonSRX mFrontIntakeMotor = new TalonSRX(Constants.IntakeConstants.kFrontIntakeMotorId);
    // private TalonSRX mBackIntakeMotor = new TalonSRX(Constants.IntakeConstants.kBackIntakeMotorId);

    public Intake() {
        mFrontIntakeMotor.configPeakCurrentLimit(20);
        // mBackIntakeMotor.configPeakCurrentLimit(40);
        mFrontIntakeMotor.setNeutralMode(NeutralMode.Brake);
        // mBackIntakeMotor.setNeutralMode(NeutralMode.Brake);
    }

    public void spinIn() {
        mFrontIntakeMotor.set(ControlMode.PercentOutput, 1);
        // mBackIntakeMotor.set(ControlMode.PercentOutput, -.3);
    }

    public void spinOut() {
        mFrontIntakeMotor.set(ControlMode.PercentOutput, -1);
        // mBackIntakeMotor.set(ControlMode.PercentOutput, .3);
    }

    public void stopSpin() {
        mFrontIntakeMotor.set(ControlMode.PercentOutput, 0);
        // mBackIntakeMotor.set(ControlMode.PercentOutput, 0);
    }
}