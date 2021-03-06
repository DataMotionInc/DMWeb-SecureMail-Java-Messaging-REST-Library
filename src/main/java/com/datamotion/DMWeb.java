package com.datamotion;

import java.io.File;
import java.io.FileInputStream;
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
import com.datamotion.Models.GetAttachmentResponse;
import com.datamotion.Models.GetMessageSummariesWithMetadata;
import com.datamotion.Models.GetMessageSummariesWithMetadataResponse;
import com.datamotion.Models.HttpHeader;
import com.datamotion.Models.Message;
import com.datamotion.Models.MessageIdGet;
import com.datamotion.Models.MessageId;
import com.datamotion.Models.MessageIds;
import com.datamotion.Models.MessageSummariesGet;
import com.datamotion.Models.MessageSummariesResponse;
import com.datamotion.Models.MessageWithAttachmentMetadata;
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


/**
 * Main Class containing methods for all DataMotion SecureMail API functions
 * @author Thomas Tyler Bissell
 *
 */
public class DMWeb {
	
	/**
	 * Base URL for various DataMotion SecureMail methods
	 */
	protected static String BaseUrl;
	
	/**
	 * Session Key received after passing authentication, required for SecureMail methods
	 */
	protected static String SessionKey;
	
	/**
	 * Http response status code
	 */
	protected static int StatusCode;
	
	/**
	 * If the server responds with a simple error message (string) it will be stored here
	 */
	protected static String ErrorMessage;
	
	public DMAccount Account = new DMAccount();
	public DMFolders Folders = new DMFolders();
	public DMMessage Message = new DMMessage();
	
	/**
	 * Sets <code>BaseUrl</code>
	 */
	public DMWeb() {
		BaseUrl = "https://ssl.datamotion.com/SecureMessagingApi";
	}
	
	public DMWeb(String url) {
		BaseUrl = url;
	}
	
	public class DMAccount {
		/**
		 * Retrieves a session key if valid credentials are used as arguments.
		 * SessionKey is stored as a member of the base DMWeb class.
		 * A valid session key is required for all other SecureMail API functions.
		 * @param user <code>string</code> login username
		 * @param pass <code>string</code> login password
		 * @return <code>String</code> session key
		 * @throws Exception 
		 */
		public String logon(String user, String pass) throws Exception {
			String sessionKey = "";
			String URL = BaseUrl + "/Account/Logon";
			HttpHeader contentType = new HttpHeader("Content-Type", "application/json; charset=utf8");
			ArrayList<HttpHeader> headers = new ArrayList<HttpHeader>();
			headers.add(contentType);
			Credentials creds = new Credentials(user, pass);
			String JSONcreds = buildJSONStringFromObject(creds);
			String response = "";
			try {
				HttpEntity entity = buildHttpPostEntity(URL, JSONcreds, headers);
				response = IOUtils.toString(entity.getContent(), "UTF-8");
				ObjectNode node = new ObjectMapper().readValue(response,  ObjectNode.class);
				sessionKey = node.get("SessionKey").asText();
			}catch (Exception ex) {
				ErrorMessage = response;
				throw new Exception(response);
			}
			SessionKey = sessionKey;
			return sessionKey;
		}
		
		/**
		 * Retrieves account details in a standard format
		 * @return <code>Details</code> object mapped from JSON in server response
		 * @throws Exception
		 */
		public Details getAccountDetails() throws Exception {
			Details details = new Details();
			String response = "";
			String URL = BaseUrl + "/Account/Details";
			try {
				HttpEntity entity = buildHttpGetEntity(URL, assembleCommonHeaders());
				response = IOUtils.toString(entity.getContent(), "UTF-8");
				ObjectMapper objectMapper = new ObjectMapper();
				details = objectMapper.readValue(response, Details.class);
			}catch (Exception ex) {
				ErrorMessage = response;
				throw new Exception(response);
			}
			return details;
		}
		
