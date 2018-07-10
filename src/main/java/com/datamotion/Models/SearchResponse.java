package com.datamotion.Models;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Search Response Model Class
 */
@NoArgsConstructor
@AllArgsConstructor
public class SearchResponse {
	/**
	 * PageDetails object
	 * See PageDetails model class
	 */
	@JsonProperty("PageDetails") @Getter @Setter
	private PageDetails details;
	
	/**
	 * Array of results objects
	 * See Results model class
	 */
	@JsonProperty("Results")@Getter @Setter
	private ArrayList<Results> results;
}
