package login;

import java.io.Serializable;
import java.util.regex.Pattern;

public class UserAccount implements Serializable{
	private String userName;
	private String password;
	private String email;

	public UserAccount(String username, String password, String email) {
		this.userName = username;
		this.password = password;
		this.email = email;
	}

	public static boolean validUsername(String username) {
		return username.length() >= 3 || username.length() <= 16;
	}

	public static boolean usernameExists(String username) {
		boolean usernameExists = false;
		for(UserAccount userAccount: UserAccountManager.accountManager) {
			usernameExists |= userAccount.userName.equals(username);
		}
		return usernameExists;
	}

	public static boolean validEmail(String email) {
		return Pattern.matches("^[A-z0-9._%+-]+@[A-z0-9.-]+\\.[A-z]{2,6}$", email);
	}

	public static boolean emailExists(String email) {
		boolean emailExists = false;
		for(UserAccount userAccount: UserAccountManager.accountManager) {
			emailExists |= userAccount.email.equals(email);
		}
		return emailExists;
	}

	public static boolean validatePassword(String password) {
		return password.length() >= 8 && password.length() <= 128;
	}

	public String getUsername() {
		return userName;
	}

	public String getPassword() {
		return password;
	}

	public String getEmail() {
		return email;
	}

	public boolean setEmail(String email) {
		this.email = email;
		return true;
	}

	public boolean setUsername(String username) {
		if(!validUsername(username)) {
			return false;
		}
		this.userName = username;
		return true;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
