package com.datamotionTest;

import static org.junit.Assert.*;

import org.junit.Test;

import com.datamotion.DMWeb;
import com.datamotion.Search;
import com.datamotion.SearchResponse;
import com.fasterxml.jackson.core.JsonParseException;

public class SearchInboxTest {

	@Test
	public void test() throws JsonParseException {
		DMWeb tester = new DMWeb();
		tester.setStatusCode(-1);
		Search search = new Search("account", 1, false, false, "", false, 1, 1);
		SearchResponse response = tester.searchInbox(search);
		assertNotNull(response);
		assertEquals(200, tester.getStatusCode());
	}
}
