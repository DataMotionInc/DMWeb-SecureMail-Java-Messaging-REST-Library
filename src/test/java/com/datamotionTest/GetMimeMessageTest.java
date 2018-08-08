package com.datamotionTest;

import static org.junit.Assert.*;

import org.junit.Test;

import com.datamotion.DMWeb;
import com.datamotion.Models.MimeMessage;
import com.fasterxml.jackson.core.JsonParseException;

public class GetMimeMessageTest {

	@Test
	public void test() throws JsonParseException {
		DMWeb tester = new DMWeb();
		tester.setStatusCode(-1);
		MimeMessage mimeMessage = tester.getMimeMessage(547);
		assertNotNull(mimeMessage);
		assertEquals(200, tester.getStatusCode());
	}

}
