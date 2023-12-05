package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.*;

import java.util.function.Supplier;
import frc.robot.subsystems.Drivetrain;

public class JoystickCMD extends CommandBase {
    

    Drivetrain rob = new Drivetrain();
    Supplier<Double> xSpd, ySpd;

    public JoystickCMD(Drivetrain rob, Supplier<Double> xSpd, Supplier<Double> ySpd) {
        this.rob = rob;
        this.xSpd = xSpd;
        this.ySpd = ySpd;
        addRequirements(rob);
    }
    public void initialize() {}

    @Override 
    public void execute(){
        rob.setMotors(xSpd.get(), -ySpd.get());
    }
@Override 
public void end(boolean interrupted){}

@Override
public boolean isFinished(){
    return false;

}
    
}
