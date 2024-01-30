package util;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import com.google.gson.Gson;

public class generate_header {

	String plaintext = "pandyapurvish1708@gmail.com";

	public String getEmail() {
		return plaintext;
	}

	public String run() {
		try {

			String secretKey = "ocfEiUstScNdg8X8";
			String ciphertext = encrypt(plaintext, secretKey);
			System.out.println("Encrypted Text: " + ciphertext);
			return ciphertext;
		} catch (Exception exp) {
			return "";
		}
	}

	public String encrypt(String plaintext, String keyi) {

		try {
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			SecretKeySpec key = new SecretKeySpec(keyi.getBytes(StandardCharsets.UTF_8), "AES");
			cipher.init(Cipher.ENCRYPT_MODE, key);
			byte[] encryptedBytes2 = cipher.doFinal(plaintext.getBytes(StandardCharsets.UTF_8));
			String res2 = Base64.getEncoder().encodeToString(encryptedBytes2);
			return res2;
		} catch (Exception exp) {
			return "";
		}
	}
}