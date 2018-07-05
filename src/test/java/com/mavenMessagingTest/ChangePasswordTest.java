package com.mavenMessagingTest;

import static org.junit.Assert.*;

import org.junit.Test;

import com.mavenMessaging.MessagingAPI;

public class ChangePasswordTest {

	@Test
	public void test() {
		MessagingAPI tester = new MessagingAPI();
		tester.setStatusCode(-1);
		tester.changePassword(tester.getSessionKey(), "CURRENTPASSWORD", "NEWPASSWORD");
		assertEquals(200, MessagingAPI.getStatusCode());
	}

}
