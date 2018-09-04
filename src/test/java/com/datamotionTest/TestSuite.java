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
import com.datamotionTest.Tests.CreateDeleteFolderTest;
import com.datamotionTest.Tests.GetAccountDetailsTest;
import com.datamotionTest.Tests.GetInboxMessageIdsTest;
import com.datamotionTest.Tests.GetMessageMetadataTest;
import com.datamotionTest.Tests.GetMessageSummariesTest;
import com.datamotionTest.Tests.GetMessageTest;
import com.datamotionTest.Tests.GetMimeMessageTest;
import com.datamotionTest.Tests.GetSessionKeyTest;
import com.datamotionTest.Tests.GetUnreadMessagesTest;
import com.datamotionTest.Tests.ListAllFoldersTest;
import com.datamotionTest.Tests.MoveMessageTest;
import com.datamotionTest.Tests.RetractMessageTest;
import com.datamotionTest.Tests.SearchInboxTest;
import com.datamotionTest.Tests.SendDeleteMessageTest;
import com.datamotionTest.Tests.SendMimeMessageTest;

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
public class TestSuite {

}
