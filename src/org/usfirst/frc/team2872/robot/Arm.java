package org.usfirst.frc.team2872.robot;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class Arm {
	WPI_TalonSRX armMaster;
	
	private static Arm instance = null;
	
	public static Arm getInstance() {
		if (instance == null) {
			instance = new Arm();
		}
		return instance;
	}
	
	private Arm() {
		armMaster = new WPI_TalonSRX(0);
	}
	
	public void setSpeed(double speed){
		armMaster.set(speed);
		
	}
}