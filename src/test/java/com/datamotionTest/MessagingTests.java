package com.datamotionTest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.datamotion.DMWeb;

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

}
