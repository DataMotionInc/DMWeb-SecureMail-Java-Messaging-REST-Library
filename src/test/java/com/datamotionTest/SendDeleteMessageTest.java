package com.datamotionTest;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import com.datamotion.Attachment;
import com.datamotion.DMWeb;
import com.datamotion.DeleteMessageResponse;
import com.datamotion.Message;
import com.fasterxml.jackson.core.JsonParseException;

public class SendDeleteMessageTest {

	@Test
	public void test() throws JsonParseException, InterruptedException {
		DMWeb tester = new DMWeb();
		tester.setStatusCode(-1);
		ArrayList<String> to = new ArrayList<String>();
		to.add("UnitTest1@dmfaketest.com");
		ArrayList<String> cc = new ArrayList<String>();
		ArrayList<String> bcc = new ArrayList<String>();
		ArrayList<Attachment> attachments = new ArrayList<Attachment>();
		Attachment attachment = new Attachment("dGhpcyBpcyBhIHRlc3QgZmlsZQ==", "text/plain", "test.txt");
		attachments.add(attachment);
		Message message = new Message(to, "UnitTest1@dmfaketest.com", cc, bcc, "TestSubject", "CreateTime", attachments, "content", "content");
		int messageId = tester.sendMessage(message, tester.getSessionKey()).getMessageId();
		assertNotNull(messageId);
		assertEquals(200, tester.getStatusCode());
		Thread.sleep(5000);
		tester.setStatusCode(-1);
		DeleteMessageResponse response = tester.deleteMessage(messageId, false);
		assertNotNull(response);
		assertEquals(200, tester.getStatusCode());
	}

}
