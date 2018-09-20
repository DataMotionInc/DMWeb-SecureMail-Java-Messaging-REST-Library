package com.datamotionTest.Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.datamotion.DMWeb;

public class LogoutTest {

	@Test
	public void test() {
		DMWeb tester = new DMWeb();
		tester.setStatusCode(-1);
		tester.Account.logout();
		assertEquals(200, tester.getStatusCode());
	}

}