		/**
		 * Changes login password, requires valid new password and valid old password to be successful
		 * @param oldPass <code>string</code> old password
		 * @param newPass <code>string</code> new password
		 * @throws Exception 
		 */
		public void changePassword(String oldPass, String newPass) throws Exception {
			PasswordChange passChange = new PasswordChange(oldPass, newPass);
			String JSONPassChange = buildJSONStringFromObject(passChange);
			String URL = BaseUrl + "/Account/ChangePassword";
			String response = "";
			try {
				HttpEntity entity = buildHttpPostEntity(URL, JSONPassChange, assembleCommonHeaders());
				response = IOUtils.toString(entity.getContent(), "UTF-8");
				if (StatusCode != 200) {
					ErrorMessage = IOUtils.toString(entity.getContent(), "UTF-8");
				}
			} catch (Exception ex) {
				ErrorMessage = response;
				throw new Exception(response);
			}
		}
		
		/**
		 * Invalidates the <code>SessionKey</code> in use by <code>DMWeb</code>
		 * @throws Exception 
		 */
		public void logout() throws Exception {
			String URL = BaseUrl + "/Account/Logout";
			String response = "";
			try {
				HttpEntity entity = buildHttpPostEntity(URL, "", assembleCommonHeaders());
				response = IOUtils.toString(entity.getContent(), "UTF-8");
				if (StatusCode != 200) {
					ErrorMessage = response;
				}
			} catch (Exception ex) {
				ErrorMessage = response;
				throw new Exception(response);
			}	
		}

	}

	public class DMFolders {
		/**
		 * Retrieves folder structure and related statistics
		 * @return <code>Folders</code> object mapped from JSON in server response
		 * @throws Exception
		 */
		public Folders listAllFolders() throws Exception {
			Folders folders = new Folders();
			String URL = BaseUrl + "/Folder/List";
			String response = "";
			try {
				HttpEntity entity = buildHttpGetEntity(URL, assembleCommonHeaders());
				response = IOUtils.toString(entity.getContent(), "UTF-8");
				ObjectMapper objectMapper = new ObjectMapper();
				folders = objectMapper.readValue(response, Folders.class);
			} catch (Exception ex) {
				ErrorMessage = response;
				throw new Exception(response);
			}
			return folders;
		}

		/**
		 * Creates a custom folder with appropriate information mapped from new folder object
		 * @param newFolder <code>NewFolder</code> object
		 * @return <code>string</code> New Folder ID
		 * @throws Exception 
		 */
		public NewFolderId createFolder(NewFolder newFolder) throws Exception {
			String URL = BaseUrl + "/Folder";
			String JSONNewFolder = buildJSONStringFromObject(newFolder);
			NewFolderId newFolderId = new NewFolderId();
			String response = "";
			try {
				HttpEntity entity = buildHttpPostEntity(URL, JSONNewFolder, assembleCommonHeaders());
				response = IOUtils.toString(entity.getContent(),  "UTF-8");
				ObjectMapper objectMapper = new ObjectMapper();
				newFolderId = objectMapper.readValue(response, NewFolderId.class);
			} catch (JsonParseException ex) {
				ErrorMessage = response;
				throw new Exception(response);
			}
			return newFolderId;
		}
		
		/**
		 * Deletes a custom folder, given that folder's ID.
		 * Non-custom folders cannot be deleted
		 * @param folderID <code>int</code> folder ID
		 * @throws Exception 
		 */
		public void deleteFolder(int folderID) throws Exception {
			String URL = BaseUrl + "/Folder/" + folderID;
			String response = "";
			try {
				HttpEntity entity = buildHttpDeleteEntity(URL, assembleCommonHeaders());
				response = IOUtils.toString(entity.getContent(), "UTF-8");
				if (StatusCode != 200) {
					ErrorMessage = IOUtils.toString(entity.getContent(), "UTF-8");
				}
			} catch (Exception ex) {
				ErrorMessage = response;
				throw new Exception(response);
			}
		}

	}

