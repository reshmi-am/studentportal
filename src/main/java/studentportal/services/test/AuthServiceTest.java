package studentportal.services.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import studentportal.model.UserInfo;
import studentportal.services.AuthService;

public class AuthServiceTest {

	AuthService authService = new AuthService();
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetUserForNullValuesReturnsNull() {
		assertNull(authService.getUserInfo(null, null));
	}

	@Test
	public void testGetUserValidCrendentialsReturnsUserObject() {
		assertEquals(authService.getUserInfo("test@gmail.com", "secret").getClass() , new UserInfo().getClass());
	}
	
}
