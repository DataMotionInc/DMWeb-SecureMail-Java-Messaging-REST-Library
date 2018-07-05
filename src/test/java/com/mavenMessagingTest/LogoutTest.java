package com.mavenMessagingTest;

import static org.junit.Assert.*;

import org.junit.Test;

import com.mavenMessaging.MessagingAPI;

public class LogoutTest {

	@Test
	public void test() {
		MessagingAPI tester = new MessagingAPI();
		tester.setStatusCode(-1);
		tester.logout(tester.getSessionKey());
		assertEquals(200, tester.getStatusCode());
	}

}