	public class DMMessage {
		/**
		 * Retrieves the message IDs of all messages in the user's inbox
		 * @param ID <code>MessageIDget</code> object, containing search parameters
		 * @return <code>MessageIds</code> object, mapped from JSON in server response
		 * @throws Exception 
		 */
		public MessageIds getInboxMessageIds(MessageIdGet ID) throws Exception {
			String URL = BaseUrl + "/Message/GetInboxMessageIds";
			String JSONMessageIDget = buildJSONStringFromObject(ID);
			MessageIds messageIds = new MessageIds();
			String response = "";
			try {
				HttpEntity entity = buildHttpPostEntity(URL, JSONMessageIDget, assembleCommonHeaders());
				response = IOUtils.toString(entity.getContent(), "UTF-8");
				ObjectMapper objectMapper = new ObjectMapper();
				messageIds = objectMapper.readValue(response, MessageIds.class);
			}catch (Exception ex) {
				ErrorMessage = response;
				throw new Exception(response);
			}
			return messageIds;
		}
		
		/**
		 * Retrieves message summaries of all messages within a specified folder
		 * @param messageSummariesGet <code>MessageSummariesGet</code> object, containing search parameters
		 * @return <code>MessageSummariesResponse</code> object, mapped from JSON in server response
		 * @throws Exception 
		 */
		public MessageSummariesResponse getMessageSummaries(MessageSummariesGet messageSummariesGet) throws Exception {
			MessageSummariesResponse messageSummariesResponse = new MessageSummariesResponse();
			String URL = BaseUrl + "/Message/GetMessageSummaries";
			String JSONGetSummaries = buildJSONStringFromObject(messageSummariesGet);
			String response = "";
			try {
				HttpEntity entity = buildHttpPostEntity(URL, JSONGetSummaries, assembleCommonHeaders());
				response = IOUtils.toString(entity.getContent(), "UTF-8");
				ObjectMapper objectMapper = new ObjectMapper();
				messageSummariesResponse = objectMapper.readValue(response, MessageSummariesResponse.class);
			}catch (Exception ex) {
				ErrorMessage = response;
				throw new Exception(response);
			}
			return messageSummariesResponse;
		}
		
		/**
		 * Retrieves message summaries of all unread messages in a user's inbox
		 * @param after <code>boolean</code> to retrieve only messages after a specified ID
		 * @param lastMessageId <code>int</code> specified ID, used if <b>after</b> is true
		 * @return MessageSummariesResponse object, mapped from JSON in server response
		 * @throws Exception
		 */
		public MessageSummariesResponse getUnreadMessages(boolean after, int lastMessageId) throws Exception {
			MessageSummariesResponse messageSummariesResponse = new MessageSummariesResponse();
			String URL = BaseUrl + "/Message/Inbox/Unread";
			String response = "";
			if (after) {URL += "?After=" + lastMessageId;}
			try {
				HttpEntity entity = buildHttpGetEntity(URL, assembleCommonHeaders());
				response = IOUtils.toString(entity.getContent(), "UTF-8");
				ObjectMapper objectMapper = new ObjectMapper();
				messageSummariesResponse = objectMapper.readValue(response, MessageSummariesResponse.class);
			}catch (Exception ex) {
				ErrorMessage = response;
				throw new Exception(response);
			}
			return messageSummariesResponse;
		}
		
		/**
		 * Searches the user's inbox, based on filter parameters
		 * @param search <code>Search</code> Object containing filter parameters
		 * @return <code>SearchResponse</code> object, mapped from JSON in server response
		 * @throws Exception
		 */
		public SearchResponse searchInbox(Search search) throws Exception {
			SearchResponse searchResponse = new SearchResponse();
			String URL = BaseUrl + "/Message/Inbox/Search";
			String JSONSearch = buildJSONStringFromObject(search);
			String response = "";
			try {
				HttpEntity entity = buildHttpPostEntity(URL, JSONSearch, assembleCommonHeaders());
				response = IOUtils.toString(entity.getContent(), "UTF-8");
				ObjectMapper objectMapper = new ObjectMapper();
				searchResponse = objectMapper.readValue(response, SearchResponse.class);
			}catch (Exception ex) {
				ErrorMessage = response;
				throw new Exception(response);
			}
			return searchResponse;
		}

