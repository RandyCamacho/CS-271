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

	/**
	 * Tests the validUsername() method.
	 */
	public void testValidUsername() {
		assertFalse(UserAccount.validUsername("qw"));
		assertFalse(UserAccount.validUsername("johnissuchanamazingbeastthisusernameistoolong"));
		assertTrue(UserAccount.validUsername("johndoe"));
	}
	
	// TODO: Test usernameExists()
//	public void testUserNameExists() {
//		assertTrue(UserAccount.usernameExists("johndoe"));
//	}
	
	/*
	 * Tests the validEmail() method.
	 */
	public void testValidEmail() {
		assertFalse(UserAccount.validEmail("notavalidemail"));
		assertTrue(UserAccount.validEmail("johndoe@example.com"));
	}
	
	// TODO: Test emailExists()
//	public void testEmailExists() {
//		assertTrue(UserAccount.emailExists("johndoe@example.com"));
//	}
	
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
		userAccount = new UserAccount("johndoe", "12345678", "johndoe@example.com");
		assertNotNull(userAccount);
		assertEquals(userAccount.getUsername(), "johndoe");
	}
	
	/**
	 * Tests the getPassword() method.
	 */
	public void testGetPassword() {
		userAccount = new UserAccount("johndoe", "12345678", "johndoe@example.com");
		assertNotNull(userAccount);
		assertEquals(userAccount.getPassword(), "12345678");
	}
	
	/**
	 * Tests the getEmail() method.
	 */
	public void testGetEmail() {
		userAccount = new UserAccount("johndoe", "12345678", "johndoe@example.com");
		assertNotNull(userAccount);
		assertEquals(userAccount.getEmail(), "johndoe@example.com");
	}
	
	// TODO: Test setters, also having trouble avoiding NullPointerException(s) here
	
	// TODO: Test authentication methods
}
