package frc.robot;

import javax.swing.MenuElement;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

public class Elevator {
    Compressor mCompressor = new Compressor(PneumaticsModuleType.REVPH);
    DigitalInput limitSwitchBot = new DigitalInput(1);
    DigitalInput limitSwitchTop = new DigitalInput(4);
    TalonFX elevatorMotor = new TalonFX(12);
    DoubleSolenoid elevatorLock = new DoubleSolenoid(0, PneumaticsModuleType.CTREPCM,1,0);

    public Elevator() {
      elevatorMotor .setNeutralMode(NeutralMode.Brake);
    }

    void ElevatorMove(double joystick_position) {
        joystick_position = -joystick_position;
        if (limitSwitchBot.get() == false) {
          resetPosition();
          elevatorMotor.set(ControlMode.PercentOutput, 0);
        }
        if(joystick_position < 0 && elevatorMotor.getSelectedSensorPosition() <= 5000){
          elevatorMotor.set(ControlMode.PercentOutput, 0);
        }
        else if (joystick_position > 0 && limitSwitchTop.get() == true){
          elevatorMotor.setSelectedSensorPosition(300000);
          elevatorMotor.set(ControlMode.PercentOutput, 0);
        }
        else{
          elevatorMotor.set(ControlMode.PercentOutput, joystick_position);
        }
      }

    void toggleElevatorLock() {
        elevatorLock.toggle();
        elevatorMotor.set(ControlMode.PercentOutput, 0);
      }

    void resetPosition(){
        elevatorMotor.setSelectedSensorPosition(0);
    }
}
