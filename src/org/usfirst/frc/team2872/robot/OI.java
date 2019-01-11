package org.usfirst.frc.team2872.robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Sendable;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class OI {

	Joystick XBOX;
	Joystick XBOX2;
	
	Drive drive;
		Intake intake;
		Scissor scissor;
		Arm arm;
	LiveWindow lw = new LiveWindow();
	
	String gear, grab;
	
	boolean grabToggle = false;
	boolean rAxisState = false;
	boolean speed = false;
		double slow = 1.0;
	boolean in = false;
	boolean gearToggle = false;
	boolean aState = false;
	boolean xState = false;
	public static OI instance;
	private OI()
	{
		XBOX = new Joystick(0);
		XBOX2 = new Joystick(1);

		drive = Drive.getInstance();
		intake = Intake.getInstance();
		scissor = Scissor.getInstance();
		arm = Arm.getInstance();
		
	}
	
	public static OI getInstance()
	{
		if (instance == null) {
			instance = new OI();
		}
		return instance;
	}
	
	public void processInput()
	{
		double leftX = XBOX.getRawAxis(0), leftY = -1.0*XBOX.getRawAxis(1);
		double lTrig = XBOX.getRawAxis(2), rTrig = XBOX.getRawAxis(3);
		double rightY = -1.0*XBOX.getRawAxis(5); double rightX = XBOX.getRawAxis(4);
		boolean rightB = XBOX.getRawButton(6), leftB = XBOX.getRawButton(5);
		boolean rightAxis = XBOX.getRawButton(10);
		boolean a = XBOX.getRawButton(1), x = XBOX.getRawButton(3);		
		double lTrig2 = XBOX2.getRawAxis(2), rTrig2 = XBOX2.getRawAxis(3);
		boolean leftB2 = XBOX2.getRawButton(5), rightB2 = XBOX2.getRawButton(6);
		boolean a2 = XBOX2.getRawButton(1), x2 = XBOX2.getRawButton(3);
		
		drive.setSpeed(leftY*slow, rightY*slow);
		//drive.arcade(rightY, rightX);
		
		if(leftB) {
			scissor.setSpeed(-1.0);
		}
		else if(rightB) {
			scissor.setSpeed(1.0);
		}
		else {
			scissor.setSpeed(0);
		}
		
		if(rTrig > .2 && lTrig < .2) {
			arm.setSpeed(.75*rTrig);		
		}
		else if(lTrig > .2 && rTrig < .2) {
			arm.setSpeed(lTrig*-.75);		
		}
		else {
			arm.setSpeed(0.0);
		}
		
		if(rightAxis != rAxisState && rightAxis) {
			intake.grabMode(grabToggle);
			grabToggle = !grabToggle;
		}		
		
		if(a) {
			intake.setSpeed(-0.85);
		}
		else if(x) {
			intake.setSpeed(-.5);
		}
		else if(rTrig2 > .2 || lTrig2 > .2) {
			intake.setRightSpeed(rTrig2);
			intake.setLeftSpeed(lTrig2);
		}
		else if(leftB2) {
			intake.setLeftSpeed(1.0);
			intake.setRightSpeed(0.5);
		}
		else if(rightB2) {
			intake.setRightSpeed(1.0);
			intake.setLeftSpeed(0.5);
		}
		else {
			intake.setSpeed(0);
		}
		
		if(a2 != aState && a2) {
			drive.gearMode(gearToggle);
			gearToggle = !gearToggle;
		}
		
		gear = gearToggle? "Low" : "High";
		grab = grabToggle? "Close" : "Open";
		
		SmartDashboard.putString("Grabber", gear);
		SmartDashboard.putString("Dog Gear", grab);
		
		rAxisState = rightAxis;
		aState = a2;
		xState = x2;

	}

}
