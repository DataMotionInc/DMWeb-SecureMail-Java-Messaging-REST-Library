package com.datamotionTest.Tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import com.datamotion.DMWeb;
import com.datamotion.Models.Attachment;
import com.datamotion.Models.DeleteMessageResponse;
import com.datamotion.Models.Message;
import com.datamotion.Models.MoveMessage;
import com.fasterxml.jackson.core.JsonParseException;

public class MoveMessageTest {

	@Test
	public void test() throws InterruptedException, JsonParseException {
		DMWeb tester = new DMWeb();
		tester.setStatusCode(-1);
		MoveMessage moveMessage = new MoveMessage(140);
		ArrayList<String> to = new ArrayList<String>();
		to.add("UnitTest1@dmfaketest.com");
		ArrayList<String> cc = new ArrayList<String>();
		ArrayList<String> bcc = new ArrayList<String>();
		ArrayList<Attachment> attachments = new ArrayList<Attachment>();
		Attachment attachment = new Attachment("dGhpcyBpcyBhIHRlc3QgZmlsZQ==", "text/plain", "test.txt");
		attachments.add(attachment);
		Message message = new Message(to, "UnitTest1@dmfaketest.com", cc, bcc, "TestSubject", "CreateTime", attachments, "content", "content");
		int messageId = tester.sendMessage(message).getMessageId();
		tester.moveMessage(moveMessage, messageId);
		assertEquals(200, tester.getStatusCode());
		Thread.sleep(3000);
		moveMessage.setDestinationFolderId(1);
		tester.moveMessage(moveMessage, messageId);
		assertEquals(200, tester.getStatusCode());
		DeleteMessageResponse response = tester.deleteMessage(messageId, false);
	}

}
