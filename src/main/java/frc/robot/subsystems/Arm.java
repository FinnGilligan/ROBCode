package frc.robot.subsystems;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.commands.ArmCommand;

import java.util.function.Supplier;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;


public class Arm extends SubsystemBase{
    TalonSRX armMotor1;
    TalonSRX armMotor2;

    public Arm() {
        this.armMotor1 = new TalonSRX(4);
        this.armMotor2 = new TalonSRX(5);

        armMotor1.configFactoryDefault();
        armMotor2.configFactoryDefault();


    }

    public void SetMotors(double desiredPos) {
        if(Potentiometer.readPot() + desiredPos > 0) {
            armMotor1.set(ControlMode.PercentOutput, 0.5);
            armMotor2.set(ControlMode.PercentOutput, 0.5);
        }
        
        else if(Potentiometer.readPot() + desiredPos < 0) {
            armMotor1.set(ControlMode.PercentOutput, -0.3);
            armMotor2.set(ControlMode.PercentOutput, -0.3);
        }

        SmartDashboard.putNumber("Desired Position", desiredPos);
        }

    public void SetMotorsManual(double speed) {
        armMotor1.set(ControlMode.PercentOutput, 0.4 * speed + 0.15);
        armMotor2.set(ControlMode.PercentOutput, 0.4 * speed + 0.15);
    }

    @Override
    public void periodic() {
    }
}
