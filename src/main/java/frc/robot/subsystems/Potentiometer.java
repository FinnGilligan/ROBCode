package frc.robot.subsystems;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.TalonSRXConfiguration;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Potentiometer extends SubsystemBase{

    static TalonSRX potEncoder;

    public Potentiometer(){
        potEncoder = new TalonSRX(4);

        TalonSRXConfiguration config = new TalonSRXConfiguration();

        potEncoder.configAllSettings(config);
    }

    public static double readPot(){
        return potEncoder.getSelectedSensorPosition();
    }

    @Override
    public void periodic() {
      // This method will be called once per scheduler run
      SmartDashboard.putNumber("Potentiometer Position", Potentiometer.readPot());
    }
}
