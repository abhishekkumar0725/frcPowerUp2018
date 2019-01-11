package org.usfirst.frc.team2872.robot;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

public class Intake {
	WPI_TalonSRX intakeMaster;
	WPI_TalonSRX intakeSlave;
	DoubleSolenoid grabSwitch;
	Timer timer = new Timer();
	long time = 0;
	LiveWindow lw = new LiveWindow();
	Value set;
	
	private static Intake instance = null;
	
	public static Intake getInstance() {
		if (instance == null) {
			instance = new Intake();
		}
		return instance;
	}
	
	@SuppressWarnings("deprecation")
	private Intake() {
		intakeMaster = new WPI_TalonSRX(4);
			intakeSlave = new WPI_TalonSRX(8);
			
		grabSwitch = new DoubleSolenoid(0,1);
		
		intakeSlave.setInverted(true);
		
	}
	
	public void setRightSpeed(double speed){
		intakeMaster.set(speed);
	}
	
	public void setLeftSpeed(double speed) {
		intakeSlave.set(speed);
	}
	
	public void setSpeed(double speed) {
		intakeSlave.follow(intakeMaster);
		intakeMaster.set(speed);
	}
	
	public void grabMode(boolean grabToggle) {
		Value forward = DoubleSolenoid.Value.kForward;
			Value reverse = DoubleSolenoid.Value.kReverse;
			Value off = DoubleSolenoid.Value.kOff;
			
		if(grabToggle) {
			set = reverse;
		}
		else if(!grabToggle) {
			set	= forward;
		}
		
		grabSwitch.set(set);
	}
	
	public DoubleSolenoid getVal() {
		return grabSwitch;
	}
}