		/**
		 * Retrieves metadata for a sent message
		 * @param messageId <code>int</code> message ID of the message in question
		 * @return <code>MetaData</code> object, mapped from JSON in server response
		 * @throws Exception
		 */
		public MetaData getMessageMetadata(int messageId) throws Exception {
			MetaData metaData = new MetaData();
			String URL = BaseUrl + "/Message/" + messageId + "/Metadata";
			String response = "";
			try {
				HttpEntity entity = buildHttpGetEntity(URL, assembleCommonHeaders());
				response = IOUtils.toString(entity.getContent(), "UTF-8");
				ObjectMapper objectMapper = new ObjectMapper();
				metaData = objectMapper.readValue(response, MetaData.class);
			}catch (Exception ex) {
				ErrorMessage = response;
				throw new Exception(response);
			}
			return metaData;
		}
		
		/**
		 * Retrieves a message based on the message ID passed
		 * @param messageId <code>int</code> ID of message to be retrieved
		 * @return <code>Message</code> object, mapped from JSON in server response
		 * @throws Exception
		 */
		public Message getMessage(int messageId) throws Exception {
			Message message = new Message();
			String URL = BaseUrl + "/Message/" + messageId;
			String response = "";
			try {
				HttpEntity entity = buildHttpGetEntity(URL, assembleCommonHeaders());
				response = IOUtils.toString(entity.getContent(), "UTF-8");
				ObjectMapper objectMapper = new ObjectMapper();
				message = objectMapper.readValue(response,  Message.class);
			}catch (Exception ex) {
				ErrorMessage = response;
				throw new Exception(response);
			}
			return message;
		}
		
		/**
		 * Retrieves a message in MIME format
		 * @param messageId <code>int</code> ID of message to be retrieved
		 * @return <code>MimeMessage</code> object, mapped from JSON in server response
		 * @throws Exception
		 */
		public MimeMessage getMimeMessage(int messageId) throws Exception {
			MimeMessage mimeMessage = new MimeMessage();
			String URL = BaseUrl + "/Message/" + messageId + "/Mime";
			String response = "";
			try {
				HttpEntity entity = buildHttpGetEntity(URL, assembleCommonHeaders());
				response = IOUtils.toString(entity.getContent(), "UTF-8");
				ObjectMapper objectMapper = new ObjectMapper();
				mimeMessage = objectMapper.readValue(response, MimeMessage.class);
			}catch (Exception ex) {
				ErrorMessage = response;
				throw new Exception(response);
			}
			return mimeMessage;
		}
		
		/**
		 * Sends a message, with all relevant information contained in <code>Message</code> object
		 * @param message <code>Message</code> object
		 * @return <code>int</code> ID of message that was sent
		 * @throws Exception
		 */
		public MessageId sendMessage(Message message) throws Exception {
			MessageId messageId = new MessageId();
			String URL = BaseUrl + "/Message/";
			String JSONMessage = buildJSONStringFromObject(message);
			String response = "";
			try {
				HttpEntity entity = buildHttpPostEntity(URL, JSONMessage, assembleCommonHeaders());
				response = IOUtils.toString(entity.getContent(), "UTF-8");
				ObjectMapper objectMapper = new ObjectMapper();
				messageId = objectMapper.readValue(response, MessageId.class);
			} catch (Exception ex) {
				ErrorMessage = response;
				throw new Exception(response);
			}
			return messageId;
		}
		
