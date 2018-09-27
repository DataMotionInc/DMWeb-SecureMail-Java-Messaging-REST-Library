package com.datamotion.Models;

import java.io.File;
import java.io.IOException;

import org.apache.tika.Tika;

import com.datamotion.DMWeb;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Attachment Model Class
 */
public class Attachment {	
	/**
	 * Attachment Base64 string
	 */
	@JsonProperty("AttachmentBase64")
	private String AttachmentBase64;
	
	/**
	 * Attachment MIME Content Type tag
	 */
	@JsonProperty("ContentType")
	private String ContentType;
	
	/**
	 * Attachment Filename
	 */
	@JsonProperty("FileName")
	private String FileName;
	
	@JsonIgnore
	public Attachment() {
		AttachmentBase64 = null;
		ContentType = null;
		FileName = null;
	}
	
	@JsonIgnore
	public Attachment(String attachmentBase64, String contentType, String fileName) {
		AttachmentBase64 = attachmentBase64;
		ContentType = contentType;
		FileName = fileName;
	}
	
	@JsonIgnore
	public Attachment(File file) {
		DMWeb dmweb = new DMWeb();
		try {
			AttachmentBase64 = dmweb.encodeFileToBase64Binary(file);
			Tika tika = new Tika();
			try {
				ContentType = tika.detect(file);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			FileName = file.getName();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@JsonIgnore
	public String getAttachmentBase64() {
		return AttachmentBase64;
	}
	
	@JsonIgnore
	public void setAttachmentBase64(String attachmentBase64) {
		AttachmentBase64 = attachmentBase64;
	}

	@JsonIgnore
	public String getContentType() {
		return ContentType;
	}

	@JsonIgnore
	public void setContentType(String contentType) {
		ContentType = contentType;
	}

	@JsonIgnore
	public String getFileName() {
		return FileName;
	}

	@JsonIgnore
	public void setFileName(String fileName) {
		FileName = fileName;
	}
	
}
