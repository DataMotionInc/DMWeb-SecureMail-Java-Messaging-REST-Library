package com.datamotionTest.Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.datamotion.DMWeb;
import com.datamotion.Models.MessageSummariesGet;
import com.datamotion.Models.MessageSummariesResponse;
import com.fasterxml.jackson.core.JsonParseException;

public class GetMessageSummariesTest {

	@Test
	public void test() throws JsonParseException {
	DMWeb tester = new DMWeb();
	tester.setStatusCode(-1);
	MessageSummariesGet getSummaries = new MessageSummariesGet(1, 0);
	MessageSummariesResponse response = tester.getMessageSummaries(getSummaries);
	assertNotNull(response);
	assertEquals(200, tester.getStatusCode());
	}
}
