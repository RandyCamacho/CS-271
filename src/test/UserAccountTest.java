package test;

import junit.framework.TestCase;

import login.UserAccount;
import login.UserAccountManager;

/**
 * Test UserAccount class.
 * @author quinnshultz
 */
public class UserAccountTest extends TestCase {

	private UserAccount userAccount;
	private UserAccountManager userAccountManager;

	
	/*
	 * Construct example user account.
	 */
	protected void setUp() throws Exception {
		super.setUp();
		userAccount = new UserAccount("johndoe", "12345678", "johndoe@example.com");
		userAccountManager = new UserAccountManager();
		userAccountManager.add(userAccount);
	}
	
	/**
	 * Tests the creation of a new account.
	 */
	public void testNewAccount() {
		assertNotNull(userAccount);
		assertTrue(userAccount.matchUserName("johndoe"));
		assertTrue(userAccount.isValidCredential("johndoe", "12345678"));
	}

	/**
	 * Tests the validUsername() method.
	 */
	public void testValidUsername() {
		assertFalse(UserAccount.validUsername("qw"));
		assertFalse(UserAccount.validUsername("johnissuchanamazingbeastthisusernameistoolong"));
		assertTrue(UserAccount.validUsername("johndoe"));
	}
	
	/*
	 * Tests the userNameExists() method.
	 */
	public void testUserNameExists() {
		assertTrue(UserAccount.usernameExists("johndoe"));
	}
	
	/*
	 * Tests the validEmail() method.
	 */
	public void testValidEmail() {
		assertFalse(UserAccount.validEmail("notavalidemail"));
		assertTrue(UserAccount.validEmail("johndoe@example.com"));
	}
	
	// TODO: Test emailExists()
	public void testEmailExists() {
		assertTrue(UserAccount.emailExists("johndoe@example.com"));
	}
	
	/**
	 * Tests the validatePassword() method.
	 */
	public void testValidPassword() {
		assertFalse(UserAccount.validatePassword("1234"));
		assertFalse(UserAccount.validatePassword("evPz^]SXF)\\f4.=N_E7:f=T87Zb}U>V>T=URpa>j(n8%rd$V{w^M7d/QdA/-Qq>8hTHJ)RKDJv.wm>bA(Lz,Le>[VDP<taA-%(*/]qZMn<ZgmF<NBKN%+hFQdVbHva=[1"));
		assertTrue(UserAccount.validatePassword("12345678"));
	}
	
	/**
	 * Tests the getUsername() method.
	 */
	public void testGetUsername() {
		assertNotNull(userAccount);
		assertEquals(userAccount.getUsername(), "johndoe");
	}
	
	/**
	 * Tests the getPassword() method.
	 */
	public void testGetPassword() {
		assertNotNull(userAccount);
		assertEquals(userAccount.getPassword(), "12345678");
	}
	
	/**
	 * Tests the getEmail() method.
	 */
	public void testGetEmail() {
		assertNotNull(userAccount);
		assertEquals(userAccount.getEmail(), "johndoe@example.com");
	}
	
	// TODO: Test setters, also having trouble avoiding NullPointerException(s) here
	
	/**
	 * Tests the setEmail() method.
	 */
	public void testSetEmail() {
		assertNotNull(userAccount);
		assertTrue(userAccount.setEmail("johndoe@boisestate.edu"));
		assertEquals(userAccount.getEmail(), "johndoe@boisestate.edu");
	}
	
	/**
	 * Tests the setUsername() method.
	 */
	public void testSetUsername() {
		assertNotNull(userAccount);
		userAccount.setUsername("janedoe");
		assertEquals(userAccount.getUsername(), "janedoe");
	}
	
	/**
	 * Tests the setPassword() method.
	 */
	public void testSetPassword() {
		assertNotNull(userAccount);
		userAccount.setPassword("87654321");
		assertEquals(userAccount.getPassword(), "87654321");
	}
	
	// TODO: Test authentication methods
	
	/**
	 * Tests isValidCredential() method, and by reference: matchUserName()
	 * and matchPassword()
	 */
	public void testIsValidCredential() {
		assertNotNull(userAccount);
		assertTrue(userAccount.isValidCredential("johndoe", "12345678"));
	}
}
