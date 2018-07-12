package com.datamotionTest;

import static org.junit.Assert.*;

import org.junit.Test;

import com.datamotion.DMWeb;
import com.datamotion.Models.MoveMessage;

public class MoveMessageTest {

	@Test
	public void test() throws InterruptedException {
		DMWeb tester = new DMWeb();
		tester.setStatusCode(-1);
		MoveMessage moveMessage = new MoveMessage(140);
		tester.moveMessage(moveMessage, 448);
		assertEquals(200, tester.getStatusCode());
		Thread.sleep(3000);
		moveMessage.setDestinationFolderId(1);
		tester.moveMessage(moveMessage, 448);
		assertEquals(200, tester.getStatusCode());
	}

}