		/**
		 * Sends a MIME message, assuming <code>MimeMessage</code> object contains a properly formatted MIME string
		 * @param mimeMessage <code>MimeMessage</code> object
		 * @return <code>int</code> ID of message that was sent
		 * @throws Exception 
		 */
		public MessageId sendMimeMessage(MimeMessage mimeMessage) throws Exception {
			MessageId messageId = new MessageId();
			String URL = BaseUrl + "/Message/Mime";
			String JSONMimeMessage = buildJSONStringFromObject(mimeMessage);
			String response = "";
			try {
				HttpEntity entity = buildHttpPostEntity(URL, JSONMimeMessage, assembleCommonHeaders());
				response = IOUtils.toString(entity.getContent(), "UTF-8");
				ObjectMapper objectMapper = new ObjectMapper();
				messageId = objectMapper.readValue(response, MessageId.class);
			} catch (Exception ex) {
				ErrorMessage = response;
				throw new Exception(response);
			}
			return messageId;
		}

		/**
		 * Moves a message into a specified folder
		 * @param moveMessage <code>MoveMessage</code> object, containing relevant parameters
		 * @param messageId <code>int</code> ID of message to be moved
		 * @throws Exception 
		 */
		public void moveMessage(MoveMessage moveMessage, int messageId) throws Exception {
			String URL = BaseUrl + "/Message/" + messageId + "/Move";
			String JSONMoveMessage = buildJSONStringFromObject(moveMessage);
			String response = "";
			try {
				HttpEntity entity = buildHttpPostEntity(URL, JSONMoveMessage, assembleCommonHeaders());
				response = IOUtils.toString(entity.getContent(), "UTF-8");
				if (StatusCode != 200) {
					ErrorMessage = IOUtils.toString(entity.getContent(), "UTF-8");
				}
			} catch (Exception ex) {
				throw new Exception(response);
			}
		}
		
		/**
		 * Deletes a message from a folder
		 * @param messageId <code>int</code> ID of message to be deleted
		 * @param permanent <code>boolean</code> Flag to delete message permanently
		 * @return <code>DeleteMessageResponse</code> object, mapped from JSON in server response
		 * @throws Exception 
		 */
		public DeleteMessageResponse deleteMessage(int messageId, boolean permanent) throws Exception {
			DeleteMessageResponse deleteMessageResponse = new DeleteMessageResponse();
			String URL = BaseUrl + "/Message/" + messageId;
			String response = "";
			if (permanent) {URL += "?Permanently=true";}
			try { 
				HttpEntity entity = buildHttpDeleteEntity(URL, assembleCommonHeaders());
				response = IOUtils.toString(entity.getContent(), "UTF-8");
				ObjectMapper objectMapper = new ObjectMapper();
				deleteMessageResponse = objectMapper.readValue(response, DeleteMessageResponse.class);
			} catch (Exception ex) {
				ErrorMessage = response;
				throw new Exception(response);
			}
			return deleteMessageResponse;
		}
		
		/**
		 * Retracts a message from any recipients who received it
		 * @param messageId <code>int</code> ID of message to be retracted
		 * @throws Exception 
		 */
		public void retractMessage(int messageId) throws Exception {
			String URL = BaseUrl + "/Message/" + messageId + "/Retract";
			String response = "";
			try {
				HttpEntity entity = buildHttpPostEntity(URL, "", assembleCommonHeaders());
				response = IOUtils.toString(entity.getContent(), "UTF-8");
				if (StatusCode != 200) {
					ErrorMessage = IOUtils.toString(entity.getContent(), "UTF-8");
				}
			} catch (Exception ex) {
				throw new Exception(response);
			}
		}
		
		public MessageWithAttachmentMetadata getMessageWithoutAttachmentData(int messageId) throws Exception {
			MessageWithAttachmentMetadata message = new MessageWithAttachmentMetadata();
			String URL = BaseUrl + "/Message/" + messageId + "/NoAttachmentData";
			String response = "";
			try {
				HttpEntity entity = buildHttpGetEntity(URL, assembleCommonHeaders());
				response = IOUtils.toString(entity.getContent(), "UTF-8");
				ObjectMapper objectMapper = new ObjectMapper();
				message = objectMapper.readValue(response, MessageWithAttachmentMetadata.class);
			} catch (Exception ex) {
				ErrorMessage = response;
				throw new Exception(response);
			}
			return message;
		}
		
