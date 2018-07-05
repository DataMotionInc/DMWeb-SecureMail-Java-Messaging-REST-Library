package com.mavenMessagingTest;

import static org.junit.Assert.*;

import org.junit.Test;

import com.mavenMessaging.MessagingAPI;
import com.mavenMessaging.MoveMessage;

public class MoveMessageTest {

	@Test
	public void test() throws InterruptedException {
		MessagingAPI tester = new MessagingAPI();
		tester.setStatusCode(-1);
		MoveMessage moveMessage = new MoveMessage(140);
		tester.moveMessage(moveMessage, tester.getSessionKey(), 448);
		assertEquals(200, tester.getStatusCode());
		Thread.sleep(3000);
		moveMessage.setDestinationFolderId(1);
		tester.moveMessage(moveMessage, tester.getSessionKey(), 448);
		assertEquals(200, tester.getStatusCode());
	}

}
