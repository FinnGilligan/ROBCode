package frc.robot.commands;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Potentiometer;

public class ArmCommand extends CommandBase{
    Arm arm = new Arm();
    Potentiometer pot;
    public double desiredPos;

    public ArmCommand(Arm arm, Potentiometer pot, double pos) {
        this.arm = arm;
        this.pot = pot;
        this.desiredPos = pos;
        addRequirements(arm);
    }

    public void initialize(){}

    @Override
    public void execute() {
        arm.SetMotors(desiredPos);
    }

    @Override
    public void end(boolean interrupted){}

    @Override
    public boolean isFinished() {
        return Math.abs(Potentiometer.readPot() + desiredPos) < 5;
    }
}
