package org.usfirst.frc.team2872.robot;

import edu.wpi.first.wpilibj.Timer;

public class Center {
	
	Drive drive;
	Intake intake;
	Scissor scissor;
	Arm arm;
	Timer timer;
	double l, r;
	
	private static Center instance = new Center();
	private Center() {
		drive = Drive.getInstance();
		intake = Intake.getInstance();
		scissor = Scissor.getInstance();
		arm = Arm.getInstance();
		timer = new Timer();
	}
	
	public static Center getInstance()
	{
		if (instance == null) {
			instance = new Center();
		}
		return instance;
	}
	
	public void setTime() {
		timer.reset();
		timer.start();
	}
	
	public void autoCenter(char endPos, char startPos) {
		
		if(startPos == endPos) {
			if(timer.get()<2.9) {
				drive.setSpeed(.70, .70);	
			}
			
			else if(timer.get()<3.7) {
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
		}
		
		else {
			if(timer.get()<.75) {
				drive.setSpeed(.70, .70);	
			}
			else if(timer.get()<1.55) {
				drive.setSpeed(-.75, .75);
			}
			else if(timer.get()<1.75) {
				drive.setSpeed(0, 0);
			}
			else if(timer.get()<3.55) {
				drive.setSpeed(.75, .75);
			}
			else if(timer.get()<3.8) {
				drive.setSpeed(0, 0);
			}
			else if(timer.get()<4.55) {
				drive.setSpeed(.75, -.75);
			}
			else if(timer.get()<5.65) {
				drive.setSpeed(.75, .75);
			}
			else if(timer.get()<6.45){
				drive.setSpeed(0, 0);
				scissor.setSpeed(1.0);
			}
			
			else if(timer.get()<7.2) {
				intake.setSpeed(-.8);
				scissor.setSpeed(0.0);

			}
			else {
				intake.setSpeed(0);
			}
		}
	}
	
	
}
