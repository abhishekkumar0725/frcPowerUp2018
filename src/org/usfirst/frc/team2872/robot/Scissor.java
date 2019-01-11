package org.usfirst.frc.team2872.robot;

	import com.ctre.phoenix.motorcontrol.can.TalonSRX;
	import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

	public class Scissor {
		WPI_TalonSRX scissorMaster;
		TalonSRX scissorSlave;
		
		private static Scissor instance = null;
		
		public static Scissor getInstance() {
			if (instance == null) {
				instance = new Scissor();
			}
			return instance;
		}
		
		private Scissor() {
			scissorMaster = new WPI_TalonSRX(5);
				scissorSlave = new TalonSRX(1);
			
			scissorSlave.follow(scissorMaster);	
		}
		
		public void setSpeed(double speed){
			scissorMaster.set(speed);
		}
	
}
