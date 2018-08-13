package com.datamotionTest;

import static org.junit.Assert.*;

import org.junit.Test;

import com.datamotion.DMWeb;
import com.datamotion.Models.Message;
import com.fasterxml.jackson.core.JsonParseException;

public class GetMessageTest {

	@Test
	public void test() throws JsonParseException {
		DMWeb tester = new DMWeb();
		tester.setStatusCode(-1);
		Message message = tester.getMessage(628);
		assertNotNull(message);
		assertEquals(200, tester.getStatusCode());
	}
}
