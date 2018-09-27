package com.datamotion.Models;

import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonIgnore;

import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * Search Response Model Class
 */
public class SearchResponse {
	/**
	 * PageDetails object
	 * See PageDetails model class
	 */
	@JsonProperty("PageDetails") 
	private PageDetails details;
	
	/**
	 * Array of results objects
	 * See Results model class
	 */
	@JsonProperty("Results")
	private ArrayList<Results> results;

	@JsonIgnore
	public SearchResponse() {
		this.details = null;
		this.results = null;
	}

	@JsonIgnore
	public SearchResponse(PageDetails details, ArrayList<Results> results) {
		this.details = details;
		this.results = results;
	}

	@JsonIgnore
	public PageDetails getDetails() {
		return details;
	}

	@JsonIgnore
	public void setDetails(PageDetails details) {
		this.details = details;
	}

	@JsonIgnore
	public ArrayList<Results> getResults() {
		return results;
	}

	@JsonIgnore
	public void setResults(ArrayList<Results> results) {
		this.results = results;
	}
}
