package com.mavenMessagingTest;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import com.mavenMessaging.Details;
import com.mavenMessaging.MessagingAPI;

public class GetAccountDetailsTest {

	@Test
	public void test() throws IOException {
		MessagingAPI tester = new MessagingAPI();
		tester.setStatusCode(-1);
		Details details = tester.getAccountDetails(tester.getSessionKey());
		assertNotNull(details);
		assertEquals(200, tester.getStatusCode());
	}

}
