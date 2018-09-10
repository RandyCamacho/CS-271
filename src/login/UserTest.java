package login;

public class UserTest {
	public static void main(String[] args) {
		int testNum = 1;
		try {
			UserAccount test = new UserAccount("Username", "password", "email@account.com");
			
			//Test username
			System.out.println("TEST 1: Username ");
			if(!testValidateUsername("testUsername")) {
				System.out.println("TEST 1: FAIL");
			} else {
				System.out.println("TEST 1: PASS");
			}
			testNum++;
			
			//Testing valid password validation
			System.out.println("TEST 2: Password (Valid)");
			if(!testValidatePassword("testPassword")) {
				System.out.println("TEST 2: FAIL");
			} else {
				System.out.println("TEST 2: PASS");
			}
			testNum++;
			
			//Testing invalid password validation
			System.out.println("TEST 3: Password (Invalid)");
			if(testValidatePassword("bad")) {
				System.out.println("TEST 3: FAIL");
			} else {
				System.out.println("TEST 3: PASS");
			}
			testNum++;
			
			//Testing get username
			System.out.println("TEST 4: Get Username");
			testGetUsername(test);
			System.out.println("TEST 4: PASS");
			testNum++;
			
			//Testing get password
			System.out.println("TEST 5: Get Password");
			testGetPassword(test);
			System.out.println("TEST 5: PASS");
			testNum++;
			
			//Testing get email
			System.out.println("TEST 6: Get email");
			testGetEmail(test);
			System.out.println("TEST 6: PASS");
			testNum++;
			
			//Testing set username
			System.out.println("TEST 7: Set username");
			testSetUsername(test, "newUsername");
			if(!test.getUsername().equals("newUsername")) {
				System.out.println("TEST 7: FAIL");
			} else {
				System.out.println("TEST 7: PASS");
			}
			testNum++;
			
			//Testing set password
			System.out.println("TEST 8: Set password");
			testSetPassword(test, "newPassword");
			if(!test.getPassword().checkPassword("newPassword")) {
				System.out.println("TEST 8: FAIL");
			} else {
				System.out.println("TEST 8: PASS");
			}
			testNum++;
			
			//Testing set email
			System.out.println("TEST 9: Set email");
			testSetEmail(test, "newEmail@something.com");
			if(!test.getEmail().equals("newEmail@something.com")) {
				System.out.println("TEST 9: FAIL");
			} else {
				System.out.println("TEST 9: PASS");
			}
		}
		catch (Exception e) {
			System.out.println("TEST " + testNum + ": FAIL");
		}
		
	}
	
	public static boolean testValidateUsername(String username) {
		return UserAccount.validUsername(username);
	}
	
	public static boolean testValidatePassword(String password) {
		return UserAccount.validatePassword(password);
	}
	
	public static String testGetUsername(UserAccount test) {
		return test.getUsername();
	}
	
	public static Password testGetPassword(UserAccount test) {
		return test.getPassword();
	}
	
	public static String testGetEmail(UserAccount test) {
		return test.getEmail();
	}
	
	public static void testSetUsername(UserAccount test, String username) {
		test.setUsername(username);
	}
	
	public static void testSetPassword(UserAccount test, String password) {
		test.setPassword(password);
	}
	
	public static void testSetEmail(UserAccount test, String email) {
		test.setEmail(email);
	}
}
