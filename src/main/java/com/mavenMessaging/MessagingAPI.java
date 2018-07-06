package com.mavenMessaging;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.ObjectNode;

import lombok.Getter;
import lombok.Setter;

public class MessagingAPI {
	
	@Getter @Setter
	private static String SessionKey;
	
	@Getter @Setter
	private static int StatusCode;
	//SecureMail Messaging API Functions
	//Account:
	@SuppressWarnings("unused")
	public static String getNewSessionKey(String user, String pass) throws JsonParseException {
		String sessionKey = "";
		String URL = "https://securemailbeta.datamotion.com/SecureMessagingApi/Account/Logon";
		HttpHeader contentType = new HttpHeader("Content-Type", "application/json");
		ArrayList<HttpHeader> headers = new ArrayList<HttpHeader>();
		headers.add(contentType);
		Credentials creds = new Credentials(user, pass);
		String JSONcreds = buildJSONStringFromObject(creds);
		try {
			HttpEntity entity = buildHttpPostEntity(URL, JSONcreds, headers);
			String JSONsessionKey = IOUtils.toString(entity.getContent(), "UTF-8");
			ObjectNode node = new ObjectMapper().readValue(JSONsessionKey,  ObjectNode.class);
			sessionKey = node.get("SessionKey").asText();
		}catch (Exception ex) {
			ex.printStackTrace();
		}
		return sessionKey;

	}
	
