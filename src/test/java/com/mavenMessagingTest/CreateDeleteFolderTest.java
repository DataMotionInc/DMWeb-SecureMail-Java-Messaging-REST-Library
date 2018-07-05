package com.mavenMessagingTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.mavenMessaging.MessagingAPI;
import com.mavenMessaging.NewFolder;
import com.mavenMessaging.NewFolderId;

public class CreateDeleteFolderTest {

	@Test
	public void testCreateFolder() {
		MessagingAPI tester = new MessagingAPI();
		tester.setStatusCode(-1);
		NewFolder testFolder = new NewFolder("testFolderName", 0);
		int newFolderId = tester.createFolder(tester.getSessionKey(), testFolder).getFolderId();
		assertEquals(200, tester.getStatusCode());
		tester.deleteFolder(tester.getSessionKey(), newFolderId);
		assertEquals(200, tester.getStatusCode());
	}

}
