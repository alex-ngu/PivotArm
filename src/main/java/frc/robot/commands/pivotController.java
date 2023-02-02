package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.button.CommandPS4Controller;
import frc.robot.subsystems.Pivot;

public class pivotController extends CommandBase{
    Pivot pivot;
    DoubleSupplier speed;
    public pivotController(Pivot newPivot, DoubleSupplier newSpeed){
        speed = newSpeed;
        pivot = newPivot;
        addRequirements(pivot);
    }
    

@Override
public void initialize(){
    pivot.zeroEncoder();
}
@Override
public void execute(){
    pivot.pivotInward(speed);


}
@Override
public void end(boolean interrupted){
    pivot.pivotStop();


    }
@Override
public boolean isFinished(){
    return false;
    }
}


