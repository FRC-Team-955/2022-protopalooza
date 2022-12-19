package frc.robot.subsystems;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import frc.robot.Constants;

public class Intake {
    private TalonSRX mFrontIntakeMotor = new TalonSRX(Constants.IntakeConstants.kFrontIntakeMotorId);
    private TalonSRX mBackIntakeMotor = new TalonSRX(Constants.IntakeConstants.kBackIntakeMotorId);

    public Intake() {
        mFrontIntakeMotor.configPeakCurrentLimit(20);
        mBackIntakeMotor.configPeakCurrentLimit(20);
        mFrontIntakeMotor.setNeutralMode(NeutralMode.Brake);
        mBackIntakeMotor.setNeutralMode(NeutralMode.Brake);
    }

    public void spinIn(double joyPos) {
        mFrontIntakeMotor.set(ControlMode.PercentOutput, joyPos * .6);
        mBackIntakeMotor.set(ControlMode.PercentOutput, -joyPos * .6);
    }

    public void spinOut(double joyPos) {
        mFrontIntakeMotor.set(ControlMode.PercentOutput, -joyPos * .6);
        mBackIntakeMotor.set(ControlMode.PercentOutput, joyPos * .6);
    }

    public void stopSpin() {
        mFrontIntakeMotor.set(ControlMode.PercentOutput, 0);
        mBackIntakeMotor.set(ControlMode.PercentOutput, 0);
    }
}