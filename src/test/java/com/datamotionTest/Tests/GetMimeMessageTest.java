package com.datamotionTest.Tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import com.datamotion.DMWeb;
import com.datamotion.Models.Attachment;
import com.datamotion.Models.DeleteMessageResponse;
import com.datamotion.Models.Message;
import com.datamotion.Models.MimeMessage;
import com.fasterxml.jackson.core.JsonParseException;

public class GetMimeMessageTest {

	@Test
	public void test() throws JsonParseException {
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
		int messageId = tester.sendMessage(message).getMessageId();
		MimeMessage mimeMessage = tester.getMimeMessage(messageId);
		assertNotNull(mimeMessage);
		assertEquals(200, tester.getStatusCode());
		DeleteMessageResponse response = tester.deleteMessage(messageId, false);
	}

}
