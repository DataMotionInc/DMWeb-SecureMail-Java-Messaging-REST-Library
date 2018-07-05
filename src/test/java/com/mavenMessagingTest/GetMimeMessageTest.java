package com.mavenMessagingTest;

import static org.junit.Assert.*;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.mavenMessaging.MessagingAPI;
import com.mavenMessaging.MimeMessage;

public class GetMimeMessageTest {

	@Test
	public void test() throws JsonParseException {
		MessagingAPI tester = new MessagingAPI();
		tester.setStatusCode(-1);
		MimeMessage mimeMessage = tester.getMimeMessage(tester.getSessionKey(), 448);
		assertNotNull(mimeMessage);
		assertEquals(200, tester.getStatusCode());
	}

}
