package com.datamotionTest.Tests;

import org.junit.Test;

import static org.junit.Assert.*;

import com.datamotion.DMWeb;
import com.datamotion.Models.MessageIdGet;
import com.datamotion.Models.MessageIds;
import com.fasterxml.jackson.core.JsonParseException;

public class GetInboxMessageIdsTest {

	@Test
	public void test() throws JsonParseException {
		DMWeb tester = new DMWeb();
		tester.setStatusCode(-1);
		MessageIdGet messageIdGet = new MessageIdGet(1, 0, false);
		MessageIds messageIds = tester.getInboxMessageIds(messageIdGet);
		assertNotNull(messageIds);
		assertEquals(200, tester.getStatusCode());
	}
}
