package com.datamotionTest.Tests;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import com.datamotion.DMWeb;

public class GetSessionKeyTest {

	@Test
	public void test() throws Exception {
		DMWeb tester = new DMWeb("https://dmscim.ngrok.io/scim/v2/Users/");
		Context context = new Context();
		tester.Account.logon(context.getUsername(), context.getPassword());
		System.out.println(tester.getErrorMessage());
		assertEquals(32, tester.getSessionKey().length());
	}
}
