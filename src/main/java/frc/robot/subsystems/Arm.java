package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import java.util.function.Supplier;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;


public class Arm extends SubsystemBase{
    TalonSRX armMotor1;
    TalonSRX armMotor2;

    public Arm() {
        this.armMotor1 = new TalonSRX(4);
        this.armMotor2 = new TalonSRX(5);
    }

    public void SetMotors(double speed) {
        armMotor1.set(ControlMode.PercentOutput, 0.5 * speed + 0.1);
        armMotor2.set(ControlMode.PercentOutput, 0.5 * speed + 0.1);
    }
}
