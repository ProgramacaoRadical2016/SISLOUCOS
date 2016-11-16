package br.com.sisclinic.utilitarios;

import java.security.MessageDigest;

public class SecurityUtil {

	public static String toMD5(String value) throws Exception {
		String pwdCrypt = null;
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(value.getBytes());
		pwdCrypt = bytesToHex(md.digest());
		return pwdCrypt;
	}
	
	
	private static String bytesToHex(byte[] text) {
		char[] hexOutput = new char[text.length * 2];
		String hexString;
		for (int i = 0; i < text.length; i++) {
			hexString = "00" + Integer.toHexString(text[i]);
			hexString.toUpperCase().getChars(hexString.length() - 2, hexString.length(), hexOutput, i * 2);
		}
		return new String(hexOutput);
	}
}