		public GetAttachmentResponse getAttachment(int attachmentId) throws Exception {
			GetAttachmentResponse attachment = new GetAttachmentResponse();
			String URL = BaseUrl + "/Message/" + attachmentId + "/Attachment";
			String response = "";
			try {
				HttpEntity entity = buildHttpGetEntity(URL, assembleCommonHeaders());
				response = IOUtils.toString(entity.getContent(), "UTF-8");
				ObjectMapper objectMapper = new ObjectMapper();
				attachment = objectMapper.readValue(response, GetAttachmentResponse.class);
			} catch(Exception ex) {
				ErrorMessage = response;
				throw new Exception(response);
			}
			return attachment;
		}
		
		public GetMessageSummariesWithMetadataResponse getMessageSummariesWithMetadata(GetMessageSummariesWithMetadata req) throws Exception {
			GetMessageSummariesWithMetadataResponse summaries = new GetMessageSummariesWithMetadataResponse();
			String URL = BaseUrl + "/Message/GetMessageSummariesWithMetadata";
			String JSONreq = buildJSONStringFromObject(req);
			String response = "";
			try {
				HttpEntity entity = buildHttpPostEntity(URL, JSONreq, assembleCommonHeaders());
				response = IOUtils.toString(entity.getContent(), "UTF-8");
				ObjectMapper objectMapper = new ObjectMapper();
				summaries = objectMapper.readValue(response, GetMessageSummariesWithMetadataResponse.class);
			} catch (Exception ex) {
				ErrorMessage = response;
				throw new Exception(response);
			}
			return summaries;
		}
		
		public MessageId saveDraft(Message draft) throws Exception {
			MessageId messageId = new MessageId();
			String URL = BaseUrl + "/Message/SaveDraft";
			String JSONDraft = buildJSONStringFromObject(draft);
			String response = "";
			try {
				HttpEntity entity = buildHttpPostEntity(URL, JSONDraft, assembleCommonHeaders());
				response = IOUtils.toString(entity.getContent(), "UTF-8");
				ObjectMapper objectMapper = new ObjectMapper();
				messageId = objectMapper.readValue(response, MessageId.class);
			} catch (Exception ex) {
				ErrorMessage = response;
				throw new Exception(response);
			}
			return messageId;
		}
		
		public MessageId sendDraft(String draftId) throws Exception {
			MessageId messageId = new MessageId();
			String URL = BaseUrl + "/Message/" + draftId + "/SendDraft";
			String response = "";
			try {
				HttpEntity entity = buildHttpPostEntity(URL, "", assembleCommonHeaders());
				response = IOUtils.toString(entity.getContent(), "UTF-8");
				ObjectMapper objectMapper = new ObjectMapper();
				messageId = objectMapper.readValue(response, MessageId.class);
			} catch (Exception ex) {
				ErrorMessage = response;
				throw new Exception(response);
			}
			return messageId;
		}
	}
	//Auxiliary Functions:
	
	/**
	 * Builds a JSON string from an object
	 * @param object <code>object</code> of any type
	 * @return <code>String</code> representation of passed object
	 */
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

		/**
		 * Assembles necessary parts of an HTTP POST and handles send/response
		 * @param URL <code>String</code> target URL
		 * @param body <code>String</code> body of post
		 * @param headerList <code>ArrayList&lt;HttpHeader@gt;</code> list of header fields and associated values
		 * @return <code>HttpEntity</code> object
		 * @throws ClientProtocolException Throws underlying ClientProtocolException Throws underlying ClientProtocolException
		 * @throws IOException Throws underlying IOException
		 */
	public static HttpEntity buildHttpPostEntity(String URL, String body, ArrayList<HttpHeader> headerList) throws ClientProtocolException, IOException {
		HttpClient client = HttpClientBuilder.create().build();
		HttpPost httpPost = new HttpPost(URL);
		StringEntity input = new StringEntity(body, "UTF-8");
		for (int i = 0; i < headerList.size(); i++) {
			httpPost.addHeader(headerList.get(i).getKey(), headerList.get(i).getValue());
		}
		httpPost.setEntity(input);
		HttpResponse httpResponse = client.execute(httpPost);
		StatusCode = httpResponse.getStatusLine().getStatusCode();
		HttpEntity entity = httpResponse.getEntity();
		return entity;
	}
	
