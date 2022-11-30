package frc.robot.Input;

public class AxisPreset {
    public boolean Composite;
    public int Binding;
    public int CompositePositive;
    public int CompositeNegative;

    public AxisPreset(boolean _Composite, int _Binding, int _CompositePositive, int _CompositeNegative) {
        Composite = _Composite;
        Binding = _Binding;
        CompositePositive = _CompositePositive;
        CompositeNegative = _CompositeNegative;
    }
}
