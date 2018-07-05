package com.mavenMessagingTest;

import static org.junit.Assert.*;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.mavenMessaging.Message;
import com.mavenMessaging.MessagingAPI;

public class GetMessageTest {

	@Test
	public void test() throws JsonParseException {
		MessagingAPI tester = new MessagingAPI();
		tester.setStatusCode(-1);
		Message message = tester.getMessage(tester.getSessionKey(), 448);
		assertNotNull(message);
		assertEquals(200, tester.getStatusCode());
	}
}
