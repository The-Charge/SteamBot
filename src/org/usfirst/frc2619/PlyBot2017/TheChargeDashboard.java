package org.usfirst.frc2619.PlyBot2017;

import edu.wpi.first.wpilibj.NamedSendable;
import edu.wpi.first.wpilibj.Sendable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class TheChargeDashboard {

	private static String[] whiteList = {
			
			};

	public static void putNumber(String key, double value) {
		for (int x = 0; x < whiteList.length; x++) {
			if (key.equals(whiteList[x])) {
				SmartDashboard.putNumber(key, value);
			}
		}
	}

	public static void putBoolean(String key, boolean value) {
		for (int x = 0; x < whiteList.length; x++) {
			if (key.equals(whiteList[x])) {
				SmartDashboard.putBoolean(key, value);
			}
		}
	}

	public static void putString(String key, String value) {
		for (int x = 0; x < whiteList.length; x++) {
			if (key.equals(whiteList[x])) {
				SmartDashboard.putString(key, value);
			}
		}
	}
	
	public static void putData(String key, Sendable value) {
		for (int x = 0; x < whiteList.length; x++) {
			if (key.equals(whiteList[x])) {
				SmartDashboard.putData(key, value);
			}
		}
	}
	
	public static void putData(NamedSendable value) {
		for (int x = 0; x < whiteList.length; x++) {
			if (value.getName().equals(whiteList[x])) {
				SmartDashboard.putData(value);
			}
		}
	}
}
