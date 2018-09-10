package login;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.io.Serializable;
import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
//
public class Password implements Serializable {
	private static final String ALGORITHM = "PBKDF2";
	private static final int S_BYTES = 32;
	private static final int H_BYTES = 32;
	private static final int INITIAL_ITERATIONS = 10000;

	private byte[] hash;
	private byte[] salt;
	private int iterations;

	public Password(String password) {
		SecureRandom random = new SecureRandom();
		byte[] salt = new byte[S_BYTES];
		random.nextBytes(salt);
//	Password thisPassword = new Password(password, salt, INITIAL_ITERATIONS);
//		this.hash = thisPassword.hash;
//		this.salt = thisPassword.salt;
//		this.iterations = thisPassword.iterations;
	}

	public Password(String password, Password setPassword) {
		this(password, setPassword.salt, setPassword.iterations);
	}

	@SuppressWarnings("")
	public Password(String password, byte[] salt, int iterations) {
		if(password == null) {
			throw new IllegalArgumentException("password must be non-null");
		}
		if(salt == null) {
			throw new IllegalArgumentException("salt must be non-null");
		}
		this.salt = salt;
		this.iterations = iterations;

		PBEKeySpec keySpec = new PBEKeySpec(password.toCharArray(), salt, iterations, H_BYTES);
		try {
			SecretKeyFactory skf = SecretKeyFactory.getInstance(ALGORITHM);
			this.hash = skf.generateSecret(keySpec).getEncoded();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			this.hash = password.getBytes();
		} catch (InvalidKeySpecException e) {
			e.printStackTrace();
			this.hash = password.getBytes();
		}
	}

	private static boolean equals(byte[] a, byte[] b) {
		int diff = a.length ^ b.length;
		for(int i = 0; i < a.length && i < b.length; i++) {
			diff |= a[i] ^ b[i];
		}
		return diff == 0;
	}

	public boolean checkPassword(String password) {
		return checkPassword(new Password(password, this.salt, this.iterations));
	}

	public boolean checkPassword(Password password) {
		return equals(this.hash, password.hash);
	}

	@Override
	public String toString() {
		return new BigInteger(hash).toString(16) + ':' + new BigInteger(salt).toString(16) + ':' + iterations;
	}
}
