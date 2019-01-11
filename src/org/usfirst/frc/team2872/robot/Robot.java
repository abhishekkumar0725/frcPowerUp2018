package org.usfirst.frc.team2872.robot;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;


public class Robot extends IterativeRobot {
	
	OI oi;
		AutoOI auto;
	
	String autoPosition;
		String start;
		boolean scle;
	
	Center center; 
		Scale scale;
		Swtch swtch;
		Intake intake;	
		Drive drive;
		Timer timer;
	public void robotInit() {
		oi = OI.getInstance();
			auto = AutoOI.getInstance();
			intake = Intake.getInstance();
		center = Center.getInstance();
			scale = Scale.getInstance();
			swtch = Swtch.getInstance();
		drive = Drive.getInstance();
			timer = new Timer();
	}
	
	public void autonomousInit() {
		autoPosition =  DriverStation.getInstance().getGameSpecificMessage();
			autoPosition = autoPosition.toUpperCase();
		start = "C";
			scle = false;
		center.setTime();
			scale.setTime();
			swtch.setTime();
			//auto.setTime();
		timer.start();
		timer.reset();
	}

	public void autonomousPeriodic() {
		auto.runAuto(start, autoPosition, scle);
	}
	
	public void teleopInit() {
		drive.gearMode(true);
	}
	
	public void teleopPeriodic() {
		oi.processInput();
	}
}
