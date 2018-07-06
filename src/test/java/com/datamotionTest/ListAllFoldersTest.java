package com.datamotionTest;

import static org.junit.Assert.*;

import org.junit.Test;

import com.datamotion.DMWeb;
import com.datamotion.Folders;
import com.fasterxml.jackson.core.JsonParseException;

public class ListAllFoldersTest {

	@Test
	public void test() throws JsonParseException {
		DMWeb tester = new DMWeb();
		tester.setStatusCode(-1);
		Folders folders = tester.listAllFolders();
		assertNotNull(folders);
		assertEquals(200, tester.getStatusCode());
	}
}
