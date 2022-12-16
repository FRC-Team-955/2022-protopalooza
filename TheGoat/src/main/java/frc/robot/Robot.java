package frc.robot;
import edu.wpi.first.wpilibj.TimedRobot;
import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.Intake;
import edu.wpi.first.wpilibj.XboxController;

public class Robot extends TimedRobot {

  public Drivebase mDrive = new Drivebase();
  public Elevator mElevator = new Elevator();
  public Intake mIntake = new Intake();
  public XboxController mDriveJoy = new XboxController(Constants.JoystickConstants.kDriveJoyId);
  public XboxController mMechJoy = new XboxController(Constants.JoystickConstants.kMechJoyId);

  @Override
  public void robotInit() {}

  @Override
  public void robotPeriodic() {}

  @Override
  public void autonomousInit() {}

  @Override
  public void autonomousPeriodic() {}

  @Override
  public void teleopInit() {}

  @Override
  public void teleopPeriodic() { 
    // Drivebase
    mDrive.drive(mDriveJoy.getLeftY(), mDriveJoy.getRightX());

    // Elevator
    if (mMechJoy.getLeftBumper()){
      mElevator.moveElevator(mMechJoy.getRightY());
    }

    // Intake
    // if (mMechJoy.getAButton()){
    //   if(mMechJoy.getRightTriggerAxis() > 0 && mMechJoy.getRightTriggerAxis() > 0){
    //     mIntake.stopSpin();
    //   } else if(mMechJoy.getRightTriggerAxis() == 1){
    //     mIntake.spinIn();
    //   } else if (mMechJoy.getLeftTriggerAxis() == 1){
    //     mIntake.spinOut();
    //   } else {
    //     mIntake.stopSpin();
    //   }
    // }

    if (mMechJoy.getAButton()) {
      if(mMechJoy.getRightTriggerAxis() == 1){
        mIntake.spinOut();
      } else if (mMechJoy.getLeftTriggerAxis() == 1){
        mIntake.spinIn();
      } else if (mMechJoy.getRightTriggerAxis() > 0 && mMechJoy.getLeftTriggerAxis() > 0) {
        mIntake.stopSpin();
      } else {
        mIntake.stopSpin();
      }
    }
  }
  
  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  @Override
  public void testInit() {}

  @Override
  public void testPeriodic() {}

  @Override
  public void simulationInit() {}

  @Override
  public void simulationPeriodic() {}
}