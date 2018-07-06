package com.mavenMessagingTest;

import java.io.IOException;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.mavenMessaging.MessagingAPI;

@RunWith(Suite.class)
@SuiteClasses({GetSessionKeyTest.class,
	GetAccountDetailsTest.class,
	ListAllFoldersTest.class,
	CreateDeleteFolderTest.class,
	GetInboxMessageIdsTest.class,
	GetMessageSummariesTest.class,
	GetUnreadMessagesTest.class,
	SearchInboxTest.class,
	GetMessageMetadataTest.class,
	GetMessageTest.class,
	GetMimeMessageTest.class,
	SendDeleteMessageTest.class,
	SendMimeMessageTest.class,
	MoveMessageTest.class,
	RetractMessageTest.class})
public class MessagingTests {
	@BeforeClass
	public static void setup() throws IOException {
		MessagingAPI.setSessionKeyFromFile("userpass.txt");
	}
}
