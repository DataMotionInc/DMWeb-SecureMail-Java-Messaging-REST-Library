package com.mavenMessagingTest;

import org.junit.Test;

import static org.junit.Assert.*;

import com.fasterxml.jackson.core.JsonParseException;
import com.mavenMessaging.MessageIDget;
import com.mavenMessaging.MessageIds;
import com.mavenMessaging.MessagingAPI;

public class GetInboxMessageIdsTest {

	@Test
	public void test() throws JsonParseException {
		MessagingAPI tester = new MessagingAPI();
		tester.setStatusCode(-1);
		MessageIDget messageIdGet = new MessageIDget(1, 0, false);
		MessageIds messageIds = tester.getInboxMessageIds(tester.getSessionKey(), messageIdGet);
		assertNotNull(messageIds);
		assertEquals(200, tester.getStatusCode());
	}
}
