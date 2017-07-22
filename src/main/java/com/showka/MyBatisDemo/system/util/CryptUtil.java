package com.showka.MyBatisDemo.system.util;

public class CryptUtil {

	private static String dummy = "CCC";

	public static String encrypt(String target) {
		return dummy + target;
	}

	public static String decrypt(String encrypted) {
		return encrypted.replaceAll("^" + dummy, "");
	}

}
