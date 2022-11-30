package frc.robot;

import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.*;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.motorcontrol.MotorController;

public class UniversalMotor {   
    public ClassMotorType ClassMotorType;

    public WPI_TalonSRX Falcon;
    public CANSparkMax Neo;

    public PID Pid;


    public void SetMotorTarget(double Target) {
        switch (ClassMotorType) {
            case Falcon:
                Falcon.set(TalonSRXControlMode.PercentOutput, Target * Pid.Control(Target - Falcon.getSelectedSensorVelocity()));
                break;
            
            case Neo:
                Neo.set(Target * Pid.Control(Target - Neo.getEncoder().getPosition()));
                break;
            }
    }

    public double GetMotorPosition() {
        switch (ClassMotorType) {
            case Falcon:
                return Falcon.getSelectedSensorPosition() / 4096.0;
            
            case Neo:
                return Neo.getEncoder().getPosition();

            default:
                return 0;
        }
    }

    public double GetMotorVelocity() {
        switch (ClassMotorType) {
            case Falcon:
                return Falcon.getSelectedSensorVelocity() / 40960.0;
            
            case Neo:
                return Neo.getEncoder().getVelocity() * 60;

            default:
                return 0;
        }
    }

    public MotorController GetMotorController() {
        switch (ClassMotorType) {
            case Falcon:
                return Falcon;
            
            case Neo:
                return Neo;

            default:
                return null;
        }  
    }


    public enum ClassMotorType {
        Falcon,
        Neo
    }

    public UniversalMotor(int Port, ClassMotorType _ClassMotorType) {
        ClassMotorType = _ClassMotorType;

        switch (ClassMotorType) {
            case Falcon:
                Falcon = new WPI_TalonSRX(Port);
            
            case Neo:
                Neo = new CANSparkMax(Port, MotorType.kBrushless);
        }

        Pid = new PID(1, 0, 0, false);
    }

    public UniversalMotor(int Port, ClassMotorType _ClassMotorType, double P, double I, double D) {
        ClassMotorType = _ClassMotorType;

        switch (ClassMotorType) {
            case Falcon:
                Falcon = new WPI_TalonSRX(Port);
            
            case Neo:
                Neo = new CANSparkMax(Port, MotorType.kBrushless);
        }

        Pid = new PID(P, I, D);
    }

    public UniversalMotor(int Port, ClassMotorType _ClassMotorType, double P, double I, double D, boolean EnablePid) {
        ClassMotorType = _ClassMotorType;

        switch (ClassMotorType) {
            case Falcon:
                Falcon = new WPI_TalonSRX(Port);
            
            case Neo:
                Neo = new CANSparkMax(Port, MotorType.kBrushless);
        }

        Pid = new PID(P, I, D, EnablePid);
    }

    public UniversalMotor(int Port, ClassMotorType _ClassMotorType, double P, double I, double D, double InitialPidError) {
        ClassMotorType = _ClassMotorType;

        switch (ClassMotorType) {
            case Falcon:
                Falcon = new WPI_TalonSRX(Port);
            
            case Neo:
                Neo = new CANSparkMax(Port, MotorType.kBrushless);
        }

        Pid = new PID(P, I, D, InitialPidError);
    }

    public UniversalMotor(int Port, ClassMotorType _ClassMotorType, double P, double I, double D, double InitialPidError, boolean EnablePid) {
        ClassMotorType = _ClassMotorType;

        switch (ClassMotorType) {
            case Falcon:
                Falcon = new WPI_TalonSRX(Port);
            
            case Neo:
                Neo = new CANSparkMax(Port, MotorType.kBrushless);
        }

        Pid = new PID(P, I, D, InitialPidError, EnablePid);
    }
}