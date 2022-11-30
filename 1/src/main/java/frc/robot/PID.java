package frc.robot;

import edu.wpi.first.wpilibj.*;

public class PID {
    public double P;
    public double I;
    public double D;

    public boolean Enabled;

    double SumOfError;

    Timer Timer;

    double PrevTime = 0;

    double PrevError;

    public double Control(double Error) {
        if (!Enabled)
            return 1;

        SumOfError += Error;
        double ToReturn = (P * Error) + (I * SumOfError * (Timer.get() - PrevTime)) + (D * ((Error - PrevError) / (Timer.get() - PrevTime)));
        PrevTime = Timer.get();
        PrevError = Error;
        return ToReturn;
    }

    public void SetPID(double _P, double _I, double _D) {
        P = _P;
        I = _I;
        D = _D;

        SumOfError = 0;
    }

    public void SetPID(double _P, double _I, double _D, double Error) {
        P = _P;
        I = _I;
        D = _D;
        SumOfError = Error;
    }

    public void SetActive(boolean State) {
        Enabled = State;

        if (State)
            Timer.start();
        else
            Timer.stop();
    }

    public void SetInitialError(double Error) {
        PrevError = Error;
    }

    public PID(double _P, double _I, double _D, double InitialError) {
        P = _P;
        I = _I;
        D = _D;
        PrevError = InitialError;
        Timer = new Timer();
        Enabled = true;
        Timer.start();
    }
    public PID(double _P, double _I, double _D, double InitialError, boolean Start) {
        P = _P;
        I = _I;
        D = _D;
        PrevError = InitialError;
        Timer = new Timer();

        Enabled = Start;

        if (Start)
            Timer.start();
    }

    public PID(double _P, double _I, double _D) {
        P = _P;
        I = _I;
        D = _D;
        PrevError = 0;
        Timer = new Timer();
        Enabled = true;
        Timer.start();
    }
    public PID(double _P, double _I, double _D, boolean Start) {
        P = _P;
        I = _I;
        D = _D;
        PrevError = 0;
        Timer = new Timer();

        Enabled = Start;

        if (Start)
            Timer.start();
    }
}
