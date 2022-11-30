package frc.robot.Input;

import com.fasterxml.jackson.databind.ObjectMapper;

public class InputPreset {
    public int[] ButtonBindings;

    public boolean[] AxisComposite;
    public int[] AxisBinding;
    public int[] AxisCompositePositive;
    public int[] AxisCompositeNegative;

    public String ToJSON() throws Exception {
        return new ObjectMapper().writeValueAsString(this);
    }
    /*
    public InputPreset(int[] Bindings, boolean[] Composite, int[] Binding, int[] CompositePositive, int[] CompositeNegative) {
        ButtonBindings = Bindings;
        AxisComposite = Composite;
        AxisBinding = Binding;
        AxisCompositePositive = CompositePositive;
        AxisCompositeNegative = CompositeNegative;
    }
    */
}
