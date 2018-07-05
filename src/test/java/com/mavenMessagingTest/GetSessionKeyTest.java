package com.mavenMessagingTest;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import com.mavenMessaging.MessagingAPI;

public class GetSessionKeyTest {

	@Test
	public void test() throws IOException {
		MessagingAPI tester = new MessagingAPI();
		assertNotNull(MessagingAPI.getSessionKey());
	}
}
