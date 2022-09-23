package com.vti.utils;

import java.util.Scanner;

public class ScannerUtils {
	private static Scanner sc = new Scanner(System.in);

	public static int inputInt(String errorMessage) {
		while (true) {
			try {
				String iput = sc.nextLine();
				return Integer.valueOf(iput).intValue();
			} catch (NumberFormatException e) {
				System.out.println(errorMessage);
			}
		}
	}

	public static float inputFloat(String errorMessage) {
		while (true) {
			try {
				String iput = sc.nextLine();
				return Float.valueOf(iput).floatValue();
			} catch (NumberFormatException e) {
				System.out.println(errorMessage);
			}
		}
	}

	public static double inputDouble(String errorMessage) {
		while (true) {
			try {
				String iput = sc.nextLine();
				return Double.valueOf(iput).doubleValue();
			} catch (NumberFormatException e) {
				System.out.println(errorMessage);
			}
		}
	}

	public static String inputString() {
		return sc.nextLine();
	}
}
