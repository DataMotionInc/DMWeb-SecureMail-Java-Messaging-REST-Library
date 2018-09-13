package com.datamotion.Models;

import java.io.File;
import java.io.IOException;

import org.apache.tika.Tika;

import com.datamotion.DMWeb;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Attachment Model Class
 */
@NoArgsConstructor
@AllArgsConstructor
public class Attachment {	
	/**
	 * Attachment Base64 string
	 */
	@JsonProperty("AttachmentBase64")
	@Getter (onMethod_=@JsonIgnore)
	@Setter (onMethod_=@JsonIgnore)
	private String AttachmentBase64;
	
	/**
	 * Attachment MIME Content Type tag
	 */
	@JsonProperty("ContentType")
	@Getter (onMethod_=@JsonIgnore)
	@Setter (onMethod_=@JsonIgnore)
	private String ContentType;
	
	/**
	 * Attachment Filename
	 */
	@JsonProperty("FileName")
	@Getter (onMethod_=@JsonIgnore)
	@Setter (onMethod_=@JsonIgnore)
	private String FileName;
	
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

}
