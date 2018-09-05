package com.datamotionTest.Tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.datamotion.DMWeb;
import com.datamotion.Models.NewFolder;
import com.datamotion.Models.NewFolderId;

public class CreateDeleteFolderTest {

	@Test
	public void testCreateFolder() {
		DMWeb tester = new DMWeb();
		tester.setStatusCode(-1);
		NewFolder testFolder = new NewFolder("testFolderName", 0);
		int newFolderId = tester.createFolder(testFolder).getFolderId();
		assertEquals(200, tester.getStatusCode());
		tester.deleteFolder(newFolderId);
		assertEquals(200, tester.getStatusCode());
	}

}
