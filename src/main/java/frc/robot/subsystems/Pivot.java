package frc.robot.subsystems;
import java.util.function.DoubleSupplier;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
public class Pivot extends SubsystemBase{
    TalonSRX pivotMotor;
    //TalonEncoder pivotEnc = new TalonEncoder(pivotMotor);
    public Pivot(){
        pivotMotor = new TalonSRX(4);


    }
    public void pivotInward(DoubleSupplier speed){
        pivotMotor.set(ControlMode.PercentOutput, speed.getAsDouble());
    }

    public void pivotOutward(double speed){
        pivotMotor.set(ControlMode.PercentOutput, -speed);
    }

    public void pivotStop(){
        pivotMotor.set(ControlMode.PercentOutput, 0);
    }

    public void zeroEncoder(){
        pivotMotor.getSensorCollection().setQuadraturePosition(0, 5);
    }


    public double getEncoder(){
        return pivotMotor.getSensorCollection().getQuadraturePosition();
    }

    @Override
    public void periodic() {
      SmartDashboard.putNumber("Encoder Value", getEncoder());
    }

}