	@SuppressWarnings("unused")
	public static Details getAccountDetails(String sessionKey) throws JsonParseException {
		Details details = new Details();
		String JSONdetails = "";
		String URL = "https://securemailbeta.datamotion.com/SecureMessagingApi/Account/Details";
		try {
			HttpEntity entity = buildHttpGetEntity(URL, assembleCommonHeaders(sessionKey));
			JSONdetails = IOUtils.toString(entity.getContent(), "UTF-8");
			ObjectMapper objectMapper = new ObjectMapper();
			details = objectMapper.readValue(JSONdetails, Details.class);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return details;
	}
	
	@SuppressWarnings("unused")
	public static void changePassword(String sessionKey, String oldPass, String newPass) {
		PasswordChange passChange = new PasswordChange(oldPass, newPass);
		String JSONPassChange = buildJSONStringFromObject(passChange);
		String URL = "https://securemailbeta.datamotion.com/SecureMessagingApi/Account/ChangePassword";
		try {
			HttpEntity entity = buildHttpPostEntity(URL, JSONPassChange, assembleCommonHeaders(sessionKey));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	@SuppressWarnings("unused")
	public static void logout(String sessionKey) {
		String URL = "https://securemailbeta.datamotion.com/SecureMessagingApi/Account/Logout";
		try {
			HttpEntity entity = buildHttpPostEntity(URL, "", assembleCommonHeaders(sessionKey));
		} catch (Exception ex) {
			ex.printStackTrace();
		}	
	}

	//Folder:
	@SuppressWarnings("unused")
	public static Folders listAllFolders(String sessionKey) throws JsonParseException {
		Folders folders = new Folders();
		String URL = "https://securemailbeta.datamotion.com/SecureMessagingApi/Folder/List";
		try {
			HttpEntity entity = buildHttpGetEntity(URL, assembleCommonHeaders(sessionKey));
			String JSONFolders = IOUtils.toString(entity.getContent(), "UTF-8");
			ObjectMapper objectMapper = new ObjectMapper();
			folders = objectMapper.readValue(JSONFolders, Folders.class);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return folders;
	}

	@SuppressWarnings("unused")
	public static NewFolderId createFolder(String sessionKey, NewFolder newFolder) {
		String URL = "https://securemailbeta.datamotion.com/SecureMessagingApi/Folder";
		String JSONNewFolder = buildJSONStringFromObject(newFolder);
		NewFolderId newFolderId = new NewFolderId();
		try {
			HttpEntity entity = buildHttpPostEntity(URL, JSONNewFolder, assembleCommonHeaders(sessionKey));
			String JSONNewFolderId = IOUtils.toString(entity.getContent(),  "UTF-8");
			ObjectMapper objectMapper = new ObjectMapper();
			newFolderId = objectMapper.readValue(JSONNewFolderId, NewFolderId.class);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return newFolderId;
	}
	
	@SuppressWarnings("unused")
	public static void deleteFolder(String sessionKey, int folderID) {
		String URL = "https://securemailbeta.datamotion.com/SecureMessagingApi/Folder/" + folderID;
		try {
			HttpEntity entity = buildHttpDeleteEntity(URL, assembleCommonHeaders(sessionKey));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	//Message:
	@SuppressWarnings("unused")
	public static MessageIds getInboxMessageIds(String sessionKey, MessageIDget ID) throws JsonParseException {
		String URL = "https://securemailbeta.datamotion.com/SecureMessagingApi/Message/GetInboxMessageIds";
		String JSONMessageIDget = buildJSONStringFromObject(ID);
		MessageIds messageIds = new MessageIds();
		try {
			HttpEntity entity = buildHttpPostEntity(URL, JSONMessageIDget, assembleCommonHeaders(sessionKey));
			String JSONMessageIds = IOUtils.toString(entity.getContent(), "UTF-8");
			ObjectMapper objectMapper = new ObjectMapper();
			messageIds = objectMapper.readValue(JSONMessageIds, MessageIds.class);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return messageIds;
	}
	
	@SuppressWarnings("unused")
	public static MessageSummariesResponse getMessageSummaries(String sessionKey, MessageSummariesGet messageSummariesGet) throws JsonParseException {
		MessageSummariesResponse response = new MessageSummariesResponse();
		String URL = "https://securemailbeta.datamotion.com/SecureMessagingApi/Message/GetMessageSummaries";
		String JSONGetSummaries = buildJSONStringFromObject(messageSummariesGet);
		try {
			HttpEntity entity = buildHttpPostEntity(URL, JSONGetSummaries, assembleCommonHeaders(sessionKey));
			String JSONMessageSummaries = IOUtils.toString(entity.getContent(), "UTF-8");
			ObjectMapper objectMapper = new ObjectMapper();
			response = objectMapper.readValue(JSONMessageSummaries, MessageSummariesResponse.class);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return response;
	}
	
	@SuppressWarnings("unused")
	public static MessageSummariesResponse getUnreadMessages(String sessionKey, boolean after, int lastMessageId) throws JsonParseException {
		MessageSummariesResponse response = new MessageSummariesResponse();
		String URL = "https://securemailbeta.datamotion.com/SecureMessagingApi/Message/Inbox/Unread";
		if (after) {URL += "?After=" + lastMessageId;}
		try {
			HttpEntity entity = buildHttpGetEntity(URL, assembleCommonHeaders(sessionKey));
			String JSONUnreadMessageSummaries = IOUtils.toString(entity.getContent(), "UTF-8");
			ObjectMapper objectMapper = new ObjectMapper();
			response = objectMapper.readValue(JSONUnreadMessageSummaries, MessageSummariesResponse.class);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return response;
	}
	
	@SuppressWarnings("unused")
	public static SearchResponse searchInbox(String sessionKey, Search search) throws JsonParseException {
		SearchResponse response = new SearchResponse();
		String URL = "https://securemailbeta.datamotion.com/SecureMessagingApi/Message/Inbox/Search";
		String JSONSearch = buildJSONStringFromObject(search);
		try {
			HttpEntity entity = buildHttpPostEntity(URL, JSONSearch, assembleCommonHeaders(sessionKey));
			String JSONSearchResults = IOUtils.toString(entity.getContent(), "UTF-8");
			ObjectMapper objectMapper = new ObjectMapper();
			response = objectMapper.readValue(JSONSearchResults, SearchResponse.class);
		}catch (Exception ex) {
			ex.printStackTrace();
		}
		return response;
	}

	@SuppressWarnings("unused")
	public static MetaData getMessageMetadata(String sessionKey, int messageId) throws JsonParseException {
		MetaData metaData = new MetaData();
		String URL = "https://securemailbeta.datamotion.com/SecureMessagingApi/Message/" + messageId + "/Metadata";
		try {
			HttpEntity entity = buildHttpGetEntity(URL, assembleCommonHeaders(sessionKey));
			String JSONMetaData = IOUtils.toString(entity.getContent(), "UTF-8");
			ObjectMapper objectMapper = new ObjectMapper();
			metaData = objectMapper.readValue(JSONMetaData, MetaData.class);
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return metaData;
	}
	
	@SuppressWarnings("unused")
	public static Message getMessage(String sessionKey, int messageId) throws JsonParseException {
		Message message = new Message();
		String URL = "https://securemailbeta.datamotion.com/SecureMessagingApi/Message/" + messageId;
		try {
			HttpEntity entity = buildHttpGetEntity(URL, assembleCommonHeaders(sessionKey));
			String JSONMessage = IOUtils.toString(entity.getContent(), "UTF-8");
			ObjectMapper objectMapper = new ObjectMapper();
			message = objectMapper.readValue(JSONMessage,  Message.class);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return message;
	}
	
	@SuppressWarnings("unused")
	public static MimeMessage getMimeMessage(String sessionKey, int messageId) throws JsonParseException {
		MimeMessage mimeMessage = new MimeMessage();
		String URL = "https://securemailbeta.datamotion.com/SecureMessagingApi/Message/" + messageId + "/Mime";
		try {
			HttpEntity entity = buildHttpGetEntity(URL, assembleCommonHeaders(sessionKey));
			String JSONMimeMessage = IOUtils.toString(entity.getContent(), "UTF-8");
			ObjectMapper objectMapper = new ObjectMapper();
			mimeMessage = objectMapper.readValue(JSONMimeMessage, MimeMessage.class);
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return mimeMessage;
	}
	
	@SuppressWarnings("unused")
	public static MessageId sendMessage(Message message, String sessionKey) {
		MessageId messageId = new MessageId();
		String URL = "https://securemailbeta.datamotion.com/SecureMessagingApi/Message/";
		String JSONMessage = buildJSONStringFromObject(message);
		//System.out.println(JSONMessage);
		try {
			HttpEntity entity = buildHttpPostEntity(URL, JSONMessage, assembleCommonHeaders(sessionKey));
			String response = IOUtils.toString(entity.getContent(), "UTF-8");
			ObjectMapper objectMapper = new ObjectMapper();
			messageId = objectMapper.readValue(response, MessageId.class);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return messageId;
	}
	
	@SuppressWarnings("unused")
	public static MessageId sendMimeMessage(MimeMessage mimeMessage, String sessionKey) {
		MessageId messageId = new MessageId();
		String URL = "https://securemailbeta.datamotion.com/SecureMessagingApi/Message/Mime";
		String JSONMimeMessage = buildJSONStringFromObject(mimeMessage);
		try {
			HttpEntity entity = buildHttpPostEntity(URL, JSONMimeMessage, assembleCommonHeaders(sessionKey));
			String response = IOUtils.toString(entity.getContent(), "UTF-8");
			ObjectMapper objectMapper = new ObjectMapper();
			messageId = objectMapper.readValue(response, MessageId.class);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return messageId;
	}

	@SuppressWarnings("unused")
	public static void moveMessage(MoveMessage moveMessage, String sessionKey, int messageId) {
		String URL = "https://securemailbeta.datamotion.com/SecureMessagingApi/Message/" + messageId + "/Move";
		String JSONMoveMessage = buildJSONStringFromObject(moveMessage);
		try {
			HttpEntity entity = buildHttpPostEntity(URL, JSONMoveMessage, assembleCommonHeaders(sessionKey));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	@SuppressWarnings("unused")
	public static DeleteMessageResponse deleteMessage(String sessionKey, int messageId, boolean permanent) throws JsonParseException {
		DeleteMessageResponse response = new DeleteMessageResponse();
		String URL = "https://securemailbeta.datamotion.com/SecureMessagingApi/Message/" + messageId;
		if (permanent) {URL += "?Permanently=true";}
		try { 
			HttpEntity entity = buildHttpDeleteEntity(URL, assembleCommonHeaders(sessionKey));
			String JSONDeleteMessageResponse = IOUtils.toString(entity.getContent(), "UTF-8");
			ObjectMapper objectMapper = new ObjectMapper();
			response = objectMapper.readValue(JSONDeleteMessageResponse, DeleteMessageResponse.class);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return response;
	}
	
	@SuppressWarnings("unused")
	public void retractMessage(String sessionKey, int messageId) {
		String URL = "https://securemailbeta.datamotion.com/SecureMessagingApi/Message/" + messageId + "/Retract";
		try {
			HttpEntity entity = buildHttpPostEntity(URL, "", assembleCommonHeaders(sessionKey));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	//Auxiliary Functions:
	public static String buildJSONStringFromObject(Object object) {
		ObjectMapper mapper = new ObjectMapper();
		String json = null;
		mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		try {
			if (object != null)
				json = mapper.writeValueAsString(object);
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		return json;
	}

	public static HttpEntity buildHttpPostEntity(String URL, String body, ArrayList<HttpHeader> headerList) throws ClientProtocolException, IOException {
		HttpClient client = HttpClientBuilder.create().build();
		HttpPost httpPost = new HttpPost(URL);
		StringEntity input = new StringEntity(body);
		for (int i = 0; i < headerList.size(); i++) {
			httpPost.addHeader(headerList.get(i).getKey(), headerList.get(i).getValue());
		}
		httpPost.setEntity(input);
		HttpResponse httpResponse = client.execute(httpPost);
		StatusCode = httpResponse.getStatusLine().getStatusCode();
		HttpEntity entity = httpResponse.getEntity();
		return entity;
	}
	
	public static HttpEntity buildHttpGetEntity(String URL, ArrayList<HttpHeader> headerList) throws ClientProtocolException, IOException {
		HttpClient client = HttpClientBuilder.create().build();
		HttpGet httpGet = new HttpGet(URL);
		for (int i = 0; i < headerList.size(); i++) {
			httpGet.addHeader(headerList.get(i).getKey(), headerList.get(i).getValue());
		}
		HttpResponse httpResponse = client.execute(httpGet);
		StatusCode = httpResponse.getStatusLine().getStatusCode();
		HttpEntity entity = httpResponse.getEntity();
		return entity;
	}
	
	public static HttpEntity buildHttpDeleteEntity(String URL, ArrayList<HttpHeader> headerList) throws ClientProtocolException, IOException {
		HttpClient client = HttpClientBuilder.create().build();
		HttpDelete httpDelete = new HttpDelete(URL);
		for (int i = 0; i < headerList.size(); i++) {
			httpDelete.addHeader(headerList.get(i).getKey(), headerList.get(i).getValue());
		}
		HttpResponse httpResponse = client.execute(httpDelete);
		StatusCode = httpResponse.getStatusLine().getStatusCode();
		HttpEntity entity = httpResponse.getEntity();
		return entity;
	}
	
	public static ArrayList<HttpHeader> assembleCommonHeaders(String sessionKey){
		HttpHeader contentType = new HttpHeader("Content-Type", "application/json");
		HttpHeader xSessionKey = new HttpHeader("X-Session-Key", sessionKey);
		ArrayList<HttpHeader> headers = new ArrayList<HttpHeader>();
		headers.add(contentType);
		headers.add(xSessionKey);	
		return headers;
	}
	
	@SuppressWarnings("unused")
	public static String encodeFileToBase64Binary(String fileName) throws IOException {

		File file = new File(fileName);
		byte[] bytes = loadFile(file);
		byte[] encoded = Base64.encodeBase64(bytes);
		String encodedString = new String(encoded);

		return encodedString;
	}
	
	@SuppressWarnings("resource")
	public static byte[] loadFile(File file) throws IOException {
	    InputStream is = new FileInputStream(file);

	    long length = file.length();
	    if (length > Integer.MAX_VALUE) {
	        // File is too large
	    }
	    byte[] bytes = new byte[(int)length];
	    
	    int offset = 0;
	    int numRead = 0;
	    while (offset < bytes.length
	           && (numRead=is.read(bytes, offset, bytes.length-offset)) >= 0) {
	        offset += numRead;
	    }

	    if (offset < bytes.length) {
	        throw new IOException("Could not completely read file "+file.getName());
	    }

	    is.close();
	    return bytes;
	}

	public static void setSessionKeyFromFile(String filepath) throws IOException {
		File file = new File(filepath);
		BufferedReader br = new BufferedReader(new FileReader(file));
		String username = br.readLine();
		String password = br.readLine();
		SessionKey = getNewSessionKey(username, password);
	}
}


