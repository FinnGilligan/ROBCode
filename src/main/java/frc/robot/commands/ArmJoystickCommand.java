package frc.robot.commands;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Potentiometer;

public class ArmJoystickCommand extends CommandBase{
    Arm arm = new Arm();
    Potentiometer pot;
    Supplier<Double> joystick;
    public static double desiredPos;

    public ArmJoystickCommand(Arm arm, Potentiometer pot, Supplier<Double> joystick) {
        this.arm = arm;
        this.pot = pot;
        this.joystick = joystick;
        addRequirements(arm);
    }

    public void initialize(){}

    @Override
    public void execute() {
        arm.SetMotorsManual(-joystick.get());
    }

    @Override
    public void end(boolean interrupted){}

    @Override
    public boolean isFinished() {
        return false;
    }
}
