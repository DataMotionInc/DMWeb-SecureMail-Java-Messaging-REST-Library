package com.mavenMessagingTest;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import com.mavenMessaging.MessagingAPI;
import com.mavenMessaging.Message;
import com.fasterxml.jackson.core.JsonParseException;
import com.mavenMessaging.Attachment;
import com.mavenMessaging.DeleteMessageResponse;

public class SendDeleteMessageTest {

	@Test
	public void test() throws JsonParseException, InterruptedException {
		MessagingAPI tester = new MessagingAPI();
		tester.setStatusCode(-1);
		ArrayList<String> to = new ArrayList<String>();
		to.add("UnitTest1@dmfaketest.com");
		ArrayList<String> cc = new ArrayList<String>();
		ArrayList<String> bcc = new ArrayList<String>();
		ArrayList<Attachment> attachments = new ArrayList<Attachment>();
		Attachment attachment = new Attachment("", "", "");
		attachments.add(attachment);
		Message message = new Message(to, "UnitTest1@dmfaketest.com", cc, bcc, "TestSubject", "CreateTime", attachments, "content", "content");
		int messageId = tester.sendMessage(message, tester.getSessionKey()).getMessageId();
		assertNotNull(messageId);
		assertEquals(200, tester.getStatusCode());
		Thread.sleep(5000);
		tester.setStatusCode(-1);
		DeleteMessageResponse response = tester.deleteMessage(tester.getSessionKey(), messageId, false);
		assertNotNull(response);
		assertEquals(200, tester.getStatusCode());
	}

}
