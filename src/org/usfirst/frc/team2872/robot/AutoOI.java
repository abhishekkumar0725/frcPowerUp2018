package org.usfirst.frc.team2872.robot;

import edu.wpi.first.wpilibj.Timer;

public class AutoOI {
	
	char startPos;
		String input;
		char endPos;
		boolean scle;
	Center center;	
		Swtch swtch;
		Scale scale;
	Drive drive;
		Intake intake;
		Arm arm;
		Scissor scissor;		
		Timer timer = new Timer();
	
	private static AutoOI instance;
	public static AutoOI getInstance()
	{
		if (instance == null) {
			instance = new AutoOI();
		}
		return instance;
	}
	
	private AutoOI() {
		center = Center.getInstance();
			swtch = Swtch.getInstance();
			scale = Scale.getInstance();
		drive = Drive.getInstance();
		intake = Intake.getInstance();		
		arm = Arm.getInstance();
		scissor = Scissor.getInstance();
	}
	
	public void setTime() {
		timer.start();
	}
	
	public void runAuto(String start, String autoPos, boolean scl) {
		
		
		/**
		if(timer.get()<.4) {
			drive.setSpeed(-.75, .75);
		}
		**/
		startPos = start.charAt(0);
		input = autoPos.toUpperCase();
		scle = scl;
		
		drive.gearMode(true);
		intake.grabMode(true);
		
		if(!scle || startPos == 'C') {
			endPos = input.charAt(0);
		}
		else {
			endPos = input.charAt(1);
		}
		
		if(startPos == 'C') {
			center.autoCenter(endPos, 'R');
		}
		
		else if(scle) {
			if(startPos == 'L' && endPos == 'L') {
				scale.LL();
			}
			else if(startPos == 'L' && endPos == 'R') {
				scale.diff();
			}
			else if(startPos == 'R' && endPos == 'L') {
				scale.diff();
			}
			else if(startPos == 'R' && endPos == 'R') {
				scale.RR();
			}
		}
		
		else if(!scle) {
			if(startPos == 'L' && endPos == 'L') {
				swtch.LL();
			}
			else if(startPos == 'L' && endPos == 'R') {
				swtch.diff();
			}
			else if(startPos == 'R' && endPos == 'L') {
				swtch.diff();
			}
			else if(startPos == 'R' && endPos == 'R') {
				swtch.RR();
			}
		}
		
		
	}
	
}
