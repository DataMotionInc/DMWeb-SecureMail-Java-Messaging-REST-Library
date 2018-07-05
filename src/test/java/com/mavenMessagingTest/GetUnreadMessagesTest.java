package com.mavenMessagingTest;

import static org.junit.Assert.*;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.mavenMessaging.MessageSummariesGet;
import com.mavenMessaging.MessageSummariesResponse;
import com.mavenMessaging.MessagingAPI;

public class GetUnreadMessagesTest {

	@Test
	public void test() throws JsonParseException {
		MessagingAPI tester = new MessagingAPI();
		tester.setStatusCode(-1);
		MessageSummariesResponse response = tester.getUnreadMessages(tester.getSessionKey(), false, 0);
		assertNotNull(response);
		assertEquals(200, tester.getStatusCode());
	}

}
