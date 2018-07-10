package com.datamotion;

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

import com.datamotion.Models.Credentials;
import com.datamotion.Models.DeleteMessageResponse;
import com.datamotion.Models.Details;
import com.datamotion.Models.Folders;
import com.datamotion.Models.HttpHeader;
import com.datamotion.Models.Message;
import com.datamotion.Models.MessageIDget;
import com.datamotion.Models.MessageId;
import com.datamotion.Models.MessageIds;
import com.datamotion.Models.MessageSummariesGet;
import com.datamotion.Models.MessageSummariesResponse;
import com.datamotion.Models.MetaData;
import com.datamotion.Models.MimeMessage;
import com.datamotion.Models.MoveMessage;
import com.datamotion.Models.NewFolder;
import com.datamotion.Models.NewFolderId;
import com.datamotion.Models.PasswordChange;
import com.datamotion.Models.Search;
import com.datamotion.Models.SearchResponse;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.ObjectNode;

import lombok.Getter;
import lombok.Setter;

public class DMWeb {

	@Getter @Setter
	private static String BaseUrl;
	
	/**
	 * Session Key received after passing authentication, required for SecureMail methods
	 */
	@Getter @Setter
	private static String SessionKey;
	
	/**
	 * Http response status code
	 */
	@Getter @Setter
	private static int StatusCode;
	