	/**
	 * Assembles necessary parts of an HTTP GET and handles send/response
	 * @param URL <code>String</code> target URL
	 * @param headerList <code>ArrayList&lt;HttpHeader@gt;</code> list of header fields and associated values
	 * @return <code>HttpEntity</code> object
	 * @throws ClientProtocolException Throws underlying ClientProtocolException
	 * @throws IOException Throws underlying IOException
	 */
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
	
	/**
	 * Assembles necessary parts of an HTTP Delete and handles send/response
	 * @param URL <code>String</code> target URL
	 * @param headerList <code>ArrayList&lt;HttpHeader@gt;</code> list of header fields and associated values
	 * @return <code>HttpEntity</code> object
	 * @throws ClientProtocolException Throws underlying ClientProtocolException
	 * @throws IOException Throws underlying IOException
	 */
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
	
	/**
	 * Assembles header fields/values commonly used by the DataMotion SecureMail API
	 * @return <code>ArrayList&lt;HttpHeader@gt;</code> list of header fields and associated values
	 */
	public static ArrayList<HttpHeader> assembleCommonHeaders(){
		HttpHeader contentType = new HttpHeader("Content-Type", "application/json");
		HttpHeader xSessionKey = new HttpHeader("X-Session-Key", SessionKey);
		ArrayList<HttpHeader> headers = new ArrayList<HttpHeader>();
		headers.add(contentType);
		headers.add(xSessionKey);	
		return headers;
	}
	
	/**
	 * Loads file from filename and encodes it to a Base64 string
	 * @param file <code>File</code> Java File object
	 * @return <code>String</code> encoded string
	 * @throws IOException Throws underlying IOException
	 */
	public static String encodeFileToBase64Binary(File file) throws IOException {
		byte[] bytes = loadFile(file);
		byte[] encoded = Base64.encodeBase64(bytes);
		String encodedString = new String(encoded);

		return encodedString;
	}
	
	/**
	 * Loads a file into a byte array
	 * @param file <code>File</code> file to be loaded
	 * @return <code>byte[]</code> byte array
	 * @throws IOException Throws underlying IOException
	 */
	@SuppressWarnings("resource")
	public static byte[] loadFile(File file) throws IOException {
	    InputStream is = new FileInputStream(file);

	    long length = file.length();
	    if (length > Integer.MAX_VALUE) {
	        //TODO error message for extremely large files;
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

	/**
	 * Decodes a Base64 string into a byte array
	 * @param base64 <code>String</code> input Base64 string
	 * @return <code>byte[]</code> byte array
	 */
	public static byte[] decodeBase64ToByteArray(String base64) {
		byte[] bytes = Base64.decodeBase64(base64);
		return bytes;
	}

	public static String getBaseUrl() {
		return BaseUrl;
	}

	public static void setBaseUrl(String baseUrl) {
		BaseUrl = baseUrl;
	}

	public static String getSessionKey() {
		return SessionKey;
	}

	public static void setSessionKey(String sessionKey) {
		SessionKey = sessionKey;
	}

	public static int getStatusCode() {
		return StatusCode;
	}

	public static void setStatusCode(int statusCode) {
		StatusCode = statusCode;
	}

	public static String getErrorMessage() {
		return ErrorMessage;
	}

	public static void setErrorMessage(String errorMessage) {
		ErrorMessage = errorMessage;
	}
}


