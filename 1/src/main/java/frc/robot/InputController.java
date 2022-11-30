package frc.robot;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

import edu.wpi.first.wpilibj.Joystick;
import frc.robot.Input.Button;
import frc.robot.Input.InputPreset;

public class InputController {
    boolean[] CompositeAxes;
    int[] AxesBindings;
    int[][] CompositeButtonBindings;

    Button[] Buttons;

    Joystick Stick;


    public double GetAxis(int Axis) {
        if (CompositeAxes[Axis]) {
            double AxisValue = 0;
            if (Stick.getRawButton(CompositeButtonBindings[Axis][0]))
                AxisValue--;
            if (Stick.getRawButton(CompositeButtonBindings[Axis][1]))
                AxisValue++;

            return AxisValue;
        } else {
            return Stick.getRawAxis(AxesBindings[Axis]);
        }
    }

    public Button GetButton(int Button) {
        return Buttons[Button];
    }

    public InputController(String PresetPath, int StickPort) {
        try {
            ObjectMapper Reader = new ObjectMapper();

            System.out.println("Pre load");

            InputPreset Preset = Reader.readValue(new File(PresetPath), InputPreset.class);

            System.out.println("Post load");

            Stick = new Joystick(StickPort);

            System.out.println("Stick");

            Buttons = new Button[Preset.ButtonBindings.length];
            for (int i = 0; i < Preset.ButtonBindings.length; i++) {
                Buttons[i] = new Button(Preset.ButtonBindings[i], Stick);
                System.out.println("New Button");
            }

            System.out.println("Buttons Loaded");

            CompositeAxes = new boolean[Preset.AxisComposite.length];
            AxesBindings = new int[Preset.AxisComposite.length];

            System.out.println("Loading Axes");

            CompositeButtonBindings = new int[Preset.AxisComposite.length][2];

            for (int i = 0; i < Preset.AxisComposite.length; i++) {
                System.out.println("Determining Axis Type");
                if (Preset.AxisComposite[i]) {
                    CompositeButtonBindings[i][0] = Preset.AxisCompositeNegative[i];
                    CompositeButtonBindings[i][1] = Preset.AxisCompositePositive[i];
                    CompositeAxes[i] = true;
                } else {
                    System.out.println("Starting Axis");
                    AxesBindings[i] = Preset.AxisBinding[i];
                    CompositeAxes[i] = false;
                    System.out.println("New Non-Composite");
                }
            }

            System.out.println("Control Loading Done");
        } catch (Exception e) {
            System.err.println("Control Preset failed to load: " + e.toString());
        }
    }

    public InputController(InputPreset Preset, int StickPort) {
        Stick = new Joystick(StickPort);

        Buttons = new Button[Preset.ButtonBindings.length];
        for (int i = 0; i < Preset.ButtonBindings.length; i++) {
            Buttons[i] = new Button(Preset.ButtonBindings[i], Stick);
        }

        CompositeAxes = new boolean[Preset.AxisComposite.length];
        AxesBindings = new int[Preset.AxisComposite.length];
        for (int i = 0; i < Preset.AxisComposite.length; i++) {
            CompositeButtonBindings[i] = new int[2];
            if (Preset.AxisComposite[i]) {
                CompositeButtonBindings[i][0] = Preset.AxisCompositeNegative[i];
                CompositeButtonBindings[i][1] = Preset.AxisCompositePositive[i];
                CompositeAxes[i] = true;
            } else {
                AxesBindings[i] = Preset.AxisBinding[i];
                CompositeAxes[i] = false;
            }
        }
    }
}
