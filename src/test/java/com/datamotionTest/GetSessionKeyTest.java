package com.datamotionTest;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import com.datamotion.DMWeb;

public class GetSessionKeyTest {

	@Test
	public void test() throws IOException {
		DMWeb tester = new DMWeb();
		Context context = new Context();
		tester.logon(context.getUsername(), context.getPassword());
		assertNotNull(tester.getSessionKey());
	}
}
