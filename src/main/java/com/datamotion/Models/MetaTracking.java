package com.datamotion.Models;

import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonIgnore;

import com.fasterxml.jackson.annotation.JsonProperty;


public class MetaTracking {
	@JsonProperty("Recipients") 
	private ArrayList<Recipients> Recipients;

	@JsonIgnore
	public MetaTracking() {
		Recipients = null;
	}

	@JsonIgnore
	public MetaTracking(ArrayList<com.datamotion.Models.Recipients> recipients) {
		Recipients = recipients;
	}

	@JsonIgnore
	public ArrayList<Recipients> getRecipients() {
		return Recipients;
	}

	@JsonIgnore
	public void setRecipients(ArrayList<Recipients> recipients) {
		Recipients = recipients;
	}
}
