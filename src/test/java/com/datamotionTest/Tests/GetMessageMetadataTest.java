package com.datamotionTest.Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.datamotion.DMWeb;
import com.datamotion.Models.MetaData;
import com.fasterxml.jackson.core.JsonParseException;

public class GetMessageMetadataTest {

	@Test
	public void test() throws JsonParseException {
		DMWeb tester = new DMWeb();
		tester.setStatusCode(-1);
		MetaData metadata = tester.getMessageMetadata(628);
		assertNotNull(metadata);
		assertEquals(200, tester.getStatusCode());
	}
}
