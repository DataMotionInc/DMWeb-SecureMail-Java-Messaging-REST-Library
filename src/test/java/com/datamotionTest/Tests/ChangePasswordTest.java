package com.datamotionTest.Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.datamotion.DMWeb;

public class ChangePasswordTest {

	@Test
	public void test() {
		DMWeb tester = new DMWeb();
		tester.setStatusCode(-1);
		tester.Account.changePassword("CURRENTPASSWORD", "NEWPASSWORD");
		assertEquals(200, DMWeb.getStatusCode());
	}

}
