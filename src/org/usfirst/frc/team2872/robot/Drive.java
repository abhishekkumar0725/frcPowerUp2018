package org.usfirst.frc.team2872.robot;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class Drive {
	WPI_TalonSRX leftMaster, rightMaster;
	WPI_TalonSRX leftSlave, rightSlave;
	DoubleSolenoid gearSwitch;
	
	DifferentialDrive robot;
	private static Drive instance = null;
	long time = 0;
	
	public static Drive getInstance() {
		if (instance == null) {
			instance = new Drive();
		}
		return instance;
	}
	
	private Drive() {
		leftMaster = new WPI_TalonSRX(6);
			leftSlave = new WPI_TalonSRX(7);
		rightMaster = new WPI_TalonSRX(2);
			rightSlave = new WPI_TalonSRX(3);
		
		leftMaster.setInverted(false);
			leftSlave.setInverted(false);
		rightMaster.setInverted(false);
			rightSlave.setInverted(false);
			
		leftSlave.follow(leftMaster);
			rightSlave.follow(rightMaster);
		
		leftMaster.setNeutralMode(NeutralMode.Brake);
			leftSlave.setNeutralMode(NeutralMode.Brake);
		rightMaster.setNeutralMode(NeutralMode.Brake);
			rightSlave.setNeutralMode(NeutralMode.Brake);	
			
		gearSwitch = new DoubleSolenoid(2,3);
				
		robot = new DifferentialDrive(leftMaster, rightMaster);
	}
	
	public void setSpeed(double left, double right) {
		robot.tankDrive(left, right);
	}
	
	
	public void arcade(double speed, double angle) {
		robot.arcadeDrive(speed, angle);
	}
	
	public void gearMode(boolean gearToggle) {
		Value forward = DoubleSolenoid.Value.kForward;
			Value reverse = DoubleSolenoid.Value.kReverse;
			Value off = DoubleSolenoid.Value.kOff;
			
		if(gearToggle) {
			gearSwitch.set(reverse);
		}
		else if(!gearToggle) {
			gearSwitch.set(forward);
		}
	}
}
