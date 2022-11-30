package frc.robot.Input;

import edu.wpi.first.wpilibj.Joystick;

public class Button {
    public boolean IsPressed() {
        return Stick.getRawButton(TrueBinding);
    }

    public boolean Pressed() {
        return Stick.getRawButtonPressed(TrueBinding);
    }

    public boolean Released() {
        return Stick.getRawButtonReleased(TrueBinding);
    }

    int TrueBinding;

    Joystick Stick;

    public Button(int Binding, Joystick ControlStick) {
        TrueBinding = Binding;
        Stick = ControlStick;
    }
}
