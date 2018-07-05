package com.mavenMessagingTest;

import static org.junit.Assert.*;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.mavenMessaging.Folders;
import com.mavenMessaging.MessagingAPI;

public class ListAllFoldersTest {

	@Test
	public void test() throws JsonParseException {
		MessagingAPI tester = new MessagingAPI();
		tester.setStatusCode(-1);
		Folders folders = tester.listAllFolders(tester.getSessionKey());
		assertNotNull(folders);
		assertEquals(200, tester.getStatusCode());
	}
}
