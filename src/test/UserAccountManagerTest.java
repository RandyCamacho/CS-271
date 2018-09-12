package test;

import junit.framework.TestCase;

import login.UserAccountManager;

import login.UserAccount;

/**
 * Test UserAccountManager class.
 * @author quinnshultz
 */
public class UserAccountManagerTest extends TestCase {

	private UserAccountManager userAccountManager;
	
	private UserAccount userAccount;
	private UserAccount fakeAccount;
	
	/**
	 * Construct necessary accounts and account manager.
	 */
	protected void setUp() throws Exception {
		super.setUp();
		userAccountManager = new UserAccountManager();
		userAccount = new UserAccount("johndoe", "12345678", "johndoe@example.com");
		userAccount = new UserAccount("janedoe", "87654321", "janedoe@example.com");
		userAccountManager.add(userAccount);
	}

	/**
	 * Check if an existing account can be found in the manager.
	 */
	public void testExistingUserAccount() {
		assertTrue(userAccountManager.contains(userAccount));
	}

	/**
	 * Check that accounts that do not exist, are not reported by the manager.
	 */
	public void testNonExistantUserAccount() {
		assertFalse(userAccountManager.contains(fakeAccount));
	}
	
	// TODO: Add more test cases, only two unique methods are being tested.

}
