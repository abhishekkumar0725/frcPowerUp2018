package org.usfirst.frc.team2872.robot;

import edu.wpi.first.wpilibj.Timer;

public class Scale {

	Drive drive;
	Intake intake;
	Scissor scissor;
	Timer timer;
	
	private static Scale instance = new Scale();
	private Scale() {
		drive = Drive.getInstance();
		intake = Intake.getInstance();
		scissor = Scissor.getInstance();
		timer = new Timer();
	}
	
	public static Scale getInstance()
	{
		if (instance == null) {
			instance = new Scale();
		}
		return instance;
	}
	
	public void setTime() {
		timer.reset();
		timer.start();
	}
	
	public void LL() {
		if(timer.get()<4.75) {
			drive.setSpeed(.5, .5);	
		}
		
		/**
		else if(timer.get()<3.5) {
			drive.setSpeed(0, 0);
			scissor.setSpeed(1.0);
		}
		
		else if(timer.get()<4.5) {
			intake.setSpeed(-.8);
			scissor.setSpeed(0.0);

		}
		else {
			intake.setSpeed(0);
		}
		**/
	}
	public void diff() {
		if(timer.get()<4.75) {
			drive.setSpeed(.75, .75);	
		}
	}
	public void RL() {
		if(timer.get() < 4.25) {
			drive.setSpeed(.75, .75);
		}
		else if(timer.get()<4.6) {
			drive.setSpeed(.75, -.75);
		}
		else if(timer.get()<11.4) {
			drive.setSpeed(.75, .75);
		}
	}
	public void LR() {
		if(timer.get() < 4.25) {
			drive.setSpeed(.75, .75);
		}
		else if(timer.get()<4.6) {
			drive.setSpeed(-.75, .75);
		}
		else if(timer.get()<11.4) {
			drive.setSpeed(.75, .75);
		}
	}
	public void RR() {
		if(timer.get()<4.05) {
			drive.setSpeed(.75, .75);	
		}
		else if(timer.get()<7.55) {
			scissor.setSpeed(1.0);
			drive.setSpeed(0, 0);
		}
		else if(timer.get()<8.55) {
			scissor.setSpeed(0);
			intake.setSpeed(-.8);
		}
		else {
			scissor.setSpeed(0);
		}
		/**
		if(timer.get() < 5.0) {
			drive.setSpeed(.75, .75);
		}
		else if(timer.get()<8.5) {
			drive.setSpeed(0, 0);
			scissor.setSpeed(1.0);
		}
		else if(timer.get()<10.0) {
			intake.setSpeed(1.0);
		}
		else {
			intake.setSpeed(0);
		}
		**/
		/**if(timer.get()<4.0) {
		drive.setSpeed(.75, .75);
	}
	else {
		drive.setSpeed(0, 0);
	}**/
	}
}
