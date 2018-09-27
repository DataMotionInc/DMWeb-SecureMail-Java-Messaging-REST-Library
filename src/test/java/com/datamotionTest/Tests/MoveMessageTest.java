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
	public void test() throws Exception {
		try {
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
			int messageId = tester.Message.sendMessage(message).getMessageId();
			Thread.sleep(5000);
			tester.Message.moveMessage(moveMessage, messageId);
			assertEquals(200, tester.getStatusCode());
			Thread.sleep(3000);
			moveMessage.setDestinationFolderId(1);
			tester.Message.moveMessage(moveMessage, messageId);
			assertEquals(200, tester.getStatusCode());
			Thread.sleep(5000);
			DeleteMessageResponse response = tester.Message.deleteMessage(messageId, false);

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

}
