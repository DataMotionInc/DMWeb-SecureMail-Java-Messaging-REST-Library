package com.datamotionTest.Tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import com.datamotion.DMWeb;
import com.datamotion.Models.Attachment;
import com.datamotion.Models.DeleteMessageResponse;
import com.datamotion.Models.Message;
import com.datamotion.Models.MetaData;
import com.fasterxml.jackson.core.JsonParseException;

public class GetMessageMetadataTest {

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
		MetaData metadata = tester.getMessageMetadata(messageId);
		assertNotNull(metadata);
		assertEquals(200, tester.getStatusCode());
		DeleteMessageResponse response = tester.deleteMessage(messageId, false);

	}
}
