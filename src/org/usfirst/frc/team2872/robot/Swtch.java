package org.usfirst.frc.team2872.robot;

import edu.wpi.first.wpilibj.Timer;

public class Swtch {
	
	Drive drive;
		Intake intake;
		Scissor scissor;
		Arm arm;
	Timer timer;
	
	private static Swtch instance = new Swtch();
	private Swtch() {
		drive = Drive.getInstance();
		intake = Intake.getInstance();
		scissor = Scissor.getInstance();
		arm = Arm.getInstance();
		timer  = new Timer();
	}
	
	public static Swtch getInstance()
	{
		if (instance == null) {
			instance = new Swtch();
		}
		return instance;
	}
	
	public void setTime() {
		timer.reset();
		timer.start();
	}
	
	public void LL() {
		
	}
	public void diff() {
		if(timer.get() < 4.0) {
			drive.setSpeed(.75, .75);
		}
	}
	public void RR() {
		
	}
	/**
	 * if(timer.get()<.62) {
			arm.setSpeed(.5);
		}
		else if(timer.get()<1.0) {
			arm.setSpeed(0);
			intake.setSpeed(0.5);
		}
		else if(timer.get()<1.6) {
			scissor.setSpeed(.75);
		}
		else {
			scissor.setSpeed(0);
		}
	 **/
	
}
