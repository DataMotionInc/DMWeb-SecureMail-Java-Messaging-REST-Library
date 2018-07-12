package com.datamotionTest;

import static org.junit.Assert.*;

import org.junit.Test;

import com.datamotion.DMWeb;
import com.datamotion.Models.MessageSummariesGet;
import com.datamotion.Models.MessageSummariesResponse;
import com.fasterxml.jackson.core.JsonParseException;

public class GetUnreadMessagesTest {

	@Test
	public void test() throws JsonParseException {
		DMWeb tester = new DMWeb();
		tester.setStatusCode(-1);
		MessageSummariesResponse response = tester.getUnreadMessages(false, 0);
		assertNotNull(response);
		assertEquals(200, tester.getStatusCode());
	}

}
