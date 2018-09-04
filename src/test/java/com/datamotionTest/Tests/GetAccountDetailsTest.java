package com.datamotionTest.Tests;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import com.datamotion.DMWeb;
import com.datamotion.Models.Details;

public class GetAccountDetailsTest {

	@Test
	public void test() throws IOException {
		DMWeb tester = new DMWeb();
		tester.setStatusCode(-1);
		Details details = tester.getAccountDetails();
		assertNotNull(details);
		assertEquals(200, tester.getStatusCode());
	}

}
