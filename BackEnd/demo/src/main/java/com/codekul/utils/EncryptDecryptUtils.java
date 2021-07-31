package com.codekul.utils;

import java.nio.charset.Charset;
import java.util.Base64;

import javax.annotation.PostConstruct;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.stereotype.Component;

@Component
public class EncryptDecryptUtils {

	private String TOKEN = "zQKNY5Qj6IaZjlCYcmvV66XTTLgbOcFd";	//encryption key
	private static String salt = "dGVzdFNhbHQhISE=";			//encrypts encrypted key
	private int pwdIterations = 65536;
	private int keySize = 256;
	byte ivBytes[] = new byte[16];
	private String keyAlgorithm = "AES";
	private String encryptAlgorithm = "AES/CBC/PKCS5Padding";
	private String secretKeyFactoryAlgorithm = "PBKDF2WithHmacSHA1";

	/** The cipher. */
	private Cipher encodecipher;

	/** The cipher. */
	private Cipher decodecipher;
	private SecretKeySpec sharedByteArray;
	
@PostConstruct
	public void generateSharedKey() {
		try {
			byte[] saltBytes = salt.getBytes(Charset.defaultCharset());
			this.encodecipher = Cipher.getInstance(encryptAlgorithm);
			this.decodecipher = Cipher.getInstance(encryptAlgorithm);

			SecretKeyFactory skf = SecretKeyFactory.getInstance(this.secretKeyFactoryAlgorithm);
			PBEKeySpec spec = new PBEKeySpec(TOKEN.toCharArray(), saltBytes, this.pwdIterations, this.keySize);
			SecretKey secretKey = skf.generateSecret(spec);
			this.sharedByteArray = new SecretKeySpec(secretKey.getEncoded(), keyAlgorithm);
			this.encodecipher.init(Cipher.ENCRYPT_MODE, sharedByteArray, new IvParameterSpec(ivBytes));
			this.decodecipher.init(Cipher.DECRYPT_MODE, sharedByteArray, new IvParameterSpec(ivBytes));
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	/**
	 * 
	 * @param plainText
	 * @return encrypted text
	 * @throws Exception
	 */

	public String encrypt(String plainText) {
		String encryptedText = null;

		try {
			byte[] plainTextByte = plainText.getBytes();
			byte[] encryptedByte = encodecipher.doFinal(plainTextByte);
			Base64.Encoder encoder = Base64.getUrlEncoder();
			encryptedText = encoder.encodeToString(encryptedByte);
		} 
		catch (Exception ex) 
		{
			ex.printStackTrace();
		}
		return encryptedText;
	}

	/**
	 * 
	 * @param encryptText
	 * @return decrypted text
	 * @throws Exception
	 */

	public String decrypt(String encryptedText) {
		String decryptedText = null;
		try {
			Base64.Decoder decoder = Base64.getUrlDecoder();
			byte[] encryptedTextByte = decoder.decode(encryptedText);
			byte[] decryptedByte = this.decodecipher.doFinal(encryptedTextByte);
			decryptedText = new String(decryptedByte);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return decryptedText;
	}


	    public static void main(String args []) throws Exception
	    {
	    	
	    	EncryptDecryptUtils td= new EncryptDecryptUtils();
	    	td.generateSharedKey();
	    	
	        String target="manager";
	        String encrypted=td.encrypt(target);
	        String decrypted=td.decrypt(encrypted);

	        System.out.println("String To Encrypt: "+ target);
	        System.out.println("Encrypted String:" + encrypted);
	        System.out.println("Decrypted String:" + decrypted);

	    }
}
