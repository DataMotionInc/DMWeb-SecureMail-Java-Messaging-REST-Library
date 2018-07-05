package com.mavenMessagingTest;

import static org.junit.Assert.*;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.mavenMessaging.MessagingAPI;
import com.mavenMessaging.MetaData;

public class GetMessageMetadataTest {

	@Test
	public void test() throws JsonParseException {
		MessagingAPI tester = new MessagingAPI();
		tester.setStatusCode(-1);
		MetaData metadata = tester.getMessageMetadata(tester.getSessionKey(), 448);
		assertNotNull(metadata);
		assertEquals(200, tester.getStatusCode());
	}
}
