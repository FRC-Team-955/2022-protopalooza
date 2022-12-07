package frc.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public class Grabber {
    public TalonSRX grabberMotor = new TalonSRX(1);

    public void grab(){
        if(grabberMotor.getSelectedSensorPosition() <2500){
            grabberMotor.set(ControlMode.PercentOutput, 0.5);
        }
        else{
            grabberMotor.set(ControlMode.PercentOutput, 0);
        }   
    }

    public void release(){
        if(grabberMotor.getSelectedSensorPosition() > 100){
            grabberMotor.set(ControlMode.PercentOutput, -0.5);
        }
        else{
            grabberMotor.set(ControlMode.PercentOutput, 0);
        }
    }
}
