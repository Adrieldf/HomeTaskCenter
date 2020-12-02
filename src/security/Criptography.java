package security;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

public class Criptography {

	public static byte[] Encode(String value) {
		try {
			KeyGenerator keygenerator = KeyGenerator.getInstance("DES");
			SecretKey keyDES = keygenerator.generateKey();
			Cipher cipherDES;

			cipherDES = Cipher.getInstance("DES/ECB/PKCS5Padding");
			cipherDES.init(Cipher.ENCRYPT_MODE, keyDES);

			return cipherDES.doFinal(value.getBytes());

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		}

		return null;
	}

	public static String Decode(byte[] value) {
		try {
			KeyGenerator keygenerator = KeyGenerator.getInstance("DES");
			SecretKey keyDES = keygenerator.generateKey();
			Cipher cipherDES;

			cipherDES = Cipher.getInstance("DES/ECB/PKCS5Padding");
			cipherDES.init(Cipher.DECRYPT_MODE, keyDES);

			return new String(cipherDES.doFinal(value));

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		}

		return null;
	}

}
