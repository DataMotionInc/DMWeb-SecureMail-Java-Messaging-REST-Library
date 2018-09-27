package com.datamotionTest.Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.datamotion.DMWeb;
import com.datamotion.Models.MimeMessage;

public class RetractMessageTest {

	@Test
	public void test() throws Exception {
		DMWeb tester = new DMWeb();
		tester.setStatusCode(-1);
		MimeMessage mimeMessage = new MimeMessage(
				"MIME-Version: 1.0\r\n" + 
				" X-Mailer: MailBee.NET 8.0.4.428\r\n" + 
				" Subject: This is the subject of a sample message\r\n" + 
				" To: UnitTest1@dmfaketest.com\r\n" + 
				" Content-Type: multipart/alternative;\r\n" + 
				" boundary=\"--XXXXboundary text--\"\r\n" + 
				"\r\n" + 
				"--XXXXboundary text--\r\n" + 
				" Content-Type: text/plain;\r\n" + 
				" charset=\"utf-8\"\r\n" + 
				" Content-Transfer-Encoding: quoted-printable\r\n" + 
				"\r\n" + 
				"This is the body text of a sample message.\r\n" + 
				"\r\n" + 
				"--XXXXboundary text--\r\n" + 
				" Content-Type: text/html;\r\n" + 
				" charset=\"utf-8\"\r\n" + 
				" Content-Transfer-Encoding: quoted-printable\r\n" + 
				"\r\n" + 
				"<pre>This is the body text of a sample message.</pre>\r\n" + 
				"--XXXXboundary text--");
		int messageId = tester.Message.sendMimeMessage(mimeMessage).getMessageId();
		Thread.sleep(3000);
		tester.Message.retractMessage(messageId);
		assertEquals(200, tester.getStatusCode());
	}

}
