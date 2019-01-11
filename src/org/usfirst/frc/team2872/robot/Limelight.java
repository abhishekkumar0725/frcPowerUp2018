package org.usfirst.frc.team2872.robot;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

public class Limelight {
	private static NetworkTableInstance table = null;
	
	
	
	//Light modes
	public static enum LightMode {
		eOn, eOff, eBlink
	}

	//Camera modes
	public static enum CameraMode {
		eVision, eDriver
	}

	//tv
	public static boolean isTarget() {
		return getValue("tv").getDouble(0) == 1;
	}

	//tx
	public static double getTx() {
		return getValue("tx").getDouble(0.00);
	}

	//ty
	public static double getTy() {
		return getValue("ty").getDouble(0.00);
	}

	//ta
	public static double getTa() {
		return getValue("ta").getDouble(0.00);
	}

	//ts
	public static double getTs() {
		return getValue("ts").getDouble(0.00);
	}

	//tl
	public static double getTl() {
		return getValue("tl").getDouble(0.00);
	}

	//sets ledMode
	public static void setLedMode(LightMode mode) {
		getValue("ledMode").setNumber(mode.ordinal());
	}

	//sets cameraMode
	public static void setCameraMode(CameraMode mode) {
		getValue("camMode").setNumber(mode.ordinal());
	}

	//sets pipeline number
	public static void setPipeline(int number) {
		getValue("pipeline").setNumber(number);
	}

	private static NetworkTableEntry getValue(String key) {
		if (table == null) {
			table = NetworkTableInstance.getDefault();
		}

		return table.getTable("limelight").getEntry(key);
	}
}