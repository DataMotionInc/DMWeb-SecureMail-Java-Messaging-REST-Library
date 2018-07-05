package com.mavenMessagingTest;

import static org.junit.Assert.*;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.mavenMessaging.MessagingAPI;
import com.mavenMessaging.Search;
import com.mavenMessaging.SearchResponse;

public class SearchInboxTest {

	@Test
	public void test() throws JsonParseException {
		MessagingAPI tester = new MessagingAPI();
		tester.setStatusCode(-1);
		Search search = new Search("account", 1, false, false, "", false, 1, 1);
		SearchResponse response = tester.searchInbox(tester.getSessionKey(), search);
		assertNotNull(response);
		assertEquals(200, tester.getStatusCode());
	}
}
