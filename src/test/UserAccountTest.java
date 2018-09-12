package test;

import junit.framework.TestCase;

import login.UserAccount;

/**
 * Test UserAccount class.
 * @author quinnshultz
 */
public class UserAccountTest extends TestCase {

	private UserAccount userAccount;
	
	/**
	 * Tests the creation of a new account.
	 */
	public void testNewAccount() {
		userAccount = new UserAccount("johndoe", "12345678", "johndoe@example.com");
		assertNotNull(userAccount);
		assertTrue(userAccount.matchUserName("johndoe"));
		assertTrue(userAccount.isValidCredential("johndoe", "12345678"));
	}

	// TODO: Add more test cases, only two unique methods are being tested.
}