	public DMWeb() {
		BaseUrl = "https://securemailbeta.datamotion.com/";
	}
	//SecureMail Messaging API Methods
	//Account:
	/**
	 * Retrieves a session key if valid credentials are used as arguments.
	 * SessionKey is stored as a member of the base DMWeb class.
	 * A valid session key is required for all other SecureMail API functions.
	 * @param user <code>string</code> login username
	 * @param pass <code>string</code> login password
	 * @throws JsonParseException Exception specific to JSON to Object mapping errors
	 */
	public static void logon(String user, String pass) throws JsonParseException {
		String sessionKey = "";
		String URL = BaseUrl + "SecureMessagingApi/Account/Logon";
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
		}catch (JsonParseException ex) {
			throw ex;
		}catch (Exception ex) {
			ex.printStackTrace();
		}
		SessionKey = sessionKey;
	}
	
	/**
	 * Retrieves account details in a standard format
	 * @return <code>Details</code> object mapped from JSON in server response
	 * @throws JsonParseException Exception specific to JSON to Object mapping errors
	 */
	public static Details getAccountDetails() throws JsonParseException {
		Details details = new Details();
		String JSONdetails = "";
		String URL = BaseUrl + "SecureMessagingApi/Account/Details";
		try {
			HttpEntity entity = buildHttpGetEntity(URL, assembleCommonHeaders());
			JSONdetails = IOUtils.toString(entity.getContent(), "UTF-8");
			ObjectMapper objectMapper = new ObjectMapper();
			details = objectMapper.readValue(JSONdetails, Details.class);
		}catch (JsonParseException ex) {
			throw ex;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return details;
	}
	
	/**
	 * Changes login password, requires valid current password and valid old password to be successful
	 * @param oldPass <code>string</code> old password
	 * @param newPass <code>string</code> new password
	 */
	public static void changePassword(String oldPass, String newPass) {
		PasswordChange passChange = new PasswordChange(oldPass, newPass);
		String JSONPassChange = buildJSONStringFromObject(passChange);
		String URL = BaseUrl + "SecureMessagingApi/Account/ChangePassword";
		try {
			HttpEntity entity = buildHttpPostEntity(URL, JSONPassChange, assembleCommonHeaders());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	/**
	 * Invalidates the <code>SessionKey</code> in use by <code>DMWeb</code>
	 */
	public static void logout() {
		String URL = BaseUrl + "SecureMessagingApi/Account/Logout";
		try {
			HttpEntity entity = buildHttpPostEntity(URL, "", assembleCommonHeaders());
		} catch (Exception ex) {
			ex.printStackTrace();
		}	
	}

	//Folder:
	/**
	 * Retrieves folder structure and related statistics
	 * @return <code>Folders</code> object mapped from JSON in server response
	 * @throws JsonParseException Exception specific to JSON to Object mapping errors
	 */
	public static Folders listAllFolders() throws JsonParseException {
		Folders folders = new Folders();
		String URL = BaseUrl + "SecureMessagingApi/Folder/List";
		try {
			HttpEntity entity = buildHttpGetEntity(URL, assembleCommonHeaders());
			String JSONFolders = IOUtils.toString(entity.getContent(), "UTF-8");
			ObjectMapper objectMapper = new ObjectMapper();
			folders = objectMapper.readValue(JSONFolders, Folders.class);
		}catch (JsonParseException ex) {
			throw ex;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return folders;
	}

	/**
	 * Creates a custom folder with appropriate information mapped from new folder object
	 * @param newFolder <code>NewFolder</code> object
	 * @return <code>string</code> New Folder ID
	 */
	public static NewFolderId createFolder(NewFolder newFolder) {
		String URL = BaseUrl + "SecureMessagingApi/Folder";
		String JSONNewFolder = buildJSONStringFromObject(newFolder);
		NewFolderId newFolderId = new NewFolderId();
		try {
			HttpEntity entity = buildHttpPostEntity(URL, JSONNewFolder, assembleCommonHeaders());
			String JSONNewFolderId = IOUtils.toString(entity.getContent(),  "UTF-8");
			ObjectMapper objectMapper = new ObjectMapper();
			newFolderId = objectMapper.readValue(JSONNewFolderId, NewFolderId.class);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return newFolderId;
	}
	
	/**
	 * Deletes a custom folder, given that folder's ID.
	 * Non-custom folders cannot be deleted
	 * @param folderID <code>int</code> folder ID
	 */
	public static void deleteFolder(int folderID) {
		String URL = BaseUrl + "SecureMessagingApi/Folder/" + folderID;
		try {
			HttpEntity entity = buildHttpDeleteEntity(URL, assembleCommonHeaders());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	//Message:
	/**
	 * Retrieves the message IDs of all messages in the user's inbox
	 * @param ID <code>MessageIDget</code> object, containing search parameters
	 * @return <code>MessageIds</code> object, mapped from JSON in server response
	 * @throws JsonParseException Exception specific to JSON to Object mapping errors
	 */
	public static MessageIds getInboxMessageIds(MessageIDget ID) throws JsonParseException {
		String URL = BaseUrl + "SecureMessagingApi/Message/GetInboxMessageIds";
		String JSONMessageIDget = buildJSONStringFromObject(ID);
		MessageIds messageIds = new MessageIds();
		try {
			HttpEntity entity = buildHttpPostEntity(URL, JSONMessageIDget, assembleCommonHeaders());
			String JSONMessageIds = IOUtils.toString(entity.getContent(), "UTF-8");
			ObjectMapper objectMapper = new ObjectMapper();
			messageIds = objectMapper.readValue(JSONMessageIds, MessageIds.class);
		}catch (JsonParseException ex) {
			throw ex;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return messageIds;
	}
	
	/**
	 * Retrieves message summaries of all messages within a specified folder
	 * @param messageSummariesGet <code>MessageSummariesGet</code> object, containing search parameters
	 * @return <code>MessageSummariesResponse</code> object, mapped from JSON in server response
	 * @throws JsonParseException Exception specific to JSON to Object mapping errors
	 */
	public static MessageSummariesResponse getMessageSummaries(MessageSummariesGet messageSummariesGet) throws JsonParseException {
		MessageSummariesResponse response = new MessageSummariesResponse();
		String URL = BaseUrl + "SecureMessagingApi/Message/GetMessageSummaries";
		String JSONGetSummaries = buildJSONStringFromObject(messageSummariesGet);
		try {
			HttpEntity entity = buildHttpPostEntity(URL, JSONGetSummaries, assembleCommonHeaders());
			String JSONMessageSummaries = IOUtils.toString(entity.getContent(), "UTF-8");
			ObjectMapper objectMapper = new ObjectMapper();
			response = objectMapper.readValue(JSONMessageSummaries, MessageSummariesResponse.class);
		}catch (JsonParseException ex) {
			throw ex;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return response;
	}
	
	/**
	 * Retrieves message summaries of all unread messages in a user's inbox
	 * @param after <code>boolean</code> to retrieve only messages after a specified ID
	 * @param lastMessageId <code>int</code> specified ID, used if <b>after</b> is true
	 * @return MessageSummariesResponse object, mapped from JSON in server response
	 * @throws JsonParseException Exception specific to JSON to Object mapping errors
	 */
	public static MessageSummariesResponse getUnreadMessages(boolean after, int lastMessageId) throws JsonParseException {
		MessageSummariesResponse response = new MessageSummariesResponse();
		String URL = BaseUrl + "SecureMessagingApi/Message/Inbox/Unread";
		if (after) {URL += "?After=" + lastMessageId;}
		try {
			HttpEntity entity = buildHttpGetEntity(URL, assembleCommonHeaders());
			String JSONUnreadMessageSummaries = IOUtils.toString(entity.getContent(), "UTF-8");
			ObjectMapper objectMapper = new ObjectMapper();
			response = objectMapper.readValue(JSONUnreadMessageSummaries, MessageSummariesResponse.class);
		}catch (JsonParseException ex) {
			throw ex;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return response;
	}
	
	/**
	 * Searches the user's inbox, based on filter parameters
	 * @param search <code>Search</code> Object containing filter parameters
	 * @return <code>SearchResponse</code> object, mapped from JSON in server response
	 * @throws JsonParseException Exception specific to JSON to Object mapping errors
	 */
	public static SearchResponse searchInbox(Search search) throws JsonParseException {
		SearchResponse response = new SearchResponse();
		String URL = BaseUrl + "SecureMessagingApi/Message/Inbox/Search";
		String JSONSearch = buildJSONStringFromObject(search);
		try {
			HttpEntity entity = buildHttpPostEntity(URL, JSONSearch, assembleCommonHeaders());
			String JSONSearchResults = IOUtils.toString(entity.getContent(), "UTF-8");
			ObjectMapper objectMapper = new ObjectMapper();
			response = objectMapper.readValue(JSONSearchResults, SearchResponse.class);
		}catch (JsonParseException ex) {
			throw ex;
		}catch (Exception ex) {
			ex.printStackTrace();
		}
		return response;
	}

	/**
	 * Retrieves metadata for a sent message
	 * @param messageId <code>int</code> message ID of the message in question
	 * @return <code>MetaData</code> object, mapped from JSON in server response
	 * @throws JsonParseException Exception specific to JSON to Object mapping errors
	 */
	public static MetaData getMessageMetadata(int messageId) throws JsonParseException {
		MetaData metaData = new MetaData();
		String URL = BaseUrl + "SecureMessagingApi/Message/" + messageId + "/Metadata";
		try {
			HttpEntity entity = buildHttpGetEntity(URL, assembleCommonHeaders());
			String JSONMetaData = IOUtils.toString(entity.getContent(), "UTF-8");
			ObjectMapper objectMapper = new ObjectMapper();
			metaData = objectMapper.readValue(JSONMetaData, MetaData.class);
		}catch (JsonParseException ex) {
			throw ex;
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return metaData;
	}
	
	/**
	 * Retrieves a message based on the message ID passed
	 * @param messageId <code>int</code> ID of message to be retrieved
	 * @return <code>Message</code> object, mapped from JSON in server response
	 * @throws JsonParseException Exception specific to JSON to Object mapping errors
	 */
	public static Message getMessage(int messageId) throws JsonParseException {
		Message message = new Message();
		String URL = BaseUrl + "SecureMessagingApi/Message/" + messageId;
		try {
			HttpEntity entity = buildHttpGetEntity(URL, assembleCommonHeaders());
			String JSONMessage = IOUtils.toString(entity.getContent(), "UTF-8");
			ObjectMapper objectMapper = new ObjectMapper();
			message = objectMapper.readValue(JSONMessage,  Message.class);
		}catch (JsonParseException ex) {
			throw ex;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return message;
	}
	
	/**
	 * Retrieves a message in MIME format
	 * @param messageId <code>int</code> ID of message to be retrieved
	 * @return <code>MimeMessage</code> object, mapped from JSON in server response
	 * @throws JsonParseException Exception specific to JSON to Object mapping errors
	 */
	public static MimeMessage getMimeMessage(int messageId) throws JsonParseException {
		MimeMessage mimeMessage = new MimeMessage();
		String URL = BaseUrl + "SecureMessagingApi/Message/" + messageId + "/Mime";
		try {
			HttpEntity entity = buildHttpGetEntity(URL, assembleCommonHeaders());
			String JSONMimeMessage = IOUtils.toString(entity.getContent(), "UTF-8");
			ObjectMapper objectMapper = new ObjectMapper();
			mimeMessage = objectMapper.readValue(JSONMimeMessage, MimeMessage.class);
		}catch (JsonParseException ex) {
			throw ex;
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return mimeMessage;
	}
	
	/**
	 * Sends a message, with all relevant information contained in <code>Message</code> object
	 * @param message <code>Message</code> object
	 * @return <code>int</code> ID of message that was sent
	 */
	public static MessageId sendMessage(Message message) {
		MessageId messageId = new MessageId();
		String URL = BaseUrl + "SecureMessagingApi/Message/";
		String JSONMessage = buildJSONStringFromObject(message);
		try {
			HttpEntity entity = buildHttpPostEntity(URL, JSONMessage, assembleCommonHeaders());
			String response = IOUtils.toString(entity.getContent(), "UTF-8");
			ObjectMapper objectMapper = new ObjectMapper();
			messageId = objectMapper.readValue(response, MessageId.class);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return messageId;
	}
	
	/**
	 * Sends a MIME message, assuming <code>MimeMessage</code> object contains a properly formatted MIME string
	 * @param mimeMessage <code>MimeMessage</code> object
	 * @return <code>int</code> ID of message that was sent
	 */
	public static MessageId sendMimeMessage(MimeMessage mimeMessage) {
		MessageId messageId = new MessageId();
		String URL = BaseUrl + "SecureMessagingApi/Message/Mime";
		String JSONMimeMessage = buildJSONStringFromObject(mimeMessage);
		try {
			HttpEntity entity = buildHttpPostEntity(URL, JSONMimeMessage, assembleCommonHeaders());
			String response = IOUtils.toString(entity.getContent(), "UTF-8");
			ObjectMapper objectMapper = new ObjectMapper();
			messageId = objectMapper.readValue(response, MessageId.class);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return messageId;
	}

	/**
	 * Moves a message into a specified folder
	 * @param moveMessage <code>MoveMessage</code> object, containing relevant parameters
	 * @param messageId <code>int</code> ID of message to be moved
	 */
	public static void moveMessage(MoveMessage moveMessage, int messageId) {
		String URL = BaseUrl + "SecureMessagingApi/Message/" + messageId + "/Move";
		String JSONMoveMessage = buildJSONStringFromObject(moveMessage);
		try {
			HttpEntity entity = buildHttpPostEntity(URL, JSONMoveMessage, assembleCommonHeaders());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	/**
	 * Deletes a message from a folder
	 * @param messageId <code>int</code> ID of message to be deleted
	 * @param permanent <code>boolean</code> Flag to delete message permanently
	 * @return <code>DeleteMessageResponse</code> object, mapped from JSON in server response
	 * @throws JsonParseException Exception specific to JSON to Object mapping errors
	 */
	public static DeleteMessageResponse deleteMessage(int messageId, boolean permanent) throws JsonParseException {
		DeleteMessageResponse response = new DeleteMessageResponse();
		String URL = BaseUrl + "SecureMessagingApi/Message/" + messageId;
		if (permanent) {URL += "?Permanently=true";}
		try { 
			HttpEntity entity = buildHttpDeleteEntity(URL, assembleCommonHeaders());
			String JSONDeleteMessageResponse = IOUtils.toString(entity.getContent(), "UTF-8");
			ObjectMapper objectMapper = new ObjectMapper();
			response = objectMapper.readValue(JSONDeleteMessageResponse, DeleteMessageResponse.class);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return response;
	}
	
	/**
	 * Retracts a message from any recipients who received it
	 * @param messageId <code>int</code> ID of message to be retracted
	 */
	public static void retractMessage(int messageId) {
		String URL = BaseUrl + "SecureMessagingApi/Message/" + messageId + "/Retract";
		try {
			HttpEntity entity = buildHttpPostEntity(URL, "", assembleCommonHeaders());
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
	
	public static ArrayList<HttpHeader> assembleCommonHeaders(){
		HttpHeader contentType = new HttpHeader("Content-Type", "application/json");
		HttpHeader xSessionKey = new HttpHeader("X-Session-Key", SessionKey);
		ArrayList<HttpHeader> headers = new ArrayList<HttpHeader>();
		headers.add(contentType);
		headers.add(xSessionKey);	
		return headers;
	}
	

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

	public static byte[] decodeBase64ToByteArray(String base64) {
		byte[] bytes = Base64.decodeBase64(base64);
		return bytes;
	}
}


