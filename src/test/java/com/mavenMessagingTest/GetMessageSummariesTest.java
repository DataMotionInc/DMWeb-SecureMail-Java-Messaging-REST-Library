package com.mavenMessagingTest;

import static org.junit.Assert.*;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.mavenMessaging.MessageSummariesGet;
import com.mavenMessaging.MessageSummariesResponse;
import com.mavenMessaging.MessagingAPI;

public class GetMessageSummariesTest {

	@Test
	public void test() throws JsonParseException {
	MessagingAPI tester = new MessagingAPI();
	tester.setStatusCode(-1);
	MessageSummariesGet getSummaries = new MessageSummariesGet(1, 0);
	MessageSummariesResponse response = tester.getMessageSummaries(tester.getSessionKey(), getSummaries);
	assertNotNull(response);
	assertEquals(200, tester.getStatusCode());
	}
}
