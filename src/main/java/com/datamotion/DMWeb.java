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
import com.datamotion.Models.HttpHeader;
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
	
	/**
	 * Sets <code>BaseUrl</code>
	 */
	public DMWeb() {
		BaseUrl = "https://ssl.datamotion.com/";
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
			String URL = BaseUrl + "SecureMessagingApi/Account/Logon";
			HttpHeader contentType = new HttpHeader("Content-Type", "application/json");
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


