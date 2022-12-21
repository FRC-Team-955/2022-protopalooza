package frc.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public class Grabber {
    public TalonSRX grabberMotor = new TalonSRX(9);

    public void setZero(){
        grabberMotor.setSelectedSensorPosition(0);
    }

    public double getPosition(){
        return grabberMotor.getSelectedSensorPosition(0);
    }

    public void grab(double joystick_position){
        grabberMotor.set(ControlMode.PercentOutput, joystick_position * 0.5);
    }
}
